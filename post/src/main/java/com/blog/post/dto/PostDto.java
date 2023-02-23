package com.blog.post.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PostDto {
    private Integer id;
    private String title;
    private String description;
    private String content;
    private AuthorDto author;
    private Date createdAt;
}
