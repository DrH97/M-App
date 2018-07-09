package com.example.m_app.model;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id")
    private Integer id;

    @SerializedName("firstname")
    private String firstname;

    @SerializedName("lastname")
    private String lastname;

    @SerializedName("email")
    private String email;

    @SerializedName("gym_location_id")
    private int gymLocation;

    @SerializedName("pin")
    private Integer pin;

    @SerializedName("photo")

    private String photo;

    @SerializedName("age")
    private Integer age;

    @SerializedName("gender")
    private String gender;

    @SerializedName("weight")
    private double weight;

    @SerializedName("target_weight")
    private double targetWeight;

    public User(Integer id, String firstname, String lastname, String email, int gymLocation, Integer pin, String photo, Integer age, String gender, double weight, double targetWeight) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.gymLocation = gymLocation;
        this.pin = pin;
        this.photo = photo;
        this.age = age;
        this.gender = gender;
        this.weight = weight;
        this.targetWeight = targetWeight;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGymLocation() {
        return gymLocation;
    }

    public void setGymLocation(int gymLocation) {
        this.gymLocation = gymLocation;
    }

    public Integer getPin() {
        return pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getTargetWeight() {
        return targetWeight;
    }

    public void setTargetWeight(double targetWeight) {
        this.targetWeight = targetWeight;
    }
}