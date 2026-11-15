package com.linguaflow.model;

public record Word(String english, String translation) {

    @Override
    public String toString() {
        return english + " - " + translation;
    }
}
