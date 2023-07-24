package com.mysite.sbb.answer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/answers")
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerService answerService;

    @PostMapping("/{id}")
    public String createAnswer(@PathVariable("id") Long id, @RequestParam String content, Model model) {
        this.answerService.create(id, content);
        return String.format("redirect:/question/%s", id);
    }
}
