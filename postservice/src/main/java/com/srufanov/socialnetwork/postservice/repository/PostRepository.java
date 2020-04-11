package com.srufanov.socialnetwork.postservice.repository;

import com.srufanov.socialnetwork.postservice.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findFirst10ByParentPostIsNullAndUserIdInOrderByCreated(List<Long> ids);

    List<Post> findFirst10ByParentPostIdOrderByCreated(Long id);

}
