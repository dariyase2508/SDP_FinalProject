package com.linguaflow.factory.product;

import com.linguaflow.model.Word;

public interface Exercise {
    String getType();
    String getQuestion();
    boolean check(String answer);
    Word getWord();
}
