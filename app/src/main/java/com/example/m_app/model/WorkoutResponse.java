package com.example.m_app.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WorkoutResponse {

    @SerializedName("status")
    private String status;

    @SerializedName("message")
    private String message;

    @SerializedName("user_id")
    private String[] user_id;

    @SerializedName("location_id")
    private String[] location_id;

    @SerializedName("workout_date")
    private String[] workout_date;

    @SerializedName("exercise_type")
    private String[] exercise_type;

    @SerializedName("reps")
    private String[] reps;

    @SerializedName("sets")
    private String[] sets;

    @SerializedName("total_results")
    private Integer totalResults;

    @SerializedName("results")
    private List<Workout> workouts;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String[] getUser_id() {
        return user_id;
    }

    public void setUser_id(String[] user_id) {
        this.user_id = user_id;
    }

    public String[] getLocation_id() {
        return location_id;
    }

    public void setLocation_id(String[] location_id) {
        this.location_id = location_id;
    }

    public String[] getWorkout_date() {
        return workout_date;
    }

    public void setWorkout_date(String[] workout_date) {
        this.workout_date = workout_date;
    }

    public String[] getExercise_type() {
        return exercise_type;
    }

    public void setExercise_type(String[] exercise_type) {
        this.exercise_type = exercise_type;
    }

    public String[] getReps() {
        return reps;
    }

    public void setReps(String[] reps) {
        this.reps = reps;
    }

    public String[] getSets() {
        return sets;
    }

    public void setSets(String[] sets) {
        this.sets = sets;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<Workout> workouts) {
        this.workouts = workouts;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
