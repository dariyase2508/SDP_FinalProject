package com.linguaflow.factory.creator;

import com.linguaflow.factory.product.Exercise;
import com.linguaflow.factory.product.ScrambleExercise;
import com.linguaflow.model.Word;

public class ScrambleExerciseFactory extends ExerciseFactory {
    @Override
    public Exercise createExercise(Word word) {
        return new ScrambleExercise(word);
    }
}