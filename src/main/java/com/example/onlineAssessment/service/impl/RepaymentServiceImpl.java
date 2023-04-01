package com.example.onlineAssessment.service.impl;

import com.example.onlineAssessment.enums.CommonEnums;
import com.example.onlineAssessment.enums.RepaymentType;
import com.example.onlineAssessment.enums.exception.ErrorCodeEnum;
import com.example.onlineAssessment.infra.DAL.LoanDAL;
import com.example.onlineAssessment.infra.DAL.PaymentHistoryDAL;
import com.example.onlineAssessment.infra.DAO.LoanDAO;
import com.example.onlineAssessment.model.base.ResponseData;
import com.example.onlineAssessment.model.request.RepaymentRequest;
import com.example.onlineAssessment.model.response.RepaymentResponse;
import com.example.onlineAssessment.service.RepaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yijing.tan
 */
@Service
public class RepaymentServiceImpl implements RepaymentService {

    @Autowired
    LoanDAL loanDAL;

    @Autowired
    PaymentHistoryDAL paymentHistoryDAL;

    @Override
    public ResponseData<RepaymentResponse> repayLoan(RepaymentRequest repaymentRequest) {
        LoanDAO loan = loanDAL.queryLoanByClientNoAndLoanNo(repaymentRequest.getClientNo(), repaymentRequest.getLoanNo());

        Integer successCount = 0;
        if (repaymentRequest.getRepaymentType().getCode().equals(RepaymentType.FULL_REPAYMENT.getCode())) {
            successCount = loanDAL.repayFullLoanAmountByClientNoAndLoanNo(repaymentRequest.getClientNo(), repaymentRequest.getLoanNo());
        }

        if (repaymentRequest.getRepaymentType().getCode().equals(RepaymentType.PARTIAL_REPAYMENT.getCode())) {
            Integer remainingLoanAmount = Integer.parseInt(loan.getOutstandingAmount()) - Integer.parseInt(repaymentRequest.getAmount());
            successCount = loanDAL.updateLoanAmountByLoanNoAndClientNo(remainingLoanAmount.toString(), repaymentRequest.getClientNo(),
                    repaymentRequest.getLoanNo());
        }

        if (successCount != 0) {
            return ResponseData.fail(ErrorCodeEnum.SYSTEM_ERROR);
        } else {
            // save payment history into the database

            paymentHistoryDAL.insertPaymentHistory(repaymentRequest.getClientNo(), repaymentRequest.getLoanNo(),
                    repaymentRequest.getAmount(),
                    Long.toString(System.currentTimeMillis()));
        }
        return ResponseData.success(assembleRepaymentResponse(repaymentRequest));
    }

    private RepaymentResponse assembleRepaymentResponse(RepaymentRequest repaymentRequest) {
        RepaymentResponse response = new RepaymentResponse();
        response.setStatus(CommonEnums.SUCCESS.name());
        response.setClientNo(repaymentRequest.getClientNo());
        response.setLoanNo(repaymentRequest.getLoanNo());
        response.setRepaidAmount(repaymentRequest.getAmount());
        return response;

    }
}
