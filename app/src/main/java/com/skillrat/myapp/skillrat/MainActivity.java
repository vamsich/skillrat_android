package com.skillrat.myapp.skillrat;



import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.skillrat.myapp.fragments.BrowseFragment;
import com.skillrat.myapp.fragments.HomeFragment;
import com.skillrat.myapp.fragments.MySessionsFragment;
import com.skillrat.myapp.fragments.NotificationsFragment;
import com.skillrat.myapp.fragments.ProfileFragment;

import static android.R.attr.fragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener
{

        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            loadFragment(new HomeFragment());

            //getting bottom navigation view and attaching the listener
            BottomNavigationView navigation = (BottomNavigationView)findViewById(R.id.navigation);
            navigation.setOnNavigationItemSelectedListener(this);
        }

        private boolean loadFragment(Fragment fragment)
        {
            if(fragment !=null)
            {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, fragment).commit();
                return true;
            }
            return false;
        }

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item)
        {
            Fragment fragment= null;

            switch (item.getItemId())
            {
                case R.id.navigation_home:
                    fragment= new HomeFragment();
                    break;
                case R.id.navigation_dashboard:
                    fragment= new BrowseFragment();
                    break;
                case R.id.navigation_sessions:
                    fragment= new MySessionsFragment();
                    break;
                case R.id.navigation_notifications:
                    fragment= new NotificationsFragment();
                    break;
                case R.id.navigation_profile:
                    fragment= new ProfileFragment();
                    break;
            }
            return loadFragment(fragment);
        }
    }
