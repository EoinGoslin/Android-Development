package com.example.user.superspinner;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Vibrator;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
Animation rotate,scale;
ImageView iView;

public static int number = 0;
public static int counter = 0;
private SoundPool soundPool;
   // Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Bundle extras = getIntent().getExtras();
        number = extras.getInt("spinnerbutton");

        if(number ==1)
        {
            setContentView(R.layout.activity_main);

        }
        else if (number==2)
        {


            setContentView(R.layout.blueactivity);

        }
        else if (number==3)
        {
            setContentView(R.layout.blackactivity);
        }
        else if(number ==4)
        {
            setContentView(R.layout.glowactivity);
        }



       // soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
       // soundPool.load(this, R.raw.fidgetnoise,1);












        rotate = AnimationUtils.loadAnimation(this, R.anim.rotate);

        rotate.setFillAfter(true);
        rotate.setFillEnabled(true);


        iView = (ImageView) findViewById(R.id.imageView);

        if(number ==1)//red was pressed
        {
            iView.setImageResource(R.drawable.rednoback);
        }
        else if (number == 2)//dark blue was pressed
        {
            iView.setImageResource(R.drawable.bluenoback);
        }
        else if (number == 3)//black was pressed
        {
            iView.setImageResource(R.drawable.blacknoback);
        }
        else if (number==4)
        {
            iView.setImageResource(R.drawable.glownoback);

        }







        iView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;

                if(counter >=3)
                {
                    //soundPool.play(1,1,0,0,1, 1);
                    //vibe.vibrate(10);
                    float deg = iView.getRotation() + 2*1080 + 1080;

                    iView.animate().rotation(deg).setDuration(7000)
                            .setInterpolator(new LinearOutSlowInInterpolator());
                    Log.d("ROTATEANGLE", "Rotation: " + iView.getRotation()%360);
                    counter = 0;




                }
                else
                {

                   // soundPool.play(1,1,0,0,1, 1);
                   // soundPool.pause(5);

                   // vibe.vibrate(10);
                    float deg = iView.getRotation() + 2*360 + 720;

                    iView.animate().rotation(deg).setDuration(4000)
                            .setInterpolator(new LinearOutSlowInInterpolator());
                    Log.d("ROTATEANGLE", "Rotation: " + iView.getRotation()%360);


                }
















            }
        });

    }




}







