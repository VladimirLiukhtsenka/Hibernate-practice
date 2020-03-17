package com.liukhtenko.ticket.entity;
@Deprecated
public enum TypeEvent {
    SPORT("Спорт"),
    CONCERTS("Концерты"),
    FESTIVALS("Фестивали"),
    THEATER("Театр"),
    FOR_CHILDREN("Для детей"),
    MOVIE("Кино");
    private String value;


    TypeEvent() {
    }

    TypeEvent(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
