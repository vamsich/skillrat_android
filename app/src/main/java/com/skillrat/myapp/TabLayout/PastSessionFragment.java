package com.skillrat.myapp.TabLayout;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.skillrat.myapp.Adapter.AdapterPastSession;
import com.skillrat.myapp.Models.MyAddsModel.CurrentAndPastSession;
import com.skillrat.myapp.api.ApiService;
import com.skillrat.myapp.helper.RetroClient;
import com.skillrat.myapp.skillrat.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PastSessionFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {


    ArrayList<CurrentAndPastSession> data;
    SwipeRefreshLayout mSwipeRefreshLayout;
    RecyclerView rv;
    AdapterPastSession adapterPastSession;
    private ProgressDialog pDialog;


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
        /*prepareData();*/
    }

    public void refreshItems() {
        onItemsLoadComplete();
    }

    public void onItemsLoadComplete() {
        mSwipeRefreshLayout.setRefreshing(false);
    }






    public void prepareData() {

       /* data = new ArrayList<>();

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



        rv.setLayoutManager(llm);*/

       /* pDialog = new ProgressDialog(getContext());
        pDialog.setMessage("Loading Data.. Please wait...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();
*/

        //Creating an object of our api interface
        ApiService api = RetroClient.getApiService();

        /**
         * Calling JSON
         */
        Call<ArrayList<CurrentAndPastSession>> call = api.getMyJSONOnPastSession();

        /**
         * Enqueue Callback will be call when get response...
         */
        call.enqueue(new Callback<ArrayList<CurrentAndPastSession>>() {
            @Override
            public void onResponse(Call<ArrayList<CurrentAndPastSession>> call, Response<ArrayList<CurrentAndPastSession>> response) {
                //Dismiss Dialog
/*
                pDialog.dismiss();
*/

                if (response.isSuccessful()) {
                    Log.d("RES", "In");

                    /**
                     * Got Successfully
                     */
                    data = response.body();
                    Log.d("emplist", "emp: " + data);


                    adapterPastSession = new AdapterPastSession(getActivity(), data);
                    rv.setAdapter(adapterPastSession);

                    LinearLayoutManager llm
                            = new LinearLayoutManager(getActivity());


                    rv.setLayoutManager(llm);
                    rv.setItemAnimator(new DefaultItemAnimator());

                }
            }

            @Override
            public void onFailure(Call<ArrayList<CurrentAndPastSession>> call, Throwable t) {
/*
                pDialog.dismiss();
*/

                Log.d("RES", "Error: " + t.getMessage());
            }
        });










    }
}