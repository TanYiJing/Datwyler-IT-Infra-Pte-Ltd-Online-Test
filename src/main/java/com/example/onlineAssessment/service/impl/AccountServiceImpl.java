package com.example.onlineAssessment.service.impl;

import com.example.onlineAssessment.enums.exception.ErrorCodeEnum;
import com.example.onlineAssessment.infra.DAL.UserDAL;
import com.example.onlineAssessment.infra.DAO.UserDAO;
import com.example.onlineAssessment.model.base.ResponseData;
import com.example.onlineAssessment.model.request.UserLoginRequest;
import com.example.onlineAssessment.model.request.UserRegisterRequest;
import com.example.onlineAssessment.model.response.UserLoginResponse;
import com.example.onlineAssessment.model.response.UserRegisterResponse;
import com.example.onlineAssessment.service.AccountService;
import com.example.onlineAssessment.util.ArgonHashingUtils;
import com.example.onlineAssessment.util.SessionUtils;
import io.lettuce.core.RedisException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.util.Objects;
import java.util.UUID;

/**
 * @author yijing.tan
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    UserDAL userDAL;

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    private static final Duration SESSION_DURATION = Duration.ofMinutes(60);

    @Override
    public ResponseData<UserLoginResponse> login(UserLoginRequest userLoginInfo) {
        UserDAO userInfo = userDAL.queryUserInfoByUsername(userLoginInfo.getUsername());

        boolean validUser = false;
        try {
            validUser = ArgonHashingUtils.verifyPassword(userLoginInfo.getPassword(), userInfo.getSalt(), userInfo.getPassword());
        } catch (NoSuchAlgorithmException e) {
            return ResponseData.fail(ErrorCodeEnum.SYSTEM_ERROR);
        }
        if (!validUser) {
            return ResponseData.fail(ErrorCodeEnum.INVALID_LOGIN);
        }

        return ResponseData.success(assembleUserLoginResponse(userInfo));

    }

    @Override
    public ResponseData<UserRegisterResponse> register(UserRegisterRequest userRegisterRequest) throws NoSuchAlgorithmException {
        String passwordSalt = ArgonHashingUtils.generateSalt();
        String hashedPassword = ArgonHashingUtils.hashPasswordWithSalt(userRegisterRequest.getPassword(), passwordSalt);

        try {
            userDAL.insertUserInfo(userRegisterRequest.getUsername(), generateUuid(), userRegisterRequest.getName(),
                    hashedPassword, passwordSalt);

        } catch (DuplicateKeyException exception) {
            return ResponseData.fail(ErrorCodeEnum.DUPLICATED_USERNAME);
        } catch (Exception ex) {
            return ResponseData.fail(ErrorCodeEnum.SYSTEM_ERROR);
        }

        try {
            insertSessionToken(userRegisterRequest);

        } catch (RedisException e) {
            return ResponseData.fail(ErrorCodeEnum.REDIS_FAIL);
        }

        UserRegisterResponse userRegisterResponse = new UserRegisterResponse();
        userRegisterResponse.setStatus(true);
        return ResponseData.success(userRegisterResponse);
    }

    private UserLoginResponse assembleUserLoginResponse(UserDAO userInfo) {
        UserLoginResponse response = new UserLoginResponse(true);
        UserLoginResponse.UserDetails userDetails = new UserLoginResponse.UserDetails();
        userDetails.setName(userInfo.getName());
        userDetails.setClientNo(userInfo.getClientNo());
        userDetails.setUsername(userInfo.getUsername());
        response.setUserDetails(userDetails);
        return response;
    }

    private String generateUuid() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    private void insertSessionToken(UserRegisterRequest userRegisterRequest) {
        try {
            String sessionToken;
            //avoid generating the same session id
            do {
                sessionToken = SessionUtils.generateNewSessionToken();
            } while (Objects.nonNull(redisTemplate.hasKey(sessionToken)) && redisTemplate.hasKey(sessionToken).equals(Boolean.TRUE));
            redisTemplate.opsForValue().set(sessionToken, userRegisterRequest.getUsername(), SESSION_DURATION);
            System.out.println("Session Token : " + sessionToken);

        } catch (RedisException e) {
            e.printStackTrace();
            throw new RuntimeException(String.valueOf(ErrorCodeEnum.SYSTEM_ERROR.getCode()));
        }
    }

}
