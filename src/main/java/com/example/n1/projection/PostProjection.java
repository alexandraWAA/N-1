package com.example.n1.projection;

import com.example.n1.dto.PostDTO;

public interface PostProjection {
    Long getId();

    String getUsername();

    String getTitle();

    String getBody();
//    Long getAllCommentsCount();
//    Long getLastPostId();
//    Long getAllPostCount();
    public default PostDTO fromPostProjectionToPostDTO() {
        PostDTO postDTO = new PostDTO();
        postDTO.setId(getId());
        postDTO.setTitle(getTitle());
        postDTO.setBody(getBody());
//        postDTO.setUsername(getUsername());
//        postDTO.setCountPosts(getAllPostCount());
//        postDTO.setCountComments(getAllCommentsCount());

        return postDTO;
    }

//    public static PostProjection toProjection(PostDTO postDTO) {
//        PostProjection projection = new PostProjection();
//        projection.setId(postDTO.getUserId());
//        projection.setUserName(postDTO.getUserName());
//        projection.setCountPosts(postDTO.getAllPostCount());
//        projection.setCountComments(postDTO.getAllCommentsCount());
//        projection.setLatestPostId(postDTO.getLastPostId());
//
//        return projection;
//    }
}
