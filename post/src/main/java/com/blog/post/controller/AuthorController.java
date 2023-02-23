package com.blog.post.controller;

import com.blog.post.dto.AuthorDto;
import com.blog.post.dto.UserDto;
import com.blog.post.model.Author;
import com.blog.post.service.AuthorService;
import com.blog.post.service.UserService;
import com.blog.post.service.impl.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("/")
    ResponseEntity<?> createAuthor(@RequestBody AuthorDto AuthorDto) {
        AuthorDto author = authorService.createAuthor(AuthorDto);

        return new ResponseEntity<>(author, HttpStatus.CREATED);
    }
}
