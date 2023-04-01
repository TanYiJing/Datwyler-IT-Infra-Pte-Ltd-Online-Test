package com.example.onlineAssessment.model.response;

import lombok.Data;

/**
 * @author yijing.tan
 */
@Data
public class RepaymentResponse {

    private String loanNo;

    private String clientNo;

    private String repaidAmount;

    private String status;
}
