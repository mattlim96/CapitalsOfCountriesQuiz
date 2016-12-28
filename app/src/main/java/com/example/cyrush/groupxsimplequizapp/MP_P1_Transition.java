package com.example.cyrush.groupxsimplequizapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MP_P1_Transition extends AppCompatActivity {

    private Button p1_to_p2;
    public static int p1TotalScore;
    public static boolean player1Finished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp_p1_transition);

        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPref.edit();

        // Getting the reference to the widgets in the layout.
        p1_to_p2 = (Button) findViewById(R.id.p1_finished_btn);

        /**
         *  Do this on Player 2 Start button.
         */
        p1_to_p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Making the questions available for Player 2 to answer.
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

                // Boolean variable to be used at the end of Multiplayer quiz.
                player1Finished = true;

                // Creates an Intent object from current page to Player 2 Question list page.
                Intent goToList = new Intent(MP_P1_Transition.this,MPQuestionList2.class );
                startActivity(goToList);

                // Initiate scores of Player 1 for each question.
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

                // Sum of the scores for Player 1.
                p1TotalScore  = score1 + score2 + score3 + score4 + score5 +
                                score6 + score7 + score8 + score9 + score10;

                // Storing Player 1's total score.
                editor.putInt("player1Score", p1TotalScore);
                editor.commit();

                //Toast.makeText(MP_P1_Transition.this,"Test 1 "+ p1TotalScore
                //        ,Toast.LENGTH_SHORT).show();

                //Toast.makeText(MP_P1_Transition.this,"Test 2 "+ MPQ1Page.MPQ1Score
                //        ,Toast.LENGTH_SHORT).show();

                // Setting all the scores for each question for Player 2 to start playing.
                MPQ1Page.MPQ1Score = 0;
                MPQ2Page.MPQ2Score = 0;
                MPQ3Page.MPQ3Score = 0;
                MPQ4Page.MPQ4Score = 0;
                MPQ5Page.MPQ5Score = 0;
                MPQ6Page.MPQ6Score = 0;
                MPQ7Page.MPQ7Score = 0;
                MPQ8Page.MPQ8Score = 0;
                MPQ9Page.MPQ9Score = 0;
                MPQ10Page.MPQ10Score = 0;

            }
        });
    }
}
