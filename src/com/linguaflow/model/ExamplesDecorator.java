
package com.linguaflow.model;

import java.util.List;

public class ExamplesDecorator extends LessonDecorator {

    private final List<String> examples;

    public ExamplesDecorator(Lesson lesson, List<String> examples) {
        super(lesson);
        this.examples = List.copyOf(examples);
    }

    public List<String> getExamples() {
        return examples;
    }
}
