package com.example.kev.revanotes;

public class Contacts {
    private int id;
    private String contactName;
    private String contactDesc;
    int contactImage;

    public Contacts(int id, String contactName, String contactDesc, int contactImage) {
        this.id = id;
        this.contactName = contactName;
        this.contactDesc = contactDesc;
        this.contactImage = contactImage;
    }

    public int getId() {
        return id;
    }

    public String getContactName() {
        return contactName;
    }

    public String getContactDesc() {
        return contactDesc;
    }

    public int getContactImage() {
        return contactImage;
    }
}
