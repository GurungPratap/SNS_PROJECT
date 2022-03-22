package com.sns.project.sns_core.payload;

import com.sns.project.sns_core.model.UserPost;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostResponse {
    private List<UserPost> post;
   //TODO: ADD remaining features here

}
