package com.srufanov.socialnetwork.userservice.repository;

import com.srufanov.socialnetwork.userservice.entity.Friendship;
import com.srufanov.socialnetwork.userservice.entity.FriendshipId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendshipRepository extends JpaRepository<Friendship, FriendshipId> {

}
