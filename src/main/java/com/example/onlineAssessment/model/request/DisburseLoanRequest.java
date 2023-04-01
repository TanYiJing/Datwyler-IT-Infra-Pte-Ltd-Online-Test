package com.example.onlineAssessment.model.request;

import lombok.Data;

/**
 * @author yijing.tan
 */
@Data
public class DisburseLoanRequest {
    private String loanNo;

    private String loanAmount;

    private String clientNo;

}
