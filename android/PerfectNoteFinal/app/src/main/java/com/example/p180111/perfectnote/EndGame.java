//In this activity, we show the user the result of the game, either a "You Win" or "Game Over" sign denoting whether they won with a score of 10 or lost with a score of 0
//Two buttons on this screen let user choose where they want to go, either back to homescreen or play PerfectPlay again and test their skills once more
package com.example.p180111.perfectnote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EndGame extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();//create extras which a Bundle that will extract the integer from the other activity
        int number = 0;//number will be used to store the user's score from the PerfectPlay game
        number = extras.getInt("ResultOfGame");//name of package from PerfectPlay activity carrying in it the user's score at the end of the game
        if(number <= 0){//If less than or = 0 than user lost the game
            setContentView(R.layout.activity_end_game);//user lost game
        } else {
            setContentView(R.layout.activity_endgame_userwon);//user won
        }

        Button playagainbutton = (Button) findViewById(R.id.idplayagain);
        Button homebutton = (Button) findViewById(R.id.idHome);



                playagainbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if user presses this button, send them back to PerfectPlay game where they can try again
                Intent intent = new Intent(EndGame.this,PerfectPlay.class);
                startActivity(intent);//start the intent to take user back

            }
        });

        homebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //If this button is pressed, then user taken from this activity to the Main activity, our homescreen, where they can select another feature in our app
                Intent intent = new Intent(EndGame.this,MainActivity.class);
                startActivity(intent);//send user to the homescreen
            }
        });


    }
}//end of the activity
