package com.example.n1.dto;

import com.example.n1.model.Post;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class PostDTO {

    private Long id;
    private String title;
    private String body;
    private List<CommentDTO> comments;
    private UserDTO user;

    public static PostDTO fromPostToPostDTO (Post post) {
        List<CommentDTO> commentList = post.getComments().stream()
                .map(CommentDTO::fromCommentToCommentDTO)
                .collect(Collectors.toList());
        PostDTO postDTO = new PostDTO();
        postDTO.setId(post.getId());
        postDTO.setTitle(post.getTitle());
        postDTO.setBody(post.getBody());
        postDTO.setComments(commentList);
        postDTO.setUser(UserDTO.fromUserToUserDTO(post.getUser()));
        return postDTO;
    }
    public Post toPost () {
        Post post = new Post();
        post.setId(this.getId());
        post.setTitle(this.getTitle());
        post.setBody(this.getBody());

        return post;
    }

}
