package com.skillrat.myapp.Models.MyAddsModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Maryam on 6/23/2018.
 */

public class CurrentAndPastSession {

    @SerializedName("id")
    @Expose
    private Integer Id;
    @SerializedName("name")
    @Expose
    String instructor_name;
    @SerializedName("qualification")
    @Expose
    String instructor_qualification;
    @SerializedName("price")
    @Expose
    String instructor_course_price;
    @SerializedName("discountedPrice")
    @Expose
    String instructor_course_discounted_price;
    @SerializedName("startingDate")
    @Expose
    String instructor_course_starting_date;
    @SerializedName("durationCourse")
    @Expose
    String instructor_course_duration;
    @SerializedName("rating")
    @Expose
    String instructor_rating;
    @SerializedName("cover")
    @Expose
    String instructor_image;


    public CurrentAndPastSession(String instructor_name, String instructor_qualification, String instructor_course_price, String instructor_course_discounted_price, String instructor_course_starting_date, String instructor_course_duration, String instructor_rating) {
        this.instructor_name = instructor_name;
        this.instructor_qualification = instructor_qualification;
        this.instructor_course_price = instructor_course_price;
        this.instructor_course_discounted_price = instructor_course_discounted_price;
        this.instructor_course_starting_date = instructor_course_starting_date;
        this.instructor_course_duration = instructor_course_duration;
        this.instructor_rating = instructor_rating;
    }

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

    public String getInstructor_image() {
        return instructor_image;
    }

    public void setInstructor_image(String instructor_image) {
        this.instructor_image = instructor_image;
    }
}
