package com.linguaflow.data;

import com.linguaflow.model.Lesson;
import com.linguaflow.model.Word;
import java.util.List;

/**
 * 5 ready-made lessons x 8 words = 40 words.
 * TODO (Builder teammate): build these lessons with LessonBuilder instead of "new Lesson(...)".
 */
public final class SampleData {
    private SampleData() { }

    public static List<Lesson> createLessons() {
        return List.of(
            new Lesson(1, "Greetings", List.of(
                new Word("hello", "привет"), new Word("goodbye", "до свидания"),
                new Word("please", "пожалуйста"), new Word("thank you", "спасибо"),
                new Word("sorry", "извините"), new Word("yes", "да"),
                new Word("no", "нет"), new Word("welcome", "добро пожаловать"))),
            new Lesson(2, "Food", List.of(
                new Word("bread", "хлеб"), new Word("water", "вода"),
                new Word("milk", "молоко"), new Word("apple", "яблоко"),
                new Word("cheese", "сыр"), new Word("rice", "рис"),
                new Word("tea", "чай"), new Word("soup", "суп"))),
            new Lesson(3, "Travel", List.of(
                new Word("ticket", "билет"), new Word("airport", "аэропорт"),
                new Word("hotel", "отель"), new Word("passport", "паспорт"),
                new Word("luggage", "багаж"), new Word("map", "карта"),
                new Word("station", "вокзал"), new Word("taxi", "такси"))),
            new Lesson(4, "Family", List.of(
                new Word("mother", "мама"), new Word("father", "папа"),
                new Word("sister", "сестра"), new Word("brother", "брат"),
                new Word("grandmother", "бабушка"), new Word("grandfather", "дедушка"),
                new Word("friend", "друг"), new Word("child", "ребёнок"))),
            new Lesson(5, "University", List.of(
                new Word("book", "книга"), new Word("teacher", "учитель"),
                new Word("student", "студент"), new Word("exam", "экзамен"),
                new Word("computer", "компьютер"), new Word("lesson", "урок"),
                new Word("homework", "домашнее задание"), new Word("university", "университет")))
        );
    }
}
