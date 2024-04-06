package com.example.thymeleafform.domain.article.comment;

import com.example.thymeleafform.domain.article.answer.Answer;
import com.example.thymeleafform.domain.article.article.Article;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Article article;

    @OneToMany(mappedBy = "comment")
    private List<Answer> answers;
}
