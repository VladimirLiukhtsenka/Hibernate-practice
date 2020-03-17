package com.liukhtenko.ticket.entity;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
@Table(name = "schedule", schema = "university")
public class ScheduleEntity {
    private long id;
    private long courseId;
    private long studentId;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "course_id", nullable = false)
    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    @Basic
    @Column(name = "student_id", nullable = false)
    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScheduleEntity that = (ScheduleEntity) o;
        return id == that.id &&
                courseId == that.courseId &&
                studentId == that.studentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseId, studentId);
    }

    @Override
    public String toString() {
        return "ScheduleEntity{" +
                "id=" + id +
                ", courseId=" + courseId +
                ", studentId=" + studentId +
                '}';
    }
}
