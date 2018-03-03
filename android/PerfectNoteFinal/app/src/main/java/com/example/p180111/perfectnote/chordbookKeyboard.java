//This activity shows each of the notes that make up a chord
//The chord is chosen in ChordBook activity from two independent lists that the user can use to scroll through Major and Minor chords
//In the future we will add more chords and more songs in songList as well
package com.example.p180111.perfectnote;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class chordbookKeyboard extends AppCompatActivity {
    private static int number = 0;//static so can access later in class and number used again so can capture that number position sent from Chordbook activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();//creating extras object that is a Bundle capable of reaching into our intent and taking out a certain aspect of it i.e. the number sent over

        number = extras.getInt("chord picked");//collecting number from Chordbook.class, "ChordPicked" is the name of the bundle we created in ChordBook activty
        //Like naming a package and sending it and then telling android what package to collect and what to take from it once opened
        //.getInt allows use to extract the Integer from the intent

        //Use this extracted number in switch statement as the argument
        //Depending on what chordArray[position] was selected would have set a unique number from 1-14 to be assigned to number integer
        //And depending on its value, we set an XML to display that chord
        //Each XML will have a unique set of notes highlighted yellow to help our users learn what exact notes make up each chord be it major or minor

        //A switch statement was used rather than numerous if/else statements so is a lot cleaner and the added "break" at end of each case
        //means only one case has to be true to stop running so will be a lot quicker displaying the XML


        switch (number){
            case 1:  setContentView(R.layout.c_major);
                break;
            case 2: setContentView(R.layout.d_major);
                break;
            case 3: setContentView(R.layout.e_major);
                break;
            case 4: setContentView(R.layout.f_major);
                break;
            case 5: setContentView(R.layout.g_major);
                break;
            case 6: setContentView(R.layout.a_major);
                break;
            case 7: setContentView(R.layout.b_major);
                break;
            case 8: setContentView(R.layout.c_minor);
                break;
            case 9: setContentView(R.layout.d_minor);
                break;
            case 10: setContentView(R.layout.e_minor);
                break;
            case 11: setContentView(R.layout.f_minor);
                break;
            case 12: setContentView(R.layout.g_minor);
                break;
            case 13: setContentView(R.layout.a_minor);
                break;
            case 14: setContentView(R.layout.b_minor);
                break;
        }



    }
}//end of activity




