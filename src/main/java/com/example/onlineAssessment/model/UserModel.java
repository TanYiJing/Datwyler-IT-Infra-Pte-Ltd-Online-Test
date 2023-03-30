package com.example.onlineAssessment.model;

import lombok.Data;

/**
 * @author yijing.tan
 */
@Data
public class UserModel {
    private long id;

    private String name;

    private String nickname;

    private String username;

    private String password;

    private String salt;

    private long created_on;

    private long modified_on;

}
