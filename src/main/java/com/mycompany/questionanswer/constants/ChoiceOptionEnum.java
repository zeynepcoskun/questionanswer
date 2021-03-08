package com.mycompany.questionanswer.constants;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Zeynep Coşkun
 */
public enum ChoiceOptionEnum {
    
    ASK("Ask Question", 1),
    ADD("Add Question and it's answers", 2);

    private static final Map<String, ChoiceOptionEnum> BY_LABEL = new HashMap<>();
    private static final Map<Integer, ChoiceOptionEnum> BY_CHOICE_NUMBER = new HashMap<>();
    
    static {
        for (ChoiceOptionEnum e : values()) {
            BY_LABEL.put(e.label, e);
            BY_CHOICE_NUMBER.put(e.choiceNumber, e);
        }
    }

    public final String label;
    public final int choiceNumber;
   

    private ChoiceOptionEnum(String label, int choiceNumber) {
        this.label = label;
        this.choiceNumber = choiceNumber;
      
    }

    public static ChoiceOptionEnum valueOfLabel(String label) {
        return BY_LABEL.get(label);
    }

    public static ChoiceOptionEnum valueOfChoiceNumber(int number) {
        return BY_CHOICE_NUMBER.get(number);
    }
}
