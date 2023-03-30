package com.example.onlineAssessment.service;

import com.example.onlineAssessment.model.base.ResponseData;
import com.example.onlineAssessment.model.request.OnboardCreditFacilityRequest;
import com.example.onlineAssessment.model.response.OnboardCreditFacilityResponse;

/**
 * @author yijing.tan
 */
public interface OnboardService {
    ResponseData<OnboardCreditFacilityResponse> onboardCreditFacility(String sessionToken, OnboardCreditFacilityRequest onboardCreditFacilityInfo);
}
