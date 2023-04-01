package com.example.onlineAssessment.infra.DAO;

import lombok.Data;

/**
 * @author yijing.tan
 */

@Data
public class PaymentHistoryDO {

    private String id;

    private String amount;

    private String timeStamp;

    private String loanNo;

    private String clientNo;


}
