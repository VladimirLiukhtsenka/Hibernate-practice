package com.liukhtenko.ticket.entity;

import java.util.Date;
import java.util.Objects;
@Deprecated
public class Event extends Entity {
    private long id;
    private String name;
    private String address;
    private String description;
    private TypeEvent typeEvent;
    private Date date;
Event(){}
    public Event(long id, String name, String address, String description, TypeEvent typeEvent, Date date) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
        this.typeEvent = typeEvent;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TypeEvent getTypeOfEvent() {
        return typeEvent;
    }

    public void setTypeOfEvent(TypeEvent typeEvent) {
        this.typeEvent = typeEvent;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) { // FIXME: 17.01.2020
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id &&
                Objects.equals(name, event.name) &&
                Objects.equals(address, event.address) &&
                Objects.equals(description, event.description) &&
                Objects.equals(typeEvent, event.typeEvent) &&
                Objects.equals(date, event.date);
    }

    @Override
    public int hashCode() { // FIXME: 17.01.2020
        return Objects.hash(id, name, address, description, typeEvent, date);
    }

    @Override
    public String toString() { // FIXME: 17.01.2020
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", typeEvent=" + typeEvent +
                ", date=" + date +
                '}';
    }
}