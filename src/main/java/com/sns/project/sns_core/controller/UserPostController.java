package com.sns.project.sns_core.controller;

import com.sns.project.sns_core.model.UserPost;
import com.sns.project.sns_core.service.UserPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserPostController {
    @Autowired
    private UserPostService userPostService;

    @PostMapping("/savePost")
    public String savePost(@Valid @RequestBody UserPost post){
        boolean result = userPostService.savePost(post);
        if(result)
            return "Post Saved Successfully!!!";
        return "Post could not be saved!!!";
    }

    @GetMapping("/getPosts")
    public List<UserPost> getPosts(@Valid @RequestParam String username){
        List<UserPost> result = userPostService.getPostsByUserName(username);
        return result;
    }

}
