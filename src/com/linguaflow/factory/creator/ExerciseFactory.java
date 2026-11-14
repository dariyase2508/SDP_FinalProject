package com.linguaflow.factory.creator;

import com.linguaflow.factory.product.Exercise;
import com.linguaflow.model.Word;

public abstract class ExerciseFactory {
    public abstract Exercise createExercise(Word word);
}