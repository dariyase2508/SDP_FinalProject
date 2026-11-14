package com.linguaflow.strategy;

import com.linguaflow.model.WordProgress;
import java.time.Duration;
import java.time.LocalDateTime;

/** Easy mode: short intervals, a mistake only drops the word by one level. */
public class EasyStrategy implements ReviewStrategy {
    private static final long[] DAYS = {1, 2, 3, 5, 7};
    private static final Duration RETRY = Duration.ofMinutes(10);

    @Override
    public String getName() {
        return "Easy";
    }

    @Override
    public ReviewSchedule calculate(WordProgress p, boolean correct, LocalDateTime now) {
        if (!correct) {
            return ReviewSchedule.of(Math.max(p.getLevel() - 1, 0), RETRY, now);
        }
        int level = Math.min(p.getLevel() + 1, DAYS.length);
        return ReviewSchedule.of(level, Duration.ofDays(DAYS[level - 1]), now);
    }
}
