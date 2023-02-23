package com.blog.post.mapper;

import com.blog.post.dto.PostDto;
import com.blog.post.model.Post;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class PostMapper {
    public static PostDto toDto(Post entity) {
        PostDto post = new PostDto();
        post.setId(entity.getId());
        post.setContent(entity.getContent());
        post.setDescription(entity.getDescription());
        post.setTitle(entity.getTitle());
        post.setCreatedAt(entity.getCreatedAt());
        post.setAuthor(AuthorMapper.toDto(entity.getAuthor()));
        return post;
    }

    public static Post toEntity(PostDto post) {
        Post postEntity = new Post();
        postEntity.setId(post.getId());
        postEntity.setContent(post.getContent());
        postEntity.setDescription(post.getDescription());
        postEntity.setTitle(post.getTitle());
        postEntity.setCreatedAt(post.getCreatedAt());
        postEntity.setAuthor(AuthorMapper.toEntity(post.getAuthor()));
        return postEntity;
    }

    public static List<PostDto> toDtoList(List<Post> entities) {
        return entities.stream().map(PostMapper::toDto).collect(Collectors.toList());
    }

    public static List<PostDto> toDtoList(Iterable<Post> entities) {
        List<PostDto> posts = new LinkedList<>();
        entities.forEach( e -> posts.add(toDto(e)));
        return posts;
    }
}
