package com.example.onlineAssessment.model.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author yijing.tan
 */
@Data
public class OnboardCreditFacilityRequest {
    @NotBlank(message = "cannot be blank")
    private String username;

}
