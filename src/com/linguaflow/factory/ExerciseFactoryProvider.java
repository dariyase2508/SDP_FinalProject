package com.linguaflow.factory;

import com.linguaflow.factory.creator.ExerciseFactory;
import com.linguaflow.factory.creator.ReverseTranslationExerciseFactory;
import com.linguaflow.factory.creator.ScrambleExerciseFactory;
import com.linguaflow.factory.creator.TranslationExerciseFactory;

import java.util.EnumMap;
import java.util.Map;

public class ExerciseFactoryProvider {

    private final Map<ExerciseType, ExerciseFactory> factories = new EnumMap<>(ExerciseType.class);

    public ExerciseFactoryProvider() {
        factories.put(ExerciseType.TRANSLATION, new TranslationExerciseFactory());
        factories.put(ExerciseType.REVERSE_TRANSLATION, new ReverseTranslationExerciseFactory());
        factories.put(ExerciseType.SCRAMBLE, new ScrambleExerciseFactory());
    }

    public ExerciseFactory getFactory(ExerciseType type) {
        ExerciseFactory factory = factories.get(type);
        if (factory == null) {
            throw new IllegalArgumentException("Unknown exercise type: " + type);
        }
        return factory;
    }
}