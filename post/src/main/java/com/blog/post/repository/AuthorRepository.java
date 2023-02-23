package com.blog.post.repository;

import com.blog.post.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, String> {
    Optional<Author> findByUsername(String username);
}
