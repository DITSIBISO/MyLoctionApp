package com.example.android.myloctionapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ReportIssuesActivity extends AppCompatActivity {
    EditText ename,eaddress,eproblems;
    Button report,view;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_issues);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ename = (EditText) findViewById(R.id.name);
        eaddress = (EditText) findViewById(R.id.address);
        eproblems = (EditText) findViewById(R.id.problems);

        report = (Button) findViewById(R.id.report);
        view = (Button) findViewById(R.id.view);
        // eproblems = (EditText) findViewById(R.id.problems);

        db = openOrCreateDatabase("Report_Issues", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS report(name String, address String,report String)");

        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ename.getText().toString().trim().length() == 0 ||
                        eaddress.getText().toString().trim().length() == 0 ||
                        eproblems.getText().toString().trim().length() == 0) {
                    showMessage("Error", "Please enter all values");
                    return;
                }

                db.execSQL("INSERT INTO report VALUES('" + ename.getText() + "','" + eaddress.getText() +
                        "','" + eproblems.getText() + "');");
                showMessage("Success", "Report added Successfully");
                clearText();
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c = db.rawQuery("SELECT * FROM report", null);
                if (c.getCount() == 0) {
                    showMessage("Error", "No report found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (c.moveToNext()) {
                    buffer.append("Name: " + c.getString(0) + "\n");
                    buffer.append("Address: " + c.getString(1) + "\n");
                    buffer.append("Problems: " + c.getString(2) + "\n\n");
                }
                showMessage("Reported Issues", buffer.toString());
            }
        });
    }

    public void showMessage(String title,String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
    public void clearText()
    {
        ename.setText("");
        eaddress.setText("");
        eproblems.setText("");

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.action_settings:
                //add the function to perform here
                return (true);
            case R.id.action_Feedback:
                //add the function to perform here
                return (true);
            case R.id.action_Invite:
                //add the function to perform here
                return (true);
            case R.id.action_Call:
                //add the function to perform here
                return (true);
            case R.id.action_LOGOUT:
                //add the function to perform here
                Bundle dataBundle = new Bundle();
                dataBundle.putInt("id",0);
                Intent intent = new Intent(getApplicationContext(),LogInActivity.class);
                intent.putExtras(dataBundle);

                startActivity(intent);
                return true;
            default:
                return (super.onOptionsItemSelected(item));

        }

    }
}
