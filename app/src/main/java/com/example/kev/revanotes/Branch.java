package com.example.kev.revanotes;

public class Branch {
    private int id;
    private int sample;
    private String branchName;
    int branchImage;

    public Branch(int id, String branchName,int branchImage) {
        this.id = id;

        this.branchName = branchName;
        this.branchImage=branchImage;
    }

    public int getId() {
        return id;
    }

    public String getBranchName() {
        return branchName;
    }

    public int getBranchImage()
    {
        return branchImage;
    }
}
