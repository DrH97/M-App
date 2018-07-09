package com.example.m_app.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class InstructorResponse {
    @SerializedName("total_results")
    private Integer totalResults;

    @SerializedName("results")
    private List<Instructor> instructors;


    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }
}
