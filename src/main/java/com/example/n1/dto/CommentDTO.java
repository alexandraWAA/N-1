package com.example.n1.dto;

import com.example.n1.model.Comment;
import lombok.Data;

@Data
public class CommentDTO {
    private Long id;
    private String body;
    private Long postId;

    public static CommentDTO fromCommentToCommentDTO(Comment comment) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setId(comment.getId());
        commentDTO.setBody(comment.getBody());
        commentDTO.setPostId(comment.getPost().getId());

        return commentDTO;
    }
}
