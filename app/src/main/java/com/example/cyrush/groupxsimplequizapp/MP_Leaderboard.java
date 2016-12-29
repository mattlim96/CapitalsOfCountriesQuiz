package com.example.cyrush.groupxsimplequizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class MP_Leaderboard extends AppCompatActivity {

    private TextView mpUsernames, mpScores;

    private int row_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp_leaderboard);

        // Getting the reference to the widgets in the layout.
        mpUsernames = (TextView) findViewById(R.id.mpUsernames);
        mpScores = (TextView) findViewById(R.id.mpScores);

        // Creating a DataBaseHelper class variable.
        DataBaseHelper dataBaseHelper = new DataBaseHelper(this);

        // Retrieving all Multiplayer scores in descending order.
        List<Player> pList = dataBaseHelper.showMpAllScores();

        // Grouping players based on the Game Number they are associated with in descending order.
        Map<Integer, List<Player>> groupedPlayers = new HashMap<Integer, List<Player>>();
        for (Player p: pList) {
            Integer key = p.getGameNumber();
            if (groupedPlayers.get(key) == null) {
                groupedPlayers.put(key, new ArrayList<Player>());
            }
            groupedPlayers.get(key).add(p);
        }

        // Initiating two StringBuilder variables.
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        StringBuilder space = new StringBuilder();

        // For-Each Loop to create two Strings to display the nicknames and scores using the
        // groupedPlayers created above.

        Set<Integer> groupedPlayersKeySet = groupedPlayers.keySet();
        for (Integer gNumber: groupedPlayersKeySet) {
            List<Player> pL = groupedPlayers.get(gNumber);
            for (Player p : pL) {
                //System.out.println("Name : "+p.getName()+"\t"+"Score : "+p.getScore()+"   "+p.getGameNumber());


                sb.append(p.getName() + "\n");
                sb2.append(p.getScore() + "\n");


                row_num++;
                if (row_num == 2) {

                    sb.append("\n");
                    sb2.append("\n");
                    space.append("\n");
                    space.append("\n");
                    row_num = 0;
                }
            }
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
