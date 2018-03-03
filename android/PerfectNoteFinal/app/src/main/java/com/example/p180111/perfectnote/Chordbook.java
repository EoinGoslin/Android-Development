//In this activity there are two independent ListViews
//This means both lists can move up and down and not affect one beside it
//One List deals with Major Chords
//Other is Minor
//At the top of each list is a text View with either "Major" or "Minor" instructing users what chordList to select from
//This activity interacts with the chordbookKeyboard activity in which the chord the user selected is highlighted and the notes that make up that chord are shown in yellow
//The chordbookKeyboard activity is a non-plyable activity as we did not want our users to linger in that activity, but rather test out their new chord knowledge
// in our keyboard activity
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

    String[] chordArray = {"C Major", "D Major", "E Major", "F Major", "G Major", "A Major", "B Major"};//This is creating our chordArray list which is capable of storing Strings
    String[] chordArray2 = {"C Minor", "D Minor", "E Minor", "F Minor", "G Minor", "A Minor", "B Minor"};
    //In each of these arrays, is what will be shown in the lists

    private static int number = 0;//static so can be accessed later in the class, used in switch statement
    //will store what chord user selects on our list so we can send that number denoting
    //the position integer the chord was at, bundle this position number up and when chordbookKeyboard
    //obtains this bundle, can select to get the integer from the bundle and depending on this, will display an XML based on that chord
    // - e.g.highlight notes of the chord of C or D# yellow



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chordbook);//calls on this XML layout resource file to display each of the lists
        //The lists are dsiplayed over a set background image of an open book to give illusion to users they are scrolling through a book rather than a plain background




        ArrayAdapter<String> chordAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, chordArray);//setting the layout of our list view,
        //can change the layout by altering the simple_List_Item_1 part of the parameters
        //The final parameter is what array we would like to use for our list, in our case we use chordArray which holds the String names of our chords

        ListView listView = (ListView) findViewById(R.id.chordList);
        listView.setAdapter(chordAdapter);//set the adapter to hold our array and the layout we wish to display these Strings


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View v, int position, long id){
                Toast.makeText(getApplicationContext(),""+chordArray[position], Toast.LENGTH_SHORT).show();//This toast will display
                //when the user selects on a note to add another element to this activity
                //we can set length of toast in the .LENGTHSHORT part of toast parameters and also
                //the chordArray[position] holds the position of each of our Strings so we know later what to pass to chordbookKeyboard activity

                Intent intent = new Intent(Chordbook.this,chordbookKeyboard.class);//from this activity to chordbookKeyboard

                //a switch statement takes in a single parameter as an argument and compares this condition against all cases inside its body
                //This switch statement takes in the position of the chord that was selected so if the chord of C was selected, then position would equal C Major String as that is at
                //first position in array
                //based on what case is true, the static int at top of activity will be set to a made up number that we will give meaning to in other activity
                //stating that if 1, then 1 now means C Major and so on. In next activity, we will know what was picked because number will only be set to that value
                //if that chord was chosen
                //A break after each case as only need to find which case is true no need to check anymore cases
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

                intent.putExtra("chord picked",number);//intent.putExtra adds a name for this package (it's ID so we know what to get in next activity) and also what we would like to
                //buundle up and send off
                startActivity(intent);//if a chord from this activity was picked then leave this activity and display it in other activity with notes highlighted showing their chosen chord



            }
        });

        ArrayAdapter<String> chordAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, chordArray2);//same setup as other list

        ListView listView2 = (ListView) findViewById(R.id.chordList2);
        listView2.setAdapter(chordAdapter2);


        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View v, int position, long id){
                Toast.makeText(getApplicationContext(),""+chordArray2[position], Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(Chordbook.this,chordbookKeyboard.class);
                //In this switch statement, number does not start at 1 as other list used numbers 1-7 and number needs to be unique so we
                //know what chord was chosen
                switch (chordArray2[position]) {
                    case "C Minor": number = 8;
                        break;
                    case "D Minor": number = 9;
                        break;
                    case "E Minor": number = 10;
                        break;
                    case "F Minor": number = 11;
                        break;
                    case "G Minor": number = 12;
                        break;
                    case "A Minor": number = 13;
                        break;
                    case "B Minor": number = 14;
                        break;

                }
                intent.putExtra("chord picked",number);//send of same bundleID with a new number
                startActivity(intent);//start activity which will take us to chordBook activity which will display that chord and its notes

            }
        });

    }

}
