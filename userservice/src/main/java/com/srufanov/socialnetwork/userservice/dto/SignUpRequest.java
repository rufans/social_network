package com.srufanov.socialnetwork.userservice.dto;

import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {

    @ApiParam(required = true)
    @NotBlank
    @Size(min = 3, max = 40)
    private String name;

    @ApiParam(required = true)
    @NotBlank
    @Size(min = 3, max = 15)
    private String username;

    @ApiParam(required = true)
    @NotBlank
    @Size(max = 40)
    @Email
    private String email;

    @ApiParam(required = true)
    @NotBlank
    @Size(min = 6, max = 100)
    private String password;

}
