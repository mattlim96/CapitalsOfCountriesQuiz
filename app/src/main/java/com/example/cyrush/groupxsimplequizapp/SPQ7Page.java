package com.example.cyrush.groupxsimplequizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SPQ7Page extends AppCompatActivity {

    private Button mListofQuestionsButton;
    private RadioGroup SPQ7MultiChoice;
    private Button SPQ7SubmitBtn;
    public static int SPQ7Score = 0;
    public static boolean SPQ7Answered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spq7_page);

        // Getting the reference to the widgets in the layout.
        SPQ7MultiChoice = (RadioGroup) findViewById(R.id.SPQ7YesorNoRadioGroup);
        SPQ7SubmitBtn = (Button) findViewById(R.id.submit_btn);
        mListofQuestionsButton = (Button) findViewById(R.id.questionList);

        /**
         *  Do this on Submit button in Question 7.
         */
        SPQ7SubmitBtn.setOnClickListener(new View.OnClickListener(){

            public void onClick (View v){

                int SPQ7SelectedID = SPQ7MultiChoice.getCheckedRadioButtonId();

                if (SPQ7SelectedID == R.id.yes) {

                    Toast.makeText(getApplicationContext(), "Incorrect!", Toast.LENGTH_SHORT).show();
                    SPQ7Score = 0;
                    SPQ7SubmitBtn.setClickable(false);

                } else if (SPQ7SelectedID == R.id.no) {

                    Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT).show();
                    SPQ7Score++;
                    SPQ7SubmitBtn.setClickable(false);

                } else if (SPQ7SelectedID == R.id.radiocheat) {

                    Toast.makeText(getApplicationContext(), "The answer is Yes, you cheater!", Toast.LENGTH_SHORT).show();
                    SPQ7Score = 0;
                    SPQ7SubmitBtn.setClickable(false);

                } else {

                    Toast.makeText(getApplicationContext(), "Please select an answer or leave blank to skip.", Toast.LENGTH_SHORT).show();

                }

                // Boolean variable set true to indicate Question 7 has been answered.
                SPQ7Answered = true;

            }
        });

        /**
         *  Do this on List of Questions button in Question 7.
         */
        mListofQuestionsButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){

                // Creates an Intent object from current page to Question List page.
                Intent goToList = new Intent(SPQ7Page.this,SPQuestionList.class );

                // Executes Intent object.
                startActivity(goToList);
            }
        });
    }

    public static void setSPQ7Answered(boolean SPQ7Answered) {
        SPQ7Page.SPQ7Answered = SPQ7Answered;
    }

    @Override
    public void onBackPressed() {
        // Do nothing.
    }
}