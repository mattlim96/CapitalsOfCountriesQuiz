package com.example.cyrush.groupxsimplequizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SPQ1Page extends AppCompatActivity {

    private Button mListofQuestionsButton;
    private RadioGroup SPQ1MultiChoice;
    private Button SPQ1SubmitBtn;
    public static int SPQ1Score = 0;
    public static boolean SPQ1Answered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spq1_page);

        // Getting the reference to the widgets in the layout.
        SPQ1MultiChoice = (RadioGroup) findViewById(R.id.SPQ1YesorNoRadioGroup);
        SPQ1SubmitBtn = (Button) findViewById(R.id.submit_btn);
        mListofQuestionsButton = (Button) findViewById(R.id.questionList);

        /**
         *  Do this on Submit button in Question 1.
         */
        SPQ1SubmitBtn.setOnClickListener(new View.OnClickListener(){

            public void onClick (View v){

                // Initiating the radio buttons in Question 1 to an integer variable.
                int SPQ1SelectedID = SPQ1MultiChoice.getCheckedRadioButtonId();

                // Nested If-Else Statement when Yes, No, Cheat or Skip has been chosen.
                if (SPQ1SelectedID == R.id.yes) {

                    Toast.makeText(getApplicationContext(), "Incorrect!", Toast.LENGTH_SHORT).show();
                    SPQ1Score = 0;
                    SPQ1SubmitBtn.setClickable(false);

                } else if (SPQ1SelectedID == R.id.no) {

                    Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT).show();
                    SPQ1Score++;
                    SPQ1SubmitBtn.setClickable(false);

                } else if (SPQ1SelectedID == R.id.radiocheat) {

                    Toast.makeText(getApplicationContext(), "The answer is Yes, you cheater!", Toast.LENGTH_SHORT).show();
                    SPQ1Score = 0;
                    SPQ1SubmitBtn.setClickable(false);

                } else {

                    Toast.makeText(getApplicationContext(), "Please select an answer or leave blank to skip.", Toast.LENGTH_SHORT).show();

                }

                // Boolean variable set true to indicate Question 1 has been answered.
                SPQ1Answered = true;

            }
        });

        /**
         *  Do this on List of Questions button in Question 1.
         */
        mListofQuestionsButton.setOnClickListener(new View.OnClickListener() {

           //method to go to Single Player Question List
            @Override
            public void onClick(View view){

                // Creates an Intent object from current page to Question List page.
                Intent goToList = new Intent(SPQ1Page.this,SPQuestionList.class );

                // Execute Intent object.
                startActivity(goToList);
            }
        });


    }

    public static void setSPQ1Answered(boolean SPQ1Answered) {
        SPQ1Page.SPQ1Answered = SPQ1Answered;
    }

    @Override
    public void onBackPressed() {
        // Do nothing.
    }
}




