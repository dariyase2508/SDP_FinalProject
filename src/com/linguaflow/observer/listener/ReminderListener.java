package com.linguaflow.observer.listener;

import com.linguaflow.observer.event.ProgressEvent;

import java.time.format.DateTimeFormatter;

public class ReminderListener implements ProgressListener {
    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("dd.MM HH:mm");

    @Override
    public void onProgressChanged(ProgressEvent event) {
        if (!event.correct() && event.nextReview() != null) {
            System.out.println(" [Reminder] Repeat \"" + event.word().english()
                    + "\" at " + event.nextReview().format(FORMAT));
        }
    }
}
