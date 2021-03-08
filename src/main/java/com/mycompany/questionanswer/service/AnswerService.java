package com.mycompany.questionanswer.service;

import com.mycompany.questionanswer.model.Answer;
import java.util.List;

/**
 *
 */
public interface AnswerService {

    void saveAnswer(Answer answer);

    List<Answer> answers();

    Answer getAnswer(Long answerId);

}
