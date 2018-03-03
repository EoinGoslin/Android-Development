package com.example.p180111.sunshinesoccer;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int shots = 0;
    int goals = 0;
    String shotmessage = "Shots: ";
    String goalmessage = "Goals :";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final TextView textView = (TextView)findViewById(R.id.textView3);
       final  TextView textView2 = (TextView) findViewById(R.id.textView4);
        //textView.setText(shotmessage + Integer.toString(shots));
        //textView2.setText(goalmessage + Integer.toString(goals));


        Button button1 = (Button) findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int random = (int) (5*Math.random())+1;//setting random number
                Toast ImageToast = new Toast(getBaseContext());
                LinearLayout toastLayout = new LinearLayout(getBaseContext());
                toastLayout.setOrientation(LinearLayout.VERTICAL);
                ImageToast.setGravity(Gravity.FILL, 0,0);
                ImageView image = new ImageView(getBaseContext());


                if(random == 1){
                    image.setImageResource(R.drawable.savedleft);
                    shots = shots+1;//keeper saves the shot
                }
                else {
                    image.setImageResource(R.drawable.scoredleft);
                    shots = shots+1;
                    goals = goals+1;//goal
                }

                image.setScaleType(ImageView.ScaleType.FIT_XY);





                toastLayout.addView(image);

                ImageToast.setView(toastLayout);
                ImageToast.setDuration(Toast.LENGTH_SHORT);
                ImageToast.show();
                textView.setText(shotmessage + Integer.toString(shots));
                textView2.setText(goalmessage + Integer.toString(goals));

            }
        });

        Button button2 = (Button) findViewById(R.id.button3);
       button2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               int random = (int) (5*Math.random())+1;//setting random number
               Toast ImageToast = new Toast(getBaseContext());
               LinearLayout toastLayout = new LinearLayout(getBaseContext());
               toastLayout.setOrientation(LinearLayout.VERTICAL);
               ImageToast.setGravity(Gravity.FILL, 0,0);
               ImageView image = new ImageView(getBaseContext());
               // TextView text = new TextView(getBaseContext());

               if(random == 2){
                   image.setImageResource(R.drawable.savemiddle);
                   shots = shots+1;//keeper saves the shot
               }
               else {
                   image.setImageResource(R.drawable.scoredtop);
                   shots = shots+1;
                   goals = goals+1;//goal
               }

               image.setScaleType(ImageView.ScaleType.FIT_XY);





               toastLayout.addView(image);

               ImageToast.setView(toastLayout);
               ImageToast.setDuration(Toast.LENGTH_SHORT);
               ImageToast.show();
               textView.setText(shotmessage + Integer.toString(shots));
               textView2.setText(goalmessage + Integer.toString(goals));





           }
       });

        Button button3 = (Button) findViewById(R.id.button4);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int random = (int) (5*Math.random())+1;//setting random number
                Toast ImageToast = new Toast(getBaseContext());
                LinearLayout toastLayout = new LinearLayout(getBaseContext());
                toastLayout.setOrientation(LinearLayout.VERTICAL);
                ImageToast.setGravity(Gravity.FILL, 0,0);
                ImageView image = new ImageView(getBaseContext());
                // TextView text = new TextView(getBaseContext());

                if(random == 3){
                    image.setImageResource(R.drawable.scoreri);
                    shots = shots+1;//save
                }
                else {
                    image.setImageResource(R.drawable.saveright);
                    shots = shots+1;
                    goals = goals+1;//scores
                }

                image.setScaleType(ImageView.ScaleType.FIT_XY);





                toastLayout.addView(image);

                ImageToast.setView(toastLayout);
                ImageToast.setDuration(Toast.LENGTH_SHORT);
                ImageToast.show();
                textView.setText(shotmessage + Integer.toString(shots));
                textView2.setText(goalmessage + Integer.toString(goals));


            }
        });




    }






}

