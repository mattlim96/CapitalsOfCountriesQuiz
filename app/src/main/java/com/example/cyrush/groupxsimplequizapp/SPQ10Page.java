package com.example.cyrush.groupxsimplequizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SPQ10Page extends AppCompatActivity {

    private Button mListofQuestionsButton;
    private RadioGroup SPQ10MultiChoice;
    private Button SPQ10SubmitBtn;
    public static int SPQ10Score = 0;
    public static boolean SPQ10Answered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spq10_page);

        // Getting the reference to the widgets in the layout.
        SPQ10MultiChoice = (RadioGroup)findViewById(R.id.SPQ10YesorNoRadioGroup);
        SPQ10SubmitBtn =(Button)findViewById(R.id.submit_btn);
        mListofQuestionsButton = (Button) findViewById(R.id.questionList);

        /**
         *  Do this on Submit button in Question 10.
         */
        SPQ10SubmitBtn.setOnClickListener(new View.OnClickListener(){

            public void onClick (View v){

                // Initiating the radio buttons in Question 10 to an integer variable.
                int SPQ10SelectedID = SPQ10MultiChoice.getCheckedRadioButtonId();

                // Nested If-Else Statement when Yes, No, Cheat or Skip has been chosen.
                if (SPQ10SelectedID == R.id.yes) {

                    Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT).show();
                    SPQ10Score++;
                    SPQ10SubmitBtn.setClickable(false);

                } else if (SPQ10SelectedID == R.id.no) {

                    Toast.makeText(getApplicationContext(), "Incorrect!", Toast.LENGTH_SHORT).show();
                    SPQ10Score = 0;
                    SPQ10SubmitBtn.setClickable(false);

                } else if (SPQ10SelectedID == R.id.radiocheat) {

                    Toast.makeText(getApplicationContext(), "The answer is Yes, you cheater!", Toast.LENGTH_SHORT).show();
                    SPQ10Score = 0;
                    SPQ10SubmitBtn.setClickable(false);

                } else {

                    Toast.makeText(getApplicationContext(), "Please select an answer or leave blank to skip.", Toast.LENGTH_SHORT).show();

                }

                // Boolean variable set true to indicate Question 10 has been answered.
                SPQ10Answered = true;

            }
        });

        /**
         *  Do this on List of Questions button in Question 10.
         */
        mListofQuestionsButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){

                // Creates an Intent object from current page to Question list page.
                Intent goToList = new Intent(SPQ10Page.this,SPQuestionList.class );

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