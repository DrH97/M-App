package com.example.m_app.model;

import com.google.gson.annotations.SerializedName;

public class Activity {

    @SerializedName("id")
    private Integer id;

    @SerializedName("activity_id")
    private Integer activityId;

    @SerializedName("price")
    private Double price;

    @SerializedName("offer")
    private String offer;

    @SerializedName("type")
    private String type;

    @SerializedName("date_from")
    private String date_from;

    @SerializedName("date_to")
    private String date_to;

    @SerializedName("activity_name")
    private String activityName;

    @SerializedName("activity_description")
    private String activityDesc;

    private boolean favourite = false;

    public Activity(Integer id, Integer activityId, Double price, String offer, String type, String date_from, String date_to, String activityName, String activityDesc, boolean favourite) {
        this.id = id;
        this.activityId = activityId;
        this.price = price;
        this.offer = offer;
        this.type = type;
        this.date_from = date_from;
        this.date_to = date_to;
        this.activityName = activityName;
        this.activityDesc = activityDesc;
        this.favourite = favourite;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate_from() {
        return date_from;
    }

    public void setDate_from(String date_from) {
        this.date_from = date_from;
    }

    public String getDate_to() {
        return date_to;
    }

    public void setDate_to(String date_to) {
        this.date_to = date_to;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityDesc() {
        return activityDesc;
    }

    public void setActivityDesc(String activityDesc) {
        this.activityDesc = activityDesc;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }
}