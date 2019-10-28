package com.raisac.musicalstructureapp;

import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MusicAdapter extends ArrayAdapter<Music> {
    public MusicAdapter(@NonNull AppCompatActivity context, ArrayList<Music> music) {
        super(context, 0, music);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View musicView = convertView;
        if(musicView==null) {
            musicView = LayoutInflater.from(getContext()).inflate(R.layout.music_item, parent, false);
        }

        final Music music = getItem(position);
        final TextView songname = musicView.findViewById(R.id.song_name);
        songname.setText(music.getSongName());

        musicView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String song = songname.getText().toString();
                Intent intent = new Intent(getContext(), Playback.class);
                intent.putExtra("song_name", song);
                getContext().startActivity(intent);
            }
        });
        return musicView;
    }
}
