package com.raisac.musicalstructureapp;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MusicAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] names;

    static class ViewHolder {
        public TextView songname, artistname;
        public ImageView image;
    }

    public MusicAdapter(Activity context, String[] names) {
        super(context, R.layout.music_item, names);
        this.context = context;
        this.names = names;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        // reuse views
        if (rowView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            rowView = inflater.inflate(R.layout.music_item, null);
            // configure view holder
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.songname = rowView.findViewById(R.id.song_name);
            viewHolder.artistname =  rowView.findViewById(R.id.artist_name);
            rowView.setTag(viewHolder);
        }

        // fill data
        ViewHolder holder = (ViewHolder) rowView.getTag();
        Music music = getItem(position);
        holder.artistname.setText(s);
        holder.songname.setText();

        return rowView;
    }
}