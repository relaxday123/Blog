package com.blog.post.dto;

import com.blog.post.model.Author;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorityDto {
    private int id;
    private String authority;
    private Author author;
}
