package com.tinder.horse.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Gender {
    MALE("male"),
    FEMALE("female"),
    OTHER("other");

    public final String label;

    private Gender(String label) {
        this.label = label;
    }

    @JsonCreator
    public static Gender fromLabel(String label) {
        for (Gender g : values()) {
            if (g.label.equalsIgnoreCase(label.trim())) {
                return g;
            }
        }

        throw new IllegalArgumentException("Unknown gender: " + label);
    }
}
