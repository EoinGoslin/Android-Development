//This is our playable piano activity
//In this activity, our users can play any key on the piano and the soundfile that will
//be called on is the note that the user plays
//For the piano, we decided to create 13 seperate buttons instead of drawable so that
//we could have complete control over what happened when each note is pressed

package com.example.p180111.perfectnote;

import android.media.AudioManager;
import android.media.SoundPool;//This import is needed to use SoundPool to load our soundfiles
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class keyboard extends AppCompatActivity {

    Button a, b, c, d, e, f, g,  csharp, c2, asharp, fsharp ,dsharp, gsharp;//declaring a list of buttons that we can initialise later with a value and use an OnClickListener on
    private SoundPool soundPool;//Creating a soundPool object of type SoundPool that is capable of storing the value of our sound files
    //Declared these integers as private so they are only accessible from within the class as they are not needed elsewhere so to avoid memory leaks
    private int sound_a,sound_b,sound_c,sound_d,sound_e,sound_f,sound_g,sound_csharp,sound_fsharp,sound_dsharp,sound_gsharp,sound_asharp,sound_c2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard4);//This activity lays out the shape our buttons and what happens graphically when they are pressed and also sets the background

        //Finding our buttons by their ID and have to use (Button) because casting them as buttons
        a = (Button) findViewById(R.id.a);
        b = (Button) findViewById(R.id.b);
        c = (Button) findViewById(R.id.c);
        d = (Button) findViewById(R.id.d);
        e = (Button) findViewById(R.id.e);
        f = (Button) findViewById(R.id.f);
        g = (Button) findViewById(R.id.g);
        csharp = (Button) findViewById(R.id.csharp);
        fsharp = (Button) findViewById(R.id.fsharp);
        asharp= (Button) findViewById(R.id.asharp);
        dsharp = (Button) findViewById(R.id.dsharp);
        gsharp= (Button) findViewById(R.id.gsharp);
        c2= (Button) findViewById(R.id.c2);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { //if build greater or equal to LOLLIPOP
            soundPool = new SoundPool.Builder().setMaxStreams(5).build();//can support this kind of soundPool
        } else {
            soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);//but older devices need to utilise AudioManager
        }

        //Load each of the integers with raw files by using the
        //load method on the soundPool object
        //use "this," becuase we are in the activity in on Create other
        //ways are using getApplication Context() or say explicitly keyboard.this

        //Created each of the raw soundfiles using LogicPro 9 and then imported them after editing each
        //so that each note had same reverb and one did not resonate longer than another
        //Originally had been pulling from soundcloud and other sources
        //however we wanted all notes to be pitch perfect and from one piano so
        //all notes go up in scale accordingly
        //Piano is one octave long as certain phones have smaller screens and we did not want users
        //getting more frustrated, especially when learning, over not being able to have enough room to hit a note cleanly



        sound_a = soundPool.load(this, R.raw.a, 1);
        sound_b = soundPool.load(this, R.raw.b, 1);
        sound_c= soundPool.load(this, R.raw.pianoc, 1);
        sound_d = soundPool.load(this, R.raw.pianod, 1);
        sound_e = soundPool.load(this, R.raw.pianoe, 1);
        sound_f = soundPool.load(this, R.raw.pianof, 1);
        sound_g = soundPool.load(this, R.raw.pianog, 1);
        sound_csharp = soundPool.load(this,R.raw.pianocsharp, 1);
        sound_dsharp = soundPool.load(this,R.raw.pianodsharp,1);
        sound_fsharp = soundPool.load(this,R.raw.pianofsharp,1);
        sound_gsharp = soundPool.load(this,R.raw.gsharp,1);
        sound_asharp = soundPool.load(this,R.raw.pianoa,1);
        sound_c2 =soundPool.load(this,R.raw.c2,1);


        //The numbers between the brackets of the soundPool parameters
        //soundPool(int SoundId which is declared at top of activity, float left volume, float right volume, int priority, int loop, float rate)

        //Each of the following OnClickListeners wait until pressed, then will
        //use .play method to act on the soundPool object and pull our soundfile loaded into the int SoundID at the top
        //This is what causes sound to play
        //We can change sound to anything by changing sound loaded into our sound integers at top of program


        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {                   //if button pressed, play the sound
            soundPool.play(sound_a, 1,1,0,0,1);         //call method , play
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_b, 1,1,0,0,1);
            }
        });

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                soundPool.play(sound_c, 1,1,0,0,1);

            }
        });

        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                soundPool.play(sound_d, 1,1,0,0,1);
            }
        });

        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_e, 1,1,0,0,1);
            }
        });

        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_f, 1,1,0,0,1);
            }
        });

        csharp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                soundPool.play(sound_csharp, 1,1,0,0,1);
            }
        });

        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                soundPool.play(sound_g, 1,1,0,0,1);
            }
        });

        dsharp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                soundPool.play(sound_dsharp, 1,1,0,0,1);
            }
        });

        fsharp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                soundPool.play(sound_fsharp, 1,1,0,0,1);
            }
        });

        gsharp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                soundPool.play(sound_gsharp, 1,1,0,0,1);
            }
        });

        asharp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                soundPool.play(sound_asharp, 1,1,0,0,1);
            }
        });

        asharp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                soundPool.play(sound_asharp, 1,1,0,0,1);
            }
        });

        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                soundPool.play(sound_c2, 1,1,0,0,1);
            }
        });




    }

}
