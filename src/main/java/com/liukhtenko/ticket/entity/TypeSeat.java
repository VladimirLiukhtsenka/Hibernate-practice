package com.liukhtenko.ticket.entity;

import java.util.Objects;

@Deprecated
public class TypeSeat extends Entity {
    private String type;
    private String description;

    public TypeSeat() {
    }

    public TypeSeat(String type, String description) {
        this.type = type;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) { // FIXME: 10.01.2020
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeSeat that = (TypeSeat) o;
        return Objects.equals(type, that.type) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() { // FIXME: 10.01.2020
        return Objects.hash(type, description);
    }

    @Override
    public String toString() {
        return "TypeOfSeat{" +
                "type='" + type + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
