package com.example.onlineAssessment.service.impl;

import com.example.onlineAssessment.enums.exception.ErrorCodeEnum;
import com.example.onlineAssessment.infra.DAL.UserDAL;
import com.example.onlineAssessment.infra.DAO.UserDAO;
import com.example.onlineAssessment.model.base.ResponseData;
import com.example.onlineAssessment.model.request.UserLoginRequest;
import com.example.onlineAssessment.model.UserModel;
import com.example.onlineAssessment.model.response.UserLoginResponse;
import com.example.onlineAssessment.service.AccountService;
import com.example.onlineAssessment.util.ArgonHashingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

/**
 * @author yijing.tan
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    UserDAL userDAL;
    @Override
    public ResponseData<UserLoginResponse> login(UserLoginRequest userLoginInfo) {
        //todo query user from database
        UserDAO user = userDAL.queryUserInfoByUsername(userLoginInfo.getUsername());

        boolean validUser = false;
        try {
            validUser = ArgonHashingUtils.verifyPassword(userLoginInfo.getPassword(), "test", "passw0rd");
        } catch (NoSuchAlgorithmException e) {
            return ResponseData.fail(ErrorCodeEnum.SYSTEM_ERROR);
        }
        if (!validUser) {
            return ResponseData.fail(ErrorCodeEnum.INVALID_LOGIN);
        }

        //todo insert into redis
        return ResponseData.success(assembleUserLoginResponse());

    }

    private UserLoginResponse assembleUserLoginResponse(){
        return new UserLoginResponse(true);
    }

}
