package com.example.onlineAssessment.service.impl;

import com.example.onlineAssessment.model.base.ResponseData;
import com.example.onlineAssessment.model.request.RepaymentRequest;
import com.example.onlineAssessment.model.response.RepaymentResponse;
import com.example.onlineAssessment.service.RepaymentService;
import org.springframework.stereotype.Service;

/**
 * @author yijing.tan
 */
@Service
public class RepaymentServiceImpl implements RepaymentService {

    @Override
    public ResponseData<RepaymentResponse> repayLoan(final String sessionToken, final RepaymentRequest repaymentRequest) {
        return null;
    }
}
