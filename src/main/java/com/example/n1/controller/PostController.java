package com.example.n1.controller;

import com.example.n1.dto.PostDTO;
import com.example.n1.dto.UserDTO;
import com.example.n1.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<UserDTO>> getTopTenUsers(@PathVariable Long id) {
        return ResponseEntity.ok(postService.getTopTenUsersPerPost(id));
    }
    @GetMapping

    public ResponseEntity<List<PostDTO>> getAllPosts(@RequestParam(required = false) Integer pageNumber,
                                                     @RequestParam(required = false) Integer size) {
        if (pageNumber == null && size == null) {
            return ResponseEntity.ok(postService.getAllPosts());
        }
        if (size == null) {
            size = 5;
        }
        return ResponseEntity.ok(postService.getAllPostWithPageable(pageNumber, size));
    }

    @GetMapping ("/comments")
    public ResponseEntity<List<PostDTO>> getAllPostWithComments(@RequestParam String body) {
        return ResponseEntity.ok(postService.getPostsWithBodyLike(body));
    }
}
