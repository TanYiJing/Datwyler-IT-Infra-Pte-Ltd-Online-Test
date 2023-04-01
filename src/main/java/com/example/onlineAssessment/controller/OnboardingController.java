package com.example.onlineAssessment.controller;

import com.example.onlineAssessment.constant.CONSTANT;
import com.example.onlineAssessment.model.base.ResponseData;
import com.example.onlineAssessment.model.request.OnboardCreditFacilityRequest;
import com.example.onlineAssessment.model.request.UserLoginRequest;
import com.example.onlineAssessment.model.response.OnboardCreditFacilityResponse;
import com.example.onlineAssessment.model.response.UserLoginResponse;
import com.example.onlineAssessment.service.OnboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("bank/onboarding")
public class OnboardingController {

    @Autowired
    OnboardService onboardService;

    @PostMapping("/creditFacility")
    public ResponseData<OnboardCreditFacilityResponse> onboardCreditFacilityResponse(
             @RequestBody OnboardCreditFacilityRequest onboardCreditFacilityRequest) {
        return onboardService.onboardCreditFacility(onboardCreditFacilityRequest);
    }
}
