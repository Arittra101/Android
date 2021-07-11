package com.example.media_player;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button play = (Button) findViewById(R.id.play);
        Button stop = (Button) findViewById(R.id.stop);
        MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.momo);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                play(mediaPlayer);
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop(mediaPlayer);
            }
        });
    }
    public  void play(MediaPlayer mediaPlayer)
    {
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){

            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(MainActivity.this, "Momo Shut up!", Toast.LENGTH_SHORT).show();
            }
        });
        mediaPlayer.start();
    }
    public  void stop(MediaPlayer mediaPlayer)
    {
        mediaPlayer.pause();
    }
}