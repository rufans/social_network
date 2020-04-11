package com.srufanov.socialnetwork.userservice.controller;

import com.srufanov.socialnetwork.userservice.dto.UserDTO;
import com.srufanov.socialnetwork.userservice.entity.User;
import com.srufanov.socialnetwork.userservice.service.UserService;
import com.srufanov.socialnetwork.userservice.service.UserToDtoConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;
    private final UserToDtoConverter converter;

    public UserController(UserService userService, UserToDtoConverter converter) {
        this.userService = userService;
        this.converter = converter;
    }

    @GetMapping("{userId}/friends")
    public List<UserDTO> getFriends(@NotNull @PathVariable Long userId) {
        List<User> friends = userService.getFriends(userId);
        return converter.convertListToDto(friends);
    }

    @GetMapping("{userId}/requests")
    public List<UserDTO> getRequestedUsers(@NotNull @PathVariable Long userId) {
        List<User> requestedUsers = userService.getRequestedUsers(userId);
        return converter.convertListToDto(requestedUsers);
    }

}
