package com.example.onlineAssessment.service.impl;

import com.example.onlineAssessment.enums.CommonEnums;
import com.example.onlineAssessment.enums.exception.ErrorCodeEnum;
import com.example.onlineAssessment.infra.DAL.LoanDAL;
import com.example.onlineAssessment.infra.DAL.PaymentHistoryDAL;
import com.example.onlineAssessment.infra.DAO.PaymentHistoryDO;
import com.example.onlineAssessment.model.base.ResponseData;
import com.example.onlineAssessment.model.request.DisburseLoanRequest;
import com.example.onlineAssessment.model.request.QueryLoanDetailsRequest;
import com.example.onlineAssessment.model.response.DisburseLoanResponse;
import com.example.onlineAssessment.model.response.QueryLoanDetailsResponse;
import com.example.onlineAssessment.service.LoanManagementService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yijing.tan
 */
@Service
public class LoanManagementServiceImpl implements LoanManagementService {

    @Autowired
    LoanDAL loanDAL;

    @Autowired
    PaymentHistoryDAL paymentHistoryDAL;

    @Override
    public ResponseData<DisburseLoanResponse> disburseLoan(DisburseLoanRequest disburseLoanRequest) {
        Integer loanSuccessCount = loanDAL.updateLoanAmountByLoanNoAndClientNo(disburseLoanRequest.getLoanAmount(),
                disburseLoanRequest.getLoanNo(),
                disburseLoanRequest.getClientNo());

        if (ObjectUtils.isEmpty(loanSuccessCount)) {
            return ResponseData.fail(ErrorCodeEnum.SYSTEM_ERROR);
        }
        return ResponseData.success(assembleDisburseLoanResponse(disburseLoanRequest));

    }

    @Override
    public ResponseData<QueryLoanDetailsResponse> queryLoanDetails(QueryLoanDetailsRequest queryLoanDetailsRequest) {
        List<PaymentHistoryDO> paymentHistoryDOList = paymentHistoryDAL.queryPaymentHistory(queryLoanDetailsRequest.getClientNo(),
                queryLoanDetailsRequest.getLoanNo());
        return ResponseData.success(assemblLoanDetailsResponsee(paymentHistoryDOList));

    }

    private QueryLoanDetailsResponse assemblLoanDetailsResponsee(List<PaymentHistoryDO> paymentHistoryDOList) {

        // Create a map to group the PaymentHistoryDO objects by loanNo
        Map<String, List<PaymentHistoryDO>> paymentHistoryMap = paymentHistoryDOList.stream()
                .collect(Collectors.groupingBy(PaymentHistoryDO::getLoanNo));

        // Create a list of LoanAccountDetails objects based on the paymentHistoryMap
        List<QueryLoanDetailsResponse.LoanAccountDetails> loanAccountDetailsList = new ArrayList<>();
        for (Map.Entry<String, List<PaymentHistoryDO>> entry : paymentHistoryMap.entrySet()) {
            QueryLoanDetailsResponse.LoanAccountDetails loanAccountDetails = new QueryLoanDetailsResponse.LoanAccountDetails();
            loanAccountDetails.setLoanNo(entry.getKey());

            // Create a list of PaymentDetails objects based on the PaymentHistoryDO objects with the same loanNo
            List<QueryLoanDetailsResponse.PaymentDetails> paymentDetailsList = new ArrayList<>();
            for (PaymentHistoryDO paymentHistory : entry.getValue()) {
                QueryLoanDetailsResponse.PaymentDetails paymentDetails = new QueryLoanDetailsResponse.PaymentDetails();
                paymentDetails.setClientNo(paymentHistory.getClientNo());
                paymentDetails.setAmount(paymentHistory.getAmount());
                paymentDetails.setTimeStamp(paymentHistory.getTimeStamp());
                paymentDetailsList.add(paymentDetails);
            }

            loanAccountDetails.setPaymentDetails(paymentDetailsList);
            loanAccountDetailsList.add(loanAccountDetails);
        }

        // Create a QueryLoanDetailsResponse object with the list of LoanAccountDetails objects
        QueryLoanDetailsResponse queryLoanDetailsResponse = new QueryLoanDetailsResponse();
        queryLoanDetailsResponse.setLoanAccountDetails(loanAccountDetailsList);

        return queryLoanDetailsResponse;
    }

    private DisburseLoanResponse assembleDisburseLoanResponse(DisburseLoanRequest request) {
        DisburseLoanResponse disburseLoanResponse = new DisburseLoanResponse();
        disburseLoanResponse.setLoanAmount(request.getLoanAmount());
        disburseLoanResponse.setLoanNo(request.getLoanNo());
        disburseLoanResponse.setStatus(CommonEnums.SUCCESS.name());
        return disburseLoanResponse;
    }
}
