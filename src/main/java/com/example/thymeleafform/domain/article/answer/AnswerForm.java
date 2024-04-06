package com.example.thymeleafform.domain.article.answer;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerForm {

    @NotNull
    private int commentId;

    @NotEmpty(message = "내용을 입력해주세요.")
    @Size(min=1, max=1000, message = "1자 이상 1000자 이하로 입력해주세요.")
    private String content;
}
