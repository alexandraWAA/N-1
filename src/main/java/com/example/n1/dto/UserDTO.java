package com.example.n1.dto;

import com.example.n1.model.Users;
import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String userName;
    private Long countPosts;
    private Long countComments;
    private Long latestPostId;

    public static UserDTO fromUserToUserDTO (Users user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUserName(user.getUserName());
        return userDTO;
    }
    public Users toUsers () {
        Users user = new Users();
        user.setId(this.getId());
        user.setUserName(this.getUserName());
        return user;
    }
}
