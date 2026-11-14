package com.linguaflow.observer.listener;

import com.linguaflow.observer.event.ProgressEvent;

public interface ProgressListener {
    void onProgressChanged(ProgressEvent event);
}
