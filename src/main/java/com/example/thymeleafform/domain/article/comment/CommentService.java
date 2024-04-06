package com.example.thymeleafform.domain.article.comment;

import com.example.thymeleafform.domain.article.article.Article;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public void makeTestData(List<Article> articles) {
        for (Article article : articles) {
            save("comment_" + article.getId() + "_1", article);
            save("comment_" + article.getId() + "_2", article);
            save("comment_" + article.getId() + "_3", article);
        }
    }

    public void save(String content, Article article) {
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setArticle(article);

        commentRepository.save(comment);
    }

    public Comment getComment(int id) {
        return commentRepository.findById(id).orElseThrow();
    }

    public List<Comment> getComments() {
        return commentRepository.findAll();
    }
}
