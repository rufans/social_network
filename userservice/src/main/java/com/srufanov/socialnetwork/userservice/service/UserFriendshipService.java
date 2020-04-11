package com.srufanov.socialnetwork.userservice.service;

import com.srufanov.socialnetwork.userservice.dto.FriendshipRequest;
import com.srufanov.socialnetwork.userservice.entity.Friendship;
import com.srufanov.socialnetwork.userservice.entity.FriendshipId;
import com.srufanov.socialnetwork.userservice.entity.User;
import com.srufanov.socialnetwork.userservice.enumeration.FriendshipStatus;
import com.srufanov.socialnetwork.userservice.exception.FriendshipNotFoundException;
import com.srufanov.socialnetwork.userservice.exception.UserNotFoundException;
import com.srufanov.socialnetwork.userservice.repository.FriendshipRepository;
import com.srufanov.socialnetwork.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class UserFriendshipService {

    private final UserRepository userRepository;
    private final FriendshipRepository friendshipRepository;

    public UserFriendshipService(UserRepository userRepository, FriendshipRepository friendshipRepository) {
        this.userRepository = userRepository;
        this.friendshipRepository = friendshipRepository;
    }

    @Transactional
    public void addFriendshipRequest(FriendshipRequest friendshipRequest) {

        User requester = userRepository.findById(friendshipRequest.getRequesterId())
                .orElseThrow(() -> new UserNotFoundException("Can't find requester user"));

        User friend = userRepository.findById(friendshipRequest.getFriendId())
                .orElseThrow(() -> new UserNotFoundException("Can't find friend user"));

        Friendship friendship = new Friendship(requester, friend, FriendshipStatus.REQUESTED, new Date());
        friendshipRepository.save(friendship);
    }

    @Transactional
    public void acceptFriendshipRequest(FriendshipRequest friendshipRequest) {

        Friendship friendship = findFriendshipByRequest(friendshipRequest);

        if (friendship.getStatus() == FriendshipStatus.REQUESTED) {
            friendship.setStatus(FriendshipStatus.ADDED);
            friendshipRepository.save(friendship);
        }
    }

    @Transactional
    public void refuseFriendshipRequest(FriendshipRequest friendshipRequest) {
        Friendship friendship = findFriendshipByRequest(friendshipRequest);

        if (friendship.getStatus() == FriendshipStatus.REQUESTED) {
            friendshipRepository.delete(friendship);
        }
    }

    private Friendship findFriendshipByRequest(FriendshipRequest friendshipRequest) {

        User requester = userRepository.findById(friendshipRequest.getRequesterId())
                .orElseThrow(() -> new UserNotFoundException("Can't find requester user"));

        User friend = userRepository.findById(friendshipRequest.getFriendId())
                .orElseThrow(() -> new UserNotFoundException("Can't find friend user"));

        Long requesterId = requester.getId();
        Long friendId = friend.getId();

        return friendshipRepository.findById(new FriendshipId(requester.getId(), friend.getId())).orElseThrow(() ->
                new FriendshipNotFoundException(String.format("Can't find friendship. Requester id: %s. Friend id: %s", requesterId, friendId)));
    }
}
