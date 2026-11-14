package com.linguaflow.strategy;

import com.linguaflow.model.WordProgress;
import java.time.Duration;
import java.time.LocalDateTime;

/** Hard mode: the more mistakes a word has, the more often it is repeated. */
public class HardStrategy implements ReviewStrategy {
    private static final long[] DAYS = {1, 2, 4, 7, 14};
    private static final Duration RETRY = Duration.ofMinutes(5);
    private static final long MIN_INTERVAL_MINUTES = 60;

    @Override
    public String getName() {
        return "Hard";
    }

    @Override
    public ReviewSchedule calculate(WordProgress p, boolean correct, LocalDateTime now) {
        if (!correct) {
            return ReviewSchedule.of(0, RETRY, now);
        }
        int level = Math.min(p.getLevel() + 1, DAYS.length);
        double difficultyFactor = 1.0 / (1 + 0.25 * p.getWrongCount()); // more mistakes -> shorter interval
        long minutes = Math.round(DAYS[level - 1] * 24 * 60 * difficultyFactor);
        return ReviewSchedule.of(level, Duration.ofMinutes(Math.max(minutes, MIN_INTERVAL_MINUTES)), now);
    }
}
