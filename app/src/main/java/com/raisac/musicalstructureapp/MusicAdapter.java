package com.raisac.musicalstructureapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

@SuppressWarnings("NullableProblems")
class MusicAdapter extends ArrayAdapter<Music> {
    private final Activity context;
    private final List<Music> music;


    public MusicAdapter(Activity context, List<Music> music) {
        super(context, R.layout.music_item, music);
        this.context = context;
        this.music = music;
    }

    static class ViewHolder {
        @BindView(R.id.song_name)TextView songname;
        @BindView(R.id.artist_name) TextView artistname;
    }

    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {
        View rowView = convertView;
        // reuse views
        if (rowView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            rowView = inflater.inflate(R.layout.music_item, null);
            // configure view holder
            ViewHolder viewHolder = new ViewHolder();
            ButterKnife.bind(this, rowView);
            rowView.setTag(viewHolder);
        }

        // fill data
        ViewHolder holder = (ViewHolder) rowView.getTag();
        holder.songname.setText(music.get(position).getSongName());
        holder.artistname.setText(music.get(position).getArtistName());

        return rowView;
    }
}