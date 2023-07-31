package com.mysite.sbb.answer;

import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AnswerService {

    private final QuestionRepository questionRepository;

    private final AnswerRepository answerRepository;

    @Transactional
    public void create(Long questionId, String content) {
        Question question = this.questionRepository.findOne(questionId);
        Answer answer = Answer.createAnswer(question, content);
        this.answerRepository.save(answer);
    }
}
