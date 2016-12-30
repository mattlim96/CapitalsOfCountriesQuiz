package com.example.cyrush.groupxsimplequizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MPQ8Page extends AppCompatActivity {

    private Button mListofQuestionsButton;
    private RadioGroup MPQ8MultiChoice;
    private Button MPQ8SubmitBtn;
    public static int MPQ8Score = 0;
    public static boolean MPQ8Answered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpq8_page);

        // Getting the reference to the widgets in the layout.
        MPQ8MultiChoice = (RadioGroup) findViewById(R.id.MPQ8YesorNoRadioGroup);
        MPQ8SubmitBtn = (Button) findViewById(R.id.submit_btn);
        mListofQuestionsButton = (Button) findViewById(R.id.questionList);

        /**
         *  Do this on Submit button in Question 8.
         */
        MPQ8SubmitBtn.setOnClickListener(new View.OnClickListener(){

            public void onClick (View v){

                // Initiating the radio buttons in Question 8 to an integer variable.
                int MPQ8SelectedID = MPQ8MultiChoice.getCheckedRadioButtonId();

                // Nested If-Else Statement when Yes, No, Cheat or Skip has been chosen.
                if (MPQ8SelectedID == R.id.yes) {

                    Toast.makeText(getApplicationContext(), "Incorrect!", Toast.LENGTH_SHORT).show();
                    MPQ8Score = 0;
                    MPQ8SubmitBtn.setClickable(false);

                } else if (MPQ8SelectedID == R.id.no) {

                    Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT).show();
                    MPQ8Score++;
                    MPQ8SubmitBtn.setClickable(false);

                } else if (MPQ8SelectedID == R.id.radiocheat) {

                    Toast.makeText(getApplicationContext(), "The answer is No, you cheater!", Toast.LENGTH_SHORT).show();
                    MPQ8Score = 0;
                    MPQ8SubmitBtn.setClickable(false);

                } else {

                    Toast.makeText(getApplicationContext(), "Please select an answer or leave blank to skip.", Toast.LENGTH_SHORT).show();

                }

                // Boolean variable set true to indicate Question 8 has been answered.
                MPQ8Answered = true;

            }
        });

        /**
         *  Do this on List of Questions button in Question 8.
         */
        mListofQuestionsButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){

                // If-Else Statement to distinct the different Intent action for Player 1 and 2.
                if (MP_P1_Transition.player1Finished) {

                    // Creates an Intent object from current page to Player 1 Question List page.
                    Intent goToList = new Intent(MPQ8Page.this, MPQuestionList2.class);

                    // Execute Intent object.
                    startActivity(goToList);

                }

                else {

                    // Creates an Intent object from current page to Player 2 Question List page.
                    Intent goToList = new Intent(MPQ8Page.this, MPQuestionList.class);

                    // Execute Intent object.
                    startActivity(goToList);

                }
            }
        });
    }

    public static void setMPQ8Answered(boolean MPQ8Answered) {
        MPQ8Page.MPQ8Answered = MPQ8Answered;
    }

    @Override
    public void onBackPressed() {
        // Do nothing.
    }
}
