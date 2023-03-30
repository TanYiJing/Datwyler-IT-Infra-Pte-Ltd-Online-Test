package com.example.onlineAssessment.model.response;

import lombok.Data;

import java.util.List;

/**
 * @author yijing.tan
 */
@Data
public class QueryLoanDetailsResponse {


    List<LoanAccountDetails> loanAccountDetails;

    @Data
    public static class LoanAccountDetails {
        private String clientNo;
        private String loanAccountNo;
        private List<PaymentDetails> paymentDetails;
    }

    @Data
    public static class PaymentDetails {
        private String status;

        private String amount;

    }

}
