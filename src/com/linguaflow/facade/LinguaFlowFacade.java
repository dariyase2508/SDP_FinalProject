package com.linguaflow.facade;

import com.linguaflow.data.SampleData;
import com.linguaflow.model.Lesson;
import com.linguaflow.model.Word;
import com.linguaflow.model.WordProgress;
import com.linguaflow.observer.listener.ProgressListener;
import com.linguaflow.observer.subject.ProgressTracker;
import com.linguaflow.strategy.ReviewManager;
import com.linguaflow.strategy.ReviewSchedule;
import com.linguaflow.strategy.StudyMode;
import com.linguaflow.factory.ExerciseFactoryProvider;
import com.linguaflow.factory.ExerciseType;
import com.linguaflow.factory.product.Exercise;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * FACADE (Structural): one simple entry point for the UI.
 * Hides lessons, ReviewManager/strategies and ProgressTracker behind a few methods.
 */
public class LinguaFlowFacade {
    private final List<Lesson> lessons;
    private final Map<Word, WordProgress> progress = new LinkedHashMap<>();
    private final ReviewManager reviewManager;
    private final ProgressTracker tracker;
    private final ExerciseFactoryProvider exerciseFactories = new ExerciseFactoryProvider();

    private StudyMode mode;
    private Duration timeShift = Duration.ZERO;   // demo helper: lets us "skip days" without waiting

    public LinguaFlowFacade() {
        this(StudyMode.NORMAL);
    }

    public LinguaFlowFacade(StudyMode mode) {
        this.mode = mode;
        this.lessons = SampleData.createLessons();            // TODO: lessons from the Builder part
        this.reviewManager = new ReviewManager(mode.createStrategy());
        this.tracker = new ProgressTracker();
        for (Lesson lesson : lessons)
            for (Word w : lesson.getWords())
                progress.put(w, new WordProgress(w));
    }

    // ---------- lessons ----------
    public List<Lesson> getLessons() {
        return lessons;
    }

    public Lesson getLesson(int lessonId) {
        return lessons.stream().filter(l -> l.getId() == lessonId).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No lesson with id " + lessonId));
    }

    //(Factory) exercises
    public Exercise createExercise(Word word, ExerciseType type) {
        return exerciseFactories.getFactory(type).createExercise(word);
    }

    // ---------- quiz + spaced repetition ----------
    /** Checks the answer, updates the schedule (Strategy) and notifies listeners (Observer). */
    public AnswerResult answer(Exercise exercise, String userAnswer) {
        Word word = exercise.getWord();
        boolean correct = exercise.check(userAnswer);

        ReviewSchedule schedule = reviewManager.review(progress.get(word), correct, now());
        tracker.recordAnswer(word, correct, schedule.nextReview());

        return new AnswerResult(word, correct, exercise.getCorrectAnswer(),
                schedule.newLevel(), schedule.nextReview(), mode.name());
    }

    /** Words that have to be repeated right now. */
    public List<Word> getDueReviews() {
        return reviewManager.getDueWords(progress.values(), now()).stream()
                .map(WordProgress::getWord).toList();
    }

    public WordProgress getWordProgress(Word word) {
        return progress.get(word);
    }

    // ---------- mode (algorithm) ----------
    public void setMode(StudyMode newMode) {
        this.mode = newMode;
        reviewManager.setStrategy(newMode.createStrategy());
    }

    public StudyMode getMode() {
        return mode;
    }

    // ---------- progress ----------
    public void addProgressListener(ProgressListener listener) {
        tracker.addListener(listener);
    }

    public int getTotalCorrect() { return tracker.getTotalCorrect(); }
    public int getTotalWrong()   { return tracker.getTotalWrong(); }
    public int getTotalWords()   { return progress.size(); }

    /** Words answered correctly at least once and currently at level >= 1. */
    public int getLearnedWords() {
        return (int) progress.values().stream().filter(p -> p.getLevel() >= 1).count();
    }

    public List<WordProgress> getLessonProgress(int lessonId) {
        List<WordProgress> result = new ArrayList<>();
        for (Word w : getLesson(lessonId).getWords()) result.add(progress.get(w));
        return result;
    }

    // ---------- time (demo helper) ----------
    public void skipTime(Duration duration) {
        timeShift = timeShift.plus(duration);
    }

    public LocalDateTime now() {
        return LocalDateTime.now().plus(timeShift);
    }
}
