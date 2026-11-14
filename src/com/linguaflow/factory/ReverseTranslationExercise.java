package com.linguaflow.factory;

import com.linguaflow.model.Word;

public class ReverseTranslationExercise extends BaseExercise {

    public ReverseTranslationExercise(Word word) {
        super(word.translation(), word.english());
    }

    @Override
    public String getType() {
        return "Reverse translation";
    }

    @Override
    public String getQuestion() {
        return "How do you say in English: " + prompt;
    }
}
