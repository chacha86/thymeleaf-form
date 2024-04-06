package com.example.thymeleafform.domain.article.answer;

import com.example.thymeleafform.domain.article.comment.Comment;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Answer {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;
    private String content;

    @ManyToOne(fetch = jakarta.persistence.FetchType.LAZY)
    private Comment comment;
}
