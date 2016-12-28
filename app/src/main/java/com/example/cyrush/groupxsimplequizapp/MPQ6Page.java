package com.example.cyrush.groupxsimplequizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MPQ6Page extends AppCompatActivity {

    private Button mListofQuestionsButton;
    private RadioGroup MPQ6MultiChoice;
    private Button MPQ6SubmitBtn;
    public static int MPQ6Score = 0;
    public static boolean MPQ6Answered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpq6_page);

        // Getting the reference to the widgets in the layout.
        MPQ6MultiChoice = (RadioGroup) findViewById(R.id.MPQ6YesorNoRadioGroup);
        MPQ6SubmitBtn = (Button) findViewById(R.id.submit_btn);
        mListofQuestionsButton = (Button) findViewById(R.id.questionList);

        /**
         *  Do this on Submit button in Question 6.
         */
        MPQ6SubmitBtn.setOnClickListener(new View.OnClickListener(){

            public void onClick (View v){

                // Initiating the radio buttons in Question 6 to an integer variable.
                int MPQ6SelectedID = MPQ6MultiChoice.getCheckedRadioButtonId();

                // Nested If-Else Statement when Yes, No, Cheat or Skip has been chosen.
                if (MPQ6SelectedID == R.id.yes) {

                    Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT).show();
                    MPQ6Score++;
                    MPQ6SubmitBtn.setClickable(false);

                } else if (MPQ6SelectedID == R.id.no) {

                    Toast.makeText(getApplicationContext(), "Incorrect!", Toast.LENGTH_SHORT).show();
                    MPQ6Score = 0;
                    MPQ6SubmitBtn.setClickable(false);

                } else if (MPQ6SelectedID == R.id.radiocheat) {

                    Toast.makeText(getApplicationContext(), "The answer is Yes, you cheater!", Toast.LENGTH_SHORT).show();
                    MPQ6Score = 0;
                    MPQ6SubmitBtn.setClickable(false);

                } else {

                    Toast.makeText(getApplicationContext(), "Please select an answer or leave blank to skip.", Toast.LENGTH_SHORT).show();

                }

                // Boolean variable set true to indicate Question 6 has been answered.
                MPQ6Answered = true;

            }
        });

        /**
         *  Do this on List of Questions button in Question 6.
         */
        mListofQuestionsButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){

                // If-Else Statement to distinct the different Intent action for Player 1 and 2.
                if (MP_P1_Transition.player1Finished) {

                    // Creates an Intent object from current page to Player 1 Question List page.
                    Intent goToList = new Intent(MPQ6Page.this, MPQuestionList2.class);
                    startActivity(goToList);

                    //Toast.makeText(MPQ6Page.this,"Test 1",Toast.LENGTH_SHORT).show();
                }

                else {
                    //Toast.makeText(MPQ6Page.this,"Test 2",Toast.LENGTH_SHORT).show();

                    // Creates an Intent object from current page to Player 2 Question List page.
                    Intent goToList = new Intent(MPQ6Page.this, MPQuestionList.class);
                    startActivity(goToList);
                }
            }
        });
    }

    public static void setMPQ6Answered(boolean MPQ6Answered) {
        MPQ6Page.MPQ6Answered = MPQ6Answered;
    }

    @Override
    public void onBackPressed() {
        // Do nothing.
    }
}
