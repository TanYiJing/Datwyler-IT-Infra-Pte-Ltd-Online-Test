package com.example.onlineAssessment.model.response;

import lombok.Data;

/**
 * @author yijing.tan
 */
@Data
public class DisburseLoanResponse {

    private String loanNo;

    private String loanAmount;

    private String status;
}
