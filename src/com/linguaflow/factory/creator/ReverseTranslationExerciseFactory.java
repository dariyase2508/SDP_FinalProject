package com.linguaflow.factory.creator;

import com.linguaflow.factory.product.Exercise;
import com.linguaflow.factory.product.ReverseTranslationExercise;
import com.linguaflow.model.Word;

public class ReverseTranslationExerciseFactory extends ExerciseFactory {
    @Override
    public Exercise createExercise(Word word) {
        return new ReverseTranslationExercise(word);
    }
}