//package com.blog.post.controller;
//
//import com.blog.post.dto.AuthorDto;
//import com.blog.post.dto.UserDto;
//import com.blog.post.model.Author;
//import com.blog.post.repository.AuthorRepository;
//import com.blog.post.service.AuthorService;
//import com.blog.post.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/users")
//public class UserController {
//
//    @Autowired
//    UserService userService;
//
//    @PostMapping("/")
//    ResponseEntity<?> createUser(@RequestBody UserDto userDto) {
//        UserDto user = userService.createUser(userDto);
//
//        return new ResponseEntity<>(user, HttpStatus.CREATED);
//    }
//}
