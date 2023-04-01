package com.example.onlineAssessment.infra.DAL;

import com.example.onlineAssessment.infra.DAO.LoanDAO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LoanDAL {
    List<LoanDAO> queryLoanByClientNo(String clientNo);

    LoanDAO queryLoanByClientNoAndLoanNo(String clientNo, String loanNo);

    Integer repayFullLoanAmountByClientNoAndLoanNo(String clientNo, String loanNo);

    Integer updateLoanAmountByLoanNoAndClientNo(String loanAmount,String loanNo, String clientNo);

    Integer insertLoan(String clientNo, String loanNo);

}
