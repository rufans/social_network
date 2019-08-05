package com.srufanov.socialnetwork.likeservice.integration.like;

import com.srufanov.socialnetwork.likeservice.dto.LikeActionRequest;
import com.srufanov.socialnetwork.likeservice.entity.Like;
import com.srufanov.socialnetwork.likeservice.entity.LikeId;
import com.srufanov.socialnetwork.likeservice.exception.LikeServiceException;
import com.srufanov.socialnetwork.likeservice.integration.AbstractIntegrationTest;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

public class HandleLikeActionTest extends AbstractIntegrationTest {

    private static final String LIKE_ACTION_URI = "/api/v1/like/";

    @Test
    public void handleLikeActionWithEmptyPostId() throws Exception {
        LikeActionRequest request = new LikeActionRequest();
        request.setUserId(1L);

        testBadRequestResponse(post(LIKE_ACTION_URI), request);
    }

    @Test
    public void handleLikeActionWithEmptyUserId() throws Exception {
        LikeActionRequest request = new LikeActionRequest();
        request.setPostId(1L);

        testBadRequestResponse(post(LIKE_ACTION_URI), request);
    }

    @Test
    public void handleLikeActionShouldAddIfNotExist() throws Exception {
        LikeActionRequest request = new LikeActionRequest(1L, 1L);
        testOkEntityResponse(post(LIKE_ACTION_URI), request);

        LikeId likeId = new LikeId(1L, 1L);
        Like like = likeRepository.findById(likeId)
                .orElseThrow(() -> new LikeServiceException("Cannot find saved like"));

        assertNotNull(like);
        assertEquals(request.getPostId(), likeId.getPostId());
        assertEquals(request.getUserId(), likeId.getUserId());
    }

    @Test
    public void handleLikeActionShouldRemoveIfExist() throws Exception {
        LikeId likeId = new LikeId(1L, 1L);
        likeRepository.save(new Like(likeId));

        LikeActionRequest request = new LikeActionRequest(1L, 1L);
        testOkEntityResponse(post(LIKE_ACTION_URI), request);

        Optional<Like> likeOptional = likeRepository.findById(likeId);
        assertFalse(likeOptional.isPresent());
    }

}
