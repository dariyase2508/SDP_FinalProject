package com.linguaflow.strategy;

import java.time.Duration;
import java.time.LocalDateTime;

/** Result of a ReviewStrategy calculation: new level, interval and the next review moment. */
public record ReviewSchedule(int newLevel, Duration interval, LocalDateTime nextReview) {

    public static ReviewSchedule of(int newLevel, Duration interval, LocalDateTime now) {
        return new ReviewSchedule(newLevel, interval, now.plus(interval));
    }
}
