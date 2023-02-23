package com.blog.post.controller;

import com.blog.post.dto.PostDto;
import com.blog.post.service.PostService;
import com.blog.post.service.impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService service;

    @GetMapping("/")
    public ResponseEntity<List<PostDto>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getById(@PathVariable Integer id) {
        return new ResponseEntity<>(service.getId(id), HttpStatus.OK);
    }

    @GetMapping("/title/")
    public ResponseEntity<List<PostDto>> findByTitle(@RequestBody String input) {
        return new ResponseEntity<>(service.findByTitle(input), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> addPost(@RequestBody PostDto post) {
        PostDto result = service.addPost(post);
        if (result == null) {
            return new ResponseEntity<>("Cant add post because there is 1 exist in database", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Integer id) {
        return new ResponseEntity<>(service.deleteById(id), HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<?> updatePost(@RequestBody PostDto post) {
        PostDto result = service.updatePost(post);
        if (result == null) {
            return new ResponseEntity<>("Cant update post because it not exist in database", HttpStatus.CREATED);
        }
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}