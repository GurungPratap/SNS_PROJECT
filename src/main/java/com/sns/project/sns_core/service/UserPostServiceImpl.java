package com.sns.project.sns_core.service;

import com.sns.project.sns_core.model.UserPost;
import com.sns.project.sns_core.repository.UserPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPostServiceImpl implements UserPostService{
    @Autowired
    private UserPostRepository userPostRepository;

    @Override
    public List<UserPost> getPostsByUserName(String username) {
        return userPostRepository.findByUsernameOrderByTimestampDesc(username);
    }

    @Override
    public boolean savePost(UserPost post) {
        UserPost saved = userPostRepository.save(post);
        if(saved !=null)
            return true;
        return false;
    }
}
