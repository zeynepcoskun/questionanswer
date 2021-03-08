package com.mycompany.questionanswer.model;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Zeynep Coşkun
 */
public class QuestionTest {
    
    public Validator validator;

    @Before
    public void setUp() throws Exception {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void whenAllFieldsBlank_thenConstraintsViolated(){
        Question question = new Question();
        Set<ConstraintViolation<Question>> violations = validator.validate(question);
        assertEquals(2, violations.size());
    }

    @Test
    public void whenAnswerisEmpty_thenConstraintViolated() {
        Question question = new Question();
        question.setQuestionText("How are you?");
        question.setAnswer(null);

        Set<ConstraintViolation<Question>> violations = validator.validate(question);
        assertEquals(1, violations.size());
    }

}
