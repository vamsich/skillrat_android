package com.skillrat.myapp.TabLayout;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.skillrat.myapp.Adapter.AdapterCurrentSession;
import com.skillrat.myapp.Adapter.AdapterPastSession;
import com.skillrat.myapp.Models.MyAddsModel.CurrentAndPastSession;
import com.skillrat.myapp.api.ApiService;
import com.skillrat.myapp.helper.RetroClient;
import com.skillrat.myapp.skillrat.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CurrentSessionFragment extends Fragment implements AdapterCurrentSession.ItemClickListener, SwipeRefreshLayout.OnRefreshListener {

    ArrayList<CurrentAndPastSession> data;
    SwipeRefreshLayout mSwipeRefreshLayout;
    RecyclerView rv;
    AdapterCurrentSession adapterCurrentSession;
    private ProgressDialog pDialog;

    public CurrentSessionFragment() {
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
        View rootView = inflater.inflate(R.layout.fragment_one, container, false);
        rv = (RecyclerView) rootView.findViewById(R.id.rv_order_completed);
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

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onClick(View view, int position) {

        Toast.makeText(getActivity(),"Feedback",Toast.LENGTH_LONG);

       /* Fragment fragmentName = null;
        Fragment CompletedJobDetailFragment = new CompletedJobDetailFragment();
        fragmentName = CompletedJobDetailFragment;


        replaceFragment(fragmentName);*/
    }

    public void refreshItems() {
        onItemsLoadComplete();
    }

    public void onItemsLoadComplete() {
        mSwipeRefreshLayout.setRefreshing(false);
    }

    private void replaceFragment(Fragment fragment) {
        String backStateName = fragment.getClass().getName();
        String fragmentTag = backStateName;

        FragmentManager manager = getActivity().getSupportFragmentManager();
        boolean fragmentPopped = manager.popBackStackImmediate(backStateName, 0);

        if (!fragmentPopped && manager.findFragmentByTag(fragmentTag) == null) { //fragment not in back stack, create it.
            FragmentTransaction ft = manager.beginTransaction();
            ft.replace(R.id.fragment_container, fragment, fragmentTag);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.addToBackStack(backStateName);
            ft.commit();
        }
    }





    public void prepareData() {


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
        Call<ArrayList<CurrentAndPastSession>> call = api.getMyJSONOnCurrentSession();

        /**
         * Enqueue Callback will be call when get response...
         */
        call.enqueue(new Callback<ArrayList<CurrentAndPastSession>>() {
            @Override
            public void onResponse(Call<ArrayList<CurrentAndPastSession>> call, Response<ArrayList<CurrentAndPastSession>> response) {
                //Dismiss Dialog
                pDialog.dismiss();

                if (response.isSuccessful()) {
                    Log.d("RES", "In");

                    /**
                     * Got Successfully
                     */
                    data = response.body();
                    Log.d("emplist", "emp: " + data);


                    adapterCurrentSession = new AdapterCurrentSession(getActivity(), data);
                    rv.setAdapter(adapterCurrentSession);

                    LinearLayoutManager llm
                            = new LinearLayoutManager(getActivity());


                    rv.setLayoutManager(llm);
                    rv.setItemAnimator(new DefaultItemAnimator());

                }
            }

            @Override
            public void onFailure(Call<ArrayList<CurrentAndPastSession>> call, Throwable t) {
                pDialog.dismiss();

                Log.d("RES", "Error: " + t.getMessage());
            }
        });


    }
}