package com.example.p180111.perfectnote;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class keyboard extends AppCompatActivity {

    Button a, b, c, d, e, f, g,  csharp, c2, asharp, fsharp ,dsharp, gsharp;
    private SoundPool soundPool;
    private int sound_a,sound_b,sound_c,sound_d,sound_e,sound_f,sound_g,sound_csharp,sound_fsharp,sound_dsharp,sound_gsharp,sound_asharp,sound_c2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard3);

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

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            soundPool = new SoundPool.Builder().setMaxStreams(5).build();
        } else {
            soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        }

        sound_a = soundPool.load(this,R.raw.aa,1);
        sound_b = soundPool.load(this, R.raw.bb, 1);
        sound_c= soundPool.load(this, R.raw.cc, 1);
        sound_d = soundPool.load(this, R.raw.dd, 1);
        sound_e = soundPool.load(this, R.raw.ee, 1);
        sound_f = soundPool.load(this, R.raw.ff, 1);
        sound_g = soundPool.load(this, R.raw.gg, 1);
        sound_csharp = soundPool.load(this,R.raw.ccsharp,1);
        sound_dsharp = soundPool.load(this,R.raw.ddsharp,1);
        sound_fsharp = soundPool.load(this,R.raw.ffsharp,1);
        sound_gsharp = soundPool.load(this,R.raw.ggsharp,1);
        sound_asharp = soundPool.load(this,R.raw.aaasharp,1);
        sound_c2 =soundPool.load(this,R.raw.upperc,1);








        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            soundPool.play(sound_a, 1,1,0,0,1);


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
                //c.setBackgroundColor(R.color.red);

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
