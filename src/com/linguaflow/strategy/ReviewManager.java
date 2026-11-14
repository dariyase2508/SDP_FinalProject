package com.linguaflow.strategy;

import com.linguaflow.model.WordProgress;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/** Context of the STRATEGY pattern: works with any ReviewStrategy and can switch it at runtime. */
public class ReviewManager {
    private ReviewStrategy strategy;

    public ReviewManager(ReviewStrategy strategy) {
        this.strategy = Objects.requireNonNull(strategy);
    }

    public void setStrategy(ReviewStrategy strategy) {
        this.strategy = Objects.requireNonNull(strategy);
    }

    public ReviewStrategy getStrategy() {
        return strategy;
    }

    /** Registers an answer: asks the strategy for a schedule and stores it in the word's progress. */
    public ReviewSchedule review(WordProgress progress, boolean correct, LocalDateTime now) {
        ReviewSchedule schedule = strategy.calculate(progress, correct, now);
        progress.update(schedule.newLevel(), schedule.nextReview(), correct, now);
        return schedule;
    }

    /** Words that were already studied and are ready to be repeated. */
    public List<WordProgress> getDueWords(Collection<WordProgress> all, LocalDateTime now) {
        return all.stream().filter(p -> p.isDue(now)).toList();
    }
}
