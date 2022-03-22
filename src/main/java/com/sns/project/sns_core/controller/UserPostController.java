package com.sns.project.sns_core.controller;

import com.sns.project.sns_core.model.UserPost;
import com.sns.project.sns_core.payload.PostRequest;
import com.sns.project.sns_core.payload.PostResponse;
import com.sns.project.sns_core.service.UserPostService;
import com.sns.project.sns_core.util.PostApiLoggerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserPostController {
    @Autowired
    private UserPostService userPostService;

    Logger logger = LoggerFactory.getLogger(UserPostController.class);
    @PostMapping("/savePost")
    public String savePost(@Valid @RequestBody UserPost post){
        boolean result = userPostService.savePost(post);
        if(result)
            return "Post Saved Successfully!!!";
        return "Post could not be saved!!!";
    }

    /**
     * Get Posts By username
     * @param postRequest
     * @return
     */
    @GetMapping("/getPosts")
    public PostResponse getPostsByUsername(@Valid @RequestBody PostRequest postRequest){
        Timestamp startTimestamp = new Timestamp(System.currentTimeMillis());
        List<UserPost> result = userPostService.getPostsByUserName(postRequest.getUsername());
        PostResponse postResponse = PostResponse.builder().post(result).build();
        Timestamp endTimestamp = new Timestamp(System.currentTimeMillis());

        //log method execution info
        PostApiLoggerUtil.logMethod(logger,postRequest.getUsername(),userPostService.getClass().getName(),
                "getPostsByUsername()",startTimestamp,endTimestamp);
        return postResponse;
    }


}
