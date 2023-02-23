package com.blog.post.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class AuthorDto {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private Date birthDate;
    private LocalDateTime added;
    private List<String> authorities;
}
