package com.example.onlineAssessment.service;

import com.example.onlineAssessment.model.base.ResponseData;
import com.example.onlineAssessment.model.request.DisburseLoanRequest;
import com.example.onlineAssessment.model.request.QueryLoanDetailsRequest;
import com.example.onlineAssessment.model.response.DisburseLoanResponse;
import com.example.onlineAssessment.model.response.QueryLoanDetailsResponse;

/**
 * @author yijing.tan
 */
public interface LoanManagementService {
    ResponseData<DisburseLoanResponse> disburseLoan(DisburseLoanRequest userLoginInfo);

    ResponseData<QueryLoanDetailsResponse> queryLoanDetails(QueryLoanDetailsRequest queryLoanDetailsRequest);
}
