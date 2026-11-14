package com.linguaflow.strategy;

import com.linguaflow.model.WordProgress;
import java.time.LocalDateTime;

/** STRATEGY (Behavioral): a family of interchangeable spaced-repetition algorithms. */
public interface ReviewStrategy {

    /** Human-readable name of the algorithm. */
    String getName();

    /**
     * Calculates when a word must be reviewed next.
     * Must NOT modify the progress object - it only returns a schedule.
     */
    ReviewSchedule calculate(WordProgress progress, boolean correct, LocalDateTime now);
}
