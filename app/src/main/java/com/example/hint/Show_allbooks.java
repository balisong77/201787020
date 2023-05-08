package com.example.hint;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Show_allbooks extends AppCompatActivity {

    private  SQL_helper myhelper;
    private RecyclerView recyclerView;
    private Title_layout title_layout;

    private BookViewModel bookViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_allbooks);
        title_layout = findViewById(R.id.title_allbooks);
        title_layout.setTitleText("Book list");
//
//        // Create the observer which updates the UI.
//        bookViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(BookViewModel.class);
//        final Observer<List<Book>> bookObserver = new Observer<List<Book>>() {
//            @Override
//            public void onChanged(@Nullable final List<Book> bookList) {
//                // Update the UI, in this case, a TextView.
//                recyclerView = findViewById(R.id.rcv_showall);
//                recyclerView.setLayoutManager(new GridLayoutManager(Show_allbooks.this,3));
//                recyclerView.setAdapter(new Adapter_wg(Show_allbooks.this,bookList,getResources().getDrawable(R.drawable.button_shape_red)));
//            }
//        };
//
//        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
//        bookViewModel.getAllBooks().observe(this, bookObserver);
    }


    @Override
    protected void onResume() {
        super.onResume();
        // Create the observer which updates the UI.
//        bookViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(BookViewModel.class);
//        final Observer<List<Book>> bookObserver = new Observer<List<Book>>() {
//            @Override
//            public void onChanged(@Nullable final List<Book> bookList) {
//                // Update the UI, in this case, a TextView.
//                recyclerView = findViewById(R.id.rcv_showall);
//                recyclerView.setLayoutManager(new GridLayoutManager(Show_allbooks.this,3));
//                recyclerView.setAdapter(new Adapter_wg(Show_allbooks.this,bookList,getResources().getDrawable(R.drawable.button_shape_red)));
//            }
//        };

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
//        bookViewModel.getAllBooks().observe(this, bookObserver);


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
//        recyclerView.setAdapter(new Adapter_wg(Show_allbooks.this,booklist,getResources().getDrawable(R.drawable.button_shape_red)));
    }
}
