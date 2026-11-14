package com.linguaflow.model;

import java.util.List;

/**
 * PLACEHOLDER for the teammate's BUILDER part.
 * The Facade only needs getId(), getTitle() and getWords(), so the teammate's
 * Lesson / LessonBuilder can replace this class without touching the Facade.
 */
public class Lesson {
    private final int id;
    private final String title;
    private final List<Word> words;

    public Lesson(int id, String title, List<Word> words) {
        this.id = id;
        this.title = title;
        this.words = List.copyOf(words);
    }

    public int getId()            { return id; }
    public String getTitle()      { return title; }
    public List<Word> getWords()  { return words; }
}
