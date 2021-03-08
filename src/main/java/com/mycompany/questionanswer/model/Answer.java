package com.mycompany.questionanswer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Zeynep Coşkun
 */
@Entity(name = "Answer")
@Table(name = "answer")
@Getter
@Setter
public class Answer {

    @Id
    @Column(name = "question_id")
    private Long id;

    @Column(length = 255)
    @NotBlank(message = "answer can not be empty")
    private String answerText;

    @OneToOne
    @MapsId
    @JoinColumn(name = "question_id")
    private Question question;

    public Answer() {

    }

    public Answer(String answerText) {
        this.answerText = answerText;
    }

}
