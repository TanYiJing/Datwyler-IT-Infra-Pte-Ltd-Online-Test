package com.example.onlineAssessment.infra.DAL;

import com.example.onlineAssessment.infra.DAO.PaymentHistoryDO;

import java.util.List;

/**
 * @author yijing.tan
 */
public interface PaymentHistoryDAL {

    List<PaymentHistoryDO> queryPaymentHistory(String clientNo, String loanNo);

    Integer insertPaymentHistory(String clientNo, String loanNo, String amount, String timestamp);
}
