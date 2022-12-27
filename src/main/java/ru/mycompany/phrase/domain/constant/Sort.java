package ru.mycompany.phrase.domain.constant;

public enum Sort {

    RANDOM("RAND()"),
    TIME_INSERT("time_insert DESC");

    private final String value;

    Sort(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
