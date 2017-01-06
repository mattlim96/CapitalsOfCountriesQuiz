package com.example.cyrush.groupxsimplequizapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class StartPageActivity extends FragmentActivity {

    private String myQuiz = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);

        // Using Bundle class to retrieve the KEY for the extra Strings from the Home page.
        Bundle extras = getIntent().getExtras();
        if (extras != null)
            myQuiz = extras.getString("Quiz");

        // Switch Statement for two cases of fragments.
        switch (myQuiz) {
            case "Single Player":
                Fragment frag = new SinglePlayerStartPageFrag();
                FragmentManager fragmentManager = getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.startPageFrag, frag);

                fragmentTransaction.commit();
                break;
            case "Multiplayer":
                Fragment frag2 = new MultiplayerStartPageFrag();
                FragmentManager fragmentManager2 = getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                fragmentTransaction2.add(R.id.startPageFrag, frag2);

                fragmentTransaction2.commit();
        }

    }

    @Override
    public void onBackPressed() {
        // Do nothing.
    }
}
