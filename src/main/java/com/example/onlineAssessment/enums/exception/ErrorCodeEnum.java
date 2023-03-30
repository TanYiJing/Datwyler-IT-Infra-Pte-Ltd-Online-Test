package com.example.onlineAssessment.enums.exception;

import lombok.Getter;

/**
 * @author yijing.tan
 */
@Getter
public enum ErrorCodeEnum {

    /**
     * This is error code enum
     */
    SYSTEM_ERROR(0, "System Error"),
    INVALID_LOGIN(1, "Invalid Login")

    ;

    private final      int    code;
    private final String errorMessage;

    ErrorCodeEnum(int code, String errorMessage) {
        this.code = code;
        this.errorMessage = errorMessage;
    }
}
