package com.linguaflow;

import com.linguaflow.facade.AnswerResult;
import com.linguaflow.facade.LinguaFlowFacade;
import com.linguaflow.factory.ExerciseType;
import com.linguaflow.factory.product.Exercise;
import com.linguaflow.model.Lesson;
import com.linguaflow.model.Word;
import com.linguaflow.observer.listener.AchievementListener;
import com.linguaflow.observer.listener.ProgressBarListener;
import com.linguaflow.observer.listener.ReminderListener;
import com.linguaflow.strategy.StudyMode;

import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
    private static final String EXIT_COMMAND = "/exit";

    public static void main(String[] args) {
        LinguaFlowFacade app = new LinguaFlowFacade(StudyMode.NORMAL);
        Scanner in = new Scanner(System.in);

        app.addProgressListener(new ProgressBarListener());
        app.addProgressListener(new AchievementListener());
        app.addProgressListener(new ReminderListener());

        while (true) {
            System.out.printf("%n=== LinguaFlow | mode: %s ===%n", app.getMode());
            System.out.println("1) Take a lesson  2) Review due words  3) Change mode");
            System.out.println("4) Progress       5) Skip 1 day (demo)  0) Exit");
            System.out.print("> ");
            if (!in.hasNextLine()) return;
            switch (in.nextLine().trim()) {
                case "1" -> takeLesson(app, in);
                case "2" -> quiz(app, in, app.getDueReviews());
                case "3" -> changeMode(app, in);
                case "4" -> printProgress(app);
                case "5" -> { app.skipTime(Duration.ofDays(1)); System.out.println("Now: " + app.now().format(FMT)); }
                case "0" -> { return; }
                default -> System.out.println("Unknown option");
            }
        }
    }

    private static void takeLesson(LinguaFlowFacade app, Scanner in) {
        for (Lesson l : app.getLessons())
            System.out.printf("  %d. %s (%d words)%n", l.getId(), l.getTitle(), l.getWords().size());
        System.out.print("Lesson number: ");
        try {
            Lesson lesson = app.getLesson(Integer.parseInt(in.nextLine().trim()));
            lesson.getHints().forEach(h -> System.out.println(" Hint: " + h));
            lesson.getExamples().forEach(e -> System.out.println("Example: " + e));
            quiz(app, in, lesson.getWords());
        } catch (IllegalArgumentException ex) {
            System.out.println("Invalid lesson");
        }
    }

    private static void quiz(LinguaFlowFacade app, Scanner in, List<Word> words) {
        if (words.isEmpty()) { System.out.println("Nothing to review right now."); return; }
        System.out.println("(type " + EXIT_COMMAND + " to leave the lesson)");
        ExerciseType[] types = ExerciseType.values();
        int correct = 0;
        int answered = 0;
        for (int i = 0; i < words.size(); i++) {
            // Factory: every word gets a different kind of exercise
            Exercise exercise = app.createExercise(words.get(i), types[i % types.length]);
            System.out.print("[" + exercise.getType() + "] " + exercise.getQuestion() + ": ");
            String input = in.nextLine();
            if (input.trim().equalsIgnoreCase(EXIT_COMMAND)) {
                System.out.println("Lesson stopped.");
                break;
            }
            AnswerResult r = app.answer(exercise, input);
            answered++;
            if (r.correct()) correct++;
            System.out.println(r.correct() ? "   OK" : "   Wrong! Correct: " + r.correctAnswer());
            System.out.printf("   level %d, next review: %s%n", r.level(), r.nextReview().format(FMT));
        }
        System.out.printf("Result: %d / %d answered correctly%n", correct, answered);
    }

    private static void changeMode(LinguaFlowFacade app, Scanner in) {
        System.out.print("Mode (easy / normal / hard): ");
        try {
            app.setMode(StudyMode.valueOf(in.nextLine().trim().toUpperCase()));
        } catch (IllegalArgumentException ex) {
            System.out.println("Unknown mode");
        }
    }

    private static void printProgress(LinguaFlowFacade app) {
        System.out.printf("Learned words: %d / %d | correct: %d | wrong: %d | due now: %d%n",
                app.getLearnedWords(), app.getTotalWords(),
                app.getTotalCorrect(), app.getTotalWrong(), app.getDueReviews().size());
    }
}