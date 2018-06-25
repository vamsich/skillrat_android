package com.skillrat.myapp.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.skillrat.myapp.Models.MyAddsModel.CurrentAndPastSession;
import com.skillrat.myapp.skillrat.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterPastSession extends RecyclerView.Adapter<AdapterPastSession.MyViewHolder> {

    private Context acontext;
    private ArrayList<CurrentAndPastSession> arrayList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public CardView mCardView;
        public TextView tv_instructor_name, tv_instructor_qualification, tv_instructor_course_starting_date, tv_instructor_course_duration, tv_instructor_course_price, tv_instructor_course_discounted_price;
        public RatingBar tv_instructor_rating;
        ImageView img_dp_past;

        public MyViewHolder(View v) {
            super(v);
            mCardView = (CardView) v.findViewById(R.id.card_view_order_cancel);
            tv_instructor_name = (TextView) v.findViewById(R.id.tv_instructor_name);
            tv_instructor_qualification = (TextView) v.findViewById(R.id.tv_instructor_qualification);
            tv_instructor_course_starting_date = (TextView) v.findViewById(R.id.tv_instructor_course_starting_date);
            tv_instructor_course_duration = (TextView) v.findViewById(R.id.tv_instructor_course_duration);
            tv_instructor_course_price = (TextView) v.findViewById(R.id.tv_instructor_course_price);
            tv_instructor_course_discounted_price = (TextView) v.findViewById(R.id.tv_instructor_course_discounted_price);
            tv_instructor_rating = (RatingBar) v.findViewById(R.id.tv_instructor_rating);
            img_dp_past = (ImageView) v.findViewById(R.id.img_dp_past);
        }

    }

    public AdapterPastSession(Context context, ArrayList<CurrentAndPastSession> arrayList) {
        this.arrayList = arrayList;
        acontext = context;
    }

    @Override
    public AdapterPastSession.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_order_cancel, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        CurrentAndPastSession current = arrayList.get(position);
        Picasso.with(acontext).load(current.getInstructor_image()).into(holder.img_dp_past);
        holder.tv_instructor_name.setText(current.getInstructor_name());
        holder.tv_instructor_qualification.setText("Qualification : "+current.getInstructor_qualification());
        holder.tv_instructor_course_starting_date.setText("Starting Date : "+current.getInstructor_course_starting_date());
        holder.tv_instructor_course_duration.setText("Duration : "+current.getInstructor_course_duration());
        holder.tv_instructor_course_price.setText("Price : "+current.getInstructor_course_price());
        holder.tv_instructor_course_discounted_price.setText("Discounted Price : "+current.getInstructor_course_discounted_price());
        holder.tv_instructor_rating.setRating(Float.parseFloat(current.getInstructor_rating()));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

}