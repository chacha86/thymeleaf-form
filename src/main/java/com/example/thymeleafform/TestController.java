package com.example.thymeleafform;

import com.example.thymeleafform.domain.article.answer.AnswerForm;
import com.example.thymeleafform.domain.article.answer.AnswerService;
import com.example.thymeleafform.domain.article.article.Article;
import com.example.thymeleafform.domain.article.article.ArticleService;
import com.example.thymeleafform.domain.article.comment.Comment;
import com.example.thymeleafform.domain.article.comment.CommentForm;
import com.example.thymeleafform.domain.article.comment.CommentService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TestController {

    private final ArticleService articleService;
    private final CommentService commentService;
    private final AnswerService answerService;

    @GetMapping("/test")
    public String test() {
        articleService.makeTestData();
        return "article/list";
    }

    @GetMapping("/test2")
    public String test2() {

        List<Article> articles = articleService.getArticles();
        commentService.makeTestData(articles);

        return "article/list";
    }

    @PostMapping("/comment/create/{id}")
    public String createComment(@Valid CommentForm form, @PathVariable("id") int id){
        Article article = articleService.getArticle(id);
        commentService.save(form.getContent(), article);
        return "redirect:/detail/" + id;
    }

    @PostMapping("/answer/create/{id}")
    public String createAnswer(Model model, @Valid AnswerForm answerForm, BindingResult bindingResult, @PathVariable("id") int id){

        Comment comment = commentService.getComment(id);
        int aid = comment.getArticle().getId();

        if(bindingResult.hasErrors()){

            Article article = articleService.getArticle(aid);
            model.addAttribute("article", article);
            return "article/detail";
        }

        answerService.save(answerForm.getContent(), comment);

        return "redirect:/detail/" + aid;
    }
    @GetMapping("/detail/{id}")
    public String detail(Model model, AnswerForm answerForm, CommentForm commentForm, @PathVariable("id") int id) {
        Article article = articleService.getArticle(id);
        model.addAttribute("article", article);
        return "article/detail";
    }

    @GetMapping("/list")
    public String list(Model model) {

        List<Article> articles = articleService.getArticles();
        model.addAttribute("articles", articles);

        return "article/list";
    }

}
