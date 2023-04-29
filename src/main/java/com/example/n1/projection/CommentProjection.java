package com.example.n1.projection;

import com.example.n1.dto.CommentDTO;

public interface CommentProjection {
    Long getId();
    String getBody();
    Long getPostId();

    default CommentDTO fromCommentProjectionToCommentDTO () {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setId(getId());
        commentDTO.setBody(getBody());
        commentDTO.setPostId(getPostId());

        return commentDTO;
    }

}
