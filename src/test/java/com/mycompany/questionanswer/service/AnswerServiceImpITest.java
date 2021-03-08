package com.mycompany.questionanswer.service;

import com.mycompany.questionanswer.model.Answer;
import com.mycompany.questionanswer.model.Question;
import com.mycompany.questionanswer.repository.AnswerRepository;
import com.mycompany.questionanswer.repository.QuestionRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

/**
 *
 * @author Zeynep Coşkun
 */
@RunWith(MockitoJUnitRunner.class)
public class AnswerServiceImpITest {

    @Mock
    private AnswerRepository answerRepository;

    @Mock
    private QuestionRepository questionRepository;

    @InjectMocks
    private AnswerServiceImpl answerService;

    private Answer answer;
    private List<Answer> answerList;

    @Before
    public void setUp() {
        composeTestAnswer();
        composeMultipleTestAnswer();
        when(answerRepository.findById(anyInt())).thenReturn(Optional.ofNullable(answer));
    }

    @Test
    public void getAnswer() {
        Answer answer = answerService.getAnswer(1L);
        assertNotNull(answer);
        verify(answerRepository, times(1)).findById(anyInt());
    }

    @Test
    public void saveAnswer() {
        answerService.saveAnswer(answer);
        verify(answerRepository, times(1)).save(answer);
    }

    @Test
    public void getAnswerList() {
        when(answerRepository.findAll()).thenReturn(answerList);
        List<Answer> answerList = answerService.answers();
        assertNotNull(answerList);
        assertEquals(2, answerList.size());
        verify(answerRepository, times(1)).findAll();
    }

    @Test()
    public void composeTestAnswer() {

        Question question = new Question();
        question.setQuestionText("How are you?");
        Answer answer = new Answer("Very well");
        answer.setQuestion(question);
        question.setAnswer(answer);
        questionRepository.save(question);
    }

    public void composeMultipleTestAnswer() {
        answerList = new ArrayList<>();
        answerList.add(answer);

        Question question = new Question();
        question.setQuestionText("Where are you going?");
        Answer answer2 = new Answer("To Beach");
        answer2.setQuestion(question);
        question.setAnswer(answer2);

        answerList.add(answer2);
    }

}
