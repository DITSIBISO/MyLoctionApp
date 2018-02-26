package com.example.android.myloctionapp.adminclasses;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.android.myloctionapp.R;

import java.util.ArrayList;
import java.util.List;

public class EventDetail extends AppCompatActivity {

    DbHelper dbHelper;
    List<Info> dbList;
    int position;
    TextView txtevent,txtlocation,txtdatetime,txtdescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        // 5. get status value from bundle
        position = bundle.getInt("position");

        txtevent = findViewById(R.id.event);
        txtlocation = findViewById(R.id.location);
        txtdatetime = findViewById(R.id.datetime);
        txtdescription= findViewById(R.id.description);

        dbHelper = new DbHelper(this);
        dbList = new ArrayList<Info>();
        dbList =  dbHelper.getAllData();

        if (dbList.size()>0){
            String name= dbList.get(position).getEvent();
            String email=dbList.get(position).getLocation();
            String roll=dbList.get(position).getDateTime();
            String address=dbList.get(position).getDescription();

            txtevent.setText(name);
            txtlocation.setText(email);
            txtdatetime.setText(roll);
            txtdescription.setText(address);

        }

    }
}
