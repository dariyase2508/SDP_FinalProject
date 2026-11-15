package com.linguaflow.model;

import java.util.List;

public class Lesson {
    private final int id;
    private final String title;
    private final List<Word> words;

    public Lesson(int id, String title, List<Word> words) {
        this.id = id;
        this.title = title;
        this.words = List.copyOf(words);
    }

    public int getId() {
        return id;
    }
    public String getTitle(){
        return title;
    }
    public List<Word> getWords(){
        return words;
    }
    public List<String> getExamples(){
        return List.of();
    }
    public List<String> getHints () {
        return List.of();
    }
}
