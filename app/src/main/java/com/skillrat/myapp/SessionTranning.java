package com.skillrat.myapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.skillrat.myapp.skillrat.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SessionTranning extends Fragment {


    public SessionTranning() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_session_tranning, container, false);
    }

}
