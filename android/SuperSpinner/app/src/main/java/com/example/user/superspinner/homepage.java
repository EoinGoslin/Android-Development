package com.example.user.superspinner;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class homepage extends AppCompatActivity {
public static int number = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);


        Button redspinnerbutton = (Button) findViewById(R.id.button1);
        Button darbluespinnerbutton = (Button) findViewById(R.id.button2);
        Button blackspinnerbutton = (Button) findViewById(R.id.button3);
        Button neonspinner = (Button) findViewById(R.id.button4);



        redspinnerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                number = 1;

                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("spinnerbutton",number);

                startActivity(intent);


            }
        });

        darbluespinnerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number = 2;

                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("spinnerbutton", number);

                startActivity(intent);


            }
        });

        blackspinnerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number = 3;

                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("spinnerbutton",number);

                startActivity(intent);

            }
        });

        neonspinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number = 4;

                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("spinnerbutton",number);

                startActivity(intent);

            }
        });




    }
}
