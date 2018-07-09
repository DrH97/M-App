package com.example.m_app.model;

import com.google.gson.annotations.SerializedName;

public class Instructor {

    @SerializedName("id")
    private Integer id;

    @SerializedName("name")
    private String name;

    @SerializedName("contacts")
    private String contacts;

    @SerializedName("email")
    private String email;

    @SerializedName("photo")
    private String photo;

    @SerializedName("gender")
    private String gender;

    @SerializedName("gym_location_id")
    private String gymLocationId;

    public Instructor(Integer id, String name, String contacts, String email, String photo, String gender, String gymLocationId) {
        this.id = id;
        this.name = name;
        this.contacts = contacts;
        this.email = email;
        this.photo = photo;
        this.gender = gender;
        this.gymLocationId = gymLocationId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGymLocationId() {
        return gymLocationId;
    }

    public void setGymLocationId(String gymLocationId) {
        this.gymLocationId = gymLocationId;
    }
}