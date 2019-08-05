package com.srufanov.socialnetwork.postservice.dto;

import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {

    @ApiParam
    @NotNull
    private String text;

    @ApiParam
    @NotNull
    private Long userId;

    @ApiParam
    private byte[] image;

    @ApiParam
    private Long parentPostId;

}
