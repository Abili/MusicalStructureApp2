package com.raisac.musicalstructureapp;

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
        return musicView;
    }
}
