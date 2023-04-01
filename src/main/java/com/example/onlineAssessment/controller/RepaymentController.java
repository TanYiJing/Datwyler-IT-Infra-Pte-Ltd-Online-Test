package com.example.onlineAssessment.controller;

import com.example.onlineAssessment.constant.CONSTANT;
import com.example.onlineAssessment.model.base.ResponseData;
import com.example.onlineAssessment.model.request.RepaymentRequest;
import com.example.onlineAssessment.model.response.RepaymentResponse;
import com.example.onlineAssessment.service.RepaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("bank/repay")
public class RepaymentController {

    @Autowired
    RepaymentService repaymentService;

    @PostMapping("/repayment")
    public ResponseData<RepaymentResponse> onboardCreditFacilityResponse(
             @RequestBody RepaymentRequest repaymentRequest) {
        return repaymentService.repayLoan(repaymentRequest);
    }

}
