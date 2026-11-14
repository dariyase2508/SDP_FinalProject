package com.linguaflow.strategy;

import com.linguaflow.model.WordProgress;
import java.time.Duration;
import java.time.LocalDateTime;

/** Normal mode: classic Leitner-like intervals, a mistake resets the word to level 0. */
public class NormalStrategy implements ReviewStrategy {
    private static final long[] DAYS = {1, 3, 7, 14, 30};
    private static final Duration RETRY = Duration.ofMinutes(10);

    @Override
    public String getName() {
        return "Normal";
    }

    @Override
    public ReviewSchedule calculate(WordProgress p, boolean correct, LocalDateTime now) {
        if (!correct) {
            return ReviewSchedule.of(0, RETRY, now);
        }
        int level = Math.min(p.getLevel() + 1, DAYS.length);
        return ReviewSchedule.of(level, Duration.ofDays(DAYS[level - 1]), now);
    }
}
