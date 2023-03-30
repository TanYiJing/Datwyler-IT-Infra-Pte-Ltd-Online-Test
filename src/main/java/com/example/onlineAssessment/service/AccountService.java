package com.example.onlineAssessment.service;

import com.example.onlineAssessment.model.base.ResponseData;
import com.example.onlineAssessment.model.request.UserLoginRequest;
import com.example.onlineAssessment.model.response.UserLoginResponse;

/**
 * @author yijing.tan
 */
public interface AccountService {

    ResponseData<UserLoginResponse> login(UserLoginRequest userLoginInfo);
}
