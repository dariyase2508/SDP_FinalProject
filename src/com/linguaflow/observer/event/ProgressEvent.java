package com.linguaflow.observer.event;

import com.linguaflow.model.Word;

import java.time.LocalDateTime;

public record ProgressEvent(Word word, boolean correct, int totalCorrect, int totalWrong,
                            LocalDateTime nextReview) {
    public int accuracyPercent() {
        int total = totalCorrect + totalWrong;
        return total == 0 ? 0 : totalCorrect * 100 / total;
    }
}
