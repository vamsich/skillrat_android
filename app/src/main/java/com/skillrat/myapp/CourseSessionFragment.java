package com.skillrat.myapp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.skillrat.myapp.Adapter.AdapterInDemandSession;
import com.skillrat.myapp.Adapter.AdapterRecommendedSession;
import com.skillrat.myapp.Models.MyAddsModel.RecommendedCourses;
import com.skillrat.myapp.api.ApiService;
import com.skillrat.myapp.helper.RetroClient;
import com.skillrat.myapp.skillrat.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CourseSessionFragment extends Fragment {


    ArrayList<RecommendedCourses> recommendedCourses;
    ArrayList<RecommendedCourses> onDemandRecommendedCourses;
    RecyclerView rv, rv1;
    EditText et_search_filter;
    Button bt_search;
    private ProgressDialog pDialog;
    private AdapterRecommendedSession adapterRecommendedSession;
    private AdapterInDemandSession adapterInDemandSession;


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

        /*recommendedCourses = new ArrayList<>();

        RecommendedCourses recommendedCourses = new RecommendedCourses("M Mustafa", "Graduate", "$45", "$5 75% off", "24-June", "4 Month", "4.5");
        recommendedCourses.add(recommendedCourses);
        RecommendedCourses recommendedCourses1 = new RecommendedCourses("Qasim", "Graduate", "$30", "$2 75% off", "2-Sep", "4 Month", "4.9");
        recommendedCourses.add(recommendedCourses1);
        RecommendedCourses recommendedCourses2 = new RecommendedCourses("Nafees", "Graduate", "$55", "$15 75% off", "4-Aug", "4 Month", "3");
        recommendedCourses.add(recommendedCourses2);
        RecommendedCourses recommendedCourses3 = new RecommendedCourses("Usama", "Graduate", "$75", "$25 75% off", "6-July", "4 Month", "4.9");
        recommendedCourses.add(recommendedCourses3);*/

       /* AdapterRecommendedSession adapter = new AdapterRecommendedSession(getActivity(), recommendedCourses);
        rv.setAdapter(adapter);

        LinearLayoutManager llm
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true);

        llm.setReverseLayout(true);
        llm.setStackFromEnd(true);

        rv.setLayoutManager(llm);*/


        getRecommendedCourses();
        getInDemandCourses();


       /* AdapterInDemandSession adapterInDemandSession = new AdapterInDemandSession(getActivity(), recommendedCourses);
        rv1.setAdapter(adapterInDemandSession);

        LinearLayoutManager linearLayoutManager
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true);

        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);

        rv1.setLayoutManager(linearLayoutManager);*/

    }

    public void getRecommendedCourses() {

        pDialog = new ProgressDialog(getContext());
        pDialog.setMessage("Loading Data.. Please wait...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

        //Creating an object of our api interface
        ApiService api = RetroClient.getApiService();

        /**
         * Calling JSON
         */
        Call<ArrayList<RecommendedCourses>> call = api.getMyJSONRecommendCourses();

        /**
         * Enqueue Callback will be call when get response...
         */
        call.enqueue(new Callback<ArrayList<RecommendedCourses>>() {
            @Override
            public void onResponse(Call<ArrayList<RecommendedCourses>> call, Response<ArrayList<RecommendedCourses>> response) {
                //Dismiss Dialog
                pDialog.dismiss();

                if (response.isSuccessful()) {
                    Log.d("RES", "In");

                    /**
                     * Got Successfully
                     */
                    recommendedCourses = response.body();
                    Log.d("emplist", "emp: " + recommendedCourses);



                   /* adapterRecommendedSession = new AdapterRecommendedSession(getContext(), recommendedCourses);
                    RecyclerView.LayoutManager eLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, true);

                    rv.setLayoutManager(eLayoutManager);
                    rv.setItemAnimator(new DefaultItemAnimator());
                    rv.setAdapter(adapterRecommendedSession);

*/

                    adapterRecommendedSession = new AdapterRecommendedSession(getActivity(), recommendedCourses);
                    rv.setAdapter(adapterRecommendedSession);

                    LinearLayoutManager llm
                            = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true);

                    llm.setReverseLayout(true);
                    llm.setStackFromEnd(true);

                    rv.setLayoutManager(llm);
                    rv.setItemAnimator(new DefaultItemAnimator());


                }
            }

            @Override
            public void onFailure(Call<ArrayList<RecommendedCourses>> call, Throwable t) {

                Log.d("RES", "Error: " + t.getMessage());
                pDialog.dismiss();
            }
        });
    }

    public void getInDemandCourses() {


        //Creating an object of our api interface
        ApiService api = RetroClient.getApiService();

        /**
         * Calling JSON
         */
        Call<ArrayList<RecommendedCourses>> call = api.getMyJSONOnDemandCourses();

        /**
         * Enqueue Callback will be call when get response...
         */
        call.enqueue(new Callback<ArrayList<RecommendedCourses>>() {
            @Override
            public void onResponse(Call<ArrayList<RecommendedCourses>> call, Response<ArrayList<RecommendedCourses>> response) {
                //Dismiss Dialog

                if (response.isSuccessful()) {
                    Log.d("RES", "In");

                    /**
                     * Got Successfully
                     */
                    onDemandRecommendedCourses = response.body();
                    Log.d("emplist", "emp: " + onDemandRecommendedCourses);


                    adapterInDemandSession = new AdapterInDemandSession(getActivity(), onDemandRecommendedCourses);
                    rv1.setAdapter(adapterInDemandSession);

                    LinearLayoutManager llm
                            = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true);

                    llm.setReverseLayout(true);
                    llm.setStackFromEnd(true);

                    rv1.setLayoutManager(llm);
                    rv1.setItemAnimator(new DefaultItemAnimator());

                }
            }

            @Override
            public void onFailure(Call<ArrayList<RecommendedCourses>> call, Throwable t) {

                Log.d("RES", "Error: " + t.getMessage());
            }
        });
    }

}