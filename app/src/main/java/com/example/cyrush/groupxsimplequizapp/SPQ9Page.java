package com.example.cyrush.groupxsimplequizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SPQ9Page extends AppCompatActivity {

    private Button mListofQuestionsButton;
    private RadioGroup SPQ9MultiChoice;
    private Button SPQ9SubmitBtn;
    public static int SPQ9Score = 0;
    public static boolean SPQ9Answered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spq9_page);

        // Getting the reference to the widgets in the layout.
        SPQ9MultiChoice = (RadioGroup) findViewById(R.id.SPQ9YesorNoRadioGroup);
        SPQ9SubmitBtn = (Button) findViewById(R.id.submit_btn);
        mListofQuestionsButton = (Button) findViewById(R.id.questionList);

        /**
         *  Do this on Submit button in Question 9.
         */
        SPQ9SubmitBtn.setOnClickListener(new View.OnClickListener(){

            public void onClick (View v){

                // Initiating the radio buttons in Question 9 to an integer variable.
                int SPQ9SelectedID = SPQ9MultiChoice.getCheckedRadioButtonId();

                // Nested If-Else Statement when Yes, No, Cheat or Skip has been chosen.
                if (SPQ9SelectedID == R.id.yes) {

                    Toast.makeText(getApplicationContext(), "Incorrect!", Toast.LENGTH_SHORT).show();
                    SPQ9Score = 0;
                    SPQ9SubmitBtn.setClickable(false);

                } else if (SPQ9SelectedID == R.id.no) {

                    Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT).show();
                    SPQ9Score++;
                    SPQ9SubmitBtn.setClickable(false);

                } else if (SPQ9SelectedID == R.id.radiocheat) {

                    Toast.makeText(getApplicationContext(), "The answer is Yes, you cheater!", Toast.LENGTH_SHORT).show();
                    SPQ9Score = 0;
                    SPQ9SubmitBtn.setClickable(false);

                } else {

                    Toast.makeText(getApplicationContext(), "Please select an answer or leave blank to skip.", Toast.LENGTH_SHORT).show();

                }

                // Boolean variable set true to indicate Question 9 has been answered.
                SPQ9Answered = true;

            }
        });

        /**
         *  Do this on List of Questions button in Question 9.
         */
        mListofQuestionsButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){

                // Creates an Intent object from current page to Question List page.
                Intent goToList = new Intent(SPQ9Page.this,SPQuestionList.class );

                // Executes Intent object.
                startActivity(goToList);

            }
        });
    }

    public static void setSPQ9Answered(boolean SPQ9Answered) {
        SPQ9Page.SPQ9Answered = SPQ9Answered;
    }

    @Override
    public void onBackPressed() {
        // Do nothing.
    }
}