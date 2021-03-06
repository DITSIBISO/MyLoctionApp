package com.example.android.myloctionapp;

import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.List;

public class VideoActivity extends AppCompatActivity {
//    private ListView mVideosListView;
//    private List<Video> mVideosList = new ArrayList<>();
//    private VideoAdapter mVideoAdapter;
//   // VideoView vd1,vd2;
//    private VideoView videoView;
//    private MediaController mediaController;
//    private static final String VIDEO_PATH = "https://s3.amazonaws.com/androidvideostutorial/862009639.mp4";
private Button btnonce, btncontinuously, btnstop, btnplay;
    private VideoView vv;
    private MediaController mediacontroller;
    private Uri uri;
    private boolean isContinuously = false;
    private ProgressBar progressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);


        //assign video
       // mVideosListView = (ListView) findViewById(R.id.videoListView);

//        videoView = (VideoView)findViewById(R.id.video_view);
//        videoView.setVideoPath(VIDEO_PATH);
//        mediaController = new MediaController(VideoActivity.this);
//        mediaController.setAnchorView(videoView);
//        videoView.setMediaController(mediaController);
//        videoView.start();

//        //create videos
//        Video riverVideo = new Video("https://s3.amazonaws.com/androidvideostutorial/862009639.mp4");
//        Video carsVideo = new Video("https://s3.amazonaws.com/androidvideostutorial/862013714.mp4");
//        Video townVideo = new Video("https://s3.amazonaws.com/androidvideostutorial/862014159.mp4");
//        Video whiteCarVideo = new Video("https://s3.amazonaws.com/androidvideostutorial/862014159.mp4");
//        Video parkVideo = new Video("https://s3.amazonaws.com/androidvideostutorial/862014834.mp4");
//        Video busyCityVideo = new Video("https://s3.amazonaws.com/androidvideostutorial/862017385.mp4");
//
//        mVideosList.add(riverVideo);
//        mVideosList.add(carsVideo);
//        mVideosList.add(townVideo);
//        mVideosList.add(whiteCarVideo);
//        mVideosList.add(parkVideo);
//        mVideosList.add(busyCityVideo);
//
//        /***populate video list to adapter**/
//        mVideoAdapter = new VideoAdapter(this, mVideosList);
//        mVideosListView.setAdapter(mVideoAdapter);

        progressBar = (ProgressBar) findViewById(R.id.progrss);
        btnonce = (Button) findViewById(R.id.btnonce);
        btncontinuously = (Button) findViewById(R.id.btnconti);
        btnstop = (Button) findViewById(R.id.btnstop);
        btnplay = (Button) findViewById(R.id.btnplay);
        vv = (VideoView) findViewById(R.id.vv);

        mediacontroller = new MediaController(this);
        mediacontroller.setAnchorView(vv);
        String uriPath = "android.resource://com.example.android.myloctionapp/"+R.raw.videoplayback; //update package name
        uri = Uri.parse(uriPath);

        vv.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if(isContinuously){
                    vv.start();
                }
            }
        });



        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vv.pause();
            }
        });

        btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vv.start();
            }
        });

        btnonce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isContinuously = false;
                progressBar.setVisibility(View.VISIBLE);
                vv.setMediaController(mediacontroller);
                vv.setVideoURI(uri);
                vv.requestFocus();
                vv.start();
            }
        });

        btncontinuously.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isContinuously = true;
                progressBar.setVisibility(View.VISIBLE);
                vv.setMediaController(mediacontroller);
                vv.setVideoURI(uri);
                vv.requestFocus();
                vv.start();
            }
        });

        vv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            // Close the progress bar and play the video
            public void onPrepared(MediaPlayer mp) {
                progressBar.setVisibility(View.GONE);
            }
        });

        vv.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if(isContinuously){
                    vv.start();
                }
            }
        });

    }
}
