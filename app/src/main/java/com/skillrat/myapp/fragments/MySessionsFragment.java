package com.skillrat.myapp.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.skillrat.myapp.Adapter.SessionsAdapter;
import com.skillrat.myapp.BrowseModel.Browse;
import com.skillrat.myapp.skillrat.R;

import java.util.List;

/**
 * Created by Arun1234 on 5/28/2018.
 */

public class MySessionsFragment extends Fragment
{
    private List<Browse> employeeList;
    private ProgressDialog pDialog;
    private RecyclerView recyclerView;
    private SessionsAdapter eAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View rootview =  inflater.inflate(R.layout.fragment_mysessions, null);

        return rootview;
    }
}
