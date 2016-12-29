package com.example.cyrush.groupxsimplequizapp;

import android.app.Activity;
import android.content.Intent;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MultiplayerStartPageFrag extends Fragment {

    private Button multiplayerStart, quit;
    private EditText player1, player2;
    public String p1Nickname, p2Nickname;
    public static Player p1, p2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.activity_multiplayer_start_page_frag, container, false);

        // Getting the reference to the widgets in the layout.
        player1 = (EditText) view.findViewById(R.id.p1_EditText); // Get the player 1 Nickname Field object
        player2 = (EditText) view.findViewById(R.id.p2_EditText);
        multiplayerStart = (Button) view.findViewById(R.id.MP_start_Btn);
        quit = (Button) view.findViewById(R.id.MP_quit_Btn);

        // Create an Activity object.
        final Activity mActivity = this.getActivity();

        /**
         *  Do this on Start button in Multiplayer Start Page.
         */
        multiplayerStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // If-Else Statement creating toasts when players enter a nickname
                // exceeding 15 characters or leaving it empty.
                if (player1.getText().toString().length() > 15 ||
                        player2.getText().toString().length() > 15) {

                    Toast.makeText(mActivity, "Username cannot exceed 15 characters.",
                            Toast.LENGTH_SHORT).show();

                }
                else if (player1.getText().toString().isEmpty() ||
                        player2.getText().toString().isEmpty()) {

                    Toast.makeText(mActivity, "Please fill in name field.",
                            Toast.LENGTH_SHORT).show();

                } else {

                    // Getting both nicknames entered by the players.
                    p1Nickname = player1.getText().toString();
                    p2Nickname = player2.getText().toString();

                    // Creating two Player class variables.
                    p1 = new Player();
                    p2 = new Player();

                    // Setting each nickname of the two Player class variables made
                    // to the nicknames entered by the players.
                    p1.setName(p1Nickname);
                    p2.setName(p2Nickname);


                    System.out.println("Player 1 name "+ p1.getName());

                    // Calling a method.
                    startMultiplayermode();

                }

            }
        });

        /**
         *  Do this on Quit button in Multiplayer Start Page.
         */
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Creates an Intent object from current page to the Home page.
                Intent toHomePage = new Intent(getActivity(), HomeActivity.class);

                // Executes the Intent object.
                startActivity(toHomePage);
            }
        });

        return view;
    }

    public void startMultiplayermode() {

        //Create an Intent object from the current page to the list of questions.
        Intent startQuiz = new Intent(getActivity(), MPQuestionList.class);

        // Executes the Intent object
        startActivity(startQuiz);

    }
}
