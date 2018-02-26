package com.example.android.myloctionapp.adminclasses;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.android.myloctionapp.R;

import java.util.ArrayList;
import java.util.List;

public class EventList extends AppCompatActivity {

    DbHelper dbHelper;
    List<Info> dbList;
    RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dbHelper = new DbHelper(this);
        dbList = new ArrayList<Info>();
        dbList = dbHelper.getAllData();

        recyclerView = findViewById(R.id.recycleview);

        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new RecyclerAdapter(this,dbList);
        recyclerView.setAdapter(mAdapter);
    }
}
