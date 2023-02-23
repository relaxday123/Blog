//package com.blog.post.service.impl;
//
//import com.blog.post.dto.UserDto;
//import com.blog.post.mapper.UserMapper;
//import com.blog.post.model.User;
//import com.blog.post.repository.UserRepository;
//import com.blog.post.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserServiceImpl implements UserService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private UserMapper userMapper;
//
//    @Override
//    public UserDto createUser(UserDto user) {
//        try {
//            User entity = userMapper.convertToEntity(user);
//            User saveUser = userRepository.save(entity);
//            return userMapper.convertToDto(saveUser);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//}
