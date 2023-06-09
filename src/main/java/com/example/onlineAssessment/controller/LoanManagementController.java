package com.example.onlineAssessment.controller;

import com.example.onlineAssessment.constant.CONSTANT;
import com.example.onlineAssessment.model.base.ResponseData;
import com.example.onlineAssessment.model.request.DisburseLoanRequest;
import com.example.onlineAssessment.model.request.QueryLoanDetailsRequest;
import com.example.onlineAssessment.model.response.DisburseLoanResponse;
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
            @RequestBody DisburseLoanRequest disburseLoanRequest) {
        return loanManagementService.disburseLoan(disburseLoanRequest);
    }

    @PostMapping("/queryLoanDetails")
    public ResponseData<QueryLoanDetailsResponse> queryLoanDetails(@RequestBody QueryLoanDetailsRequest queryLoanDetailsRequest) {
        return loanManagementService.queryLoanDetails(queryLoanDetailsRequest);
    }
}
