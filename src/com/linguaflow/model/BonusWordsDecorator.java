
package com.linguaflow.model;

import java.util.ArrayList;
import java.util.List;

public class BonusWordsDecorator extends LessonDecorator {

    private final List<Word> bonusWords;

    public BonusWordsDecorator(Lesson lesson, List<Word> bonusWords) {
        super(lesson);
        this.bonusWords = List.copyOf(bonusWords);
    }

    @Override
    public List<Word> getWords() {
        List<Word> result = new ArrayList<>(lesson.getWords());
        result.addAll(bonusWords);
        return List.copyOf(result);
    }
}
