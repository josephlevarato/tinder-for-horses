package com.tinder.horse.enums;

public enum Gender {
    MALE("male"),
    FEMALE("female"),
    OTHER("other");

    public final String label;

    private Gender(String label) {
        this.label = label;
    }
}
