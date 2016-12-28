package com.example.cyrush.groupxsimplequizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.util.List;

public class MP_Leaderboard extends AppCompatActivity {

    private TextView mpUsernames, mpScores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp_leaderboard);

        // Getting the reference to the widgets in the layout.
        mpUsernames = (TextView) findViewById(R.id.mpUsernames);
        mpScores = (TextView) findViewById(R.id.mpScores);

        // Creating a DataBaseHelper class variable.
        DataBaseHelper dataBaseHelper = new DataBaseHelper(this);

        //
        List<Player> pList = dataBaseHelper.showMpAllScores();

        // Initiating two StringBuilder variables.
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        // For-Each Loop to create two Strings to display the nicknames and scores.
        for(Player p : pList) {

            sb.append(p.getName() + "\n");
            sb2.append(p.getScore() + "\n");

        }

        // Display the nicknames and scores of Player 1 and 2.
        mpUsernames.setText(sb.toString());
        mpUsernames.setTextSize(20);
        mpScores.setText(sb2.toString());
        mpScores.setTextSize(20);

//        ArrayAdapter<Player> arrayAdapter = new ArrayAdapter<Player>(
//                this,
//                android.R.layout.simple_list_item_1,
//                pList );

        //playerList.setAdapter(arrayAdapter);

    }

}
