package com.example.onlineAssessment.controller;

import com.example.onlineAssessment.model.base.ResponseData;
import com.example.onlineAssessment.model.request.UserLoginRequest;
import com.example.onlineAssessment.model.request.UserRegisterRequest;
import com.example.onlineAssessment.model.response.UserLoginResponse;
import com.example.onlineAssessment.model.response.UserRegisterResponse;
import com.example.onlineAssessment.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("bank/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping("/login")
    public ResponseData<UserLoginResponse> login(@RequestBody @Validated UserLoginRequest user) {
        return accountService.login(user);
    }

    @PostMapping("/register")
    public ResponseData<UserRegisterResponse> register(@RequestBody @Validated UserRegisterRequest userRegisterRequest)
            throws NoSuchAlgorithmException {
        return accountService.register(userRegisterRequest);
    }



}
