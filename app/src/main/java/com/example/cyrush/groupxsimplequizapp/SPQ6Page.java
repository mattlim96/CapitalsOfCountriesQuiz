package com.example.cyrush.groupxsimplequizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SPQ6Page extends AppCompatActivity {

    private Button mListofQuestionsButton;
    private RadioGroup SPQ6MultiChoice;
    private Button SPQ6SubmitBtn;
    public static int SPQ6Score = 0;
    public static boolean SPQ6Answered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spq6_page);

        // Getting the reference to the widgets in the layout.
        SPQ6MultiChoice = (RadioGroup) findViewById(R.id.SPQ6YesorNoRadioGroup);
        SPQ6SubmitBtn = (Button) findViewById(R.id.submit_btn);
        mListofQuestionsButton = (Button) findViewById(R.id.questionList);

        /**
         *  Do this on Submit button in Question 6.
         */
        SPQ6SubmitBtn.setOnClickListener(new View.OnClickListener(){

            public void onClick (View v){

                // Initiating the radio buttons in Question 6 to an integer variable.
                int SPQ6SelectedID = SPQ6MultiChoice.getCheckedRadioButtonId();

                // Nested If-Else Statement when Yes, No, Cheat or Skip has been chosen.
                if (SPQ6SelectedID == R.id.yes) {

                    Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT).show();
                    SPQ6Score++;
                    SPQ6SubmitBtn.setClickable(false);

                } else if (SPQ6SelectedID == R.id.no) {

                    Toast.makeText(getApplicationContext(), "Incorrect!", Toast.LENGTH_SHORT).show();
                    SPQ6Score = 0;
                    SPQ6SubmitBtn.setClickable(false);

                } else if (SPQ6SelectedID == R.id.radiocheat) {

                    Toast.makeText(getApplicationContext(), "The answer is Yes, you cheater!", Toast.LENGTH_SHORT).show();
                    SPQ6Score = 0;
                    SPQ6SubmitBtn.setClickable(false);

                } else {

                    Toast.makeText(getApplicationContext(), "Please select an answer or leave blank to skip.", Toast.LENGTH_SHORT).show();

                }

                // Boolean variable set true to indicate Question 6 has been answered.
                SPQ6Answered = true;

            }
        });

        /**
         *  Do this on List of Questions button in Question 6.
         */
        mListofQuestionsButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){

                // Creates an Intent object from current page to Question List page.
                Intent goToList = new Intent(SPQ6Page.this,SPQuestionList.class );

                // Executes Intent object.
                startActivity(goToList);

            }
        });
    }

    public static void setSPQ6Answered(boolean SPQ6Answered) {
        SPQ6Page.SPQ6Answered = SPQ6Answered;
    }

    @Override
    public void onBackPressed() {
        // Do nothing.
    }
}