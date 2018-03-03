//In this activity, users have to try and select the right note to play in a given set of time
//In the handler, 4000 milliseconds was chosen so users have 4 seconds to select correct note otherwise their score is decremented
//We wanted to add in both incrementation and decrementation of current score so to make the game more challenging giving user sense of achievement when they win
//The user has 4 seconds after toast message show what note to play, if they do not play that note in the 4 seconds their score decrements
//If they don't select anything at all, their score does not increase either as
//current score only increments if at the same time the toast is showing that note they hit the correct key it goes up otherwise will stay stagnant or decrement depending
//on user's button press

//If the user wins or loses, will bring them to a new activity asking if they would like to play again or head to homescreen to try out other features in  the app

//If user wins, then the EndGame activity will pull from a different XML showing a "YouWin" sign and if user had a score of 0, it will show game over, both have options of going homescreen or playing again



package com.example.p180111.perfectnote;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;//SoundPool used as when user guesses note and plays a key that note will sound
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class PerfectPlay extends AppCompatActivity {
    //Setting up button names and also the textView which  will hold the current score

    Button a, b, c, d, e, f, g, csharp, c2, asharp, fsharp, dsharp, gsharp;
    TextView scorebox;
    int currentScore = 1;
    int random;//will store the random number generated as don't want to display the same note to press everytime want user to not know what will be asked of them in terms of what note to press

    String scoreMessage = "Score : ";

    private SoundPool soundPool;
    private int sound_a, sound_b, sound_c, sound_d, sound_e, sound_f, sound_g, sound_csharp, sound_fsharp, sound_dsharp, sound_gsharp, sound_asharp, sound_c2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfect_play);//Layout Resource File that shows our piano and also positions and constrains the scorebox and sets the background


        a = (Button) findViewById(R.id.a);
        b = (Button) findViewById(R.id.b);
        c = (Button) findViewById(R.id.c);
        d = (Button) findViewById(R.id.d);
        e = (Button) findViewById(R.id.e);
        f = (Button) findViewById(R.id.f);
        g = (Button) findViewById(R.id.g);
        csharp = (Button) findViewById(R.id.csharp);
        fsharp = (Button) findViewById(R.id.fsharp);
        asharp = (Button) findViewById(R.id.asharp);
        dsharp = (Button) findViewById(R.id.dsharp);
        gsharp = (Button) findViewById(R.id.gsharp);
        c2 = (Button) findViewById(R.id.c2);

        scorebox = (TextView) findViewById(R.id.Score);


        Toast.makeText(PerfectPlay.this, "Play the next Note :)", Toast.LENGTH_LONG).show();//This will show before while loop to prepare user and let then know game about to start


        Thread t = new Thread() {

            @Override
            public void run() {
                try {//using a try catch so if any exceptions or errors the whole app will not crash and makes it more stable
                    while ((currentScore > 0 && currentScore < 10)) {//While loop check if score greater than 0 and less than 10, if less than 0, user has lost, if greater than 10, they win
                        //both lead to a new activity which shows two buttons: play again||Go Homes which leads to the homescreen

                        Thread.sleep(4000);//Thread.sleep outlines how long this thread will sleep until activated again, it is not how long the activity runs for
                        //before never running again, it acts as a timer so a new toast can be shown on a regular basis throughout the game so users know how long they have to guess
                        //and the time the user has to guess the perfect note is the same every time
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {


                                random = (int) (13 * Math.random() + 1);//generate a random number from 1-13, Math.random() runs from 0-.99 so add 1 to run from 1 and cast as int so
                                //it will round down and not return a float value so we can store it as an int and use it to compare in switch statement


                                scorebox.setText(scoreMessage + Integer.toString(currentScore));//scoreox is our text view
                                //use Integer.toString(which takes an int as parameters) to convert our int into String so we can display it in a textbox
                                //reason score is an int and needs to be converted as a result, it becuase we increment and decrement current score so we knew would
                                //change so had to use integer
                                //score message holds our String and + is concatenating the newly converted currentScore and the message, both will be displayed in the textbox

                                switch (random) {//Takes in a random number, a random number so toast message, that asks user to play a certain note, will be different every 4 seconds
                                    case 1:
                                        Toast.makeText(PerfectPlay.this, "Play A", Toast.LENGTH_LONG).show();//creates a toast with String "Play A" and sets .show to display it to user
                                        break;
                                    case 2:
                                        Toast.makeText(PerfectPlay.this, "Play B", Toast.LENGTH_LONG).show();
                                        break;
                                    case 3:
                                        Toast.makeText(PerfectPlay.this, "Play C", Toast.LENGTH_LONG).show();
                                        break;
                                    case 4:
                                        Toast.makeText(PerfectPlay.this, "Play D", Toast.LENGTH_LONG).show();
                                        break;
                                    case 5:
                                        Toast.makeText(PerfectPlay.this, "Play E", Toast.LENGTH_LONG).show();
                                        break;
                                    case 6:
                                        Toast.makeText(PerfectPlay.this, "Play F", Toast.LENGTH_LONG).show();
                                        break;
                                    case 7:
                                        Toast.makeText(PerfectPlay.this, "Play G", Toast.LENGTH_LONG).show();
                                        break;
                                    case 8:
                                        Toast.makeText(PerfectPlay.this, "Play A#", Toast.LENGTH_LONG).show();
                                        break;
                                    case 9:
                                        Toast.makeText(PerfectPlay.this, "Play C#", Toast.LENGTH_LONG).show();
                                        break;
                                    case 10:
                                        Toast.makeText(PerfectPlay.this, "Play D#", Toast.LENGTH_LONG).show();
                                        break;
                                    case 11:
                                        Toast.makeText(PerfectPlay.this, "Play G#", Toast.LENGTH_LONG).show();
                                        break;
                                    case 12:
                                        Toast.makeText(PerfectPlay.this, "Play F#", Toast.LENGTH_LONG).show();
                                        break;
                                    case 13:
                                        Toast.makeText(PerfectPlay.this, "Play High C", Toast.LENGTH_LONG).show();
                                        break;


                                }

                            }
                        });


                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            soundPool = new SoundPool.Builder().setMaxStreams(5).build();
                        } else {
                            soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
                        }

                        sound_a = soundPool.load(PerfectPlay.this, R.raw.a, 1);
                        sound_b = soundPool.load(PerfectPlay.this, R.raw.b, 1);
                        sound_c = soundPool.load(PerfectPlay.this, R.raw.pianoc, 1);
                        sound_d = soundPool.load(PerfectPlay.this, R.raw.pianod, 1);
                        sound_e = soundPool.load(PerfectPlay.this, R.raw.pianoe, 1);
                        sound_f = soundPool.load(PerfectPlay.this, R.raw.pianof, 1);
                        sound_g = soundPool.load(PerfectPlay.this, R.raw.pianog, 1);
                        sound_csharp = soundPool.load(PerfectPlay.this, R.raw.pianocsharp, 1);
                        sound_dsharp = soundPool.load(PerfectPlay.this, R.raw.pianodsharp, 1);
                        sound_fsharp = soundPool.load(PerfectPlay.this, R.raw.pianofsharp, 1);
                        sound_gsharp = soundPool.load(PerfectPlay.this, R.raw.gsharp, 1);
                        sound_asharp = soundPool.load(PerfectPlay.this, R.raw.pianoa, 1);
                        sound_c2 = soundPool.load(PerfectPlay.this, R.raw.c2, 1);

                        //In each of the OnCLickListeners, score is only decremented or incremented based on whether at that time random is equal to that button
                        //i.e if random is 1, then we know user should be pressing a and so we listen for that and don't want to increment if that condition is not met



                        a.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (random == 1) {
                                    currentScore++;
                                } else {
                                    currentScore--;
                                }
                                //if button pressed, play the sound

                                soundPool.play(sound_a, 1, 1, 0, 0, 1);         //call method , play on soundPool object loaded with our raw sound file in sound_a
                            }
                        });

                        b.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (random == 2) {
                                    currentScore++;
                                } else {
                                    currentScore--;
                                }
                                soundPool.play(sound_b, 1, 1, 0, 0, 1);
                            }
                        });

                        c.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (random == 3) {
                                    currentScore++;
                                } else {
                                    currentScore--;
                                }
                                soundPool.play(sound_c, 1, 1, 0, 0, 1);

                            }
                        });

                        d.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (random == 4) {
                                    currentScore++;
                                } else {
                                    currentScore--;
                                }
                                soundPool.play(sound_d, 1, 1, 0, 0, 1);
                            }
                        });

                        e.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (random == 5) {
                                    currentScore++;
                                } else {
                                    currentScore--;
                                }
                                soundPool.play(sound_e, 1, 1, 0, 0, 1);
                            }
                        });

                        f.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (random == 6) {
                                    currentScore++;
                                } else {
                                    currentScore--;
                                }
                                soundPool.play(sound_f, 1, 1, 0, 0, 1);
                            }
                        });

                        csharp.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                if (random == 9) {
                                    currentScore++;
                                } else {
                                    currentScore--;
                                }
                                soundPool.play(sound_csharp, 1, 1, 0, 0, 1);
                            }
                        });

                        g.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (random == 7) {
                                    currentScore++;
                                } else {
                                    currentScore--;
                                }

                                soundPool.play(sound_g, 1, 1, 0, 0, 1);
                            }
                        });

                        dsharp.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (random == 10) {
                                    currentScore++;
                                } else {
                                    currentScore--;
                                }
                                soundPool.play(sound_dsharp, 1, 1, 0, 0, 1);
                            }
                        });

                        fsharp.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (random == 12) {
                                    currentScore++;
                                } else {
                                    currentScore--;
                                }

                                soundPool.play(sound_fsharp, 1, 1, 0, 0, 1);
                            }
                        });

                        gsharp.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (random == 11) {
                                    currentScore++;
                                } else {
                                    currentScore--;
                                }
                                soundPool.play(sound_gsharp, 1, 1, 0, 0, 1);
                            }
                        });

                        asharp.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (random == 8) {
                                    currentScore++;
                                } else {
                                    currentScore--;
                                }
                                soundPool.play(sound_asharp, 1, 1, 0, 0, 1);
                            }
                        });

                        c2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (random == 13) {
                                    currentScore++;
                                } else {
                                    currentScore--;
                                }

                                soundPool.play(sound_c2, 1, 1, 0, 0, 1);
                            }
                        });


                    }




                        Intent intent = new Intent(PerfectPlay.this,EndGame.class);
                        intent.putExtra("ResultOfGame",currentScore);//if user lost, currentScore will be0, if won, will be 10
                        startActivity(intent);//send this information to EndGame so can decide what to show and also this intent will bring user to that activity


                } catch (InterruptedException e) {
                }
            }
        };

        t.start();//start our thread


    }
}


