package com.example.n1.service;

import com.example.n1.dto.PostDTO;
import com.example.n1.dto.UserDTO;
import com.example.n1.projection.CommentProjection;
import com.example.n1.projection.PostProjection;
import com.example.n1.projection.UsersProjection;
import com.example.n1.repository.CommentRepository;
import com.example.n1.repository.PostRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class PostService {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public PostService(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    public List<UserDTO> getTopTenUsersPerPost(Long id) {

        List<UsersProjection> users = postRepository.findTopTenUsers(id);
        return users.stream().map(UsersProjection::fromProgectionToUserDTO)
                .collect(Collectors.toList());
    }
    public List<PostDTO> getAllPosts(){
        return postRepository.findAllBy().stream()
                .map(PostDTO::fromPostToPostDTO)
                .collect(Collectors.toList());
    }

    public List<PostDTO> getAllPostWithPageable(Integer pageNumber, Integer pageSize) {
        List<PostProjection> postProjections = postRepository.findProjBy(PageRequest.of(pageNumber - 1, pageSize));
        List<CommentProjection> commentProjections = commentRepository.findByPostIdIn(postProjections.stream()
                .map(PostProjection::getId)
                .collect(Collectors.toList()));
        return postProjections.stream()
                .map(PostProjection::fromPostProjectionToPostDTO)
                .peek(postDTO -> postDTO.setComments((commentProjections.stream()
                        .filter(comment -> comment.getPostId().equals(postDTO.getId())))
                        .map(CommentProjection::fromCommentProjectionToCommentDTO).collect(Collectors.toList())))
                .collect(Collectors.toList());
    }

    public List<PostDTO> getPostsWithBodyLike(String body) {
        return postRepository.findAll()
                .stream()
                .map(PostDTO::fromPostToPostDTO)
                .collect(Collectors.toList());
    }
}
