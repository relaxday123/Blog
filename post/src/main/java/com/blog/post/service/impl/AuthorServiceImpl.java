package com.blog.post.service.impl;

import com.blog.post.config.PasswordEncoderConfig;
import com.blog.post.dto.AuthorDto;
import com.blog.post.exceptions.NotFoundException;
import com.blog.post.exceptions.UserException;
import com.blog.post.mapper.AuthorMapper;
import com.blog.post.model.Author;
import com.blog.post.model.Authority;
import com.blog.post.model.User;
import com.blog.post.repository.AuthorRepository;
import com.blog.post.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authRepo;

    private final PasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public Author getByUsername(String username) {
        return authRepo.findById(username).orElse(null);
    }

    @Override
    public List<AuthorDto> getAll() {
        return AuthorMapper.toDtoList(this.authRepo.findAll());
    }

    @Override
    public AuthorDto addPost(AuthorDto authorDto) {
        Author check = authRepo.findById(authorDto.getUsername()).orElse(null);
        if (check != null) {
            return null;
        }
        Author toDb = AuthorMapper.toEntity(authorDto);
        Set<Authority> authorities = new HashSet<>();
        authorities.add(new Authority(1, "AUTHOR", toDb));
        toDb.setAuthorities(authorities);
        Author a = this.authRepo.save(toDb);
        return AuthorMapper.toDto(a);
    }

    @Override
    public AuthorDto createAuthor(AuthorDto author) {
            if (!authRepo.findByUsername(author.getUsername()).isPresent()) {
                Author entity = AuthorMapper.toEntity(author);

                entity.setPassword(encoder.encode(entity.getPassword()));
                entity.setAdded(LocalDateTime.now());
                Author savedAuthor = authRepo.save(entity);

                return AuthorMapper.toDto(savedAuthor);
            } else {
                throw new UserException(UserException.EXISTED);
            }
    }
}
