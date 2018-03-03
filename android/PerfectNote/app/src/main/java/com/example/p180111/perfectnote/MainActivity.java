package com.example.p180111.perfectnote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button keyboardbutton= (Button) findViewById(R.id.Keyboard1);
        Button chordbookbutton= (Button) findViewById(R.id.Chordbook);

        keyboardbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,keyboard.class);
                startActivity(intent);
                //finish();

            }
        });

        chordbookbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2= new Intent(MainActivity.this, Chordbook.class);
                startActivity(intent2);
            }


        });







    }







}
