package com.skillrat.myapp.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.skillrat.myapp.Models.MyAdds;
import com.skillrat.myapp.skillrat.R;

import java.util.List;

/**
 * Created by Qasim Ahmed on 31/05/2018.
 */

public class MyAddsAdapter extends RecyclerView.Adapter<MyAddsAdapter.MyViewHolder> {

    public  List<MyAdds> myaddsList;

    public MyAddsAdapter(List<MyAdds> addsList)
    {
        this.myaddsList = addsList;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_myadds_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MyAdds myAdds = myaddsList.get(position);
       holder.tv_addCategory.setText( myAdds.getAdd_category());
       holder.tv_addTitle.setText(myAdds.getAdd_title());
       holder.ratingBar_Add.setRating(myAdds.getAdd_rating());
        // todo  MyAddsAdapter By using picasso we set Image here
        holder.img_add.setImageResource(R.mipmap.ic_launcher);
    }

    @Override
    public int getItemCount() {
        return myaddsList.size();
    }


    // ViewHolder Class
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView  tv_addTitle,tv_addCategory;
        public RatingBar ratingBar_Add;
        public ImageView img_add;

        public MyViewHolder(View view) {
            super(view);
            tv_addTitle = (TextView) view.findViewById(R.id.tv_addtitle);
            tv_addCategory = (TextView) view.findViewById(R.id.tv_addcategory);
            ratingBar_Add = (RatingBar) view.findViewById(R.id.ratingbar_add);
            img_add = (ImageView) view.findViewById(R.id.img_add);

        }
    }




}
