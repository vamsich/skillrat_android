package com.skillrat.myapp.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.skillrat.myapp.Models.MyAddsModel.RecommendedCourses;
import com.skillrat.myapp.skillrat.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterRecommendedSession extends RecyclerView.Adapter<AdapterRecommendedSession.MyViewHolder> {

    private Context acontext;
    private ArrayList<RecommendedCourses> arrayList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public CardView mCardView;
        public TextView tv_instructor_name, tv_instructor_qualification, tv_instructor_course_price, tv_instructor_course_discounted_price, tv_instructor_course_starting_date, tv_instructor_course_duration, tv_instructor_rating;
        ImageView img_recommended_courses;

        public MyViewHolder(View v) {
            super(v);
            mCardView = (CardView) v.findViewById(R.id.card_view_recommended_session);
            tv_instructor_name = (TextView) v.findViewById(R.id.tv_instructor_name);
            tv_instructor_qualification = (TextView) v.findViewById(R.id.tv_instructor_qualification);
            tv_instructor_course_price = (TextView) v.findViewById(R.id.tv_instructor_course_price);
            tv_instructor_course_starting_date = (TextView) v.findViewById(R.id.tv_instructor_course_starting_date);
            tv_instructor_course_duration = (TextView) v.findViewById(R.id.tv_instructor_course_duration);
            tv_instructor_rating = (TextView) v.findViewById(R.id.tv_instructor_rating);
            tv_instructor_course_discounted_price = (TextView) v.findViewById(R.id.tv_instructor_course_discounted_price);
            img_recommended_courses = (ImageView) v.findViewById(R.id.img_recommended_courses);
        }

    }

    public AdapterRecommendedSession(Context context, ArrayList<RecommendedCourses> arrayList) {
        this.arrayList = arrayList;
        acontext = context;
    }

    @Override
    public AdapterRecommendedSession.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_recommended_session, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        RecommendedCourses current = arrayList.get(position);
        Picasso.with(acontext).load(current.getCourse_image_cover()).into(holder.img_recommended_courses);
        holder.tv_instructor_name.setText(current.getInstructor_name());
        holder.tv_instructor_qualification.setText(current.getInstructor_qualification());
        holder.tv_instructor_course_price.setText(current.getInstructor_course_price());
        holder.tv_instructor_course_starting_date.setText(current.getInstructor_course_starting_date());
        holder.tv_instructor_course_duration.setText(current.getInstructor_course_duration());
        holder.tv_instructor_rating.setText(current.getInstructor_rating());
        holder.tv_instructor_course_discounted_price.setText(current.getInstructor_course_discounted_price());
        //Toast.makeText(acontext,""+current.getCourse_image_cover(),Toast.LENGTH_LONG).show();

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

}