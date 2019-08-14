package com.srufanov.socialnetwork.userservice.dto;

import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {

    @ApiParam(required = true)
    @NotBlank
    private String usernameOrEmail;

    @ApiParam(required = true)
    @NotBlank
    private String password;

}
