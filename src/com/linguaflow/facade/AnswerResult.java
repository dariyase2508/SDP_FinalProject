package com.linguaflow.facade;

import com.linguaflow.model.Word;
import java.time.LocalDateTime;

/** What the UI gets back after the user answers a question. */
public record AnswerResult(Word word, boolean correct, String correctAnswer,
                           int level, LocalDateTime nextReview, String mode) { }
