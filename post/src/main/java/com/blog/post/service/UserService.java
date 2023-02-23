package com.blog.post.service;

import com.blog.post.dto.UserDto;
import org.springframework.stereotype.Service;

public interface UserService {
    UserDto createUser(UserDto user);
}
