package com.linguaflow.observer.subject;

import com.linguaflow.model.Word;
import com.linguaflow.observer.event.ProgressEvent;
import com.linguaflow.observer.listener.ProgressListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * PLACEHOLDER (Observer teammate): the Subject. The Facade calls only recordAnswer(...)
 * and addListener(...), so the teammate can replace the internals freely.
 */
public class ProgressTracker {
    private final List<ProgressListener> listeners = new ArrayList<>();
    private int totalCorrect;
    private int totalWrong;

    public void addListener(ProgressListener l)    { listeners.add(l); }
    public void removeListener(ProgressListener l) { listeners.remove(l); }

    public void recordAnswer(Word word, boolean correct, LocalDateTime nextReview) {
        if (correct) totalCorrect++; else totalWrong++;
        ProgressEvent event = new ProgressEvent(word, correct, totalCorrect, totalWrong, nextReview);
        for (ProgressListener l : listeners) l.onProgressChanged(event);
    }

    public int getTotalCorrect() { return totalCorrect; }
    public int getTotalWrong()   { return totalWrong; }
}
