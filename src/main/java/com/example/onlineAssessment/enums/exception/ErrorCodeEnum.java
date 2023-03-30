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
    INVALID_LOGIN(1, "Invalid Login"),

    REGISTER_FAIL(2, "Register Fail"),

    REDIS_FAIL(3, "Redis Error"),

    DUPLICATED_USERNAME(3, "Duplicate Username Error"),

    ;

    private final      int    code;
    private final String errorMessage;

    ErrorCodeEnum(int code, String errorMessage) {
        this.code = code;
        this.errorMessage = errorMessage;
    }
}
