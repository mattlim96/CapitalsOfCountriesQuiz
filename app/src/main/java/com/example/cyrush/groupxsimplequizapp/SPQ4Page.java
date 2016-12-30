package com.example.cyrush.groupxsimplequizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SPQ4Page extends AppCompatActivity {

    private Button mListofQuestionsButton;
    private RadioGroup SPQ4MultiChoice;
    private Button SPQ4SubmitBtn;
    public static int SPQ4Score = 0;
    public static boolean SPQ4Answered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spq4_page);

        // Getting the reference to the widgets in the layout.
        SPQ4MultiChoice = (RadioGroup) findViewById(R.id.SPQ4YesorNoRadioGroup);
        SPQ4SubmitBtn = (Button) findViewById(R.id.submit_btn);
        mListofQuestionsButton = (Button) findViewById(R.id.questionList);

        /**
         *  Do this on Submit button in Question 4.
         */
        SPQ4SubmitBtn.setOnClickListener(new View.OnClickListener(){

            public void onClick (View v){

                // Initiating the radio buttons in Question 4 to an integer variable.
                int SPQ4SelectedID = SPQ4MultiChoice.getCheckedRadioButtonId();

                // Nested If-Else Statement when Yes, No, Cheat or Skip has been chosen.
                if (SPQ4SelectedID == R.id.yes) {

                    Toast.makeText(getApplicationContext(), "Incorrect!", Toast.LENGTH_SHORT).show();
                    SPQ4Score = 0;
                    SPQ4SubmitBtn.setClickable(false);

                } else if (SPQ4SelectedID == R.id.no) {

                    Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT).show();
                    SPQ4Score++;
                    SPQ4SubmitBtn.setClickable(false);

                } else if (SPQ4SelectedID == R.id.radiocheat) {

                    Toast.makeText(getApplicationContext(), "The answer is No, you cheater!", Toast.LENGTH_SHORT).show();
                    SPQ4Score = 0;
                    SPQ4SubmitBtn.setClickable(false);

                } else {

                    Toast.makeText(getApplicationContext(), "Please select an answer or leave blank to skip.", Toast.LENGTH_SHORT).show();

                }

                // Boolean variable set true to indicate Question 4 has been answered.
                SPQ4Answered = true;

            }
        });

        /**
         *  Do this on List of Questions button in Question 4.
         */
        mListofQuestionsButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){

                // Creates an Intent object from current page to Question List page.
                Intent goToList = new Intent(SPQ4Page.this,SPQuestionList.class );

                // Execute Intent object.
                startActivity(goToList);

            }
        });
    }

    public static void setSPQ4Answered(boolean SPQ4Answered) {
        SPQ4Page.SPQ4Answered = SPQ4Answered;
    }

    @Override
    public void onBackPressed() {
        // Do nothing.
    }
}