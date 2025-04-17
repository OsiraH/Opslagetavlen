package com.example.restservice;
import java.time.LocalDateTime;

public record Post(String author, String content, LocalDateTime creationDate) { 

    public Post CreatePost(String author, String content) {
        Post newPost = new Post(author, content, LocalDateTime.now());
        return newPost;
    }
}