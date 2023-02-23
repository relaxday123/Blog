package com.blog.post.service;

import com.blog.post.dto.PostDto;
import com.blog.post.dto.UserDto;

import java.util.List;

public interface PostService {
    List<PostDto> getAll();
    PostDto getId(Integer id);
    PostDto addPost(PostDto post);
    int deleteById(Integer id);
    PostDto updatePost(PostDto post);

    List<PostDto> findByTitle(String input);
}
