package com.example.m_app.rest;

import com.example.m_app.model.ActivityResponse;
import com.example.m_app.model.PlaceResponse;
import com.example.m_app.model.UserResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("user/register")
    Call<UserResponse> registerUser(@Field("username") String username, @Field("email") String email, @Field("password") String password, @Field("password_confirmation") String password_confirmation);

    @FormUrlEncoded
    @POST("user/login")
    Call<UserResponse> attemptAuth(@Field("email") String email, @Field("password") String password);

    @POST("user/logout")
    Call<UserResponse> attemptLogout();

    @GET("user/{id}")
    Call<UserResponse> getUserDetails(@Path("id") int user_id);

    @GET("places")
    Call<PlaceResponse> getPlaces();

    @GET("places/{id}/activities")
    Call<ActivityResponse> getPlaceActivities(@Path("id") int id);
//
//    @GET("users/{id}/workouts")
//    Call<ActivityResponse> getActivities(@Path("id") Integer userId);
//
//    @FormUrlEncoded
//    @POST("workouts")
//    Call<ActivityResponse> addWorkout(@Field("user_id") int user_id, @Field("location_id") int location_id, @Field("workout_date") String date, @Field("exercise_type") String exercise, @Field("reps") int reps, @Field("sets") int sets);
//
//    @POST("workouts/delete/{id}")
//    Call<ActivityResponse> deleteWorkout(@Path("id") int workout_id);
//
//    @FormUrlEncoded
//    @POST("users/{id}/gyms")
//    Call<UserResponse> addUserLocation(@Path("id") Integer userId, @Field("location_id") int location_id);
}
