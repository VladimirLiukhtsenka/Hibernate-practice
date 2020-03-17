package com.liukhtenko.ticket.entity;

import java.util.Objects;
@Deprecated
public class Role extends Entity {
    private long id;
    private String description;

    public Role() {
    }

    public Role(long id, String description) {
        this.id = id;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        Role role = (Role) o;
        return id == role.id &&
                Objects.equals(description, role.description);
    }

    @Override
    public int hashCode() { // FIXME: 10.01.2020
        return Objects.hash(id, description);
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
