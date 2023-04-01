package com.example.onlineAssessment.service;

import com.example.onlineAssessment.model.base.ResponseData;
import com.example.onlineAssessment.model.request.RepaymentRequest;
import com.example.onlineAssessment.model.response.RepaymentResponse;

/**
 *  @author yijing.tan
 */
public interface RepaymentService {

    ResponseData<RepaymentResponse> repayLoan(RepaymentRequest repaymentRequest);

}
