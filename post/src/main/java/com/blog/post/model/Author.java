package com.blog.post.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "author")
public class Author {
    @Id
    @Column(name = "username")
    @NotNull("cannot be null")
    private String username;

    @Column(name = "password")
    @NotNull("cannot be null")
    private String password;

    @Column(name = "first_name")
    @NotNull("cannot be null")
    private String firstName;

    @Column(name = "last_name")
    @NotNull("cannot be null")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "birth_date")
    @NotNull("cannot be null")
    private Date birthDate;

    @Column(name = "added")
    @NotNull("cannot be null")
    private LocalDateTime added;

    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
    private Set<Authority> authorities = new HashSet<>();
}
