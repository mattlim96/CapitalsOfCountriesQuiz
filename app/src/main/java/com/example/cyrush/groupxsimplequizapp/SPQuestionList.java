package com.example.cyrush.groupxsimplequizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.cyrush.groupxsimplequizapp.SPQ3Page.SPQ3Answered;

public class SPQuestionList extends AppCompatActivity {

    private Button mFinishButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spquestion_list);

        // Getting the reference to the widgets in the layout.
        final TextView spQ1TextView = (TextView) findViewById(R.id.SPListQ1);
        final TextView spQ2TextView = (TextView) findViewById(R.id.SPListQ2);
        final TextView spQ3TextView = (TextView) findViewById(R.id.SPListQ3);
        final TextView spQ4TextView = (TextView) findViewById(R.id.SPListQ4);
        final TextView spQ5TextView = (TextView) findViewById(R.id.SPListQ5);
        final TextView spQ6TextView = (TextView) findViewById(R.id.SPListQ6);
        final TextView spQ7TextView = (TextView) findViewById(R.id.SPListQ7);
        final TextView spQ8TextView = (TextView) findViewById(R.id.SPListQ8);
        final TextView spQ9TextView = (TextView) findViewById(R.id.SPListQ9);
        final TextView spQ10TextView = (TextView) findViewById(R.id.SPListQ10);
        mFinishButton = (Button) findViewById(R.id.ListFinish_btn);

        /**
         *  Following methods navigate from Single Player Question List (Current Page) to corresponding
         *  Questions and gives a toast when a question has been answered.
         */

        spQ1TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!SPQ1Page.SPQ1Answered){
                    Intent spq1 = new Intent(SPQuestionList.this, SPQ1Page.class);
                    startActivity(spq1);
                } else {
                    Toast.makeText(getApplicationContext(), "Question 1 Answered.",
                            Toast.LENGTH_SHORT).show();
                }
            }});

        spQ2TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!SPQ2Page.SPQ2Answered){
                    Intent spq2 = new Intent(SPQuestionList.this, SPQ2Page.class);
                    startActivity(spq2);
                } else {
                    Toast.makeText(getApplicationContext(), "Question 2 Answered.",
                            Toast.LENGTH_SHORT).show();
                }
            }});

        spQ3TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!SPQ3Page.SPQ3Answered){
                    Intent spq3 = new Intent(SPQuestionList.this, SPQ3Page.class);
                    startActivity(spq3);
                } else {
                    Toast.makeText(getApplicationContext(), "Question 3 Answered.",
                            Toast.LENGTH_SHORT).show();
                }
            }});

        spQ4TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!SPQ4Page.SPQ4Answered){
                    Intent spq4 = new Intent(SPQuestionList.this, SPQ4Page.class);
                    startActivity(spq4);
                } else {
                    Toast.makeText(getApplicationContext(), "Question 4 Answered.",
                            Toast.LENGTH_SHORT).show();
                }
            }});

        spQ5TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!SPQ5Page.SPQ5Answered){
                    Intent spq5 = new Intent(SPQuestionList.this, SPQ5Page.class);
                    startActivity(spq5);
                } else {
                    Toast.makeText(getApplicationContext(), "Question 5 Answered.",
                            Toast.LENGTH_SHORT).show();
                }
            }});

        spQ6TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!SPQ6Page.SPQ6Answered){
                    Intent spq6 = new Intent(SPQuestionList.this, SPQ6Page.class);
                    startActivity(spq6);
                } else {
                    Toast.makeText(getApplicationContext(), "Question 6 Answered.",
                            Toast.LENGTH_SHORT).show();
                }
            }});

        spQ7TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!SPQ7Page.SPQ7Answered){
                    Intent spq7 = new Intent(SPQuestionList.this, SPQ7Page.class);
                    startActivity(spq7);
                } else {
                    Toast.makeText(getApplicationContext(), "Question 7 Answered.",
                            Toast.LENGTH_SHORT).show();
                }
            }});

        spQ8TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!SPQ8Page.SPQ8Answered){
                    Intent spq8 = new Intent(SPQuestionList.this, SPQ8Page.class);
                    startActivity(spq8);
                } else {
                    Toast.makeText(getApplicationContext(), "Question 8 Answered.",
                            Toast.LENGTH_SHORT).show();
                }
            }});

        spQ9TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!SPQ9Page.SPQ9Answered){
                    Intent spq9 = new Intent(SPQuestionList.this, SPQ9Page.class);
                    startActivity(spq9);
                } else {
                    Toast.makeText(getApplicationContext(), "Question 9 Answered.",
                            Toast.LENGTH_SHORT).show();
                }
            }});

        spQ10TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!SPQ10Page.SPQ10Answered){
                    Intent spq10 = new Intent(SPQuestionList.this, SPQ10Page.class);
                    startActivity(spq10);
                } else {
                    Toast.makeText(getApplicationContext(), "Question 10 Answered.",
                            Toast.LENGTH_SHORT).show();
                }
            }});


        /**
         *  Do this on Finish button in Single Player Question List page.
         */
        mFinishButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){

                // Creates an Intent object from current page to Single Player final score page.
                Intent goToSPFinalConfirmationPage = new Intent(SPQuestionList.this, SPFinalConfirmationPage.class );

                // Execute Intent object.
                startActivity(goToSPFinalConfirmationPage);

            }
        });

    }

    @Override
    public void onBackPressed() {
        // Do nothing.
    }
}
