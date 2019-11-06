package com.raisac.musicalstructureapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NowPlaying extends AppCompatActivity implements View.OnClickListener {

    //instatiate the view
    ImageView playbtn, pause, playist_icon;
    MediaPlayer mediaPlayer;
    LinearLayout playback;
    TextView song;
    MainActivity mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);
        mainActivity = new MainActivity();

        //get the song name, from the previous class, using Intent
        Intent intent = getIntent();
        String name = intent.getStringExtra("song_name");

        //locate the view components using their resource IDs
        song = findViewById(R.id.playback_songname);
        playist_icon= findViewById(R.id.playlis_menu);
        playbtn = findViewById(R.id.playbtn);
        pause = findViewById(R.id.pausebtn);

        //set the obtained song name to the textview ontop ot the activity
        song.setText(name);

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
                if(!mediaPlayer.isPlaying()){
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
                if(!mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                break;

            case R.id.playlis_menu:
                /*
                * onclicking the plaulist menu/icon at the top right corner
                * the mainActivity class that shows the music list or the playlist is opened*/

                startActivity(new Intent(NowPlaying.this, MainActivity.class));
                break;

        }
    }
}
