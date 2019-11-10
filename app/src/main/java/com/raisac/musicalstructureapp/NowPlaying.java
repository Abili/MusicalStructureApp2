package com.raisac.musicalstructureapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NowPlaying extends AppCompatActivity implements View.OnClickListener {
    private static final String SONG_NAME = "song_name";
    private static final String ARTIST_NAME = "artist_name";


    //instatiate the view
    @BindView(R.id.playbtn) ImageView playbtn;
    @BindView(R.id.pausebtn) ImageView pause;
    @BindView(R.id.playback_songname)TextView song;
    @BindView(R.id.artists)TextView artists;
    @BindView(R.id.playlis_menu)ImageView playist_icon;

    private MediaPlayer mediaPlayer;
    private  boolean isPlaying;
    Music music;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //get the song name, from the previous class, using Intent
        Intent intent = getIntent();
        if (getIntent().getExtras() != null) {
            if (getIntent().hasExtra(SONG_NAME) || getIntent().hasExtra(ARTIST_NAME)) {
                String songsname = intent.getStringExtra(SONG_NAME);
                String Artistsname = intent.getStringExtra(ARTIST_NAME);

                //dind the views with their resource IDs
                ButterKnife.bind(this);

                //set the obtained song name to the textview ontop ot the activity
                song.setText(songsname + getString(R.string.music_separator));
                artists.setText(Artistsname);
            }
        }
        //create a new Media Player
        mediaPlayer = new MediaPlayer();

        //add onclick listeners to the play, pause and playlist icon, this is an ion that
        //opens the previous activity to show the music list(playlist)
        playbtn.setOnClickListener(this);
        pause.setOnClickListener(this);
        playist_icon.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.playbtn:
                /*
                 * on clicking th play button set;
                 * set the visibility of playbutton to Invisible
                 * show the pause button
                 * */
                playbtn.setVisibility(View.INVISIBLE);
                pause.setVisibility(View.VISIBLE);

                //if there is no music playing, start playing a song

                /* note that this fucntionality has not yet been implemeted, so the buttons
                 * only change from pause to play button actutally does not stop or play the songs
                 * */
                if (!isPlaying) {
                    mediaPlayer.start();
                }
                break;

            case R.id.pausebtn:
                /*
                 * on clicking th play button set;
                 * set the visibility of pause button to Invisible
                 * show the play button
                 * */
                playbtn.setVisibility(View.VISIBLE);
                pause.setVisibility(View.INVISIBLE);
                //if there is no music playing, start playing a song

                /* note that this functionality has not yet been implemeted, so the buttons
                 * only change from pause to play button actutally does not stop or play the songs
                 * */
                if (isPlaying) {
                    mediaPlayer.stop();
                }
                break;

            case R.id.playlis_menu:

        }
    }

    /*use this to listen to the actions taking place on the toolbars
    * for example this one is to help move back to the previous Activity*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {// goto back activity from here
            // close the current activity, this will auromatical go
            // back to the previous activity, right where it is at the moment
            // you opened the new Activity
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
