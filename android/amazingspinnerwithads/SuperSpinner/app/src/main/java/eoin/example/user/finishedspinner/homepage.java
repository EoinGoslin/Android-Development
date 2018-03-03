package eoin.example.user.finishedspinner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class homepage extends AppCompatActivity {
    private AdView adView;
public static int number = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        MobileAds.initialize(this, "ca-app-pub-7701419844216340~6450788166");
        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()

                .build();

        adView.loadAd(adRequest);


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
