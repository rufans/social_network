package com.srufanov.socialnetwork.userservice.service;

import com.srufanov.socialnetwork.userservice.entity.User;
import com.srufanov.socialnetwork.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public List<User> getFriends(Long userId) {
        return userRepository.findFriendsWithQuery(userId);
    }

    @Transactional
    public List<User> getRequestedUsers(Long userId) {
        return userRepository.findRequestedUsersWithQuery(userId);
    }
}
