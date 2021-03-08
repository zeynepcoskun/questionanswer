package com.mycompany.questionanswer.repository;

import com.mycompany.questionanswer.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Zeynep Coşkun
 */
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    /**
     *
     * @param questionText
     * @return
     */
    @Query("from Question where questionText=?1")
    public Question findByQuestionText(String questionText);

}
