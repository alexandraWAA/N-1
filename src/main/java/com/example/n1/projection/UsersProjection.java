package com.example.n1.projection;

import com.example.n1.dto.UserDTO;

public interface UsersProjection {
    Long getId();
    String getUserName();
    Long getAllPostCount();
    Long getAllCommentsCount();
    Long getLastPostId();

    public default UserDTO fromProgectionToUserDTO() {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(getId());
        userDTO.setUserName(getUserName());
        userDTO.setCountPosts(getAllPostCount());
        userDTO.setCountComments(getAllCommentsCount());
        userDTO.setLatestPostId(getLastPostId());
        return userDTO;
    }

}
