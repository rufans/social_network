package com.srufanov.socialnetwork.likeservice.dto;

import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LikeActionRequest {

    @NotNull
    @ApiParam(required = true)
    private Long postId;

    @NotNull
    @ApiParam(required = true)
    private Long userId;

}
