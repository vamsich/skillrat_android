package com.skillrat.myapp.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.skillrat.myapp.Adapter.SessionsAdapter;
import com.skillrat.myapp.SessionsModel.Session;
import com.skillrat.myapp.api.ApiService;
import com.skillrat.myapp.helper.RetroClient;
import com.skillrat.myapp.skillrat.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Arun1234 on 5/28/2018.
 */

public class MySessionsFragment extends Fragment
{
    private List<Session> employeeList;
    private ProgressDialog pDialog;
    private RecyclerView recyclerView;
    private SessionsAdapter eAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View rootview =  inflater.inflate(R.layout.fragment_mysessions, null);

        Toolbar toolbar = (Toolbar) rootview.findViewById(R.id.toolbar_mysessions);

        toolbar.setTitle("Complete Session");
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_back_white_18dp));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //What to do on back clicked
                getActivity().onBackPressed();

            }
        });

        recyclerView = (RecyclerView) rootview.findViewById(R.id.recycler_view);

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
        Call<List<Session>> call = api.getMyJSON();

        /**
         * Enqueue Callback will be call when get response...
         */
        call.enqueue(new Callback<List<Session>>() {
            @Override
            public void onResponse(Call<List<Session>> call, Response<List<Session>> response) {
                //Dismiss Dialog
                pDialog.dismiss();

                if (response.isSuccessful()) {
                    Log.d("RES","In");

                    /**
                     * Got Successfully
                     */
                    employeeList = response.body();
                    Log.d("emplist","emp: "+employeeList);



                    eAdapter = new SessionsAdapter(getContext(),employeeList);
                    RecyclerView.LayoutManager eLayoutManager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(eLayoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(eAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Session>> call, Throwable t) {

                Log.d("RES","Error: "+t.getMessage());
                pDialog.dismiss();
            }
        });
        return rootview;
    }
}
