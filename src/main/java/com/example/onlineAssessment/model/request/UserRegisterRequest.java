package com.example.onlineAssessment.model.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserRegisterRequest {
    @NotBlank(message = "cannot be blank")
    private String username;

    @NotBlank(message = "cannot be blank")
    private String password;

    @NotBlank(message = "cannot be blank")
    private String name;

}
