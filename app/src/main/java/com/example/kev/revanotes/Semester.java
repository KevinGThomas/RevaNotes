package com.example.kev.revanotes;

public class Semester {
    private int id;
    private String semName;

    public Semester(int id, String semName) {
        this.id = id;
        this.semName = semName;
    }

    public int getId() {
        return id;
    }

    public String getSemName() {
        return semName;
    }
}
