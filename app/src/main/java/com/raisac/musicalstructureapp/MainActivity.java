package com.raisac.musicalstructureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Music> music;
    ImageView play, next, pause, prev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        music = new ArrayList<>();
        music.add(new Music(R.raw.a_pass_oruso_nva_kampala));
        music.add(new Music(R.raw.a_pass_tulo_nva_kampala));
        music.add(new Music(R.raw.akaliro__rema));
        music.add(new Music(R.raw.akalulu_ziza_bafana));
        music.add(new Music(R.raw.akambe_by_maureen_nantume));
        music.add(new Music(R.raw.akatonotono__rema_namakula));
        music.add(new Music(R.raw.aliyenda_na_bus_joel_kisakye));
        music.add(new Music(R.raw.amatu_magale_a_pass_ft_tash_b));
        music.add(new Music(R.raw.amina_ykee_benda));
        music.add(new Music(R.raw.anayinama_by_nina_roz));

        final MusicAdapter musicAdapter = new MusicAdapter(this, music);
        final ListView listView = findViewById(R.id.music_list);
        listView.setAdapter(musicAdapter);


    }
}
