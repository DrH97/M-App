package com.example.m_app.model;

import com.google.gson.annotations.SerializedName;

public class Workout {

    @SerializedName("id")
    private Integer id;

    @SerializedName("user_id")
    private Integer userId;

    @SerializedName("location_id")
    private Integer locationId;

    @SerializedName("workout_date")
    private String workoutDate;

    @SerializedName("exercise_type")
    private String exerciseType;

    @SerializedName("reps")
    private Integer reps;

    @SerializedName("sets")
    private Integer sets;

    private boolean favourite = false;

    public Workout(Integer id, Integer userId, Integer locationId, String workoutDate, String exerciseType, Integer reps, Integer sets) {
        this.id = id;
        this.userId = userId;
        this.locationId = locationId;
        this.workoutDate = workoutDate;
        this.exerciseType = exerciseType;
        this.reps = reps;
        this.sets = sets;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getWorkoutDate() {
        return workoutDate;
    }

    public void setWorkoutDate(String workoutDate) {
        this.workoutDate = workoutDate;
    }

    public String getExerciseType() {
        return exerciseType;
    }

    public void setExerciseType(String exerciseType) {
        this.exerciseType = exerciseType;
    }

    public Integer getReps() {
        return reps;
    }

    public void setReps(Integer reps) {
        this.reps = reps;
    }

    public Integer getSets() {
        return sets;
    }

    public void setSets(Integer sets) {
        this.sets = sets;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }
}