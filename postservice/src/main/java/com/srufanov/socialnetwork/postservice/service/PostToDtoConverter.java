package com.srufanov.socialnetwork.postservice.service;

import com.srufanov.socialnetwork.postservice.dto.PostDTO;
import com.srufanov.socialnetwork.postservice.entity.Post;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostToDtoConverter {

    public PostDTO convertToDto(Post post) {
        PostDTO dto = new PostDTO();

        dto.setText(post.getText());
        dto.setUserId(post.getUserId());

        // TODO: read from image with path
        dto.setImage(new byte[8]);

        Post parentPost = post.getParentPost();
        if (parentPost != null) {
            dto.setParentPostId(parentPost.getId());
        }

        return dto;
    }

    public List<PostDTO> convertListToDto(List<Post> posts) {
        return posts.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

}