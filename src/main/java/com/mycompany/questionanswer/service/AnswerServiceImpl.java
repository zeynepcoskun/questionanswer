package com.mycompany.questionanswer.service;


import com.mycompany.questionanswer.model.Answer;
import com.mycompany.questionanswer.repository.AnswerRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Zeynep Coşkun
 */
@Service
@Transactional
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public void saveAnswer(Answer answer) {
        answerRepository.save(answer);
    }

    @Override
    public List<Answer> answers() {
        return answerRepository.findAll();
    }

    @Override
    public Answer getAnswer(Long id) {
        return answerRepository.findByAnswerId(id);
    }

}
