package com.srufanov.socialnetwork.postservice.service;

import com.srufanov.socialnetwork.postservice.dto.PostDTO;
import com.srufanov.socialnetwork.postservice.entity.Post;
import com.srufanov.socialnetwork.postservice.exception.PostNotFoundException;
import com.srufanov.socialnetwork.postservice.repository.PostRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostService {

    @Value("${post.image-path}")
    private String fileStoragePath;

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Transactional
    public void saveFromDTO(PostDTO postDTO) {
        Post post = new Post();
        post.setText(postDTO.getText());
        post.setUserId(postDTO.getUserId());

        Long parentPostId = postDTO.getParentPostId();
        if (parentPostId != null) {
            Post parentPost = findById(parentPostId);
            post.setParentPost(parentPost);
            parentPost.getChildPosts().add(post);
        }

        // name = userId_timestamp_imageName
        // create new folder for every user - you can remove user and all images then
        // TODO: save file to fileStorage
        post.setImagePath("test_path.jpg");

        postRepository.save(post);
    }

    public Post findById(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new PostNotFoundException("Post has not been found. Id: " + id));
    }

    @Transactional
    public void updateFromDTO(Long id, PostDTO postDTO) {
        Post post = findById(id);

        post.setUserId(postDTO.getUserId());
        post.setText(postDTO.getText());

        // TODO: 1. remove previous image if changed; 2. save new image; 3. set path
        post.setImagePath("new_test_path.jpg");

        postRepository.save(post);
    }
}
