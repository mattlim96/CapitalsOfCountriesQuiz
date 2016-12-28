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

        //
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


        /*
        mainLayout = (LinearLayout) findViewById(R.id.spLeaderboard);

        DataBaseHelper dataBaseHelper = new DataBaseHelper(this);
        List<Player> pList = dataBaseHelper.showSpAllScores();

        for (int i = 0; i < pList.size(); i++) {

            LinearLayout l2 = new LinearLayout(this);
            TextView username = new TextView(this);
            TextView score = new TextView(this);

            username.setText(pList.get(i).getName());
            //usernames.setPadding(0, 0, 35, 0);
            username.setWidth(600);
            username.setTextSize(20);
            score.setText(Integer.toString(pList.get(i).getScore()));
            score.setTextSize(20);
            //scores.setPadding(0, 35, 0, 0);
            //double roundOff = Math.round(products.get(i).getSellPrice() * 100.0) / 100.0;

            l2.addView(username);
            l2.addView(score);
            mainLayout.addView(l2);
        */

        /*StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for(Player p : plist) {

            sb.append("" + p.getName());
        }

        for(Player p : plist) {

            sb2.append("" + p.getScore());
        }

        spUsernames.setText(sb.toString());
        spScores.setText(sb.toString());

        playerList = (ListView) findViewById(R.id.spList);

        DataBaseHelper dataBaseHelper = new DataBaseHelper(this);

        List<Player> pList = dataBaseHelper.showSpAllScores();

//        ArrayAdapter<Player> arrayAdapter = new ArrayAdapter<Player>(
//                this,
//                android.R.layout.simple_list_item_1,
//                pList );

        //playerList.setAdapter(arrayAdapter);*/

        //Collections.sort(pList, new Comparator<Player>(){
        //    public int compare(Player p1, Player p2) {
        //        return Integer.valueOf(p2.getScore()).compareTo(p1.getScore()); // To compare integer values
        //    }
        //});
    }

}

