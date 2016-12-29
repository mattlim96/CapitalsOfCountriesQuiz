package com.example.cyrush.groupxsimplequizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MPQ1Page extends AppCompatActivity {

    private Button mListofQuestionsButton;
    private RadioGroup MPQ1MultiChoice;
    private Button MPQ1SubmitBtn;
    public static int MPQ1Score = 0;
    public static boolean MPQ1Answered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpq1_page);

        // Getting the reference to the widgets in the layout.
        MPQ1MultiChoice = (RadioGroup) findViewById(R.id.MPQ1YesorNoRadioGroup);
        MPQ1SubmitBtn = (Button) findViewById(R.id.submit_btn);
        mListofQuestionsButton = (Button) findViewById(R.id.questionList);

        /**
         *  Do this on Submit button in Question 1.
         */
        MPQ1SubmitBtn.setOnClickListener(new View.OnClickListener(){

            public void onClick (View v){

                // Initiating the radio buttons in Question 1 to an integer variable.
                int MPQ1SelectedID = MPQ1MultiChoice.getCheckedRadioButtonId();


                // Nested If-Else Statement when Yes, No, Cheat or Skip has been chosen.
                if (MPQ1SelectedID == R.id.yes) {

                    Toast.makeText(getApplicationContext(), "Incorrect!", Toast.LENGTH_SHORT).show();
                    MPQ1Score = 0;
                    MPQ1SubmitBtn.setClickable(false);

                } else if (MPQ1SelectedID == R.id.no) {

                    Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT).show();
                    MPQ1Score++;
                    MPQ1SubmitBtn.setClickable(false);

                } else if (MPQ1SelectedID == R.id.radiocheat) {

                    Toast.makeText(getApplicationContext(), "The answer is Yes, you cheater!", Toast.LENGTH_SHORT).show();
                    MPQ1Score = 0;
                    MPQ1SubmitBtn.setClickable(false);

                } else {

                    Toast.makeText(getApplicationContext(), "Please select an answer or leave blank to skip.", Toast.LENGTH_SHORT).show();

                }

                // Boolean variable set true to indicate Question 1 has been answered.
                MPQ1Answered = true;

            }
        });

        /**
         *  Do this on List of Questions button in Question 1.
         */
        mListofQuestionsButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){

                //Toast.makeText(MPQ1Page.this,"Test 0 "+ MP_P1_Transition.player1Finished
                //        ,Toast.LENGTH_SHORT).show();


                // If-Else Statement to distinct the different Intent action for Player 1 and 2.
                if (MP_P1_Transition.player1Finished) {

                    // Creates an Intent object from current page to Player 1 Question List page.
                    Intent goToList = new Intent(MPQ1Page.this, MPQuestionList2.class);

                    // Execute Intent object.
                    startActivity(goToList);

                    //Toast.makeText(MPQ1Page.this,"Test 1",Toast.LENGTH_SHORT).show();
                } else {

                    //Toast.makeText(MPQ1Page.this,"Test 2",Toast.LENGTH_SHORT).show();

                    // Creates an Intent object from current page to Player 2 Question List page.
                    Intent goToList = new Intent(MPQ1Page.this, MPQuestionList.class);

                    // Execute Intent object.
                    startActivity(goToList);

                }
            }
        });
    }

    public static void setMPQ1Answered(boolean MPQ1Answered) {
        MPQ1Page.MPQ1Answered = MPQ1Answered;
    }

    @Override
    public void onBackPressed() {
        // Do nothing.
    }
}