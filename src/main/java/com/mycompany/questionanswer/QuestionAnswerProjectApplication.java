package com.mycompany.questionanswer;

import com.mycompany.questionanswer.constants.ChoiceOptionEnum;
import com.mycompany.questionanswer.constants.QuestionAnswerConstantText;
import com.mycompany.questionanswer.model.Answer;
import com.mycompany.questionanswer.model.Question;
import com.mycompany.questionanswer.repository.AnswerRepository;
import com.mycompany.questionanswer.repository.QuestionRepository;
import com.mycompany.questionanswer.util.QuestionAnswerParser;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuestionAnswerProjectApplication implements CommandLineRunner {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    QuestionAnswerParser myParser = new QuestionAnswerParser();
    QuestionAnswerConstantText printText = new QuestionAnswerConstantText();

    Scanner input = new Scanner(System.in);
    int userChoice = 0;

    public static void main(String[] args) {
        SpringApplication.run(QuestionAnswerProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        printText.printWellcomeMessage();
        printText.printOptions();

        while (input.hasNext()) {

            userChoice = input.nextInt();

            if (userChoice == ChoiceOptionEnum.ASK.choiceNumber
                    || userChoice == ChoiceOptionEnum.ADD.choiceNumber) {

                printText.giveInformationAboutUserChoice(userChoice);

                // Add Question and Answers
                if (userChoice == ChoiceOptionEnum.ADD.choiceNumber) {

                    printText.giveInformationAboutAsking();

                    Scanner inputAdd = new Scanner(System.in);
                    String wholeText = inputAdd.nextLine();

                    String question = myParser.getQuestion(wholeText);

                    // if it is not saved before/ not the same question
                    if (questionRepository.findByQuestionText(question) == null) {
                        if (!myParser.isQuestionCorrectFormat(wholeText)) {
                            printText.notValidQuestionTextEntered();
                            printText.printOptions();
                        } else {

                            String answer = wholeText.substring(wholeText.lastIndexOf("?") + 1);

                            if (!myParser.isAnswerCorrectFormat(answer)) {
                                printText.notValidAnswerTextEntered();
                                printText.printOptions();
                            } else {
                                saveQuestion(question, answer);
                                printText.successfullySaved();
                                printText.printOptions();
                            }
                        }
                    } else {
                        printText.questionIsAlreadySaved();
                        printText.printOptions();
                    }
                }

                // Ask Question
                if (userChoice == ChoiceOptionEnum.ASK.choiceNumber) {

                    Scanner inputAsk = new Scanner(System.in);
                    String allText = inputAsk.nextLine();
                    String subString = myParser.getQuestion(allText);
                    findAnswer(subString);
                    printText.printOptions();
                }
            } else {
                printText.notValidOptionEntered(userChoice);

            }
        }

    }

    public void saveQuestion(String questionText, String answerText) {

        Question question = new Question();
        question.setQuestionText(questionText);
        Answer answer = new Answer(answerText);
        answer.setQuestion(question);
        question.setAnswer(answer);
        questionRepository.save(question);
    }

    public void findAnswer(String questionText) {

        Question question = questionRepository.findByQuestionText(questionText);
        Long answerAllText = null;

        if (question != null) {
            answerAllText = question.getId();
            Answer answer = answerRepository.findByAnswerId(answerAllText);
            myParser.printAnswerLineByLine(answer.getAnswerText());
        } else {
            printText.printAnswerNotFound();
        }
    }
}
