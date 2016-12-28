package com.example.cyrush.groupxsimplequizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MP_P2_Transition extends AppCompatActivity {

    private Button p2_to_scores;
    public static int p2TotalScore;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp_p2_transition);

        // Getting the reference to the widgets in the layout.
        p2_to_scores = (Button) findViewById(R.id.p2_finished_btn);

        /**
         *  Do this on Complete button in Multiplayer confirmation page.
         */
        p2_to_scores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Creates an Intent object from current page to Multiplayer score page.
                Intent mpScorePage = new Intent(MP_P2_Transition.this, MPShowScore.class);

                // Executes the Intent object.
                startActivity(mpScorePage);

                // Initiate scores of Player 2 for each question.
                int score1 = MPQ1Page.MPQ1Score;
                int score2 = MPQ2Page.MPQ2Score;
                int score3 = MPQ3Page.MPQ3Score;
                int score4 = MPQ4Page.MPQ4Score;
                int score5 = MPQ5Page.MPQ5Score;
                int score6 = MPQ6Page.MPQ6Score;
                int score7 = MPQ7Page.MPQ7Score;
                int score8 = MPQ8Page.MPQ8Score;
                int score9 = MPQ9Page.MPQ9Score;
                int score10 = MPQ10Page.MPQ10Score;

                // Sum of the scores for Player 2.
                p2TotalScore  = score1 + score2 + score3 + score4 + score5 +
                                score6 + score7 + score8 + score9 + score10;

                // Retrieving and setting the total scores for Player 1 and 2.
                Player p1 = MultiplayerStartPageFrag.p1;
                Player p2 = MultiplayerStartPageFrag.p2;
                p1.setScore(MP_P1_Transition.p1TotalScore);
                p2.setScore(p2TotalScore);

                // Storing the total scores for Player 1 and 2.
                DataBaseHelper dataBaseHelper = new DataBaseHelper(MP_P2_Transition.this);
                dataBaseHelper.addPlayerToMpQuiz(p1, p2);

                //Toast.makeText(MP_P2_Transition.this,"Test 1 "+ MPQ7Page.MPQ7Score
                //        ,Toast.LENGTH_SHORT).show();

                //Toast.makeText(MP_P2_Transition.this,"Test 2 "+ p2TotalScore
                //        ,Toast.LENGTH_SHORT).show();

            }
        });
    }
}
