package com.example.onlineAssessment.model.request;

import lombok.Data;

/**
 * @author yijing.tan
 */
@Data
public class QueryLoanDetailsRequest {

    private String clientNo;
    private String loanNo;

}
