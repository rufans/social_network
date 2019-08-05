package com.srufanov.socialnetwork.postservice.controller;

import com.srufanov.socialnetwork.postservice.dto.PostDTO;
import com.srufanov.socialnetwork.postservice.entity.Post;
import com.srufanov.socialnetwork.postservice.repository.PostRepository;
import com.srufanov.socialnetwork.postservice.service.PostService;
import com.srufanov.socialnetwork.postservice.service.PostToDtoConverter;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping("/api/v1/post")
@RestController
public class PostController {

    private final PostService postService;
    private final PostRepository postRepository;
    private final PostToDtoConverter postToDtoConverter;

    public PostController(PostService postService, PostRepository postRepository, PostToDtoConverter postToDtoConverter) {
        this.postService = postService;
        this.postRepository = postRepository;
        this.postToDtoConverter = postToDtoConverter;
    }

    @PostMapping
    public void addPost(@Valid @RequestBody PostDTO postDTO) {
        postService.saveFromDTO(postDTO);
    }

    @GetMapping("/{id}")
    public PostDTO getPost(@PathVariable @NotNull Long id) {
        return postToDtoConverter.convertToDto(postService.findById(id));
    }

    @PutMapping("/{id}")
    public void updatePost(@PathVariable Long id, @Valid @RequestBody PostDTO postDTO) {
        postService.updateFromDTO(id, postDTO);
    }

    @DeleteMapping("/{id}")
    public void removePost(@PathVariable Long id) {
        postRepository.deleteById(id);
    }

    @GetMapping("/feed/{ids}")
    public List<PostDTO> getPostsFeed(@PathVariable @NotNull @DecimalMin("0") List<Long> ids) {
        List<Post> first10Posts = postRepository.findFirst10ByParentPostIsNullAndUserIdInOrderByCreated(ids);
        return postToDtoConverter.convertListToDto(first10Posts);
    }

    @GetMapping("/{id}/comments")
    public List<PostDTO> getCommentsForPost(@PathVariable @NotNull @DecimalMin("0") Long id) {
        List<Post> comments = postRepository.findFirst10ByParentPostIdOrderByCreated(id);
        return postToDtoConverter.convertListToDto(comments);
    }

}
