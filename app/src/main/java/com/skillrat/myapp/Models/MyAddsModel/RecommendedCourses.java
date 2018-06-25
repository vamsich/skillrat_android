package com.skillrat.myapp.Models.MyAddsModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Maryam on 6/12/2018.
 */

public class RecommendedCourses {


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
    String course_image_cover;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getCourse_image_cover() {
        return course_image_cover;
    }

    public void setCourse_image_cover(String course_image_cover) {
        this.course_image_cover = course_image_cover;
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
