package com.linguaflow.model;

import java.time.LocalDateTime;

/** Learning state of one word for one user: level, counters and next review time. */
public class WordProgress {
    private final Word word;
    private int level;                 // 0 = new / just failed, higher = better known
    private int correctCount;
    private int wrongCount;
    private LocalDateTime lastReview;  // null until the first answer
    private LocalDateTime nextReview;  // null until the first answer

    public WordProgress(Word word) {
        this.word = word;
    }

    /** Called by ReviewManager after a ReviewStrategy has calculated the schedule. */
    public void update(int newLevel, LocalDateTime nextReview, boolean correct, LocalDateTime reviewedAt) {
        this.level = newLevel;
        this.nextReview = nextReview;
        this.lastReview = reviewedAt;
        if (correct) correctCount++; else wrongCount++;
    }

    public boolean isNew()                         { return lastReview == null; }
    public boolean isDue(LocalDateTime now)        { return !isNew() && !nextReview.isAfter(now); }

    public Word getWord()                  { return word; }
    public int getLevel()                  { return level; }
    public int getCorrectCount()           { return correctCount; }
    public int getWrongCount()             { return wrongCount; }
    public LocalDateTime getLastReview()   { return lastReview; }
    public LocalDateTime getNextReview()   { return nextReview; }
}
