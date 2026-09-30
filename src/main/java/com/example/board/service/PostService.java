package com.example.board.service;

import com.example.board.dto.PostCreateRequest;
import com.example.board.entity.Post;
import com.example.board.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post postBoard(PostCreateRequest postCreateRequest) {
        String title = postCreateRequest.getTitle();
        String content = postCreateRequest.getContent();
        return postRepository.save(new Post(title, content));
    }
}
