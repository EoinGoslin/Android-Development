//This is the centre of our app where the back button from any activity will lead the user
package com.example.p180111.perfectnote;

import android.content.Intent;//need to import intent so can move to different activities from homescreen
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {//on create is what is run when activity is started
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//The XML this activity pulls from
        //Declaring Buttons and finding them by their Id's outlined in the XML so when
        //we utilise them so android knows which buttons are where in layout
        Button keyboardbutton= (Button) findViewById(R.id.Keyboard);
        Button chordbookbutton= (Button) findViewById(R.id.Chordbook);
        Button songbookbutton= (Button) findViewById(R.id.Songbook);
        Button perfectplaybutton= (Button) findViewById(R.id.PerfectPlay);
        Button mapbutton = (Button) findViewById(R.id.MusicStoreLocator);

        //Each of these OnClickListeners are only activated when pressed
        //Once pressed on by user, then the code between the curly braces is executed

        //Intents work by creating an intent object and calling start activity
        // on this newly created object will lead to
        //where stated in the new Intent() parameters
        //Keyword new allocates memory
        //In the Intent brackets, means (From where you are now, to what activity you want to go to)

        keyboardbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,keyboard.class);
                startActivity(intent);
                //If the word finish() was added here, would mean
                //that it would be killed and user could not return to this point after leaving
                //As this is main screen, we want user to come back to here from wherever they are
                //in our app

            }
        });

        chordbookbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2= new Intent(MainActivity.this, Chordbook.class);
                startActivity(intent2);
            }


        });

        songbookbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3= new Intent(MainActivity.this, Songbook.class);
                startActivity(intent3);
            }
        });


        perfectplaybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4= new Intent(MainActivity.this, PerfectPlay.class);
                startActivity(intent4);
            }
        });

        mapbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });






    }







}//end of class
