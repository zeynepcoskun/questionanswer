package com.mycompany.questionanswer.repository;

import com.mycompany.questionanswer.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Zeynep Coşkun
 */
public interface AnswerRepository extends JpaRepository<Answer, Integer> {

    /**
     *
     * @param id
     * @return
     */
    @Query("from Answer where id=?1")
    public Answer findByAnswerId(Long id);
}
