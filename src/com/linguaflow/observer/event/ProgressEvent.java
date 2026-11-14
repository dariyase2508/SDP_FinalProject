package com.linguaflow.observer.event;

import com.linguaflow.model.Word;
import java.time.LocalDateTime;

/** PLACEHOLDER (Observer teammate): data sent to listeners after every answer. */
public record ProgressEvent(Word word, boolean correct, int totalCorrect, int totalWrong,
                            LocalDateTime nextReview) { }
