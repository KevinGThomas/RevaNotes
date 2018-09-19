package com.example.kev.revanotes;

public class Subject {
    private int id;
    private String subName;
    private String imgLetter;

    public Subject(int id, String subName, String imgLetter) {
        this.id = id;
        this.subName = subName;
        this.imgLetter = imgLetter;
    }

    public int getId() {
        return id;
    }

    public String getSubName() {
        return subName;
    }

    public String getImgLetter() {
        return imgLetter;
    }
}
