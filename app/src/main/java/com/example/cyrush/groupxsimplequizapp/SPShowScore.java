package com.example.cyrush.groupxsimplequizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SPShowScore extends AppCompatActivity {

    TextView finalScore;
    Button leaderboardBtn, answers, mainMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spshow_score);

        // Getting the reference to the widgets in the layout.
        finalScore = (TextView) findViewById(R.id.SPFinalScoreDisplay);
        answers = (Button) findViewById(R.id.revealanswersbtn);
        mainMenu = (Button) findViewById(R.id.spMainMenuBtn);
        leaderboardBtn = (Button) findViewById(R.id.spLeaderboardBtn);

        // Initiating the Single Player total score to an integer variable.
        int totalScore = SPFinalConfirmationPage.SP_totalScore;

        // Display the total score.
        finalScore.setText("" + totalScore);

        /**
         *  Do this on Reveal Answers button in Single Player final score page.
         */
        answers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toAnswersPage = new Intent(SPShowScore.this, RevealAllAnswersPage.class);
                startActivity(toAnswersPage);
            }
        });

        /**
         *  Do this on Leaderboard button in Single Player final score page.
         */
        leaderboardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toSpLeaderboard = new Intent(SPShowScore.this, SP_Leaderboard.class);
                startActivity(toSpLeaderboard);
            }
        });

        /**
         *  Do this on Main Menu button in Single Player final score page.
         */
        mainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toMainMenu = new Intent(SPShowScore.this, HomeActivity.class);
                startActivity(toMainMenu);
            }
        });
    }

    @Override
    public void onBackPressed() {
        // Do nothing.
    }
}

