package com.example.onlineAssessment.enums;

import lombok.Getter;

/**
 * @author yijing.tan
 */
@Getter
public enum RepaymentType {

    /**
     * Repayment Type
     */
    PARTIAL_REPAYMENT("PR", "Partial Repayment"),

    FULL_REPAYMENT("FR", "Full Repayment");
    private final String code;
    private final String desc;

    RepaymentType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
