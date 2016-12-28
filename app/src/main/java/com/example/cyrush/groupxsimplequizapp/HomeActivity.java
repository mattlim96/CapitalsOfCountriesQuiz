package com.example.cyrush.groupxsimplequizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    private Button singlePlayer, multiPlayer, leaderboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Getting the reference to the widgets in the layout.
        singlePlayer = (Button) findViewById(R.id.Single_P_Btn);
        multiPlayer = (Button) findViewById(R.id.Multi_P_Btn);
        leaderboard = (Button) findViewById(R.id.leaderboardBtn);

        /**
         *  Do this on Single player button.
         */
        singlePlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Creates an Intent object from current page to Single Player start page.
                Intent spStartPage = new Intent(HomeActivity.this, StartPageActivity.class);

                // Send extra data through intent to indicate Single Player fragment.
                spStartPage.putExtra("Quiz", "Single Player");

                // Executes the Intent object.
                startActivity(spStartPage);

            }
        });

        /**
         *  Do this on Multiplayer button.
         */
        multiPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Creates an Intent object from current page to Mulitplayer start page.
                Intent mpStartPage = new Intent(HomeActivity.this, StartPageActivity.class);

                // Send extra data through intent to indicate Mulitplayer fragment.
                mpStartPage.putExtra("Quiz", "Multiplayer");

                // Executes the Intent object.
                startActivity(mpStartPage);

            }
        });

        /**
         *  Do this on Leaderboard button.
         */
        leaderboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Creates an Intent object from current page to Leaderboard choices page.
                Intent leaderboardPage = new Intent(HomeActivity.this, LeaderboardChoices.class);

                // Executes the Intent object.
                startActivity(leaderboardPage);

            }
        });
    }

    @Override
    public void onBackPressed() {
        // Do nothing.
    }
}
