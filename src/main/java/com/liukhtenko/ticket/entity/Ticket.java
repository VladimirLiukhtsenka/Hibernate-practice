package com.liukhtenko.ticket.entity;

import java.util.Objects;
@Deprecated
public class Ticket extends Entity {
    private long id;
    private long eventId;
    private TypeSeat typeSeat; // FIXME: 18.01.2020 
    private int numberOfTickets;
    private double price;

    public Ticket() {
    }

    public Ticket(long id, long eventID, TypeSeat typeOfSeat, int numberOfTickets, double price) {
        this.id = id;
        this.eventId = eventID;
        this.typeSeat = typeSeat;
        this.numberOfTickets = numberOfTickets;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getEventID() {
        return eventId;
    }

    public void setEventID(long eventID) {
        this.eventId = eventID;
    }

    public TypeSeat getTypeOfSeat() {
        return typeSeat;
    }

    public void setTypeOfSeat(TypeSeat typeOfSeat) {
        this.typeSeat = typeSeat;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) { // FIXME: 10.01.2020
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id &&
                eventId == ticket.eventId &&
                numberOfTickets == ticket.numberOfTickets &&
                Double.compare(ticket.price, price) == 0 &&
                Objects.equals(typeSeat, ticket.typeSeat);
    }

    @Override
    public int hashCode() { // FIXME: 10.01.2020 
        return Objects.hash(id, eventId, typeSeat, numberOfTickets, price);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", eventID=" + eventId +
                ", typeSeat=" + typeSeat +
                ", numberOfTickets=" + numberOfTickets +
                ", price=" + price +
                '}';
    }
}
