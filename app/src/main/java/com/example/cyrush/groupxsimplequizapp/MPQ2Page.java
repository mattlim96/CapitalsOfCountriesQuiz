package com.example.cyrush.groupxsimplequizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MPQ2Page extends AppCompatActivity {

    private Button mListofQuestionsButton;
    private RadioGroup MPQ2MultiChoice;
    private Button MPQ2SubmitBtn;
    public static int  MPQ2Score = 0;
    public static boolean MPQ2Answered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpq2_page);

        // Getting the reference to the widgets in the layout.
        MPQ2MultiChoice = (RadioGroup) findViewById(R.id.MPQ2YesorNoRadioGroup);
        MPQ2SubmitBtn = (Button) findViewById(R.id.submit_btn);
        mListofQuestionsButton = (Button) findViewById(R.id.questionList);

        /**
         *  Do this on Submit button in Question 2.
         */
        MPQ2SubmitBtn.setOnClickListener(new View.OnClickListener(){

            public void onClick (View v){

                // Initiating the radio buttons in Question 2 to an integer variable.
                int MPQ2SelectedID = MPQ2MultiChoice.getCheckedRadioButtonId();

                // Nested If-Else Statement when Yes, No, Cheat or Skip has been chosen.
                if (MPQ2SelectedID == R.id.yes) {

                    Toast.makeText(getApplicationContext(), "Incorrect!", Toast.LENGTH_SHORT).show();
                    MPQ2Score = 0;
                    MPQ2SubmitBtn.setClickable(false);

                } else if (MPQ2SelectedID == R.id.no) {

                    Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT).show();
                    MPQ2Score++;
                    MPQ2SubmitBtn.setClickable(false);

                } else if (MPQ2SelectedID == R.id.radiocheat) {

                    Toast.makeText(getApplicationContext(), "The answer is Yes, you cheater!", Toast.LENGTH_SHORT).show();
                    MPQ2Score = 0;
                    MPQ2SubmitBtn.setClickable(false);

                } else {

                    Toast.makeText(getApplicationContext(), "Please select an answer or leave blank to skip.", Toast.LENGTH_SHORT).show();

                }

                // Boolean variable set true to indicate Question 2 has been answered.
                MPQ2Answered = true;

            }
        });

        /**
         *  Do this on List of Questions button in Question 2.
         */
        mListofQuestionsButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){

                if (MP_P1_Transition.player1Finished) {

                    // Creates an Intent object from current page to Player 2 Question List page.
                    Intent goToList = new Intent(MPQ2Page.this, MPQuestionList2.class);
                    startActivity(goToList);

                    //Toast.makeText(MPQ2Page.this,"Test 1",Toast.LENGTH_SHORT).show();
                }

                else {

                    //Toast.makeText(MPQ2Page.this,"Test 2",Toast.LENGTH_SHORT).show();

                    // Creates an Intent object from current page to Player 2 Question List page.
                    Intent goToList = new Intent(MPQ2Page.this, MPQuestionList.class);
                    startActivity(goToList);
                }

            }
        });
    }

    public static void setMPQ2Answered(boolean MPQ2Answered) {
        MPQ2Page.MPQ2Answered = MPQ2Answered;
    }

    @Override
    public void onBackPressed() {
        // Do nothing.
    }
}
