package com.example.cyrush.groupxsimplequizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SPQ8Page extends AppCompatActivity {

    private Button mListofQuestionsButton;
    private RadioGroup SPQ8MultiChoice;
    private Button SPQ8SubmitBtn;
    public static int SPQ8Score = 0;
    public static boolean SPQ8Answered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spq8_page);

        // Getting the reference to the widgets in the layout.
        SPQ8MultiChoice = (RadioGroup) findViewById(R.id.SPQ8YesorNoRadioGroup);
        SPQ8SubmitBtn = (Button) findViewById(R.id.submit_btn);
        mListofQuestionsButton = (Button) findViewById(R.id.questionList);

        /**
         *  Do this on Submit button in Question 8.
         */
        SPQ8SubmitBtn.setOnClickListener(new View.OnClickListener(){

            public void onClick (View v){

                // Initiating the radio buttons in Question 8 to an integer variable.
                int SPQ8SelectedID = SPQ8MultiChoice.getCheckedRadioButtonId();

                // Nested If-Else Statement when Yes, No, Cheat or Skip has been chosen.
                if (SPQ8SelectedID == R.id.yes) {

                    Toast.makeText(getApplicationContext(), "Incorrect!", Toast.LENGTH_SHORT).show();
                    SPQ8Score = 0;
                    SPQ8SubmitBtn.setClickable(false);

                } else if (SPQ8SelectedID == R.id.no) {

                    Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT).show();
                    SPQ8Score++;
                    SPQ8SubmitBtn.setClickable(false);

                } else if (SPQ8SelectedID == R.id.radiocheat) {

                    Toast.makeText(getApplicationContext(), "The answer is Yes, you cheater!", Toast.LENGTH_SHORT).show();
                    SPQ8Score = 0;
                    SPQ8SubmitBtn.setClickable(false);

                } else {

                    Toast.makeText(getApplicationContext(), "Please select an answer or leave blank to skip.", Toast.LENGTH_SHORT).show();

                }

                // Boolean variable set true to indicate Question 8 has been answered.
                SPQ8Answered = true;

            }
        });

        /**
         *  Do this on List of Questions button in Question 8.
         */
        mListofQuestionsButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){

                // Creates an Intent object from current page to Question List page.
                Intent goToList = new Intent(SPQ8Page.this,SPQuestionList.class );

                // Executes Intent object.
                startActivity(goToList);
            }
        });
    }

    @Override
    public void onBackPressed() {
        // Do nothing.
    }
}