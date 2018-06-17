package com.skillrat.myapp.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;


import com.skillrat.myapp.Models.MyAddsModel.RecommendedCourses;
import com.skillrat.myapp.skillrat.R;

import java.util.ArrayList;

public class AdapterInDemandSession extends RecyclerView.Adapter<AdapterInDemandSession.MyViewHolder> {

    private Context acontext;
    private ArrayList<RecommendedCourses> arrayList;



    public class MyViewHolder extends RecyclerView.ViewHolder {

        public CardView mCardView;
        public TextView tv_instructor_name, tv_instructor_qualification, tv_instructor_course_price,tv_instructor_course_discounted_price, tv_instructor_course_starting_date, tv_instructor_course_duration, tv_instructor_rating;

        public MyViewHolder(View v) {
            super(v);
            mCardView = (CardView) v.findViewById(R.id.card_view_in_demand_session);
            tv_instructor_name = (TextView) v.findViewById(R.id.tv_instructor_name);
            tv_instructor_qualification = (TextView) v.findViewById(R.id.tv_instructor_qualification);
            tv_instructor_course_price = (TextView) v.findViewById(R.id.tv_instructor_course_price);
            tv_instructor_course_starting_date = (TextView) v.findViewById(R.id.tv_instructor_course_starting_date);
            tv_instructor_course_duration = (TextView) v.findViewById(R.id.tv_instructor_course_duration);
            tv_instructor_rating = (TextView) v.findViewById(R.id.tv_instructor_rating);
            tv_instructor_course_discounted_price = (TextView) v.findViewById(R.id.tv_instructor_course_discounted_price);
        }

    }

    public AdapterInDemandSession(Context context, ArrayList<RecommendedCourses> arrayList) {
        this.arrayList = arrayList;
        acontext = context;
    }

    @Override
    public AdapterInDemandSession.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_in_demand_session, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        RecommendedCourses current = arrayList.get(position);
        holder.tv_instructor_name.setText(current.getInstructor_name());
        holder.tv_instructor_qualification.setText(current.getInstructor_qualification());
        holder.tv_instructor_course_price.setText(current.getInstructor_course_price());
        holder.tv_instructor_course_starting_date.setText(current.getInstructor_course_starting_date());
        holder.tv_instructor_course_duration.setText(current.getInstructor_course_duration());
        holder.tv_instructor_rating.setText(current.getInstructor_rating());
        holder.tv_instructor_course_discounted_price.setText(current.getInstructor_course_discounted_price());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

}