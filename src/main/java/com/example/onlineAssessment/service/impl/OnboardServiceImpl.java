package com.example.onlineAssessment.service.impl;

import com.example.onlineAssessment.model.base.ResponseData;
import com.example.onlineAssessment.model.request.OnboardCreditFacilityRequest;
import com.example.onlineAssessment.model.response.OnboardCreditFacilityResponse;
import com.example.onlineAssessment.service.OnboardService;

/**
 * @author yijing.tan
 */
public class OnboardServiceImpl implements OnboardService {

    @Override
    public ResponseData<OnboardCreditFacilityResponse> onboardCreditFacility(final String sessionToken,
                                                                             final OnboardCreditFacilityRequest onboardCreditFacilityInfo) {
        return ResponseData.success(new OnboardCreditFacilityResponse());
    }
}
