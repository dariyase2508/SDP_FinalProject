package com.linguaflow.factory.product;

import com.linguaflow.model.Word;

public abstract class BaseExercise implements Exercise {
    protected final Word word;
    protected final String prompt;
    protected final String correctAnswer;

    protected BaseExercise(Word word, String prompt, String correctAnswer) {
        this.word = word;
        this.prompt = prompt;
        this.correctAnswer = correctAnswer;
    }

    @Override
    public Word getWord() {
        return word;
    }

    @Override
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    @Override
    public boolean check(String answer){

        return answer != null && normalize(answer).equals(normalize(correctAnswer));
    }

    private String normalize(String text){

        return text.trim().toLowerCase();
    }
}
