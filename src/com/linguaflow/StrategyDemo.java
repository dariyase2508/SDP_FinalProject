package com.linguaflow;

import com.linguaflow.model.Word;
import com.linguaflow.model.WordProgress;
import com.linguaflow.strategy.ReviewManager;
import com.linguaflow.strategy.ReviewSchedule;
import com.linguaflow.strategy.StudyMode;
import java.time.LocalDateTime;

/** Shows that the same answers give different schedules in each mode (Strategy pattern). */
public class StrategyDemo {
    public static void main(String[] args) {
        boolean[] answers = {true, true, false, true, true};   // sequence of user answers
        LocalDateTime now = LocalDateTime.of(2026, 11, 14, 12, 0);

        for (StudyMode mode : StudyMode.values()) {
            ReviewManager manager = new ReviewManager(mode.createStrategy());
            WordProgress wp = new WordProgress(new Word("hello", "привет"));
            System.out.println("--- " + manager.getStrategy().getName() + " ---");
            for (boolean correct : answers) {
                ReviewSchedule s = manager.review(wp, correct, now);
                System.out.printf("answer: %-5s -> level %d, next review in %s%n",
                        correct ? "right" : "wrong", s.newLevel(), format(s.interval()));
            }
        }
    }

    private static String format(java.time.Duration d) {
        return d.toDays() > 0 && d.toHours() % 24 == 0 ? d.toDays() + " day(s)"
             : d.toHours() > 0 ? d.toHours() + " h " + d.toMinutesPart() + " min"
             : d.toMinutes() + " min";
    }
}
