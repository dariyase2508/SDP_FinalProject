package com.linguaflow.observer.subject;

import com.linguaflow.observer.listener.ProgressListener;

public interface ProgressSubject {
    void addListener(ProgressListener listener);
    void removeListener(ProgressListener listener);
}
