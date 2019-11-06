package com.raisac.musicalstructureapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeScreen extends AppCompatActivity {

    //instantiate the songs layout
    LinearLayout songs;
    FloatingActionButton fabPlaylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        /*locate the floating action button
        this floaing action button helps to open the playlist actitivity or the main activity
         */
        fabPlaylist = findViewById(R.id.fabPlaylist);

        fabPlaylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeScreen.this, MainActivity.class));
            }
        });


        /*
         * note that the songs layout has an image button since each actitivy is required to have an button
         * i figure i should add an image view insside the Linear layout, and make the linear layout clickable
         * so that incase anywhere is touched on the linear layout another Actitivity is opened
         * i could not make only the button be onClick beause what happens if a user click an area with no button
         * in their mind they will think the app does not work well
         * */


        //getting the reference to the linear layout and attaching an onclick listener on it
        findViewById(R.id.download_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //opening the Man activity onclicking the linear layout open the main activity vlass
                startActivity(new Intent(HomeScreen.this, MainActivity.class));
            }
        });


        //onclciking the overflow imageview on the layout, show a toast Message
        findViewById(R.id.home_overflow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), " Drop down Menu Clicked",Toast.LENGTH_LONG);
                PopupMenu popupMenu = new PopupMenu(HomeScreen.this, v);
                popupMenu.getMenuInflater().inflate(R.menu.home_overflow, popupMenu.getMenu());
                popupMenu.show();
            }

        });
    }

}
