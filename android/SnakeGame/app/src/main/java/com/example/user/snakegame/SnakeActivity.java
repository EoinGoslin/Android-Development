package com.example.user.snakegame;

import android.app.Activity;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.PointerIcon;

public class SnakeActivity extends Activity {

    //declare an instance of snakeview
    SnakeView snakeView;
    //we will initialise it in onCreate
    //need to know more details about players device first


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //find out width and height of screen
        Display display = getWindowManager().getDefaultDisplay();

        //load the resolution into a point object
        Point size = new Point();
        display.getSize(size);

        //create a new View based on the SnakeVIew Class
        snakeView = new SnakeView(this,size);

        //Make snakeVeiw the default view of the activity
        setContentView(snakeView);
    }
    //starts the thread in snakeview when this activity is shown
    @Override
    protected void onResume() {
        super.onResume();
        snakeView.resume();
    }
    //makes sure the thread in sakeView is stopped
    //if this acitivity is about to be closed
    @Override
    protected void onPause(){
        super.onPause();
        snakeView.pause();

    }
}
