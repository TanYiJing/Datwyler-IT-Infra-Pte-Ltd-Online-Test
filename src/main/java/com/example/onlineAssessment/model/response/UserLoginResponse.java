package com.example.onlineAssessment.model.response;

import lombok.Data;

/**
 * @author yijing.tan
 */
@Data
public class UserLoginResponse {
    private Boolean validLogin;

    private UserDetails userDetails;

    @Data
    public static class UserDetails {
        private String name;

        private String clientNo;

        private String username;

    }

    public UserLoginResponse(final Boolean validLogin) {
        this.validLogin = validLogin;
    }
}
