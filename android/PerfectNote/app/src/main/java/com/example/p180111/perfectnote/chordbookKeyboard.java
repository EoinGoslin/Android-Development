package com.example.p180111.perfectnote;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class chordbookKeyboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*Bundle extras = getIntent().getExtras();
        number = extras.getInt("spinnerbutton");*///collecting number from Chordbook.class

        setContentView(R.layout.activity_chordbook_keyboard);

    }
}
