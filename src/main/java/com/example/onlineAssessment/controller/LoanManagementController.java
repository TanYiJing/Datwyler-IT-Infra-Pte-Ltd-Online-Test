package com.example.onlineAssessment.controller;

import com.example.onlineAssessment.constant.CONSTANT;
import com.example.onlineAssessment.model.base.ResponseData;
import com.example.onlineAssessment.model.request.DisburseLoanRequest;
import com.example.onlineAssessment.model.request.QueryLoanDetailsRequest;
import com.example.onlineAssessment.model.response.DisburseLoanResponse;
import com.example.onlineAssessment.model.response.OnboardCreditFacilityResponse;
import com.example.onlineAssessment.model.response.QueryLoanDetailsResponse;
import com.example.onlineAssessment.service.LoanManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author yijing.tan
 */
@RestController
@RequestMapping("bank/loanManagement")
public class LoanManagementController {

    @Autowired
    LoanManagementService loanManagementService;

    @PostMapping("/disbursement")
    public ResponseData<DisburseLoanResponse> disburseLoan(
            @RequestHeader(CONSTANT.CLIENT_SESSION_TOKEN) String x_SESSION_TOKEN
            , @RequestBody DisburseLoanRequest disburseLoanRequest) {
        return loanManagementService.disburseLoan(x_SESSION_TOKEN, disburseLoanRequest);
    }

    @PostMapping("/queryLoanDetails")
    public ResponseData<QueryLoanDetailsResponse> queryLoanDetails(
            @RequestHeader(CONSTANT.CLIENT_SESSION_TOKEN) String x_SESSION_TOKEN
            , @RequestBody QueryLoanDetailsRequest queryLoanDetailsRequest) {
        return loanManagementService.queryLoanDetails(x_SESSION_TOKEN, queryLoanDetailsRequest);
    }
}
