package com.mycompany.questionanswer.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Question")
@Table(name = "question")
@Getter
@Setter
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(length=255)
    @NotBlank(message = "question can not be empty")
    private String questionText;

    @NotNull
    @OneToOne(mappedBy = "question", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Answer answer;

    @Override
    public String toString() {
        return "questionId [id=" + id
                + ", questionText=" + questionText
                + "]";
    }

}
