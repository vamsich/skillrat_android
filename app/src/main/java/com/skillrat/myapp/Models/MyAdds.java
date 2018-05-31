package com.skillrat.myapp.Models;

/**
 * Created by Qasim Ahmed on 31/05/2018.
 */

public class MyAdds {
    int add_id;
    String add_category;
    String add_title;
    float add_rating;
    public MyAdds(){

    }

    public MyAdds(int add_id, String add_category, String add_title, float add_rating) {
        this.add_id = add_id;
        this.add_category = add_category;
        this.add_title = add_title;
        this.add_rating = add_rating;
    }

    public int getAdd_id() {
        return add_id;
    }

    public void setAdd_id(int add_id) {
        this.add_id = add_id;
    }

    public String getAdd_category() {
        return add_category;
    }

    public void setAdd_category(String add_category) {
        this.add_category = add_category;
    }

    public String getAdd_title() {
        return add_title;
    }

    public void setAdd_title(String add_title) {
        this.add_title = add_title;
    }

    public float getAdd_rating() {
        return add_rating;
    }

    public void setAdd_rating(float add_rating) {
        this.add_rating = add_rating;
    }
}
