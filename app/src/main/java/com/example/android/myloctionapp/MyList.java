package com.example.android.myloctionapp;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class MyList extends AppCompatActivity {

    ListView list;
    String[] itemname ={
            "Tembisa High School Parent Meeting",
            "Rabasotho Drug Abuse Youth Meeting",
            "Community Meeting",
            "Parent Meeting Leboneng Pre-School",
            "HIV Awareness March",
            "Youth Development Meeting",
            "Community Meeting",
            "HIV Awareness March"
    };

    Integer[] imgid={
            R.drawable.comm,
            R.drawable.community,
            R.drawable.pic,
            R.drawable.picc,
            R.drawable.piccc,
            R.drawable.piccccc,
            R.drawable.pic,
            R.drawable.piccc,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);

        new DownloadFile().execute("http://www.panafricanparliament.org/images/Resize3.jpg");
    }

    class DownloadFile extends AsyncTask<String,Integer,Long> {
        ProgressDialog mProgressDialog = new ProgressDialog(MyList.this);// Change Mainactivity.this with your activity name.
        String strFolderName;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog.setMessage("Downloading Image ...");
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.setMax(100);
            mProgressDialog.setCancelable(false);
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            mProgressDialog.show();
}
        @Override
        protected Long doInBackground(String... aurl) {
            int count;
            try {
                URL url = new URL((String) aurl[0]);
                URLConnection conexion = url.openConnection();
                conexion.connect();
                String targetFileName = "downloadedimage.jpg";//Change name and subname

                int lenghtOfFile = conexion.getContentLength();
                String PATH = Environment.getExternalStorageDirectory() + "/myImage/";
                File folder = new File(PATH);
                if (!folder.exists()) {
                    folder.mkdir();//If there is no folder it will be created.
                }
                InputStream input = new BufferedInputStream(url.openStream());
                OutputStream output = new FileOutputStream(PATH + targetFileName);
                byte data[] = new byte[1024];
                long total = 0;
                while ((count = input.read(data)) != -1) {
                    total += count;
                    publishProgress((int) (total * 100 / lenghtOfFile));
                    output.write(data, 0, count);
                }
                output.flush();
                output.close();
                input.close();
            } catch (Exception e) {
            }
            return null;
        }

        protected void onProgressUpdate(Integer... progress) {
            mProgressDialog.setProgress(progress[0]);
            if (mProgressDialog.getProgress() == mProgressDialog.getMax()) {
                mProgressDialog.dismiss();

                Toast.makeText(getApplicationContext(), "Download Completed !", Toast.LENGTH_LONG).show();

            }
        }

        protected void onPostExecute(String result) {
        }
    }}