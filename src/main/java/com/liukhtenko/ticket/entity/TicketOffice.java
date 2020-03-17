package com.liukhtenko.ticket.entity;

import java.util.Objects;
@Deprecated
public class TicketOffice extends Entity {
private String address;
private String operatingMode;
private String phone;

    public TicketOffice() {
    }

    public TicketOffice(String address, String operatingMode, String phone) {
        this.address = address;
        this.operatingMode = operatingMode;
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOperatingMode() {
        return operatingMode;
    }

    public void setOperatingMode(String operatingMode) {
        this.operatingMode = operatingMode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) { // FIXME: 23.01.2020
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketOffice that = (TicketOffice) o;
        return Objects.equals(address, that.address) &&
                Objects.equals(operatingMode, that.operatingMode) &&
                Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() { // FIXME: 23.01.2020
        return Objects.hash(address, operatingMode, phone);
    }

    @Override
    public String toString() { // FIXME: 23.01.2020
        return "TicketOffice{" +
                "address='" + address + '\'' +
                ", operatingMode='" + operatingMode + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
