package com.srufanov.socialnetwork.userservice.service;

import com.srufanov.socialnetwork.userservice.dto.UserDTO;
import com.srufanov.socialnetwork.userservice.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserToDtoConverter {

    public UserDTO convertToDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setUsername(user.getUsername());

        return userDTO;
    }

    public List<UserDTO> convertListToDto(List<User> users) {
        return users.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

}
