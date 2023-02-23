package com.blog.post.service.impl;

import com.blog.post.dto.PostDto;
import com.blog.post.exceptions.NotFoundException;
import com.blog.post.mapper.PostMapper;
import com.blog.post.model.Post;
import com.blog.post.repository.PostRepository;
import com.blog.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepo;

    public PostServiceImpl(PostRepository postRepo) {
        this.postRepo = Objects.requireNonNull(postRepo);
    }
    @Override
    public List<PostDto> getAll() {
        return PostMapper.toDtoList(this.postRepo.findAll());
    }

    @Override
    public PostDto getId(Integer id) {
        return PostMapper.toDto(this.postRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Post Id: " + id + " Not Found")));
    }

    @Override
    public PostDto addPost(PostDto post) {
        Post check = postRepo.findById(post.getId()).orElse(null);
        if (check != null) {
            return null;
        }
        Date date = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
        post.setCreatedAt(date);
        Post p = this.postRepo.save(PostMapper.toEntity(post));
        return PostMapper.toDto(p);
    }

    @Override
    public int deleteById(Integer id) {
        this.postRepo.deleteById(id);
        return 0;
    }

    @Override
    public PostDto updatePost(PostDto post) {
        if (this.postRepo.findById(post.getId()).orElse(null) == null) {
            return null;
        }
        Post p = this.postRepo.save(PostMapper.toEntity(post));
        return PostMapper.toDto(p);
    }

    @Override
    public List<PostDto> findByTitle(String input) {
        return PostMapper.toDtoList(postRepo.findAll()).stream()
                .filter(p -> p.getTitle().toLowerCase().contains(input.toLowerCase())).collect(Collectors.toList());
    }
}
