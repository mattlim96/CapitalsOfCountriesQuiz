package com.example.cyrush.groupxsimplequizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MPQ7Page extends AppCompatActivity {

    private Button mListofQuestionsButton;
    private RadioGroup MPQ7MultiChoice;
    private Button MPQ7SubmitBtn;
    public static int MPQ7Score = 0;
    public static boolean MPQ7Answered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpq7_page);

        // Getting the reference to the widgets in the layout.
        MPQ7MultiChoice = (RadioGroup) findViewById(R.id.MPQ7YesorNoRadioGroup);
        MPQ7SubmitBtn = (Button) findViewById(R.id.submit_btn);
        mListofQuestionsButton = (Button) findViewById(R.id.questionList);

        /**
         *  Do this on Submit button in Question 7.
         */
        MPQ7SubmitBtn.setOnClickListener(new View.OnClickListener(){

            public void onClick (View v){

                // Initiating the radio buttons in Question 7 to an integer variable.
                int MPQ7SelectedID = MPQ7MultiChoice.getCheckedRadioButtonId();

                // Nested If-Else Statement when Yes, No, Cheat or Skip has been chosen.
                if (MPQ7SelectedID == R.id.yes) {

                    Toast.makeText(getApplicationContext(), "Incorrect!", Toast.LENGTH_SHORT).show();
                    MPQ7Score = 0;
                    MPQ7SubmitBtn.setClickable(false);

                } else if (MPQ7SelectedID == R.id.no) {

                    Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT).show();
                    MPQ7Score++;
                    MPQ7SubmitBtn.setClickable(false);

                } else if (MPQ7SelectedID == R.id.radiocheat) {

                    Toast.makeText(getApplicationContext(), "The answer is Yes, you cheater!", Toast.LENGTH_SHORT).show();
                    MPQ7Score = 0;
                    MPQ7SubmitBtn.setClickable(false);

                } else {

                    Toast.makeText(getApplicationContext(), "Please select an answer or leave blank to skip.", Toast.LENGTH_SHORT).show();

                }

                // Boolean variable set true to indicate Question 7 has been answered.
                MPQ7Answered = true;

            }
        });

        /**
         *  Do this on List of Questions button in Question 7.
         */
        mListofQuestionsButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){

                // If-Else Statement to distinct the different Intent action for Player 1 and 2.
                if (MP_P1_Transition.player1Finished) {

                    // Creates an Intent object from current page to Player 1 Question List page.
                    Intent goToList = new Intent(MPQ7Page.this, MPQuestionList2.class);
                    startActivity(goToList);

                }

                else {

                    // Creates an Intent object from current page to Player 2 Question List page.
                    Intent goToList = new Intent(MPQ7Page.this, MPQuestionList.class);
                    startActivity(goToList);
                }
            }
        });
    }

    public static void setMPQ7Answered(boolean MPQ7Answered) {
        MPQ7Page.MPQ7Answered = MPQ7Answered;
    }

    @Override
    public void onBackPressed() {
        // Do nothing.
    }
}
