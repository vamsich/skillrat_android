package com.skillrat.myapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.skillrat.myapp.TabLayout.TabLayoutMain;
import com.skillrat.myapp.fragments.BrowseFragment;
import com.skillrat.myapp.fragments.HomeFragment;
import com.skillrat.myapp.fragments.MyAddsFragment;
import com.skillrat.myapp.fragments.MySessionsFragment;
import com.skillrat.myapp.fragments.NotificationsFragment;
import com.skillrat.myapp.skillrat.R;

public class DrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(Color.TRANSPARENT);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
        navigation.getMenu().getItem(2).setChecked(true);

        Fragment fragmentName = null;
        Fragment MapFragment = new CourseSessionFragment();
        fragmentName = MapFragment;
        replaceFragment(fragmentName);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            finish();
            /*
            super.onBackPressed();*/
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        Fragment fragmentName = null;
        Fragment CourseSessionFragment = new CourseSessionFragment();
        Fragment BrowseFragment = new BrowseFragment();
        Fragment MySessionsFragment = new MySessionsFragment();
        Fragment NotificationsFragment = new NotificationsFragment();
        Fragment MyAddsFragment = new MyAddsFragment();
        Fragment TabLayoutMain = new TabLayoutMain();

        int id = item.getItemId();

        if (id == R.id.nav_complete_traning) {
            // Handle the camera action
        } else if (id == R.id.nav_session_traning) {

        } else if (id == R.id.nav_my_session) {
            fragmentName = TabLayoutMain;
            replaceFragment(fragmentName);
        } else if (id == R.id.nav_payment) {

        } else if (id == R.id.nav_about_us) {

        } else if (id == R.id.nav_privacy_policy) {

        } else if (id == R.id.nav_feedback) {

        } else if (id == R.id.nav_help_and_support) {

        } else if (id == R.id.nav_log_out) {

        } else if (id == R.id.navigation_home) {

        } else if (id == R.id.navigation_dashboard) {
            fragmentName = MySessionsFragment;
            replaceFragment(fragmentName);
        } else if (id == R.id.navigation_sessions) {
            fragmentName = CourseSessionFragment;
            replaceFragment(fragmentName);
        } else if (id == R.id.navigation_notifications) {
            fragmentName = NotificationsFragment;
            replaceFragment(fragmentName);
        } else if (id == R.id.navigation_myadds) {
            fragmentName = MyAddsFragment;
            replaceFragment(fragmentName);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void replaceFragment(Fragment fragment) {
        String backStateName = fragment.getClass().getName();
        String fragmentTag = backStateName;


        FragmentManager manager = getSupportFragmentManager();
        boolean fragmentPopped = false;
        try {

            fragmentPopped = manager.popBackStackImmediate(backStateName, 0);

        } catch (IllegalStateException ignored) {
            // There's no way to avoid getting this if saveInstanceState has already been called.
        }
        if (!fragmentPopped && manager.findFragmentByTag(fragmentTag) == null) { //fragment not in back stack, create it.
            FragmentTransaction ft = manager.beginTransaction();
            ft.replace(R.id.fragment_container, fragment, fragmentTag);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.addToBackStack(backStateName);
            ft.commitAllowingStateLoss();
        }

    }
}
