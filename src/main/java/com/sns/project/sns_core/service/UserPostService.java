package com.sns.project.sns_core.service;

import com.sns.project.sns_core.model.UserPost;
import com.sns.project.sns_core.repository.UserPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserPostService {
   List<UserPost> getPostsByUserName(String username);
   boolean savePost(UserPost post);
}
