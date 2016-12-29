package com.example.cyrush.groupxsimplequizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SPFinalConfirmationPage extends AppCompatActivity {

    private Button mListofQuestionsButton;
    private Button finishedBtn;
    public static int SP_totalScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spfinal_confirmation_page);

        // Getting the reference to the widgets in the layout.
        mListofQuestionsButton = (Button) findViewById(R.id.ReturnToList);
        finishedBtn = (Button) findViewById(R.id.p1_finished_btn);

        /**
         *  Do this on [No, return to questions] button in Single Player confirmation page.
         */
        mListofQuestionsButton.setOnClickListener(new View.OnClickListener() {

            //method to go to Single Player Question List
            @Override
            public void onClick(View view){
                Intent goToList = new Intent(SPFinalConfirmationPage.this,SPQuestionList.class );
                startActivity(goToList);
            }
        });

        /**
         *  Do this on [Yes, I have finished] button in Single Player confirmation page.
         */
        finishedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Initiate scores for each question.
                int score1 = SPQ1Page.SPQ1Score;
                int score2 = SPQ2Page.SPQ2Score;
                int score3 = SPQ3Page.SPQ3Score;
                int score4 = SPQ4Page.SPQ4Score;
                int score5 = SPQ5Page.SPQ5Score;
                int score6 = SPQ6Page.SPQ6Score;
                int score7 = SPQ7Page.SPQ7Score;
                int score8 = SPQ8Page.SPQ8Score;
                int score9 = SPQ9Page.SPQ9Score;
                int score10 = SPQ10Page.SPQ10Score;

                // Sum of the scores.
                SP_totalScore  = score1 + score2 + score3 + score4 + score5 +
                                 score6 + score7 + score8 + score9 + score10;

                // Setting all the scores to zero for each question
                // to reset Single Player mode quiz for a new game.
                SPQ1Page.SPQ1Score = 0;
                SPQ2Page.SPQ2Score = 0;
                SPQ3Page.SPQ3Score = 0;
                SPQ4Page.SPQ4Score = 0;
                SPQ5Page.SPQ5Score = 0;
                SPQ6Page.SPQ6Score = 0;
                SPQ7Page.SPQ7Score = 0;
                SPQ8Page.SPQ8Score = 0;
                SPQ9Page.SPQ9Score = 0;
                SPQ10Page.SPQ10Score = 0;

                // Retrieving and setting the total score.
                Player singlePlayer = SinglePlayerStartPageFrag.singlePlayer;
                singlePlayer.setScore(SP_totalScore);

                // Storing the total score.
                DataBaseHelper dataBaseHelper = new DataBaseHelper(SPFinalConfirmationPage.this);
                dataBaseHelper.addPlayerToSpQuiz(singlePlayer);

                // Creates an Intent object from current page to Single Player score page.
                Intent i = new Intent(SPFinalConfirmationPage.this, SPShowScore.class);

                // Executes the Intent object.
                startActivity(i);
            }
        });
    }

    @Override
    public void onBackPressed() {
        // Do nothing.
    }
}




