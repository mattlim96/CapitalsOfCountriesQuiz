package com.example.cyrush.groupxsimplequizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SPQ3Page extends AppCompatActivity {

    private Button mListofQuestionsButton;
    private RadioGroup SPQ3MultiChoice;
    private Button SPQ3SubmitBtn;
    public static int SPQ3Score = 0;
    public static boolean SPQ3Answered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spq3_page);

        // Getting the reference to the widgets in the layout.
        SPQ3MultiChoice = (RadioGroup) findViewById(R.id.SPQ3YesorNoRadioGroup);
        SPQ3SubmitBtn = (Button) findViewById(R.id.submit_btn);
        mListofQuestionsButton = (Button) findViewById(R.id.questionList);

        /**
         *  Do this on Submit button in Question 3.
         */
        SPQ3SubmitBtn.setOnClickListener(new View.OnClickListener(){

            public void onClick (View v){

                // Initiating the radio buttons in Question 3 to an integer variable.
                int SPQ3SelectedID = SPQ3MultiChoice.getCheckedRadioButtonId();

                // Nested If-Else Statement when Yes, No, Cheat or Skip has been chosen.
                if (SPQ3SelectedID == R.id.yes) {

                    Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT).show();
                    SPQ3Score++;
                    SPQ3SubmitBtn.setClickable(false);

                } else if (SPQ3SelectedID == R.id.no) {

                    Toast.makeText(getApplicationContext(), "Incorrect!", Toast.LENGTH_SHORT).show();
                    SPQ3Score = 0;
                    SPQ3SubmitBtn.setClickable(false);

                } else if (SPQ3SelectedID == R.id.radiocheat) {

                    Toast.makeText(getApplicationContext(), "The answer is Yes, you cheater!", Toast.LENGTH_SHORT).show();
                    SPQ3Score = 0;
                    SPQ3SubmitBtn.setClickable(false);

                } else {

                    Toast.makeText(getApplicationContext(), "Please select an answer or leave blank to skip.", Toast.LENGTH_SHORT).show();

                }

                // Boolean variable set true to indicate Question 3 has been answered.
                SPQ3Answered = true;

            }
        });

        /**
         *  Do this on List of Questions button in Question 3.
         */
        mListofQuestionsButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){

                // Creates an Intent object from current page to Question List page.
                Intent goToList = new Intent(SPQ3Page.this,SPQuestionList.class );

                // Execute Intent object.
                startActivity(goToList);

            }
        });
    }

    @Override
    public void onBackPressed() {
        // Do nothing.
    }
}

