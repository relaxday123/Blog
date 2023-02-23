package com.blog.post.service;

import com.blog.post.dto.AuthorDto;
import com.blog.post.dto.UserDto;
import com.blog.post.model.Author;

import java.util.List;

public interface AuthorService {
    Author getByUsername(String username);
    List<AuthorDto> getAll();
    AuthorDto addPost(AuthorDto post);
    AuthorDto createAuthor(AuthorDto author);
}
