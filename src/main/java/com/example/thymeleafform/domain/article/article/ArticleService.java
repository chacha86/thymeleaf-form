package com.example.thymeleafform.domain.article.article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public void makeTestData() {
        save("title1", "content1");
        save("title2", "content2");
        save("title3", "content3");
    }

    public void save(String title, String content) {
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);

        articleRepository.save(article);
    }

    public Article getArticle(int id) {
        return articleRepository.findById(id).orElseThrow();
    }

    public List<Article> getArticles() {
        return articleRepository.findAll();
    }

}