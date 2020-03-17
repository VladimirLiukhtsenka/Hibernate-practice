package com.liukhtenko.ticket.entity;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
@Table(name = "teacher", schema = "university")
public class TeacherEntity {
    private long id;
    private String name;
    private String fieldOfScience;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "field_of_science", nullable = false, length = 45)
    public String getFieldOfScience() {
        return fieldOfScience;
    }

    public void setFieldOfScience(String fieldOfScience) {
        this.fieldOfScience = fieldOfScience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherEntity that = (TeacherEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(fieldOfScience, that.fieldOfScience);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, fieldOfScience);
    }

    @Override
    public String toString() {
        return "TeacherEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fieldOfScience='" + fieldOfScience + '\'' +
                '}';
    }
}
