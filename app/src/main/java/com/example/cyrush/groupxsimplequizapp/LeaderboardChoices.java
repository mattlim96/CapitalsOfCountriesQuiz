package com.example.cyrush.groupxsimplequizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LeaderboardChoices extends AppCompatActivity {

    private Button sp_Leaderboard, mp_Leaderboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard_choices);

        // Getting the reference to the widgets in the layout.
        sp_Leaderboard = (Button) findViewById(R.id.spLeaderboard);
        mp_Leaderboard = (Button) findViewById(R.id.mpLeaderboard);

        /**
         *  Do this on Single player Leaderboard button.
         */
        sp_Leaderboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Creates an Intent object from current page to Single Player Leaderboard page.
                Intent i = new Intent(LeaderboardChoices.this, SP_Leaderboard.class);
                startActivity(i);
            }
        });

        /**
         *  Do this on Multiplayer Leaderboard button.
         */
        mp_Leaderboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Creates an Intent object from current page to Multiplayer Leaderboard page.
                Intent j = new Intent(LeaderboardChoices.this, MP_Leaderboard.class);
                startActivity(j);
            }
        });
    }
}
