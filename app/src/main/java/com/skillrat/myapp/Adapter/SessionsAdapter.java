package com.skillrat.myapp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.skillrat.myapp.SessionsModel.Session;
import com.skillrat.myapp.skillrat.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Abhi on 23 Sep 2017 023.
 */

public class SessionsAdapter extends RecyclerView.Adapter<SessionsAdapter.CustomViewHolder> {
    private List<Session> courses;
    Context context;

    public SessionsAdapter(Context context, List<Session> employees) {
        this.context = context;
        this.courses = employees;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_list_sessions, parent, false);

        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        Session c = courses.get(position);
        Log.d("PARAMS","ID: "+c.getId()+"Description: "+c.getDescription());

        Picasso.with(context).load(c.getLogo()).fit().into(holder.complete_session_img);
        //holder.complete_session_title.setText(c.getId().toString());
        holder.complete_session_content.setText(c.getDescription());
        holder.complete_session_ratingbar.setRating(Float.parseFloat(c.getRating()));

    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public ImageView complete_session_img;
        public TextView complete_session_title, complete_session_content, complete_session_view;
        public RatingBar complete_session_ratingbar;

        public CustomViewHolder(View view) {
            super(view);
            complete_session_img = (ImageView) view.findViewById(R.id.complete_session_img);
            complete_session_content = (TextView) view.findViewById(R.id.complete_session_content);
            complete_session_ratingbar= (RatingBar) view.findViewById(R.id.complete_session_ratingbar);

        }
    }
}
