package com.example.kev.revanotes;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class Selection extends Application {
    static String branch;
    static String semester;
    static String subject;

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
