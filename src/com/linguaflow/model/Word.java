package com.linguaflow.model;

/** A single vocabulary item (immutable). */
public record Word(String english, String translation) {

    /** Case-insensitive answer check; trims spaces and treats "ё" as "е". */
    public boolean isCorrect(String userAnswer) {
        if (userAnswer == null) return false;
        return normalize(userAnswer).equals(normalize(translation));
    }

    private static String normalize(String s) {
        return s.trim().toLowerCase().replace('ё', 'е');
    }

    @Override
    public String toString() {
        return english + " - " + translation;
    }
}
