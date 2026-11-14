package com.linguaflow.observer.listener;

import com.linguaflow.model.Word;
import com.linguaflow.observer.event.ProgressEvent;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
