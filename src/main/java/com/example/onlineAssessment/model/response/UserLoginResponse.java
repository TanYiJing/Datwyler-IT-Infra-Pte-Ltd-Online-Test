package com.example.onlineAssessment.model.response;

import lombok.Data;

/**
 * @author yijing.tan
 */
@Data
public class UserLoginResponse {
    private Boolean validLogin;

    public UserLoginResponse(final Boolean validLogin) {
        this.validLogin = validLogin;
    }
}
