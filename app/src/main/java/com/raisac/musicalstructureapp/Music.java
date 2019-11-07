package com.raisac.musicalstructureapp;

import android.net.Uri;

public class Music {
    private int songUrl;
    private String songName;
    private String artistName;

    public Music(int SongUrl, String songName,String ArtistName ) {
        this.songUrl = SongUrl;
        this.songName = songName;
        this.artistName = ArtistName;
    }

    public int getSongUrl() {
        return songUrl;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getSongName() {
        return songName;
    }
}
