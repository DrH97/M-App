package com.example.m_app.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserResponse {

    @SerializedName("status")
    private String status;

    @SerializedName("total_results")
    private int totalResults;

    @SerializedName("results")
    private List<User> users;

    @SerializedName("firstname")
    private String[] firstname;

    @SerializedName("lastname")
    private String[] lastname;

    @SerializedName("email")
    private String[] email;

    @SerializedName("password")
    private String[] password;

    @SerializedName("message")
    private String message;

    @SerializedName("user")
    private User user;

    @SerializedName("location")
    private String location = null;

    public String[] getFirstname() {
        return firstname;
    }

    public void setFirstname(String[] firstname) {
        this.firstname = firstname;
    }

    public String[] getLastname() {
        return lastname;
    }

    public void setLastname(String[] lastname) {
        this.lastname = lastname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public String[] getEmail() {
        return email;
    }

    public void setEmail(String[] email) {
        this.email = email;
    }

    public String[] getPassword() {
        return password;
    }

    public void setPassword(String[] password) {
        this.password = password;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
