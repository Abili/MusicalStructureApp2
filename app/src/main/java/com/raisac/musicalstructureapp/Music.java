package com.raisac.musicalstructureapp;

class Music {
    private final int songUrl;
    private final String songName;
    private final String artistName;

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
