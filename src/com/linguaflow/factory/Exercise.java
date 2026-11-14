package com.linguaflow.factory;

public interface Exercise {
    String getType();
    String getQuestion();
    boolean check(String answer);
}
