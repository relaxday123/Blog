package com.blog.post.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Getter
@Setter
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "content")
    private String content;

    @Column(name = "created_at")
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "author")
    private Author authorFromPost;

    public Author getAuthor() {
        return authorFromPost;
    }

    public void setAuthor(Author authorFromPost) {
        this.authorFromPost = authorFromPost;
    }
}
