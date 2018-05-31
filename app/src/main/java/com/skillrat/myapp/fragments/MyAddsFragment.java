package com.skillrat.myapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.skillrat.myapp.Adapter.MyAddsAdapter;
import com.skillrat.myapp.Models.MyAddsModel.MyAdds;
import com.skillrat.myapp.skillrat.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyAddsFragment extends Fragment {

    MyAddsAdapter myAddsAdapter;
    private List<MyAdds> myAddsArrayList = new ArrayList<>();
    RecyclerView recyclerView;

    public MyAddsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myAddsArrayList.add(new MyAdds(1,"Category","Android App Dev","date",4.5f));
        myAddsArrayList.add(new MyAdds(2,"Category","Web Dev","date",3.5f));
        View rootView = inflater.inflate(R.layout.fragment_my_adds, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        myAddsAdapter = new MyAddsAdapter(myAddsArrayList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(myAddsAdapter);
        return rootView ;
    }

}
