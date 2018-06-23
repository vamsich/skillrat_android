package com.skillrat.myapp.TabLayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.skillrat.myapp.Adapter.AdapterPastSession;
import com.skillrat.myapp.Models.MyAddsModel.CurrentAndPastSession;
import com.skillrat.myapp.skillrat.R;

import java.util.ArrayList;

public class PastSessionFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {


    ArrayList<CurrentAndPastSession> data;
    SwipeRefreshLayout mSwipeRefreshLayout;
    RecyclerView rv;

    public PastSessionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_three, container, false);
        rv = (RecyclerView) rootView.findViewById(R.id.rv_order_cancel);
        rv.setHasFixedSize(true);

        mSwipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.contentView);
        mSwipeRefreshLayout.setOnRefreshListener(this);

        prepareData();

        return rootView;
    }



    @Override
    public void onRefresh() {
        /*loadData();*/
    }

    public void refreshItems() {
        onItemsLoadComplete();
    }

    public void onItemsLoadComplete() {
        mSwipeRefreshLayout.setRefreshing(false);
    }






    public void prepareData() {

        data = new ArrayList<>();

        CurrentAndPastSession recommendedCourses = new CurrentAndPastSession("M Mustafa", "Graduate", "$45", "$5 75% off", "24-June", "4 Month", "4.5");
        data.add(recommendedCourses);
        CurrentAndPastSession recommendedCourses1 = new CurrentAndPastSession("Qasim", "Graduate", "$30", "$2 75% off", "2-Sep", "4 Month", "4.9");
        data.add(recommendedCourses1);
        CurrentAndPastSession recommendedCourses2 = new CurrentAndPastSession("Nafees", "Graduate", "$55", "$15 75% off", "4-Aug", "4 Month", "3");
        data.add(recommendedCourses2);
        CurrentAndPastSession recommendedCourses3 = new CurrentAndPastSession("Usama", "Graduate", "$75", "$25 75% off", "6-July", "4 Month", "4.9");
        data.add(recommendedCourses3);

        AdapterPastSession adapter = new AdapterPastSession(getActivity(), data);
        rv.setAdapter(adapter);

        LinearLayoutManager llm
                = new LinearLayoutManager(getActivity());



        rv.setLayoutManager(llm);

    }
}