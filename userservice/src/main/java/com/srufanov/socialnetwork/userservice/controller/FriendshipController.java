package com.srufanov.socialnetwork.userservice.controller;

import com.srufanov.socialnetwork.userservice.dto.FriendshipRequest;
import com.srufanov.socialnetwork.userservice.service.UserFriendshipService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/friendship")
public class FriendshipController {

    private final UserFriendshipService userFriendshipService;

    public FriendshipController(UserFriendshipService userFriendshipService) {
        this.userFriendshipService = userFriendshipService;
    }

    @PostMapping("request")
    public void addFriendshipRequest(@Valid @RequestBody FriendshipRequest friendshipRequest) {
        userFriendshipService.addFriendshipRequest(friendshipRequest);
    }

    @PostMapping("accept")
    public void acceptFriendshipRequest(@Valid @RequestBody FriendshipRequest friendshipRequest) {
        userFriendshipService.acceptFriendshipRequest(friendshipRequest);
    }

    @DeleteMapping("refuse")
    public void refuseFriendshipRequest(@Valid @RequestBody FriendshipRequest friendshipRequest) {
        userFriendshipService.refuseFriendshipRequest(friendshipRequest);
    }

}
