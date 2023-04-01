package com.example.onlineAssessment.enums;

import lombok.Getter;

@Getter
public enum CommonEnums {

    /**
     * Common Enum Type
     */
    SUCCESS(0, "SUCCESS"),

    FAILED(1, "FAILED");
    private final int    code;
    private final String desc;

    CommonEnums(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
