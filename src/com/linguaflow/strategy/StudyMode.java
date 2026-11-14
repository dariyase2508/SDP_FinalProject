package com.linguaflow.strategy;

import java.util.function.Supplier;

/** Lets clients choose an algorithm without knowing the concrete strategy classes. */
public enum StudyMode {
    EASY(EasyStrategy::new),
    NORMAL(NormalStrategy::new),
    HARD(HardStrategy::new);

    private final Supplier<ReviewStrategy> factory;

    StudyMode(Supplier<ReviewStrategy> factory) {
        this.factory = factory;
    }

    public ReviewStrategy createStrategy() {
        return factory.get();
    }
}
