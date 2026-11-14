
package com.linguaflow.data;

import com.linguaflow.model.Lesson;
import com.linguaflow.model.Word;
import com.linguaflow.builder.LessonBuilder;
import com.linguaflow.model.*;

import java.util.List;

public final class SampleData {

    private SampleData() { }

    public static List<Lesson> createLessons() {

        Lesson greetings = new LessonBuilder()
                .id(1)
                .title("Greetings")
                .addWords(List.of(
                        new Word("hello", "привет"),
                        new Word("goodbye", "до свидания"),
                        new Word("please", "пожалуйста"),
                        new Word("thank you", "спасибо"),
                        new Word("sorry", "извините"),
                        new Word("yes", "да"),
                        new Word("no", "нет"),
                        new Word("welcome", "добро пожаловать")
                ))
                .build();
        greetings = new ExamplesDecorator(greetings, List.of(
                "Hello! How are you?",
                "Thank you very much!"
        ));

        greetings = new HintDecorator(greetings, List.of(
                "Hello is used for greeting someone.",
                "Thank you expresses gratitude."
        ));

        Lesson food = new LessonBuilder()
                .id(2)
                .title("Food")
                .addWords(List.of(
                        new Word("bread", "хлеб"),
                        new Word("water", "вода"),
                        new Word("milk", "молоко"),
                        new Word("apple", "яблоко"),
                        new Word("cheese", "сыр"),
                        new Word("rice", "рис"),
                        new Word("tea", "чай"),
                        new Word("soup", "суп")
                ))
                .build();

        Lesson travel = new LessonBuilder()
                .id(3)
                .title("Travel")
                .addWords(List.of(
                        new Word("ticket", "билет"),
                        new Word("airport", "аэропорт"),
                        new Word("hotel", "отель"),
                        new Word("passport", "паспорт"),
                        new Word("luggage", "багаж"),
                        new Word("map", "карта"),
                        new Word("station", "вокзал"),
                        new Word("taxi", "такси")
                ))
                .build();
        travel = new BonusWordsDecorator(travel, List.of(
                new Word("journey", "путешествие"),
                new Word("departure", "отправление")
        ));

        Lesson family = new LessonBuilder()
                .id(4)
                .title("Family")
                .addWords(List.of(
                        new Word("mother", "мама"),
                        new Word("father", "папа"),
                        new Word("sister", "сестра"),
                        new Word("brother", "брат"),
                        new Word("grandmother", "бабушка"),
                        new Word("grandfather", "дедушка"),
                        new Word("friend", "друг"),
                        new Word("child", "ребёнок")
                ))
                .build();

        Lesson university = new LessonBuilder()
                .id(5)
                .title("University")
                .addWords(List.of(
                        new Word("book", "книга"),
                        new Word("teacher", "учитель"),
                        new Word("student", "студент"),
                        new Word("exam", "экзамен"),
                        new Word("computer", "компьютер"),
                        new Word("lesson", "урок"),
                        new Word("homework", "домашнее задание"),
                        new Word("university", "университет")
                ))
                .build();

        return List.of(greetings, food, travel, family, university);
    }
}



