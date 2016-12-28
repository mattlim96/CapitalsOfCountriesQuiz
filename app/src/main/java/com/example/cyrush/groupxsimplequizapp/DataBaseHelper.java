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
                COLUMN_PLAY_TYPE + " TEXT" +
                ");";
        db.execSQL(spQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public int addPlayerToSpQuiz(Player player)
    {
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME, player.getName());
        cv.put(COLUMN_SCORE, player.getScore());
        cv.put(COLUMN_PLAY_TYPE, "1");
        SQLiteDatabase db = getWritableDatabase();
        long playerID = db.insert(TABLE_NAME, null, cv);
        db.close();
        return (int) playerID;
    }

    public int addPlayerToMpQuiz(Player player1, Player player2)
    {
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME, player1.getName());
        cv.put(COLUMN_SCORE, player1.getScore());
        cv.put(COLUMN_PLAY_TYPE, "2");
        SQLiteDatabase db = getWritableDatabase();
        long playerID = db.insert(TABLE_NAME, null, cv);


        // Second player

        ContentValues cv2 = new ContentValues();
        cv2.put(COLUMN_NAME, player2.getName());
        cv2.put(COLUMN_SCORE, player2.getScore());
        cv2.put(COLUMN_PLAY_TYPE, "2");
        SQLiteDatabase db2 = getWritableDatabase();
        long playerID2 = db2.insert(TABLE_NAME, null, cv2);
        db2.close();
        return (int) playerID2;
    }

    public ArrayList<Player> showSpAllScores()
    {

        ArrayList<Player> playerList = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE 1";
        Cursor c = db.rawQuery(query, null);

        if(c.moveToFirst()) {
            do {
                Player player = new Player();
                player.setName(c.getString(c.getColumnIndex(COLUMN_NAME)));
                player.setScore(Integer.parseInt(c.getString(c.getColumnIndex(COLUMN_SCORE))));
                playerList.add(player);
            } while (c.moveToNext());
        }

        return playerList;
    }

    public ArrayList<Player> showMpAllScores()
    {

        ArrayList<Player> playerList = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE "+ COLUMN_PLAY_TYPE + " = ?";
        Cursor c = db.rawQuery(query,new String[]{"2"});

        if(c.moveToFirst()) {
            do {
                Player player = new Player();
                player.setName(c.getString(c.getColumnIndex(COLUMN_NAME)));
                player.setScore(Integer.parseInt(c.getString(c.getColumnIndex(COLUMN_SCORE))));
                playerList.add(player);
            } while (c.moveToNext());
        }

        return playerList;
    }

}