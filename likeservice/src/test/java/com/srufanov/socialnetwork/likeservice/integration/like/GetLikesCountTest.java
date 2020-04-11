package com.srufanov.socialnetwork.likeservice.integration.like;

import com.srufanov.socialnetwork.likeservice.dto.LikeCountResponse;
import com.srufanov.socialnetwork.likeservice.entity.Like;
import com.srufanov.socialnetwork.likeservice.entity.LikeId;
import com.srufanov.socialnetwork.likeservice.integration.AbstractIntegrationTest;
import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.Assert.assertNotNull;

public class GetLikesCountTest extends AbstractIntegrationTest {

    private static final String LIKE_ACTION_URI = "/api/v1/like/count?postId=%s";

    @Test
    public void getLikesCountSuccessfully() throws Exception {
        likeRepository.save(new Like(new LikeId(1L, 1L)));
        likeRepository.save(new Like(new LikeId(1L, 2L)));
        likeRepository.save(new Like(new LikeId(1L, 3L)));

        MvcResult mvcResult = testOkEntityResponse(get(String.format(LIKE_ACTION_URI, 1)));
        LikeCountResponse likeCountResponse = mapper.readValue(mvcResult.getResponse().getContentAsString(), LikeCountResponse.class);

        assertNotNull(likeCountResponse);
        assertEquals(likeCountResponse.getLikesCount(), 3);
    }

}
