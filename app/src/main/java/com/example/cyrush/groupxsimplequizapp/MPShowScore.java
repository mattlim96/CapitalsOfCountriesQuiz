package com.example.cyrush.groupxsimplequizapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MPShowScore extends AppCompatActivity {

    private TextView p1score, p2score;
    private Button answer, leaderboard, mainMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpshow_score);

        // Getting the reference to the widgets in the layout.
        p1score = (TextView) findViewById(R.id.p1FinalScoreDisplay);
        p2score = (TextView) findViewById(R.id.p2FinalScoreDisplay);
        answer = (Button) findViewById(R.id.revealanswersbtn);
        leaderboard = (Button) findViewById(R.id.mpLeaderboardBtn);
        mainMenu = (Button) findViewById(R.id.mpMainMenuBtn);

        /**
         *  Do this on Reveal Answers button in final scores page.
         */
        answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Creates an Intent object from current page to answers page.
                Intent toAnswersPage = new Intent(MPShowScore.this, RevealAllAnswersPage.class);
                startActivity(toAnswersPage);

            }
        });

        // Displaying the scores of Player 1 and 2.
        p1score.setText(String.valueOf(MP_P1_Transition.p1TotalScore));
        p2score.setText(String.valueOf(MP_P2_Transition.p2TotalScore));

        DataBaseHelper dataBaseHelper = new DataBaseHelper(this);

        MultiplayerStartPageFrag.p1.setScore(MP_P1_Transition.p1TotalScore);
        MultiplayerStartPageFrag.p2.setScore(MP_P2_Transition.p2TotalScore);

        /**
         *  Do this on Leaderboard button in final scores page.
         */
        leaderboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Creates an Intent object from current page to Multiplayer Leaderboard page.
                Intent toMpLeaderBoard = new Intent(MPShowScore.this, MP_Leaderboard.class);
                startActivity(toMpLeaderBoard);

            }
        });

        /**
         *  Do this on Main Menu button in final scores page.
         */
        mainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Making the questions available for a new Multiplayer Quiz.
                MPQ1Page.setMPQ1Answered(false);
                MPQ2Page.setMPQ2Answered(false);
                MPQ3Page.setMPQ3Answered(false);
                MPQ4Page.setMPQ4Answered(false);
                MPQ5Page.setMPQ5Answered(false);
                MPQ6Page.setMPQ6Answered(false);
                MPQ7Page.setMPQ7Answered(false);
                MPQ8Page.setMPQ8Answered(false);
                MPQ9Page.setMPQ9Answered(false);
                MPQ10Page.setMPQ10Answered(false);

                // Creates an Intent object from current page to Home page.
                Intent toMainMenu = new Intent(MPShowScore.this, HomeActivity.class);
                startActivity(toMainMenu);

            }
        });
    }

    @Override
    public void onBackPressed() {
        // Do nothing.
    }
}

/*SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        int defaultValue = getResources().getInteger(MP_P1_Transition.p1TotalScore);
        long player1Score = sharedPref.getInt(getString(MP_P1_Transition.p1TotalScore), defaultValue);
        */
