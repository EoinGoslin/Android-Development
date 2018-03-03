package com.example.p180111.perfectnote;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Chordbook extends AppCompatActivity {

        String[] chordArray = {"C Major", "D Major", "E Major", "F Major", "G Major", "A Major", "B Major"};
        String[] chordArray2 = {"C Minor", "D Minor", "E Minor", "F Minor", "G Minor", "A Minor", "B Minor"};

    private static int number = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chordbook);

        /*number = 1;

        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        intent.putExtra("spinnerbutton",number);*///what to send to chordbookkeyboard.class

        ArrayAdapter<String> chordAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, chordArray);

        ListView listView = (ListView) findViewById(R.id.chordList);
        listView.setAdapter(chordAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View v, int position, long id){
               // Toast.makeText(getApplicationContext(),""+chordArray[position], Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Chordbook.this,chordbookKeyboard.class);
                switch (chordArray[position]) {
                    case "C Major": number = 1;
                        break;
                    case "D Major": number = 2;
                        break;
                    case "E Major": number = 3;
                        break;
                    case "F Major": number = 4;
                        break;
                    case "G Major": number = 5;
                        break;
                    case "A Major": number = 6;
                       break;
                    case "B Major": number = 7;
                        break;

                }

                intent.putExtra("chord picked",number);
                startActivity(intent);


            }
        });

        ArrayAdapter<String> chordAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, chordArray2);

        ListView listView2 = (ListView) findViewById(R.id.chordList2);
        listView2.setAdapter(chordAdapter2);


        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View v, int position, long id){
                Toast.makeText(getApplicationContext(),""+chordArray2[position], Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Chordbook.this,chordbookKeyboard.class);
                startActivity(intent);

            }
        });

    }

    }
