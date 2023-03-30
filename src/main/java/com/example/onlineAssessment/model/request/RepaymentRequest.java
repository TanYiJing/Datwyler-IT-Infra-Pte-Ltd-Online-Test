package com.example.onlineAssessment.model.request;

import com.example.onlineAssessment.enums.RepaymentType;
import lombok.Data;

/**
 * @author yijing.tan
 */
@Data
public class RepaymentRequest {

    private String amount;

    private RepaymentType repaymentType;

    private String loanAccountNo;

}
