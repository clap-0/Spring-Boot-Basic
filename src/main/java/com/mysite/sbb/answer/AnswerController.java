package com.mysite.sbb.answer;

import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/answers")
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerService answerService;
    private final QuestionService questionService;

    @PostMapping("/{id}")
    public String createAnswer(@PathVariable("id") Long id, @Valid AnswerForm answerForm,
                               BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            Question question = this.questionService.getQuestion(id);
            model.addAttribute("question", question);
            return "question_detail";
        }
        this.answerService.create(id, answerForm.getContent());
        return String.format("redirect:/questions/%s", id);
    }
}
