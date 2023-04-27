package com.example.hint;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    public static final String CREATE_TEAM = "create table Team ("
            + "id integer primary key autoincrement, "
            + "game_name text, "
            + "team_publisher text, "
            + "memberNum text, "
            + "details text)";

    public static final String CREATE_ROOM = "create table Room ("
            + "id integer primary key autoincrement, "
            + "roomID text, "
            + "group1 text, "
            + "week text, "
            + "time text,"
            + "hour text,"
            + "deleteID integer)";

    private Context mConText;

    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
        mConText = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_ROOM);
        db.execSQL(CREATE_TEAM);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
