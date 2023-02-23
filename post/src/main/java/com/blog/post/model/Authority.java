package com.blog.post.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "authority")
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authority_id")
    private int id;
    @Column(name = "authority")
    private String authority;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author")
    private Author author;
}
