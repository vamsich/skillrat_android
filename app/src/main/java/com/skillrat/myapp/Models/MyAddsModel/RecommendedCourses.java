package com.skillrat.myapp.Models.MyAddsModel;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Maryam on 6/12/2018.
 */

public class RecommendedCourses {
    String instructor_name;
    String instructor_qualification;
    String instructor_course_price;
    String instructor_course_discounted_price;
    String instructor_course_starting_date;
    String instructor_course_duration;
    String instructor_rating;

    public String getInstructor_name() {
        return instructor_name;
    }

    public void setInstructor_name(String instructor_name) {
        this.instructor_name = instructor_name;
    }

    public String getInstructor_qualification() {
        return instructor_qualification;
    }

    public void setInstructor_qualification(String instructor_qualification) {
        this.instructor_qualification = instructor_qualification;
    }

    public String getInstructor_course_price() {
        return instructor_course_price;
    }

    public void setInstructor_course_price(String instructor_course_price) {
        this.instructor_course_price = instructor_course_price;
    }

    public String getInstructor_course_discounted_price() {
        return instructor_course_discounted_price;
    }

    public void setInstructor_course_discounted_price(String instructor_course_discounted_price) {
        this.instructor_course_discounted_price = instructor_course_discounted_price;
    }

    public String getInstructor_course_starting_date() {
        return instructor_course_starting_date;
    }

    public void setInstructor_course_starting_date(String instructor_course_starting_date) {
        this.instructor_course_starting_date = instructor_course_starting_date;
    }

    public String getInstructor_course_duration() {
        return instructor_course_duration;
    }

    public void setInstructor_course_duration(String instructor_course_duration) {
        this.instructor_course_duration = instructor_course_duration;
    }

    public String getInstructor_rating() {
        return instructor_rating;
    }

    public void setInstructor_rating(String instructor_rating) {
        this.instructor_rating = instructor_rating;
    }

    public RecommendedCourses(String instructor_name, String instructor_qualification, String instructor_course_price, String instructor_course_discounted_price, String instructor_course_starting_date, String instructor_course_duration, String instructor_rating) {
        this.instructor_name = instructor_name;
        this.instructor_qualification = instructor_qualification;
        this.instructor_course_price = instructor_course_price;
        this.instructor_course_discounted_price = instructor_course_discounted_price;
        this.instructor_course_starting_date = instructor_course_starting_date;
        this.instructor_course_duration = instructor_course_duration;
        this.instructor_rating = instructor_rating;
    }

    public RecommendedCourses(JSONObject jsonObject) {
        try {
            this.instructor_name = jsonObject.getString("");
            this.instructor_qualification = jsonObject.getString("");
            this.instructor_course_price = jsonObject.getString("");
            this.instructor_course_discounted_price = jsonObject.getString("");
            this.instructor_course_starting_date = jsonObject.getString("");
            this.instructor_course_duration = jsonObject.getString("");
            this.instructor_rating = jsonObject.getString("");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
