package com.example.kev.revanotes;

public class Uploads {

    public String name, url, desc, branch, sem, sub;

    public Uploads() {

    }

    public Uploads(String name, String desc, String url, String branch, String sem, String sub) {
        this.name = name;
        this.url = url;
        this.desc = desc;
        this.branch = branch;
        this.sem = sem;
        this.sub = sub;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getDesc() {
        return desc;
    }

    public String getBranch() {
        return branch;
    }

    public String getSem() {
        return sem;
    }

    public String getSub() {
        return sub;
    }
}

