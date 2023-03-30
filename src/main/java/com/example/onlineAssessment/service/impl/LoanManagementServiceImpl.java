package com.example.onlineAssessment.service.impl;

import com.example.onlineAssessment.model.base.ResponseData;
import com.example.onlineAssessment.model.request.DisburseLoanRequest;
import com.example.onlineAssessment.model.request.QueryLoanDetailsRequest;
import com.example.onlineAssessment.model.response.DisburseLoanResponse;
import com.example.onlineAssessment.model.response.QueryLoanDetailsResponse;
import com.example.onlineAssessment.service.LoanManagementService;
import org.springframework.stereotype.Service;

/**
 * @author yijing.tan
 */
@Service
public class LoanManagementServiceImpl implements LoanManagementService {

    @Override
    public ResponseData<DisburseLoanResponse> disburseLoan(String adminHeaderToken, DisburseLoanRequest userLoginInfo) {
        return null;
    }

    @Override
    public ResponseData<QueryLoanDetailsResponse> queryLoanDetails(String headerToken,
                                                                   QueryLoanDetailsRequest queryLoanDetailsRequest) {
        return null;
    }
}
