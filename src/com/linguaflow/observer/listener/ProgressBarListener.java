package com.linguaflow.observer.listener;

import com.linguaflow.observer.event.ProgressEvent;

public class ProgressBarListener implements ProgressListener {
    private static final int BAR_SIZE = 10;

    @Override
    public void onProgressChanged(ProgressEvent event){
        int percent = event.accuracyPercent();
        int filled = percent * BAR_SIZE / 100;
        String bar = "#".repeat(filled) + "-".repeat(BAR_SIZE - filled);
        System.out.printf("[Progress] [%s] %d%% (%d right, %d wrong)%n",
                bar, percent, event.totalCorrect(), event.totalWrong());
    }
}
