package com.linguaflow.builder;

import com.linguaflow.model.Lesson;
import com.linguaflow.model.Word;

import java.util.ArrayList;
import java.util.List;

public class LessonBuilder {
    private int id;
    private String title;
    private final List<Word> words = new ArrayList<>();

    public LessonBuilder id(int id) {
        this.id = id;
        return this;
    }

    public LessonBuilder title(String title) {
        this.title = title;
        return this;
    }

    public LessonBuilder addWord(Word word) {
        if (word == null) {
            throw new IllegalArgumentException("Word cannot be null");
        }
        words.add(word);
        return this;
    }

    public LessonBuilder addWords(List<Word> words) {
        if (words == null) {
            throw new IllegalArgumentException("Words cannot be null");
        }
        for (Word word : words) {
            addWord(word);
        }
        return this;
    }

    public Lesson build() {
        if (id <= 0) {
            throw new IllegalStateException("Lesson ID must be positive");
        }
        if (title == null || title.isBlank()) {
            throw new IllegalStateException("Lesson title is required");
        }
        if (words.isEmpty()) {
            throw new IllegalStateException("Lesson must contain words");
        }

        return new Lesson(id, title, words);
    }
}

