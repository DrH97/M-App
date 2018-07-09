package com.example.m_app.model;

import com.google.gson.annotations.SerializedName;

public class Place {

    @SerializedName("id")
    private Integer id;

    @SerializedName("title")
    private String title;

    @SerializedName("image")
    private String image;

    @SerializedName("location_id")
    private Integer locationId;

    @SerializedName("description")
    private String description;

    @SerializedName("price")
    private Double price;

    public Place(Integer id, String title, String image, Integer locationId, String description, Double price) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.locationId = locationId;
        this.description = description;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}