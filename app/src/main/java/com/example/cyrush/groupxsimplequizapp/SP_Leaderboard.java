package com.example.cyrush.groupxsimplequizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.util.List;

public class SP_Leaderboard extends AppCompatActivity {

    private TextView spUsernames, spScores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp_leaderboard);

        // Getting the reference to the widgets in the layout.
        spUsernames = (TextView) findViewById(R.id.spUsernames);
        spScores = (TextView) findViewById(R.id.spScores);

        // Creating a DataBaseHelper class variable.
        DataBaseHelper dataBaseHelper = new DataBaseHelper(this);

        // Getting the Single Player quiz scores.
        List<Player> pList = dataBaseHelper.showSpAllScores();

        // Initiating two StringBuilder variables.
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        // For-Each Loop to create two Strings to display the nicknames and scores.
        for(Player p : pList) {

            sb.append(p.getName() + "\n");
            sb2.append(p.getScore() + "\n");

        }

        // Display the nickname and score of Player.
        spUsernames.setText(sb.toString());
        spUsernames.setTextSize(20);
        spScores.setText(sb2.toString());
        spScores.setTextSize(20);

    }

}

