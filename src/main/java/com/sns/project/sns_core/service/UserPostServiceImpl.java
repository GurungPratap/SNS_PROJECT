package com.sns.project.sns_core.service;

import com.sns.project.sns_core.model.UserPost;
import com.sns.project.sns_core.repository.UserPostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPostServiceImpl implements UserPostService{
    @Autowired
    private UserPostRepository userPostRepository;

    Logger logger = LoggerFactory.getLogger(UserPostServiceImpl.class);

    /**
     *
     * @param username
     * @return
     */
    @Override
    public List<UserPost> getPostsByUserName(String username) {
        return userPostRepository.findByUsernameOrderByTimestampDesc(username);
    }

    /**
     *
     * @param post
     * @return
     */
    @Override
    public boolean savePost(UserPost post) {
        UserPost saved = userPostRepository.save(post);
        if(saved !=null)
            return true;
        return false;
    }

    /**
     *
     * @param postId
     * @return
     */
    @Override
    public boolean deletePostById(long postId) {
        try{
            userPostRepository.deleteById(postId);
            logger.info("Post with id: " + postId + "deleted successfully");
            return true;
        }catch (Exception ex){
            logger.error(ex.getMessage());
        }
        return false;
    }
}
