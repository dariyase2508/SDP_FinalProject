
package com.linguaflow.decorator;

import com.linguaflow.model.Lesson;
import com.linguaflow.model.Word;

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

    @Override
    public List<String> getExamples(){
        return lesson.getExamples();
    }

    @Override
    public List<String> getHints() {
        return lesson.getHints();
    }
}
