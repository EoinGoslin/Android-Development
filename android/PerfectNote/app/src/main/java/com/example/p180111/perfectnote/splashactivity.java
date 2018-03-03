package com.example.p180111.perfectnote;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class splashactivity extends AppCompatActivity {

    Handler handler;

    private SoundPool soundPool;
    private int soundwow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashactivity);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            soundPool = new SoundPool.Builder().setMaxStreams(5).build();
        } else {
            soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        }

        soundwow = soundPool.load(this,R.raw.aa,1);

       // soundPool.play(soundwow,1,1,0,0,1);




        handler = new Handler();

        handler.postDelayed(new Runnable() {

            @Override

            public void run() {
                //soundPool.play(soundwow,1,1,0,0,1);
                Intent intent = new Intent(splashactivity.this,MainActivity.class);
                soundPool.play(soundwow,1,1,0,0,1);
                startActivity(intent);

                finish();
            }
        },5000);


    }
}
