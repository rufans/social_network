package com.srufanov.socialnetwork.userservice.dto;

import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @NotNull
    @ApiParam(required = true)
    private Long id;

    @ApiParam
    private String name;

    @ApiParam
    private String email;

    @NotNull
    @ApiParam(required = true)
    private String username;

}
