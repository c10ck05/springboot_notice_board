package com.example.board.controller;

import com.example.board.dto.PostCreateRequest;
import com.example.board.entity.Post;
import com.example.board.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


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
}
