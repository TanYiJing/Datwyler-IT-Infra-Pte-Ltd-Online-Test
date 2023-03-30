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
    PARTIAL_REPAYMENT(0, "Partial Repayment"),

    FULL_REPAYMENT(0, "Full Repayment");
    private final int    code;
    private final String desc;

    RepaymentType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
