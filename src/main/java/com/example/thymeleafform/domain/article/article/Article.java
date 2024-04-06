package com.example.thymeleafform.domain.article.article;

import com.example.thymeleafform.domain.article.comment.Comment;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String content;

    @OneToMany(mappedBy = "article")
    private List<Comment> comments = new ArrayList<>();
}
