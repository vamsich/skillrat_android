package com.skillrat.myapp.Models.MyAddsModel;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Qasim Ahmed on 31/05/2018.
 */

public class MyAdds {
    int add_id;
    String add_category;
    String add_title;
    Date dateTime;
    float add_rating;
    static final SimpleDateFormat parser = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");;
    static  final SimpleDateFormat formatter =  new SimpleDateFormat("yyyy-MM-dd") ;


    public MyAdds(int add_id, String add_category, String add_title, String dateTime, float add_rating) {
        this.add_id = add_id;
        this.add_category = add_category;
        this.add_title = add_title;
         setDateTime(dateTime);
        this.add_rating = add_rating;
    }

    public void setDateTime(String dateTime)
    {
        try {
            this.dateTime = parser.parse(dateTime);
        } catch (ParseException e) {
            Log.e("MyAdds" ,"Date Exception : "+ e.getLocalizedMessage());
            this.dateTime = Calendar.getInstance().getTime();
        }
    }
    public String getDateTimeInString()
    {
        return formatter.format(this.dateTime);
    }
    public Date getDateTime()
    {
        return this.dateTime;
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
