package com.skillrat.myapp.api;

import com.skillrat.myapp.SessionsModel.Session;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Abhi on 06 Sep 2017 006.
 */

public interface ApiService {

    /*
    Retrofit get annotation with our URL
    And our method that will return us the List of CoursesList
    */
    @GET("/course/by-category")
    Call<List<Session>> getMyJSON();
}