package com.example.onlineAssessment.service.impl;

import com.example.onlineAssessment.enums.CommonEnums;
import com.example.onlineAssessment.enums.exception.ErrorCodeEnum;
import com.example.onlineAssessment.infra.DAL.LoanDAL;
import com.example.onlineAssessment.infra.DAO.LoanDAO;
import com.example.onlineAssessment.infra.DAO.UserDAO;
import com.example.onlineAssessment.model.base.ResponseData;
import com.example.onlineAssessment.model.request.DisburseLoanRequest;
import com.example.onlineAssessment.model.request.QueryLoanDetailsRequest;
import com.example.onlineAssessment.model.response.DisburseLoanResponse;
import com.example.onlineAssessment.model.response.QueryLoanDetailsResponse;
import com.example.onlineAssessment.service.LoanManagementService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yijing.tan
 */
@Service
public class LoanManagementServiceImpl implements LoanManagementService {

    @Autowired
    LoanDAL loanDAL;

    @Override
    public ResponseData<DisburseLoanResponse> disburseLoan(DisburseLoanRequest disburseLoanRequest) {
        Integer loanSuccessCount = loanDAL.updateLoanAmountByLoanNoAndClientNo(disburseLoanRequest.getLoanAmount(), disburseLoanRequest.getLoanNo(),
                disburseLoanRequest.getClientNo());

        if (ObjectUtils.isEmpty(loanSuccessCount)) {
            return ResponseData.fail(ErrorCodeEnum.SYSTEM_ERROR);
        }
        return ResponseData.success(assembleDisburseLoanResponse(disburseLoanRequest));

    }

    @Override
    public ResponseData<QueryLoanDetailsResponse> queryLoanDetails(String headerToken,
                                                                   QueryLoanDetailsRequest queryLoanDetailsRequest) {
        return null;
    }

    private DisburseLoanResponse assembleDisburseLoanResponse(DisburseLoanRequest request) {
        DisburseLoanResponse disburseLoanResponse = new DisburseLoanResponse();
        disburseLoanResponse.setLoanAmount(request.getLoanAmount());
        disburseLoanResponse.setLoanNo(request.getLoanNo());
        disburseLoanResponse.setStatus(CommonEnums.SUCCESS.name());
        return disburseLoanResponse;
    }
}
