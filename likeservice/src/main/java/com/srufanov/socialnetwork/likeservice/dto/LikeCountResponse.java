package com.srufanov.socialnetwork.likeservice.dto;

import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LikeCountResponse {

    @NotBlank
    @ApiParam(required = true)
    private int likesCount;

}
