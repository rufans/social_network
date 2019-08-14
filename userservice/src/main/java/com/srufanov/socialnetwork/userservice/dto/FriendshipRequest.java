package com.srufanov.socialnetwork.userservice.dto;

import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FriendshipRequest {

    @ApiParam(required = true)
    @NotNull
    private Long requesterId;

    @ApiParam(required = true)
    @NotNull
    private Long friendId;

}
