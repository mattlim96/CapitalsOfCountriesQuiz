package com.example.cyrush.groupxsimplequizapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SinglePlayerStartPageFrag extends Fragment {

    private Button SinglePlayerStart, quit;
    private EditText SPnickname;
    public String nickname;
    public static Player singlePlayer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.activity_single_player_start_page_frag, container, false);

        // Getting the reference to the widgets in the layout.
        SinglePlayerStart = (Button) view.findViewById(R.id.SP_start_Btn);
        SPnickname = (EditText) view.findViewById(R.id.nickname_EdiText);
        quit = (Button) view.findViewById(R.id.SP_quit_Btn);

        // Create an Activity object.
        final Activity mActivity = this.getActivity();

        /**
         *  Do this on Start button Click.
         */
        SinglePlayerStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // If-Else Statement creating toasts when players enter a nickname
                // exceeding 15 characters or leaving it empty.
                if (SPnickname.getText().toString().length() > 15) {

                    Toast.makeText(mActivity, "Username cannot exceed 15 characters.",
                            Toast.LENGTH_SHORT).show();
                }
                else if (SPnickname.getText().toString().isEmpty()) {

                    Toast.makeText(mActivity, "Please fill in name field.",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    // Getting the nickname entered by the player.
                    nickname = SPnickname.getText().toString();


                    // Creating a Player class variable.
                    singlePlayer = new Player();

                    // Setting the nickname of the Player class variable made
                    // to the nickname entered by the player.
                    singlePlayer.setName(nickname);

                    // Calling a method.
                    startSinglePlayermode();

                }

            }
        });

        /**
         *  Do this on Quit button in Single Player Start Page.
         */
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Creates an Intent object from current page to the Home Page
                Intent toHomePage = new Intent(getActivity(), HomeActivity.class);
                startActivity(toHomePage);
            }
        });

        return view;
    }

    public void startSinglePlayermode() {

        // Creates an Intent object from current page to the Single Player question list
        Intent startQuiz = new Intent(getActivity(), SPQuestionList.class);

        // Executes the Intent object
        startActivity(startQuiz);

    }
}
