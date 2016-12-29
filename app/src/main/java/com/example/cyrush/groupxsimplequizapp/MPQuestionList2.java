package com.example.cyrush.groupxsimplequizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MPQuestionList2 extends AppCompatActivity {

    private Button p2Finished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpquestion_list2);

        // Getting the reference to the widgets in the layout.
        final TextView mpQ1TextView = (TextView) findViewById(R.id.MPListQ1);
        final TextView mpQ2TextView = (TextView) findViewById(R.id.MPListQ2);
        final TextView mpQ3TextView = (TextView) findViewById(R.id.MPListQ3);
        final TextView mpQ4TextView = (TextView) findViewById(R.id.MPListQ4);
        final TextView mpQ5TextView = (TextView) findViewById(R.id.MPListQ5);
        final TextView mpQ6TextView = (TextView) findViewById(R.id.MPListQ6);
        final TextView mpQ7TextView = (TextView) findViewById(R.id.MPListQ7);
        final TextView mpQ8TextView = (TextView) findViewById(R.id.MPListQ8);
        final TextView mpQ9TextView = (TextView) findViewById(R.id.MPListQ9);
        final TextView mpQ10TextView = (TextView) findViewById(R.id.MPListQ10);
        p2Finished = (Button) findViewById(R.id.mp_ListFinish_btn);

        /**
         *  Following methods navigate from Player 2 Question List to corresponding Questions
         *  and gives a toast when a question has been answered.
         */

        mpQ1TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!MPQ1Page.MPQ1Answered){
                    Intent mpq1 = new Intent(MPQuestionList2.this, MPQ1Page.class);
                    startActivity(mpq1);
                } else {
                    Toast.makeText(getApplicationContext(), "Question 1 Answered.",
                            Toast.LENGTH_SHORT).show();
                }
            }});

        mpQ2TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!MPQ2Page.MPQ2Answered){
                    Intent spq2 = new Intent(MPQuestionList2.this, MPQ2Page.class);
                    startActivity(spq2);
                } else {
                    Toast.makeText(getApplicationContext(), "Question 2 Answered.",
                            Toast.LENGTH_SHORT).show();
                }
            }});

        mpQ3TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!MPQ3Page.MPQ3Answered){
                    Intent spq3 = new Intent(MPQuestionList2.this, MPQ3Page.class);
                    startActivity(spq3);
                } else {
                    Toast.makeText(getApplicationContext(), "Question 3 Answered.",
                            Toast.LENGTH_SHORT).show();
                }
            }});

        mpQ4TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!MPQ4Page.MPQ4Answered){
                    Intent spq4 = new Intent(MPQuestionList2.this, MPQ4Page.class);
                    startActivity(spq4);
                } else {
                    Toast.makeText(getApplicationContext(), "Question 4 Answered.",
                            Toast.LENGTH_SHORT).show();
                }
            }});

        mpQ5TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!MPQ5Page.MPQ5Answered){
                    Intent spq5 = new Intent(MPQuestionList2.this, MPQ5Page.class);
                    startActivity(spq5);
                } else {
                    Toast.makeText(getApplicationContext(), "Question 5 Answered.",
                            Toast.LENGTH_SHORT).show();
                }
            }});

        mpQ6TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!MPQ6Page.MPQ6Answered){
                    Intent spq6 = new Intent(MPQuestionList2.this, MPQ6Page.class);
                    startActivity(spq6);
                } else {
                    Toast.makeText(getApplicationContext(), "Question 6 Answered.",
                            Toast.LENGTH_SHORT).show();
                }
            }});

        mpQ7TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!MPQ7Page.MPQ7Answered){
                    Intent spq7 = new Intent(MPQuestionList2.this, MPQ7Page.class);
                    startActivity(spq7);
                } else {
                    Toast.makeText(getApplicationContext(), "Question 7 Answered.",
                            Toast.LENGTH_SHORT).show();
                }
            }});

        mpQ8TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!MPQ8Page.MPQ8Answered){
                    Intent spq8 = new Intent(MPQuestionList2.this, MPQ8Page.class);
                    startActivity(spq8);
                } else {
                    Toast.makeText(getApplicationContext(), "Question 8 Answered.",
                            Toast.LENGTH_SHORT).show();
                }
            }});

        mpQ9TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!MPQ9Page.MPQ9Answered){
                    Intent spq9 = new Intent(MPQuestionList2.this, MPQ9Page.class);
                    startActivity(spq9);
                } else {
                    Toast.makeText(getApplicationContext(), "Question 9 Answered.",
                            Toast.LENGTH_SHORT).show();
                }
            }});

        mpQ10TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!MPQ10Page.MPQ10Answered){
                    Intent spq10 = new Intent(MPQuestionList2.this, MPQ10Page.class);
                    startActivity(spq10);
                } else {
                    Toast.makeText(getApplicationContext(), "Question 10 Answered.",
                            Toast.LENGTH_SHORT).show();
                }
            }});

        /**
         *  Do this on Finish button in Player 2 Question List page.
         */
        p2Finished.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Creates an Intent object from current page to Player 2 complete page.
                Intent i = new Intent(MPQuestionList2.this, MP_P2_Transition.class);

                // Execute Intent object.
                startActivity(i);

            }
        });
    }

    @Override
    public void onBackPressed() {
        // Do nothing.
    }
}
