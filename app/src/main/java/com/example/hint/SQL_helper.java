package com.example.hint;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class SQL_helper extends SQLiteOpenHelper {
    public static final String CREAT_BOOK = "create table Book ("
            +"id integer primary key autoincrement,"
            +"author text,"
            +"name text,"
            +"free text,"
            +"time text,"
            +"num int)";
    private Context mcontext;
    public SQL_helper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mcontext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREAT_BOOK);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
