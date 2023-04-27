package com.example.hint;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Show_mybook extends AppCompatActivity {
    private  SQL_helper myhelper;
    private RecyclerView rc1;
    private Title_layout title_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_mybook);
        title_layout = findViewById(R.id.title_mybook);
        title_layout.setTitleText("我的书籍");
    }

    @Override
    protected void onResume() {
        List<Book> books = new ArrayList<>();
        super.onResume();
        myhelper = new SQL_helper(this,"BOOKSTORE",null,1);
        myhelper.getWritableDatabase();
        SQLiteDatabase db = myhelper.getWritableDatabase();
        Cursor cursor =db.query("Book",null,null,null,null,null,null);
        if (cursor.moveToFirst()){
            do{

                Book book = new Book(cursor.getString(cursor.getColumnIndex("name")), cursor.getString(cursor.getColumnIndex("author")), cursor.getString(cursor.getColumnIndex("free")),cursor.getInt(cursor.getColumnIndex("num")));
                book.setTime(cursor.getString(cursor.getColumnIndex("time")));
                if (book.getFree().equals("我已借")) {
                    books.add(book);
                }

            }while (cursor.moveToNext());
        }
        cursor.close();
        rc1 = findViewById(R.id.rcv_showme);
        rc1.setLayoutManager(new LinearLayoutManager(Show_mybook.this));
        rc1.setAdapter(new Adapter(Show_mybook.this,books));

    }
}
