package com.raisac.musicalstructureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

public class Playback extends AppCompatActivity {
    ImageView playbtn, pause,playist_icon;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playback);

        Intent intent = getIntent();
        String name = intent.getStringExtra("song_name");
        TextView song = findViewById(R.id.playback_songname);
        song.setText(name);


        playbtn = findViewById(R.id.playbtn);
        playbtn.setImageResource(R.drawable.pause);
        pause = findViewById(R.id.pausebtn);
        mediaPlayer = new MediaPlayer();

        playbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playbtn.setImageResource(R.drawable.play_btn);
            }
        });

       findViewById(R.id.playlis_menu).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(Playback.this, MainActivity.class));
           }
       });

    }
}
