package com.skillrat.myapp.BrowseModel;

/**
 * Created by Abhi on 06 Sep 2017 006.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Browse {
    @SerializedName("id")
    @Expose
    private Integer Id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("logo")
    @Expose
    private String logo;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}