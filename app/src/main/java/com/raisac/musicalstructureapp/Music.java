package com.raisac.musicalstructureapp;

import android.net.Uri;

public class Music {
    private int songName;

    public Music(int songName) {
        this.songName = songName;
    }

    public int getSongName() {
        return songName;
    }
}
