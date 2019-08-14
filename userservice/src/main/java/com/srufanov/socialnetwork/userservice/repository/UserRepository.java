package com.srufanov.socialnetwork.userservice.repository;

import com.srufanov.socialnetwork.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    Optional<User> findByUsernameOrEmail(String username, String email);

    @Query("SELECT u FROM User u LEFT JOIN u.friendRequests fr LEFT JOIN u.friends f " +
            "WHERE (fr.friend.id = ?1 OR f.requester.id = ?1) " +
            "AND (fr.status = com.srufanov.socialnetwork.userservice.enumeration.FriendshipStatus.ADDED OR " +
            "f.status = com.srufanov.socialnetwork.userservice.enumeration.FriendshipStatus.ADDED)")
    List<User> findFriendsWithQuery(Long userId);

    @Query("SELECT u FROM User u LEFT JOIN u.friendRequests fr " +
            "WHERE fr.friend.id = ?1 AND fr.status = com.srufanov.socialnetwork.userservice.enumeration.FriendshipStatus.REQUESTED")
    List<User> findRequestedUsersWithQuery(Long userId);
}
