package com.sns.project.sns_core.repository;

import com.sns.project.sns_core.model.UserPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface UserPostRepository extends JpaRepository<UserPost, Long> {
    List<UserPost> findByUsernameOrderByTimestampDesc(String username);
}
