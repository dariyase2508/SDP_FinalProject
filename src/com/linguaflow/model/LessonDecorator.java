
package com.linguaflow.model;

import java.util.List;

public abstract class LessonDecorator extends Lesson {

    protected final Lesson lesson;

    public LessonDecorator(Lesson lesson) {
        super(
                checkLesson(lesson).getId(),
                lesson.getTitle(),
                lesson.getWords()
        );
        this.lesson = lesson;
    }

    private static Lesson checkLesson(Lesson lesson) {
        if (lesson == null) {
            throw new IllegalArgumentException("Lesson cannot be null");
        }
        return lesson;
    }

    @Override
    public int getId() {
        return lesson.getId();
    }

    @Override
    public String getTitle() {
        return lesson.getTitle();
    }

    @Override
    public List<Word> getWords() {
        return lesson.getWords();
    }

    public Lesson getWrappedLesson() {
        return lesson;
    }


}
