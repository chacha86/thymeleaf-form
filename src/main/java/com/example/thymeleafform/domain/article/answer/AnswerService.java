package com.example.thymeleafform.domain.article.answer;

import com.example.thymeleafform.domain.article.comment.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnswerService {
    private final AnswerRepository answerRepository;

    public void save(String content, Comment comment) {
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setComment(comment);

        answerRepository.save(answer);
    }

    public Answer getAnswer(int id) {
        return answerRepository.findById(id).orElseThrow();
    }

    public List<Answer> getAnswers() {
        return answerRepository.findAll();
    }
}
