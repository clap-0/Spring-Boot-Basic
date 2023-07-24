package com.mysite.sbb.answer;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AnswerRepository {

    private final EntityManager em;

    public void save(Answer answer) {
        em.persist(answer);
    }
}
