//this is a splash activity for showing the splashscreen when the app is opened on a device
//it will show a drawable image we designed with our app logo
//there will also be a soundfile played

package com.example.p180111.perfectnote;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class splashactivity extends AppCompatActivity {

    Handler handler;    //create handler

    private SoundPool soundPool;       // create soundpool object to store the soundfile
    private int soundSplash;           // integer to Load the sound from the specified APK resource.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashactivity);   //set layout to splashactivity

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//if build greater or equal to LOLLIPOP
            soundPool = new SoundPool.Builder().setMaxStreams(5).build();//can support this kind of soundPool
        } else {
            soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        }//but older devices need to utilise AudioManager

        soundSplash = soundPool.load(this,R.raw.jingle,1);





        handler = new Handler();

        handler.postDelayed(new Runnable() {

            @Override

            public void run() { //the handler will pause the activity for a certain amount of time. we have 5 seconds here.

                Intent intent = new Intent(splashactivity.this,MainActivity.class); //intent created to bring user to the main Activity
                soundPool.play(soundSplash,1,1,0,0,1); //play the soundfile

                startActivity(intent);

                finish();   //so the user can't go back to the splashscreen
            }
        },5000);


    }
}
