package com.example.cyrush.groupxsimplequizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MPQ10Page extends AppCompatActivity {

    private Button mListofQuestionsButton;
    private RadioGroup MPQ10MultiChoice;
    private Button MPQ10SubmitBtn;
    public static int MPQ10Score = 0;
    public static boolean MPQ10Answered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpq10_page);

        // Getting the reference to the widgets in the layout.
        MPQ10MultiChoice = (RadioGroup)findViewById(R.id.MPQ10YesorNoRadioGroup);
        MPQ10SubmitBtn =(Button)findViewById(R.id.submit_btn);
        mListofQuestionsButton = (Button) findViewById(R.id.questionList);

        /**
         *  Do this on Submit button in Question 10.
         */
        MPQ10SubmitBtn.setOnClickListener(new View.OnClickListener(){

            public void onClick (View v){

                // Initiating the radio buttons in Question 10 to an integer variable.
                int MPQ10SelectedID = MPQ10MultiChoice.getCheckedRadioButtonId();

                // Nested If-Else Statement when Yes, No, Cheat or Skip has been chosen.
                if (MPQ10SelectedID == R.id.yes) {

                    Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT).show();
                    MPQ10Score++;
                    MPQ10SubmitBtn.setClickable(false);

                } else if (MPQ10SelectedID == R.id.no) {

                    Toast.makeText(getApplicationContext(), "Incorrect!", Toast.LENGTH_SHORT).show();
                    MPQ10Score = 0;
                    MPQ10SubmitBtn.setClickable(false);

                } else if (MPQ10SelectedID == R.id.radiocheat) {

                    Toast.makeText(getApplicationContext(), "The answer is Yes, you cheater!", Toast.LENGTH_SHORT).show();
                    MPQ10Score = 0;
                    MPQ10SubmitBtn.setClickable(false);

                } else {

                    Toast.makeText(getApplicationContext(), "Please select an answer or leave blank to skip.", Toast.LENGTH_SHORT).show();

                }

                // Boolean variable set true to indicate Question 10 has been answered.
                MPQ10Answered = true;

            }
        });

        /**
         *  Do this on List of Questions button in Question 10.
         */
        mListofQuestionsButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){

                if (MP_P1_Transition.player1Finished) {

                    // Creates an Intent object from current page to Player 1 Question List page.
                    Intent goToList = new Intent(MPQ10Page.this, MPQuestionList2.class);

                    // Execute Intent object.
                    startActivity(goToList);

                }

                else {

                    // Creates an Intent object from current page to Player 2 Question List page.
                    Intent goToList = new Intent(MPQ10Page.this, MPQuestionList.class);

                    // Execute Intent object.
                    startActivity(goToList);

                }
            }
        });
    }

    public static void setMPQ10Answered(boolean MPQ10Answered) {
        MPQ10Page.MPQ10Answered = MPQ10Answered;
    }

    @Override
    public void onBackPressed() {
        // Do nothing.
    }
}
