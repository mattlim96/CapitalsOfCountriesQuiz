package com.example.cyrush.groupxsimplequizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SPQ2Page extends AppCompatActivity {

    private Button mListofQuestionsButton;
    private RadioGroup SPQ2MultiChoice;
    private Button SPQ2SubmitBtn;
    public static int SPQ2Score = 0;
    public static boolean SPQ2Answered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spq2_page);

        // Getting the reference to the widgets in the layout.
        SPQ2MultiChoice = (RadioGroup) findViewById(R.id.SPQ2YesorNoRadioGroup);
        SPQ2SubmitBtn = (Button) findViewById(R.id.submit_btn);
        mListofQuestionsButton = (Button) findViewById(R.id.questionList);

        /**
         *  Do this on Submit button in Question 2.
         */
        SPQ2SubmitBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                // Initiating the radio buttons in Question 2 to an integer variable.
                int SPQ2SelectedID = SPQ2MultiChoice.getCheckedRadioButtonId();

                // Nested If-Else Statement when Yes, No, Cheat or Skip has been chosen.
                if (SPQ2SelectedID == R.id.yes) {

                    Toast.makeText(getApplicationContext(), "Incorrect!", Toast.LENGTH_SHORT).show();
                    SPQ2Score = 0;
                    SPQ2SubmitBtn.setClickable(false);

                } else if (SPQ2SelectedID == R.id.no) {

                    Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT).show();
                    SPQ2Score++;
                    SPQ2SubmitBtn.setClickable(false);

                } else if (SPQ2SelectedID == R.id.radiocheat) {

                    Toast.makeText(getApplicationContext(), "The answer is Yes, you cheater!", Toast.LENGTH_SHORT).show();
                    SPQ2Score = 0;
                    SPQ2SubmitBtn.setClickable(false);

                } else {

                    Toast.makeText(getApplicationContext(), "Please select an answer or leave blank to skip.", Toast.LENGTH_SHORT).show();

                }

                // Boolean variable set true to indicate Question 2 has been answered.
                SPQ2Answered = true;

            }
        });

        /**
         *  Do this on List of Questions button in Question 2.
         */
        mListofQuestionsButton.setOnClickListener(new View.OnClickListener() {

            //method to go to Single Player Question List
            @Override
            public void onClick(View view) {

                // Creates an Intent object from current page to Question List page.
                Intent goToList = new Intent(SPQ2Page.this, SPQuestionList.class);

                // Execute Intent object.
                startActivity(goToList);

            }
        });
    }

    public static void setSPQ2Answered(boolean SPQ2Answered) {
        SPQ2Page.SPQ2Answered = SPQ2Answered;
    }

    @Override
    public void onBackPressed() {
        // Do nothing.
    }
}
