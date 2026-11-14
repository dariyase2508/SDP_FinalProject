package com.linguaflow.factory.product;

import com.linguaflow.model.Word;

public class TranslationExercise extends BaseExercise {
    public TranslationExercise(Word word) {

        super(word, word.english(), word.translation());
    }

    @Override
    public String getType(){
        return "Translation";
    }

    @Override
    public String getQuestion(){
        return "Translate the word: " + prompt;
    }
}
