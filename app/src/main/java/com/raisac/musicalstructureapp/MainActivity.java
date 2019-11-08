package com.raisac.musicalstructureapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<Music> music;
    ImageView play, next, pause, prev, list_playbtn, list_pausebtn;
    TextView nowPlaying_songname, songnameTv, artistnameTV, nowPlaying_artist_name;
    Music songs;
    MediaPlayer mediaPlayer;
    String songname_String, artistString;
    LinearLayout playBack_layout, open_nowplaying_layout;
    FloatingActionButton forward;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playBack_layout = findViewById(R.id.linear_playback);
        pause = findViewById(R.id.pause_black);
        play = findViewById(R.id.play_black);
        nowPlaying_songname = findViewById(R.id.now_playingTv);
        nowPlaying_artist_name = findViewById(R.id.nowplaying_artistname);
        forward = findViewById(R.id.nowplayingclass);
        artistnameTV = findViewById(R.id.nowplaying_artistname);


        open_nowplaying_layout = findViewById(R.id.open_nowPlaying);

        //add onclick listeners to the buttons, Play Nand Pause
        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        open_nowplaying_layout.setOnClickListener(this);


        //this button is mainly just to navigate between the actitivites
        forward.setOnClickListener(this);


        /*this is a textview that is found inside the Linead layout that is
        found at the bottom of the screen. innitially this layout is set Invisible
        a song is selected from the list*

        i added an onclick on the textview since it covers a big percentage ot the playout
        and most userd click an item right at the middle
         */
        nowPlaying_songname.setOnClickListener(this);


        //create a new object for the Media Player
        mediaPlayer = new MediaPlayer();


        //creat an arraylist for the Music class
        music = new ArrayList<>();

        //add songs on to this arraylist stored in the raw folder
        music.add(new Music(R.raw.a_pass_oruso_nva_kampala, "oruuso", "Apass"));
        music.add(new Music(R.raw.a_pass_tulo_nva_kampala, "Tuulo", "Apass"));
        music.add(new Music(R.raw.akaliro__rema, "Akaliro", "Rema Namakula"));
        music.add(new Music(R.raw.akalulu_ziza_bafana, "Akalulu", " Ziza Bafana"));
        music.add(new Music(R.raw.akambe_by_maureen_nantume, "Akambe", "maureen namntume"));
        music.add(new Music(R.raw.akatonotono__rema_namakula, "Akatonotono", "Rema Namakula"));
        music.add(new Music(R.raw.aliyenda_na_bus_joel_kisakye, "Aliyenda na Bus", "Joel kisaakye"));
        music.add(new Music(R.raw.amatu_magale_a_pass_ft_tash_b, "amatu magale", " Apass ft tash_b"));
        music.add(new Music(R.raw.amina_ykee_benda, "Amina", "Ykee benda"));
        music.add(new Music(R.raw.anayinama_by_nina_roz, "Anayinama", "Nina Roz"));

        //create an adapter object and add the music arraylist to the adapter
        final MusicAdapter musicAdapter = new MusicAdapter(this, music);

        //locate the lsitview ti be used to display the music list
        final ListView listView = findViewById(R.id.music_list);

        //cast the adapter on to the listview, this will show th added music
        listView.setAdapter(musicAdapter);


        /*
         * add an onitemClick listener to the listview Item, so that when the song is select
         * some Action can be performed
         * */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                /*on selecting a song show the layout that holds the song imageview, song name and
                the play and pause button

                this layout is made invisible innittialy from the xml file
                 */
                playBack_layout.setVisibility(View.VISIBLE);

                //show the move forar floaing action button
                forward.setVisibility(View.VISIBLE);

                //here i get the position of the selected song
                songs = music.get(position);

                /*
                 * if a song is already playing and another song is seleted the previous song is
                 * stopped
                 * */
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();

                    /*the newly selected song id the added to the media player to replace the previos song
                    and start() method is used to play the song
                     */

                    mediaPlayer = MediaPlayer.create(MainActivity.this, songs.getSongUrl());
                    mediaPlayer.start();
                } else {

                    //if there is no song playing, on selecting from the list. the selectd song is played
                    mediaPlayer = MediaPlayer.create(MainActivity.this, songs.getSongUrl());
                    mediaPlayer.start();


                }

                /*here i ws tryin to get the song name and artistname from the selected listview item
                rememeber the listview has a tectview in it that holds the song name

                1. first  get the ID of the text view
                2. then  get the text from it
                3. save th text onto a string
                4. set the text to the textview found in the playback playout
                below the screen
                *
                 */
                songnameTv = view.findViewById(R.id.song_name);
                songname_String = songnameTv.getText().toString();
                nowPlaying_songname.setText(songname_String + "__ __");

                artistnameTV = view.findViewById(R.id.artist_name);
                artistString = artistnameTV.getText().toString();
                nowPlaying_artist_name.setText(artistString);


                /*
                 * initial the lplayback layout has a playButton displayed but since its made invisible
                 * this button as wel cannot be seen
                 *
                 * on selecting a song the playButton is made Invisible and the pause button is made visible
                 *
                 * to simply show the functionality of play and pause
                 * */
                play.setVisibility(View.INVISIBLE);
                pause.setVisibility(View.VISIBLE);


            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            /*when the play button is clickec
             * set the plaaybutton invisible
             * set the pause button visible
             * start the media player to play the song selected*/
            case R.id.play_black:
                play.setVisibility(View.INVISIBLE);
                pause.setVisibility(View.VISIBLE);
                mediaPlayer.start();

                break;

            case R.id.pause_black:
                /*when the pause button is selectd set the playbutton visible
                 * set the pause button invisible
                 * the pause the song
                 * */

                play.setVisibility(View.VISIBLE);
                pause.setVisibility(View.INVISIBLE);
                mediaPlayer.pause();

                break;

            case R.id.open_nowPlaying:
                /*
                 * on clicking the playback layout
                 * Open the Now Playing Activity
                 * get the song name, and add it to the intent using the PutExtra
                 * in order th cast it to the next activity
                 * */
                Intent open_nowPlying_activity = new Intent(MainActivity.this, NowPlaying.class);
                open_nowPlying_activity.putExtra("song_name", songname_String);
                open_nowPlying_activity.putExtra("artist_name", artistString);
                startActivity(open_nowPlying_activity);

                break;
            /*open the now playing Activity on button click
             */
            case R.id.nowplayingclass:
                Intent open_nowPlying_activity2 = new Intent(MainActivity.this, NowPlaying.class);
                open_nowPlying_activity2.putExtra("song_name", songname_String);
                open_nowPlying_activity2.putExtra("artist_name", artistString);
                startActivity(open_nowPlying_activity2);
                break;
        }
    }
}
