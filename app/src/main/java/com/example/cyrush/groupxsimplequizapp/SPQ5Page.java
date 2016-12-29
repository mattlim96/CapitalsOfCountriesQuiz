package com.example.cyrush.groupxsimplequizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SPQ5Page extends AppCompatActivity {

    private Button mListofQuestionsButton;
    private RadioGroup SPQ5MultiChoice;
    private Button SPQ5SubmitBtn;
    public static int SPQ5Score = 0;
    public static boolean SPQ5Answered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spq5_page);

        // Getting the reference to the widgets in the layout.
        SPQ5MultiChoice = (RadioGroup) findViewById(R.id.SPQ5YesorNoRadioGroup);
        SPQ5SubmitBtn = (Button) findViewById(R.id.submit_btn);
        mListofQuestionsButton = (Button) findViewById(R.id.questionList);

        /**
         *  Do this on Submit button in Question 5.
         */
        SPQ5SubmitBtn.setOnClickListener(new View.OnClickListener(){

            public void onClick (View v){

                // Initiating the radio buttons in Question 5 to an integer variable.
                int SPQ5SelectedID = SPQ5MultiChoice.getCheckedRadioButtonId();

                // Nested If-Else Statement when Yes, No, Cheat or Skip has been chosen.
                if (SPQ5SelectedID == R.id.yes) {

                    Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT).show();
                    SPQ5Score++;
                    SPQ5SubmitBtn.setClickable(false);

                } else if (SPQ5SelectedID == R.id.no) {

                    Toast.makeText(getApplicationContext(), "Incorrect!", Toast.LENGTH_SHORT).show();
                    SPQ5Score = 0;
                    SPQ5SubmitBtn.setClickable(false);

                } else if (SPQ5SelectedID == R.id.radiocheat) {

                    Toast.makeText(getApplicationContext(), "The answer is Yes, you cheater!", Toast.LENGTH_SHORT).show();
                    SPQ5Score = 0;
                    SPQ5SubmitBtn.setClickable(false);

                } else {

                    Toast.makeText(getApplicationContext(), "Please select an answer or leave blank to skip.", Toast.LENGTH_SHORT).show();

                }

                // Boolean variable set true to indicate Question 5 has been answered.
                SPQ5Answered = true;

            }
        });

        /**
         *  Do this on List of Questions button in Question 5.
         */
        mListofQuestionsButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                Intent goToList = new Intent(SPQ5Page.this,SPQuestionList.class );
                startActivity(goToList);
            }
        });
    }

    public static void setSPQ5Answered(boolean SPQ5Answered) {
        SPQ5Page.SPQ5Answered = SPQ5Answered;
    }

    @Override
    public void onBackPressed() {
        // Do nothing.
    }
}