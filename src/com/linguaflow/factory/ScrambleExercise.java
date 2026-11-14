package com.linguaflow.factory;

import com.linguaflow.model.Word;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class ScrambleExercise extends BaseExercise {

    public ScrambleExercise(Word word) {
        super(word.translation(),
                word.english());
    }

    @Override
    public String getType(){
        return "Scramble";
    }

    @Override
    public String getQuestion(){
        return "Unscramble the English word for \"" + prompt + "\": " + scramble(correctAnswer);
    }

    private String scramble(String word){
        List<Character> letters = new ArrayList<>();
        for (char c : word.toCharArray()) {
            letters.add(c);
        }
        Collections.shuffle(letters);
        StringBuilder result = new StringBuilder();
        letters.forEach(result::append);
        return result.toString();
    }
}