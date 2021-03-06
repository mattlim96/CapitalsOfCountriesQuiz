package com.example.cyrush.groupxsimplequizapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by mattlim on 20/12/2016.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Score.db";
    public static final String TABLE_NAME = "ScoreTable";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_NAME = "NAME";
    public static final String COLUMN_SCORE = "SCORE";
    public static final String COLUMN_PLAY_TYPE = "PLAY_TYPE";
    public static final String COLUMN_GAME_NUMBER = "GAME_NUMBER";

    public DataBaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // Creates the table for scores.
        String spQuery = "CREATE TABLE " + TABLE_NAME + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_SCORE + " INTEGER," +
                COLUMN_PLAY_TYPE + " TEXT," +
                COLUMN_GAME_NUMBER + " INTEGER default 0" +
                ");";
        db.execSQL(spQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Updating the table of scores.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    /**
     *  Method to add a player in Single Player mode.
     */
    public int addPlayerToSpQuiz(Player player) {

        // Creating KEY value pair where the KEYs are labeled columns and the values
        // are actual values entered by the user/created by program.
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME, player.getName());
        cv.put(COLUMN_SCORE, player.getScore());
        cv.put(COLUMN_PLAY_TYPE, "1");

        // Creating a writable database because query is inserting the data.
        SQLiteDatabase db = getWritableDatabase();

        // Executing insert command using insert method on SQLite database.
        // Insert method returns the number of rows affected on the database.
        long playerID = db.insert(TABLE_NAME, null, cv);
        db.close();

        // Returning the return value of Insert method back to the calling area.
        return (int) playerID;
    }

    /**
     *  Method to add both players in Multiplayer mode.
     */
    public int addPlayerToMpQuiz(Player player1, Player player2) {

        // Initiating the Game Number to an interger variable and incrementing it.
        int game_number = this.getGameNumber();
        game_number++;

        /**
         *  First player
         */
        // Creating KEY value pair where the KEYs are labeled columns and the values
        // are actual values entered by the user/created by program.
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME, player1.getName());
        cv.put(COLUMN_SCORE, player1.getScore());
        cv.put(COLUMN_PLAY_TYPE, "2");
        cv.put(COLUMN_GAME_NUMBER, game_number);

        // Creating a writable database because query is inserting the data.
        SQLiteDatabase db = getWritableDatabase();

        // Executing insert command using insert method on SQLite database.
        // Insert method returns the number of rows affected on the database.
        long playerID = db.insert(TABLE_NAME, null, cv);

        /**
         *  Second player
         */
        // Creating KEY value pair where the KEYs are labeled columns and the values
        // are actual values entered by the user/created by program.
        ContentValues cv2 = new ContentValues();
        cv2.put(COLUMN_NAME, player2.getName());
        cv2.put(COLUMN_SCORE, player2.getScore());
        cv2.put(COLUMN_PLAY_TYPE, "2");
        cv2.put(COLUMN_GAME_NUMBER, game_number);

        // Creating a writable database because query is inserting the data.
        SQLiteDatabase db2 = getWritableDatabase();

        // Executing insert command using insert method on SQLite database.
        // Insert method returns the number of rows affected on the database.
        long playerID2 = db2.insert(TABLE_NAME, null, cv2);
        db2.close();

        // Returning the return value of Insert method back to the calling area.
        return (int) playerID2;
    }

    /**
     *  Method to show all the scores in Single Player mode.
     */
    public ArrayList<Player> showSpAllScores() {

        // Creating an ArrayList object of the Player class.
        ArrayList<Player> playerList = new ArrayList<>();

        // Creating a writable database because query is inserting the data.
        SQLiteDatabase db = getWritableDatabase();

        // Creating a query without a placeholder and rank in descending order.
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE "+ COLUMN_PLAY_TYPE + " != 2 order by score desc";

        // Replacing the placeholder with null (Player Type) to distinct Single Player mode from Multiplayer mode.
        // rawQuery method is used to execute select command.
        // Cursor is used to refer the records set returned by rawQuery method.
        Cursor c = db.rawQuery(query, null);

        // Checking if the first record exist from the record set by the query and executes the Do-While loop.
        if(c.moveToFirst()) {
            do {
                Player player = new Player();
                player.setName(c.getString(c.getColumnIndex(COLUMN_NAME)));
                player.setScore(Integer.parseInt(c.getString(c.getColumnIndex(COLUMN_SCORE))));
                playerList.add(player);
            } while (c.moveToNext());
        }

        // Returning the object created above.
        return playerList;
    }

    /**
     *  Method to show all the scores in Multiplayer mode.
     */
    public ArrayList<Player> showMpAllScores() {

        // Creating an ArrayList object of the Player class.
        ArrayList<Player> playerList = new ArrayList<>();

        // Creating a writable database because query is inserting the data.
        SQLiteDatabase db = getWritableDatabase();

        // Creating a query with a placeholder, ?, and rank in descending order.
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE "+ COLUMN_PLAY_TYPE + " = ? order by score desc";

        // Replacing the placeholder with value 2 (Player Type) to distinct Mutiplayer mode from Single Player mode.
        // rawQuery method is used to execute select command and along with values for placeholders.
        // Cursor is used to refer the records set returned by rawQuery method.
        Cursor c = db.rawQuery(query,new String[]{"2"});

        // Checking if the first record exist from the record set by the query and executes the Do-While loop.
        if(c.moveToFirst()) {
            do {
                Player player = new Player();
                player.setName(c.getString(c.getColumnIndex(COLUMN_NAME)));
                player.setScore(Integer.parseInt(c.getString(c.getColumnIndex(COLUMN_SCORE))));
                player.setGameNumber(Integer.parseInt(c.getString(c.getColumnIndex(COLUMN_GAME_NUMBER))));
                playerList.add(player);
            } while (c.moveToNext());
        }

        // Returning the object created above.
        return playerList;
    }


    /**
     *  Method to get the Game Number for Multiplayer mode.
     *  This game number helps the logic to group the players in the leaderboard.
     */
    public int getGameNumber() {

        // Creating a writable database because query is inserting the data.
        SQLiteDatabase db = getWritableDatabase();

        // Creating a query without a placeholder and inserted a sub query to get the Game Number.
        String query = "SELECT * FROM " + TABLE_NAME+" where GAME_NUMBER = (select max(GAME_NUMBER) from "+TABLE_NAME+")";

        // rawQuery method is used to execute select command.
        // Cursor is used to refer the records set returned by rawQuery method.
        Cursor c = db.rawQuery(query, null);

        // Checking if the first record exist from the record set by the query.
        if(c.moveToFirst()) {

            // Getting the Game Number.
            int n = Integer.parseInt(c.getString(c.getColumnIndex(COLUMN_GAME_NUMBER)));
            return n;

        }

        // If the query fails to get a game number.
        return -1;
    }

}