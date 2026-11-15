
package com.linguaflow.decorator;

import com.linguaflow.model.Lesson;

import java.util.List;
import java.util.ArrayList;

public class HintDecorator extends LessonDecorator {

    private final List<String> hints;

    public HintDecorator(Lesson lesson, List<String> hints) {
        super(lesson);
        this.hints = List.copyOf(hints);
    }

    public List<String> getHints() {
        List<String> result = new ArrayList<>(lesson.getHints());
        result.addAll(hints);
        return List.copyOf(result);
    }
}
