package com.t2m.musicplayer;

import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
public class Player extends AppCompatActivity {

    final String song_urs[]={"http://192.168.1.118/MusicPlayer/Bole_Dao.mp3",
                             "http://192.168.1.118/MusicPlayer/Deyale_Deyale.mp3",
                             "http://192.168.1.118/MusicPlayer/Eki_Maya.mp3",
                             "http://192.168.1.118/MusicPlayer/Meghe_Dhaka_Shohor.mp3"};


    private int counter;

    private ImageButton btnPlay;
    private ImageButton btnForward;
    private ImageButton btnBackward;
    private ImageButton btnNext;
    private ImageButton btnPrevious;
    private ImageButton btnPlaylist;
    private ImageButton btnRepeat;
    private ImageButton btnShuffle;
    private SeekBar songProgressBar;
    private TextView songTitleLabel;
    private TextView songCurrentDurationLabel;
    private TextView songTotalDurationLabel;
    // Media Player
    private  MediaPlayer mp;
    // Handler to update UI timer, progress bar etc,.
    private Handler mHandler = new Handler();;
    //private SongsManager songManager;
    //private Utilities utils;
    private int seekForwardTime = 5000; // 5000 milliseconds
    private int seekBackwardTime = 5000; // 5000 milliseconds
    private int currentSongIndex = 0;
    private boolean isShuffle = false;
    private boolean isRepeat = false;
    private ArrayList<HashMap<String, String>> songsList = new ArrayList<HashMap<String, String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);



        // All player buttons
        btnPlay = (ImageButton) findViewById(R.id.btnPlay);
        btnForward = (ImageButton) findViewById(R.id.btnForward);
        btnBackward = (ImageButton) findViewById(R.id.btnBackward);
        btnNext = (ImageButton) findViewById(R.id.btnNext);
        btnPrevious = (ImageButton) findViewById(R.id.btnPrevious);
        btnPlaylist = (ImageButton) findViewById(R.id.btnPlaylist);
        btnRepeat = (ImageButton) findViewById(R.id.btnRepeat);
        btnShuffle = (ImageButton) findViewById(R.id.btnShuffle);
        songProgressBar = (SeekBar) findViewById(R.id.songProgressBar);
        songTitleLabel = (TextView) findViewById(R.id.songTitle);
        songCurrentDurationLabel = (TextView) findViewById(R.id.songCurrentDurationLabel);
        songTotalDurationLabel = (TextView) findViewById(R.id.songTotalDurationLabel);

        counter = 0;

       // Mediaplayer
        mp = new MediaPlayer();

        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);

        btnPlay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                 //check for already playing

                songTitleLabel.setText(song_urs[counter]);

                try {
                    mp.setDataSource(song_urs[counter]);



                } catch (Throwable e) {
                    e.printStackTrace();
                }

                try {
                    mp.prepare();
                } catch (Throwable e) {
                    e.printStackTrace();
                }
                // might take long! (for buffering, etc)
                //mp.start();


                if(mp.isPlaying()){
                    if(mp!=null){
                        mp.pause();
                        // Changing button image to play button
                        btnPlay.setImageResource(R.drawable.btn_play);
                    }
                }else{
                    // Resume song
                    if(mp!=null){
                        mp.start();
                        // Changing button image to pause button
                        btnPlay.setImageResource(R.drawable.btn_pause);
                    }
                }






            }
        });


        btnNext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // check if next song is there or not

                songTitleLabel.setText(song_urs[counter]);

                if(counter < (song_urs.length)){
                    counter = counter + 1;

                    try {
                        mp.reset();
                    }catch (Exception Ex){

                        ///

                    }


                    try {
                        mp.setDataSource(song_urs[counter]);



                    } catch (Throwable e) {
                        e.printStackTrace();
                    }

                    try {
                        mp.prepare();
                    } catch (Throwable e) {
                        e.printStackTrace();
                    }


                }else{
                       Toast.makeText(Player.this,"Last Song",Toast.LENGTH_LONG).show();
                }

                if(mp.isPlaying()){
                    if(mp!=null){
                        mp.pause();
                        // Changing button image to play button
                        btnPlay.setImageResource(R.drawable.btn_play);
                    }
                }else{
                    // Resume song
                    if(mp!=null){
                        mp.start();
                        // Changing button image to pause button
                        btnPlay.setImageResource(R.drawable.btn_pause);
                    }
                }

            }
        });



        btnPrevious.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // check if next song is there or not

                songTitleLabel.setText(song_urs[counter]);

                if(counter > 0){
                    counter = counter -1;

                    try {
                        mp.reset();
                    }catch (Exception ex){

                        ///

                    }


                    try {
                        mp.setDataSource(song_urs[counter]);



                    } catch (Throwable e) {
                        e.printStackTrace();
                    }

                    try {
                        mp.prepare();
                    } catch (Throwable e) {
                        e.printStackTrace();
                    }


                }else{
                    Toast.makeText(Player.this,"Last Song",Toast.LENGTH_LONG).show();
                }

                if(mp.isPlaying()){
                    if(mp!=null){
                        mp.pause();
                        // Changing button image to play button
                        btnPlay.setImageResource(R.drawable.btn_play);
                    }
                }else{
                    // Resume song
                    if(mp!=null){
                        mp.start();
                        // Changing button image to pause button
                        btnPlay.setImageResource(R.drawable.btn_pause);
                    }
                }

            }
        });




    }
}
