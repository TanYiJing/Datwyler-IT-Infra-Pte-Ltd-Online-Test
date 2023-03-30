package com.example.onlineAssessment.model.response;

import lombok.Data;

/**
 * @author yijing.tan
 */
@Data
public class RepaymentResponse {

    private String loanAccountNo;

    private String amount;

    private String status;
}
