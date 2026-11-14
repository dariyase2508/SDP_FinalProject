package com.linguaflow.factory.creator;

import com.linguaflow.factory.product.Exercise;
import com.linguaflow.factory.product.TranslationExercise;
import com.linguaflow.model.Word;

public class TranslationExerciseFactory extends ExerciseFactory {
    @Override
    public Exercise createExercise(Word word) {
        return new TranslationExercise(word);
    }
}