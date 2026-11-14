package com.linguaflow.observer.listener;

import com.linguaflow.observer.event.ProgressEvent;

public class AchievementListener implements ProgressListener {
    private static final int STREAK_FOR_BADGE = 3;
    private int streak;

    @Override
    public void onProgressChanged(ProgressEvent event) {
        if (!event.correct()){
            streak = 0;
            return;
        }
        streak++;
        if (streak % STREAK_FOR_BADGE == 0){
            System.out.println("[Achievement] Badge unlocked: " + streak + " correct answers in a row!");
        }
    }
}
