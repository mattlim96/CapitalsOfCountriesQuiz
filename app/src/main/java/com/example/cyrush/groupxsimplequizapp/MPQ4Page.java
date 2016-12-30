package com.example.cyrush.groupxsimplequizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MPQ4Page extends AppCompatActivity {

    private Button mListofQuestionsButton;
    private RadioGroup MPQ4MultiChoice;
    private Button MPQ4SubmitBtn;
    public static int MPQ4Score = 0;
    public static boolean MPQ4Answered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpq4_page);

        // Getting the reference to the widgets in the layout.
        MPQ4MultiChoice = (RadioGroup) findViewById(R.id.MPQ4YesorNoRadioGroup);
        MPQ4SubmitBtn = (Button) findViewById(R.id.submit_btn);
        mListofQuestionsButton = (Button) findViewById(R.id.questionList);

        /**
         *  Do this on Submit button in Question 4.
         */
        MPQ4SubmitBtn.setOnClickListener(new View.OnClickListener(){

            public void onClick (View v){

                // Initiating the radio buttons in Question 4 to an integer variable.
                int MPQ4SelectedID = MPQ4MultiChoice.getCheckedRadioButtonId();

                // Nested If-Else Statement when Yes, No, Cheat or Skip has been chosen.
                if (MPQ4SelectedID == R.id.yes) {

                    Toast.makeText(getApplicationContext(), "Incorrect!", Toast.LENGTH_SHORT).show();
                    MPQ4Score = 0;
                    MPQ4SubmitBtn.setClickable(false);

                } else if (MPQ4SelectedID == R.id.no) {

                    Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT).show();
                    MPQ4Score++;
                    MPQ4SubmitBtn.setClickable(false);

                } else if (MPQ4SelectedID == R.id.radiocheat) {

                    Toast.makeText(getApplicationContext(), "The answer is No, you cheater!", Toast.LENGTH_SHORT).show();
                    MPQ4Score = 0;
                    MPQ4SubmitBtn.setClickable(false);

                } else {

                    Toast.makeText(getApplicationContext(), "Please select an answer or leave blank to skip.", Toast.LENGTH_SHORT).show();

                }

                // Boolean variable set true to indicate Question 4 has been answered.
                MPQ4Answered = true;

            }
        });

        /**
         *  Do this on List of Questions button in Question 4.
         */
        mListofQuestionsButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){

                // If-Else Statement to distinct the different Intent action for Player 1 and 2.
                if (MP_P1_Transition.player1Finished) {

                    // Creates an Intent object from current page to Player 1 Question List page.
                    Intent goToList = new Intent(MPQ4Page.this, MPQuestionList2.class);

                    // Execute Intent object.
                    startActivity(goToList);

                }

                else {

                    // Creates an Intent object from current page to Player 2 Question List page.
                    Intent goToList = new Intent(MPQ4Page.this, MPQuestionList.class);

                    // Execute Intent object.
                    startActivity(goToList);

                }
            }
        });
    }

    public static void setMPQ4Answered(boolean MPQ4Answered) {
        MPQ4Page.MPQ4Answered = MPQ4Answered;
    }

    @Override
    public void onBackPressed() {
        // Do nothing.
    }
}
