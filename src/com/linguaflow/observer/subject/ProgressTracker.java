package com.linguaflow.observer.subject;

import com.linguaflow.model.Word;
import com.linguaflow.observer.event.ProgressEvent;
import com.linguaflow.observer.listener.ProgressListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProgressTracker implements ProgressSubject {
    private final List<ProgressListener> listeners = new ArrayList<>();
    private int totalCorrect;
    private int totalWrong;

    @Override
    public void addListener(ProgressListener listener){
        listeners.add(Objects.requireNonNull(listener));
    }

    @Override
    public void removeListener(ProgressListener listener){
        listeners.remove(listener);
    }

    public void recordAnswer(Word word, boolean correct, LocalDateTime nextReview) {
        if (correct) {
            totalCorrect++;
        } else {
            totalWrong++;
        }
        ProgressEvent event = new ProgressEvent(word, correct, totalCorrect, totalWrong, nextReview);
        notifyListeners(event);
    }

    private void notifyListeners(ProgressEvent event) {
        for (ProgressListener listener : new ArrayList<>(listeners)) {
            listener.onProgressChanged(event);
        }
    }

    public int getTotalCorrect() { return totalCorrect; }
    public int getTotalWrong()   { return totalWrong; }
}
