package com.example.board.service;

import com.example.board.exception.ResponseStatusException;
import com.example.board.dto.PostCreateRequest;
import com.example.board.entity.Post;
import com.example.board.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    public Post getPost(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new ResponseStatusException("찾는 게시물이 없습니다."));
    }
}
