package com.userbanklist;

public class User {
    private int id;
    private String name;
    private String sureName;

    public User(int id, String name, String sureName) {
        this.id = id;
        this.name = name;
        this.sureName = sureName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSureName() {
        return sureName;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sureName='" + sureName + '\'' +
                '}';
    }
}
