package com.srufanov.socialnetwork.likeservice.controller;

import com.srufanov.socialnetwork.likeservice.dto.LikeActionRequest;
import com.srufanov.socialnetwork.likeservice.dto.LikeCountResponse;
import com.srufanov.socialnetwork.likeservice.service.LikeService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/like")
public class LikeController {

    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping
    public void handleLikeAction(@Valid @RequestBody LikeActionRequest request) {
        likeService.handleLikeAction(request.getPostId(), request.getUserId());
    }

    @GetMapping(value = "count")
    public LikeCountResponse getLikesCountForPost(@RequestParam Long postId) {
        return new LikeCountResponse(likeService.getLikeCountForPost(postId));
    }

}
