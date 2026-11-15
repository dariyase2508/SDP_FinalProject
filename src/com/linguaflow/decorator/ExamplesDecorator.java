
package com.linguaflow.decorator;

import com.linguaflow.model.Lesson;

import java.util.ArrayList;
import java.util.List;

public class ExamplesDecorator extends LessonDecorator {

    private final List<String> examples;

    public ExamplesDecorator(Lesson lesson, List<String> examples) {
        super(lesson);
        this.examples = List.copyOf(examples);
    }

    @Override
    public List<String> getExamples() {
        List<String> result = new ArrayList<>(lesson.getExamples());
        result.addAll(examples);
        return List.copyOf(result);
    }
}
