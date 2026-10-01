package com.example.board.controller;

import com.example.board.dto.PostCreateRequest;
import com.example.board.entity.Post;
import com.example.board.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
    

    @PostMapping("/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public Post create(@RequestBody PostCreateRequest postCreateRequest) {
        return postService.postBoard(postCreateRequest);
    }

    @GetMapping("/posts")
    @ResponseStatus(HttpStatus.OK)
    public List<Post> readAll() {
        return postService.getPosts();
    }

    @GetMapping("/posts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Post read(@PathVariable Long id) {
        return postService.getPost(id);
    }
}
