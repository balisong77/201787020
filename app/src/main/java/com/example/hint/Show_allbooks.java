package com.example.hint;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Show_allbooks extends AppCompatActivity {

    private  SQL_helper myhelper;
    private RecyclerView recyclerView;
    private Title_layout title_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_allbooks);
        title_layout = findViewById(R.id.title_allbooks);
        title_layout.setTitleText("Book list");
    }


    @Override
    protected void onResume() {
        super.onResume();
        List<Book> books = new ArrayList<>();
        myhelper = new SQL_helper(this,"BOOKSTORE",null,1);
        myhelper.getWritableDatabase();
        SQLiteDatabase db = myhelper.getWritableDatabase();
        Cursor cursor =db.query("Book",null,null,null,null,null,null);
        if (cursor.moveToFirst()){
            do{
                if(cursor.getString(cursor.getColumnIndex("free")).equals("Borrowable")) {

                    Book book = new Book(cursor.getString(cursor.getColumnIndex("name")), cursor.getString(cursor.getColumnIndex("author")), cursor.getString(cursor.getColumnIndex("free")),cursor.getInt(cursor.getColumnIndex("num")));
                    books.add(book);
                }

            }while (cursor.moveToNext());
        }
        if (cursor.moveToFirst()){
            do{
                if(cursor.getString(cursor.getColumnIndex("free")).equals("Borrowed")||cursor.getString(cursor.getColumnIndex("free")).equals("Borrowed by myself")) {
                    Book book = new Book(cursor.getString(cursor.getColumnIndex("name")), cursor.getString(cursor.getColumnIndex("author")),"Borrowed",cursor.getInt(cursor.getColumnIndex("num")));
                    books.add(book);
                }
 

            }while (cursor.moveToNext());
        }
        cursor.close();
        recyclerView = findViewById(R.id.rcv_showall);
        recyclerView.setLayoutManager(new GridLayoutManager(Show_allbooks.this,3));
        recyclerView.setAdapter(new Adapter_wg(Show_allbooks.this,books,getResources().getDrawable(R.drawable.button_shape_red)));
    }
}
