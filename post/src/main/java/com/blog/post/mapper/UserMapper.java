package com.blog.post.mapper;

import com.blog.post.dto.UserDto;
import com.blog.post.model.User;
import jdk.jshell.spi.ExecutionControl;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class UserMapper {
    private static final Logger logger = LoggerFactory.getLogger(UserMapper.class);

    @Autowired
    ModelMapper modelMapper;

//    public User convertToEntity(UserDto userDTO) throws Exception {
//        try {
//            User user = modelMapper.map(userDTO, User.class);
//            user.setFirstName(user.getFirstName().trim());
//            user.setLastName(user.getLastName().trim());
//
//            return user;
//        } catch (Exception ex) {
//            logger.warn(ex.getMessage());
//            throw new Exception("convert entity fail");
//        }
//    }

    public UserDto convertToDto(User user) throws Exception {
        try {
            UserDto userDTO = modelMapper.map(user, UserDto.class);

            return userDTO;
        } catch (Exception ex) {
            logger.warn(ex.getMessage());
            throw new Exception("convert dto fail");
        }

    }
}
