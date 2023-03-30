package com.example.onlineAssessment.service.impl;

import com.example.onlineAssessment.model.base.ResponseData;
import com.example.onlineAssessment.model.request.OnboardCreditFacilityRequest;
import com.example.onlineAssessment.model.response.OnboardCreditFacilityResponse;
import com.example.onlineAssessment.service.OnboardService;
import org.springframework.stereotype.Service;

/**
 * @author yijing.tan
 */
@Service
public class OnboardServiceImpl implements OnboardService {


    @Override
    public ResponseData<OnboardCreditFacilityResponse> onboardCreditFacility(final String sessionToken,
                                                                             final OnboardCreditFacilityRequest onboardCreditFacilityInfo) {
        return ResponseData.success(new OnboardCreditFacilityResponse());
    }
}
