package com.mycompany.questionanswer.service;

import com.mycompany.questionanswer.model.Question;
import com.mycompany.questionanswer.repository.QuestionRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Zeynep Coşkun
 */
@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public void saveQuestion(Question question) {
        questionRepository.save(question);
    }

}
