package com.mycompany.questionanswer.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.util.StringUtils;

/**
 *
 * @author Zeynep Coşkun
 */
public class QuestionAnswerParser {

    public QuestionAnswerParser() {

    }

    public String getQuestion(String wholeText) {

        String question = null;

        int charIndex = wholeText.indexOf("?");

        if (charIndex != -1) {
            question = wholeText.substring(0, charIndex);
        }

        return question;
    }

    public void printAnswerLineByLine(String answer) {

        Pattern p = Pattern.compile("\"([^\"]*)\"");
        Matcher m = p.matcher(answer);
        System.out.println("ANSWER:");
        while (m.find()) {
            System.out.println("  " + "\u2022" + m.group(1));
        }
    }

    public boolean isQuestionCorrectFormat(String str) {

        int numberOfQuestionMark = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '?') {
                numberOfQuestionMark++;
            }
        }

        if (numberOfQuestionMark == 1) {
            return true;
        }
        return false;
    }

    public boolean isAnswerCorrectFormat(String str) {

        if (StringUtils.isEmpty(str)) { // answer cannot be empty
            return false;
        }
        Pattern p = Pattern.compile("\\\"(.*?)\\\"");
        Matcher m = p.matcher(str);
        boolean b = m.matches();
        return b;
    }

}
