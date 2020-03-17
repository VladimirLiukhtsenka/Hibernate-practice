package com.liukhtenko.ticket.entity;

import java.util.Objects;
@Deprecated
public class User extends Entity {
    private long id;
    private String phone; // FIXME: 10.01.2020 String?
    private String name;
    private String surName;
    private String fatherName;
    private byte gender; // FIXME: 10.01.2020 byte?
    private String password;
    private String mail;
    private long roleId;

    public User() {
    }

    public User(long id, String phone, String name, String surName, String fatherName,
                byte gender, String password, String mail, long roleID) {
        this.id = id;
        this.phone = phone;
        this.name = name;
        this.surName = surName;
        this.fatherName = fatherName;
        this.gender = gender;
        this.password = password;
        this.mail = mail;
        this.roleId = roleID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public byte getGender() {
        return gender;
    }

    public void setGender(byte gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public long getRoleID() {
        return roleId;
    }

    public void setRoleID(long roleID) {
        this.roleId = roleID;
    }

    @Override
    public boolean equals(Object o) { // FIXME: 10.01.2020
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                gender == user.gender &&
                roleId == user.roleId &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(name, user.name) &&
                Objects.equals(surName, user.surName) &&
                Objects.equals(fatherName, user.fatherName) &&
                Objects.equals(password, user.password) &&
                Objects.equals(mail, user.mail);
    }

    @Override
    public int hashCode() { // FIXME: 10.01.2020
        return Objects.hash(id, phone, name, surName, fatherName, gender, password, mail, roleId);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", gender=" + gender +
                ", password='" + password + '\'' +
                ", mail='" + mail + '\'' +
                ", roleID=" + roleId +
                '}';
    }
}