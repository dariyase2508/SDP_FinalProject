package com.linguaflow.factory.product;

import com.linguaflow.model.Word;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScrambleExercise extends BaseExercise {

    public ScrambleExercise(Word word) {
        super(word, word.translation(), word.english());
    }

    @Override
    public String getType() {
        return "Scramble";
    }

    @Override
    public String getQuestion() {
        return "Unscramble the English word for \"" + prompt + "\": " + scramble(correctAnswer);
    }

    private String scramble(String text) {
        StringBuilder result = new StringBuilder();
        for (String part : text.split(" ")) {
            if (result.length() > 0) {
                result.append(' ');
            }
            result.append(shuffleWord(part));
        }
        return result.toString();
    }

    private String shuffleWord(String word) {
        if (word.chars().distinct().count() < 2) {
            return word; // nothing to shuffle (e.g. "a"), also protects from an endless loop
        }
        List<Character> letters = new ArrayList<>();
        for (char c : word.toCharArray()) {
            letters.add(c);
        }
        String shuffled;
        do {
            Collections.shuffle(letters);
            shuffled = join(letters);
        } while (shuffled.equals(word));
        return shuffled;
    }

    private String join(List<Character> letters) {
        StringBuilder sb = new StringBuilder();
        letters.forEach(sb::append);
        return sb.toString();
    }
}