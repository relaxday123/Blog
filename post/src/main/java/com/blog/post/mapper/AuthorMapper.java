package com.blog.post.mapper;

import com.blog.post.dto.AuthorDto;
import com.blog.post.model.Author;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class AuthorMapper {
    public static AuthorDto toDto(Author author) {
        AuthorDto result = new AuthorDto();
        result.setUsername(author.getUsername());
        result.setPassword(author.getPassword());
        result.setFirstName(author.getFirstName());
        result.setLastName(author.getLastName());
        result.setEmail(author.getEmail());
        result.setBirthDate(author.getBirthDate());
        result.setAdded(author.getAdded());
//        result.setAuthorities(author.getAuthorities().stream()
//                .map(Authority::getAuthority).collect(Collectors.toList()));
        return result;
    }

    public static Author toEntity(AuthorDto authorDto) {
        Author result = new Author();
        result.setUsername(authorDto.getUsername());
        result.setPassword(authorDto.getPassword());
        result.setFirstName(authorDto.getFirstName());
        result.setLastName(authorDto.getLastName());
        result.setEmail(authorDto.getEmail());
        result.setBirthDate(authorDto.getBirthDate());
        result.setAdded(authorDto.getAdded());
//        result.setAdded(authorDto.);
        return result;
    }

    public static List<AuthorDto> toDtoList(List<Author> entities) {
        return entities.stream().map(AuthorMapper::toDto).collect(Collectors.toList());
    }

    public static List<AuthorDto> toDtoList(Iterable<Author> entities) {
        List<AuthorDto> posts = new LinkedList<>();
        entities.forEach( e -> posts.add(toDto(e)));
        return posts;
    }
}
