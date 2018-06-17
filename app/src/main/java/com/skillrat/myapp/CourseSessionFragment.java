package com.skillrat.myapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


import com.skillrat.myapp.Adapter.AdapterInDemandSession;
import com.skillrat.myapp.Adapter.AdapterRecommendedSession;
import com.skillrat.myapp.Models.MyAddsModel.RecommendedCourses;
import com.skillrat.myapp.skillrat.R;

import java.util.ArrayList;

public class CourseSessionFragment extends Fragment {


    ArrayList<RecommendedCourses> data;
    RecyclerView rv, rv1;
    EditText et_search_filter;
    Button bt_search;


    public CourseSessionFragment() {
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
        final View rootView = inflater.inflate(R.layout.recommended_courses, container, false);
        rv = (RecyclerView) rootView.findViewById(R.id.recycler_view_recommended);
        et_search_filter = (EditText) rootView.findViewById(R.id.et_search_filter);
        bt_search = (Button) rootView.findViewById(R.id.bt_search);
        rv.setHasFixedSize(true);
        rv.setFocusable(false);


        rv1 = (RecyclerView) rootView.findViewById(R.id.recycler_view_on_demand);
        rv1.setHasFixedSize(true);
        rv1.setFocusable(false);

        bt_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               
            }
        });
        prepareData();

        return rootView;
    }

    public void prepareData() {

        data = new ArrayList<>();

        RecommendedCourses recommendedCourses = new RecommendedCourses("M Mustafa", "Graduate", "$45", "$5 75% off", "24-June", "4 Month", "4.5");
        data.add(recommendedCourses);
        RecommendedCourses recommendedCourses1 = new RecommendedCourses("Qasim", "Graduate", "$30", "$2 75% off", "2-Sep", "4 Month", "4.9");
        data.add(recommendedCourses1);
        RecommendedCourses recommendedCourses2 = new RecommendedCourses("Nafees", "Graduate", "$55", "$15 75% off", "4-Aug", "4 Month", "3");
        data.add(recommendedCourses2);
        RecommendedCourses recommendedCourses3 = new RecommendedCourses("Usama", "Graduate", "$75", "$25 75% off", "6-July", "4 Month", "4.9");
        data.add(recommendedCourses3);

        AdapterRecommendedSession adapter = new AdapterRecommendedSession(getActivity(), data);
        rv.setAdapter(adapter);

        LinearLayoutManager llm
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true);

        llm.setReverseLayout(true);
        llm.setStackFromEnd(true);

        rv.setLayoutManager(llm);


        AdapterInDemandSession adapterInDemandSession = new AdapterInDemandSession(getActivity(), data);
        rv1.setAdapter(adapterInDemandSession);

        LinearLayoutManager linearLayoutManager
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true);

        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);

        rv1.setLayoutManager(linearLayoutManager);

    }

}