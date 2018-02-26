package com.example.android.myloctionapp.adminclasses;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.myloctionapp.R;

import java.util.List;

public class CreateEvent extends AppCompatActivity {

    DbHelper myDb;
    EditText editEvent,editLocation,editDateTime,editDescription,editId;
    Button CreateEvent,ViewEvent;
    DbHelper dbHelper;
    List<Info> dbList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        myDb = new DbHelper(this);

        //Edit text Refferance
        editEvent = findViewById(R.id.Event);
        editLocation = findViewById(R.id.Location);
        editDateTime = findViewById(R.id.DateTime);
        editDescription = findViewById(R.id.Description);

        CreateEvent = findViewById(R.id.CreateEvent);
        ViewEvent = findViewById(R.id.ViewEvent);

        ViewEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CreateEvent.this,EventList.class));
            }
        });

        CreateEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String event = editEvent.getText().toString();
                String location = editLocation.getText().toString();
                String datetime = editDateTime.getText().toString();
                String description = editDescription.getText().toString();

                if(event.equals("") || location.equals("") || datetime.equals("") ||description.equals("")){
                    Toast.makeText(CreateEvent.this,"Please fill all the fields",Toast.LENGTH_LONG).show();
                }else {
                    dbHelper = new DbHelper(CreateEvent.this);
                    dbHelper.insertData(event, location, datetime, description);
                }
                editEvent.setText("");
                editLocation.setText("");
                editDateTime.setText("");
                editDescription.setText("");


                Toast.makeText(CreateEvent.this, "insert value", Toast.LENGTH_LONG).show();

            }
        });
    }
}

