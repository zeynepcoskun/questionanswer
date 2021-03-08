package com.mycompany.questionanswer.model;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Zeynep Coşkun
 */
public class AnswerTest {
    
    public Validator validator;

    @Before
    public void setUp() throws Exception {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void whenAllFieldsBlank_ConstraintsViolated(){
        Answer answer = new Answer();
        answer.setAnswerText(null);
        answer.setQuestion(null);
        Set<ConstraintViolation<Answer>> violations = validator.validate(answer);
        assertEquals(1, violations.size());
    }
}
