package com.example.onlineAssessment.service.impl;

import com.example.onlineAssessment.enums.CommonEnums;
import com.example.onlineAssessment.enums.exception.ErrorCodeEnum;
import com.example.onlineAssessment.infra.DAL.LoanDAL;
import com.example.onlineAssessment.model.base.ResponseData;
import com.example.onlineAssessment.model.request.OnboardCreditFacilityRequest;
import com.example.onlineAssessment.model.response.OnboardCreditFacilityResponse;
import com.example.onlineAssessment.service.OnboardService;
import com.example.onlineAssessment.util.RandomNumberGenerator;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yijing.tan
 */
@Service
public class OnboardServiceImpl implements OnboardService {

    @Autowired
    LoanDAL loanDAL;

    @Override
    public ResponseData<OnboardCreditFacilityResponse> onboardCreditFacility(OnboardCreditFacilityRequest onboardCreditFacilityInfo) {
        Integer loanSuccessCount;
        String loanNo;
        try {
            loanNo = String.valueOf(RandomNumberGenerator.generateLoanNumber());
            loanSuccessCount = loanDAL.insertLoan(onboardCreditFacilityInfo.getClientNo(), loanNo
            );

        } catch (Exception exception) {
            return ResponseData.fail(ErrorCodeEnum.SYSTEM_ERROR);
        }

        if (ObjectUtils.isEmpty(loanSuccessCount)) {
            return ResponseData.fail(ErrorCodeEnum.SYSTEM_ERROR);
        }

        return ResponseData.success(assembleOnboardCreditFacilityResponse(loanNo));
    }

    private OnboardCreditFacilityResponse assembleOnboardCreditFacilityResponse(String loanNo) {
        OnboardCreditFacilityResponse onboardCreditFacilityResponse = new OnboardCreditFacilityResponse();
        onboardCreditFacilityResponse.setStatus(CommonEnums.SUCCESS.getDesc());
        onboardCreditFacilityResponse.setLoanNo(loanNo);
        return onboardCreditFacilityResponse;
    }

}
