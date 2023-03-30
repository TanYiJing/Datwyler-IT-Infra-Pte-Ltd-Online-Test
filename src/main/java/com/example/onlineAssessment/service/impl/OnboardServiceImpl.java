package com.example.onlineAssessment.service.impl;

import com.example.onlineAssessment.model.base.ResponseData;
import com.example.onlineAssessment.model.response.OnboardCreditFacilityResponse;
import com.example.onlineAssessment.service.OnboardService;

/**
 * @author yijing.tan
 */
public class OnboardServiceImpl implements OnboardService {

    @Override
    public ResponseData<OnboardCreditFacilityResponse> onboardCreditFacility() {
        return ResponseData.success(new OnboardCreditFacilityResponse());
    }
}
