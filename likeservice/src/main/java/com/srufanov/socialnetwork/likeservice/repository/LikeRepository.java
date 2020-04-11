package com.srufanov.socialnetwork.likeservice.repository;

import com.srufanov.socialnetwork.likeservice.entity.Like;
import com.srufanov.socialnetwork.likeservice.entity.LikeId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, LikeId> {

    int countByLikeIdPostId(long postId);

}
