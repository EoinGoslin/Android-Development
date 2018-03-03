//This activity contains a list view to display a List of Song Titles.
//The items in the list are clickable and if clicked will bring the user to a songsheet of that particular song

package com.example.p180111.perfectnote;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;



public class Songbook  extends AppCompatActivity {

    String[] songArray = {"JINGLE BELLS ", "HAPPY BIRTHDAY ", "TWINKLE TWINKLE", "YANKEE DOODLE", "ONE LOVE"};
    //this is the list of songs in the array, which is what will be shown in the listView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songbook);

        ArrayAdapter<String> chordAdapter = new ArrayAdapter<String>(this, R.layout.listview_white, songArray);
        //setting the layout of our list view, we have a custom layout-Listview_white
        //The other parameter is what array we would like our list to consist of,
        // in this one we use songArray which holds the String names of the Songs


        ListView listView = (ListView) findViewById(R.id.songList);
        listView.setAdapter(chordAdapter);//set the adapter to hold our array and the layout we wish to display these Strings



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
        //this ItemOnClickListener will identify when an item in the list is pressed and depending on the position,
       // it will implement the matching intent
                Toast.makeText(getApplicationContext(), "" + songArray[position], Toast.LENGTH_SHORT).show();
                //This toast will display when the user selects on a song it will display the song chosen
                //we set the length to short as it will bring them to another image so no need for long
                //the songArray[position] holds the position of each of our Strings in the array so we know what item was clicked

               if(position==0)
               {
                   //the intent created will allow for a new activity to begin
                   // for this intent we want the user to be brought to a specific webpage showing the songsheet
                   Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.pianosongdownload.com/jingle_bells_easy_piano.jpg"));
                   startActivity(browserIntent);
               }
                if(position==1)
                {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://kafi.website/wp-content/uploads/2015/12/happy-birthday-piano-letters-kycx2wbqy.jpg"));
                    startActivity(browserIntent);
                }
                if(position==2)
                {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://kafi.website/wp-content/uploads/2015/12/easy-songs-to-play-on-piano-for-beginners-lnzgth5xe.jpg"));
                    startActivity(browserIntent);
                }
                if(position==3)
                {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://i.pinimg.com/originals/b/dc/8b/b2dc8b1e2ffdea752bbeb79affa5c18e.jpg"));
                    startActivity(browserIntent);
                }
                if(position==4)
                {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://i.pinimg.com/736x/e7/c7/0e/e7c70ed2af8b609af3b74bc70c0598e9--piano-letter-notes-songs-easy-songs-on-piano.jpg"));
                    startActivity(browserIntent);
                }






            }
        });
    }
}   //end of class