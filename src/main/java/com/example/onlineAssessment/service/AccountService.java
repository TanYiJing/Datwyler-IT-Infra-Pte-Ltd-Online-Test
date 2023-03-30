package com.example.onlineAssessment.service;

import com.example.onlineAssessment.model.base.ResponseData;
import com.example.onlineAssessment.model.request.UserLoginRequest;
import com.example.onlineAssessment.model.request.UserRegisterRequest;
import com.example.onlineAssessment.model.response.UserLoginResponse;
import com.example.onlineAssessment.model.response.UserRegisterResponse;

import java.security.NoSuchAlgorithmException;

/**
 * @author yijing.tan
 */
public interface AccountService {

    ResponseData<UserLoginResponse> login(UserLoginRequest userLoginInfo);

    ResponseData<UserRegisterResponse> register(UserRegisterRequest userRegisterRequest) throws NoSuchAlgorithmException;

}
