package com.linguaflow.facade;

import com.linguaflow.model.Word;
import java.time.LocalDateTime;

public record AnswerResult(Word word, boolean correct, String correctAnswer,
                           int level, LocalDateTime nextReview, String mode) { }
