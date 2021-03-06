package com.example.android.myloctionapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.android.myloctionapp.adminclasses.EmailPasswordActivity;
import com.example.android.myloctionapp.adminclasses.EventList;
import com.example.android.myloctionapp.adminclasses.LoginActivity;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
            Intent intent = new Intent(MainActivity.this,SettingsActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_Feedback){
            Intent intent = new Intent(MainActivity.this,FeedBackActivity.class);
            startActivity(intent);
            return true;
        } else if (id ==R.id.action_Invite){
            Intent intent = new Intent(MainActivity.this,InviteFriendActivity.class);
            startActivity(intent);
            return true;
        } else if (id ==R.id.action_Call) {
            Intent intent = new Intent(MainActivity.this,CallActivity.class);
            startActivity(intent);
            return true;
        }else if (id ==R.id.action_LOGOUT) {

            Intent intent = new Intent(MainActivity.this,LogInActivity.class);
            startActivity(intent);
            return true;


        }

        return super.onOptionsItemSelected(item);



    }




    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_meeting) {
            // Handle the camera action
             Intent intent = new Intent(MainActivity.this,EventList.class);
             startActivity(intent);
        } else if (id == R.id.nav_lates_news) {
            Intent intent = new Intent(MainActivity.this,LatestNewsActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_report_issues) {
            Intent intent = new Intent(MainActivity.this,ReportIssuesActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_gallery) {
            Intent intent = new Intent(MainActivity.this,GalleryActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_video) {
            Intent intent = new Intent(MainActivity.this,VideoActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_register) {
            Intent intent = new Intent(MainActivity.this,EmailPasswordActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_maps) {
            Intent intent = new Intent(MainActivity.this,MapsActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_log_in) {


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
