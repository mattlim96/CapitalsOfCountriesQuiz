package com.example.cyrush.groupxsimplequizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MPQ9Page extends AppCompatActivity {

    private Button mListofQuestionsButton;
    private RadioGroup MPQ9MultiChoice;
    private Button MPQ9SubmitBtn;
    public static int MPQ9Score = 0;
    public static boolean MPQ9Answered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpq9_page);

        // Getting the reference to the widgets in the layout.
        MPQ9MultiChoice = (RadioGroup) findViewById(R.id.MPQ9YesorNoRadioGroup);
        MPQ9SubmitBtn = (Button) findViewById(R.id.submit_btn);
        mListofQuestionsButton = (Button) findViewById(R.id.questionList);

        /**
         *  Do this on Submit button in Question 9.
         */
        MPQ9SubmitBtn.setOnClickListener(new View.OnClickListener(){

            public void onClick (View v){

                // Initiating the radio buttons in Question 9 to an integer variable.
                int MPQ9SelectedID = MPQ9MultiChoice.getCheckedRadioButtonId();

                // Nested If-Else Statement when Yes, No, Cheat or Skip has been chosen.
                if (MPQ9SelectedID == R.id.yes) {

                    Toast.makeText(getApplicationContext(), "Incorrect!", Toast.LENGTH_SHORT).show();
                    MPQ9Score = 0;
                    MPQ9SubmitBtn.setClickable(false);

                } else if (MPQ9SelectedID == R.id.no) {

                    Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT).show();
                    MPQ9Score++;
                    MPQ9SubmitBtn.setClickable(false);

                } else if (MPQ9SelectedID == R.id.radiocheat) {

                    Toast.makeText(getApplicationContext(), "The answer is Yes, you cheater!", Toast.LENGTH_SHORT).show();
                    MPQ9Score = 0;
                    MPQ9SubmitBtn.setClickable(false);

                } else {

                    Toast.makeText(getApplicationContext(), "Please select an answer or leave blank to skip.", Toast.LENGTH_SHORT).show();

                }

                // Boolean variable set true to indicate Question 9 has been answered.
                MPQ9Answered = true;

            }
        });

        /**
         *  Do this on List of Questions button in Question 9.
         */
        mListofQuestionsButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){

                // If-Else Statement to distinct the different Intent action for Player 1 and 2.
                if (MP_P1_Transition.player1Finished) {

                    // Creates an Intent object from current page to Player 1 Question List page.
                    Intent goToList = new Intent(MPQ9Page.this, MPQuestionList2.class);
                    startActivity(goToList);

                }

                else {

                    // Creates an Intent object from current page to Player 2 Question List page.
                    Intent goToList = new Intent(MPQ9Page.this, MPQuestionList.class);
                    startActivity(goToList);

                }
            }
        });
    }

    public static void setMPQ9Answered(boolean MPQ9Answered) {
        MPQ9Page.MPQ9Answered = MPQ9Answered;
    }

    @Override
    public void onBackPressed() {
        // Do nothing.
    }
}
