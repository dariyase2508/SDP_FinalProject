package com.linguaflow.factory;

public abstract class BaseExercise implements Exercise {
    protected final String prompt;
    protected final String correctAnswer;

    protected BaseExercise(String prompt, String correctAnswer) {
        this.prompt = prompt;
        this.correctAnswer = correctAnswer;
    }

    @Override
    public boolean check(String answer){
        return answer != null && normalize(answer).equals(normalize(correctAnswer));
    }

    private String normalize(String text){
        return text.trim().toLowerCase();
    }
}
