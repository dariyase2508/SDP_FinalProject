
package com.linguaflow.model;

import java.util.List;

public class HintDecorator extends LessonDecorator {

    private final List<String> hints;

    public HintDecorator(Lesson lesson, List<String> hints) {
        super(lesson);
        this.hints = List.copyOf(hints);
    }

    public List<String> getHints() {
        return hints;
    }
}
