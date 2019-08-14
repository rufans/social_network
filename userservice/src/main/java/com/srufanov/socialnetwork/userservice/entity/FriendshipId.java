package com.srufanov.socialnetwork.userservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FriendshipId implements Serializable {

    private long requester;
    private long friend;

}
