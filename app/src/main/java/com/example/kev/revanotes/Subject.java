package com.example.kev.revanotes;

public class Subject {
    private int id;
    private String subName;

    public Subject(int id, String subName) {
        this.id = id;
        this.subName = subName;
    }

    public int getId() {
        return id;
    }

    public String getSubName() {
        return subName;
    }
}
