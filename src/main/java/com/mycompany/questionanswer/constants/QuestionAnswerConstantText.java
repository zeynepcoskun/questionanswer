package com.mycompany.questionanswer.constants;

/**
 *
 * @author Zeynep Coşkun
 */
public class QuestionAnswerConstantText {

    public final String NO_ANSWER = "the answer to life, universe and everything is 42";

    public QuestionAnswerConstantText() {

    }

    public void printWellcomeMessage() {

        System.out.println(".......................................");
        System.out.println("..........Welcome!.....................");
        System.out.println(".......................................");

    }

    public void printOptions() {
        System.out.println(".......................................");
        System.out.println("Please Enter 1 = To ask a question to me.");
        System.out.println("Please Enter 2 = To add a question and it's answer.");
        System.out.println("Now Enter a number please(1 or 2):");
    }

    public void giveInformationAboutAsking() {

        System.out.println(".......................................");
        System.out.println("Ask your question at the end with ? and then give every answer between two \" \"");
    }

    public void successfullySaved() {
        System.out.println(".......................................");
        System.out.println("QUESTION and it's ANSWER is saved SUCCESSFULLY...");
    }

    public void giveInformationAboutUserChoice(int userChoice) {
        System.out.println(".......................................");
        System.out.println("You entered " + userChoice + " that means "
                + ChoiceOptionEnum.valueOfChoiceNumber(userChoice).label);
    }

    public void printAnswerNotFound() {
        System.out.println(".......................................");
        System.out.println(NO_ANSWER);
    }

    public void notValidOptionEntered(int choice) {
        System.out.println(".......................................");
        System.out.println(choice + " is not a valid option! Enter a number 1 or 2");
    }
    
    public void questionIsAlreadySaved() {
        System.out.println(".......................................");
        System.out.println("This question is saved before!");
    }

    public void notValidQuestionTextEntered() {
        System.out.println(".......................................");
        System.out.println("Not a valid question format. Ask question with one \'?\' at the end.");
    }

    public void notValidAnswerTextEntered() {
        System.out.println(".......................................");
        System.out.println("Not a valid answer format.");
    }

}
