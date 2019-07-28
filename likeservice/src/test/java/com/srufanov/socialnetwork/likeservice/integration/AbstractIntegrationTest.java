package com.srufanov.socialnetwork.likeservice.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.srufanov.socialnetwork.likeservice.repository.LikeRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.authentication;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql(scripts = "/db/clean-up.sql")
public abstract class AbstractIntegrationTest {

    @Autowired
    protected ObjectMapper mapper;

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected LikeRepository likeRepository;

    protected MvcResult testOkEntityResponse(MockHttpServletRequestBuilder requestBuilder) throws Exception {
        return performRequest(null, requestBuilder, status().isOk());
    }

    protected MvcResult testOkEntityResponse(MockHttpServletRequestBuilder builder, Object request) throws Exception {
        return performRequest(null, builder, request, status().isOk());
    }

    protected MvcResult testBadRequestResponse(MockHttpServletRequestBuilder builder, Object request) throws Exception {
        return performRequest(null, builder, request, status().isBadRequest());
    }

    protected MvcResult performRequest(Authentication authentication,
                                       MockHttpServletRequestBuilder requestBuilder,
                                       Object request,
                                       ResultMatcher statusMatcher) throws Exception {
        return mockMvc.perform(requestBuilder
                .contentType(APPLICATION_JSON_UTF8_VALUE)
                .content(mapper.writeValueAsBytes(request))
                .with(authentication(authentication)))
                .andDo(print())
                .andExpect(statusMatcher)
                .andReturn();
    }

    protected MvcResult performRequest(Authentication authentication,
                                       MockHttpServletRequestBuilder requestBuilder,
                                       ResultMatcher statusMatcher) throws Exception {
        return mockMvc.perform(requestBuilder
                .with(authentication(authentication)))
                .andDo(print())
                .andExpect(statusMatcher)
                .andReturn();
    }

}
