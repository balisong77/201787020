package com.example.hint;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Book_detals extends AppCompatActivity {

    private  SQL_helper myhelper;
    private List<Book> books = new ArrayList<>();
    private Button mtn;
    private TextView mtx;
    private ImageView ima;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detals);
//        BookDatabase.getInstance(this.getApplicationContext()).bookDao().updateBook();
        myhelper = new SQL_helper(this,"BOOKSTORE",null,1);
        myhelper.getWritableDatabase();
        final SQLiteDatabase db = myhelper.getWritableDatabase();
        mtn = findViewById(R.id.fanhui);
        mtx = findViewById(R.id.return_name);
        ima = findViewById(R.id.ima_return);
        final Intent intent = getIntent();
        final String data = intent.getStringExtra("extra_data");
        String type = intent.getStringExtra("type");;
        mtx.setText(data);
        ima.setImageResource(intent.getIntExtra("extra_num",1));
        if (type.equals("borrow")) {
            mtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent2  = new Intent(Book_detals.this,Book_borrow.class);
                    intent2.putExtra("name",data);
                    startActivity(intent2);
                    finish();


                }
            });
        }
        else {
            mtn.setText("return");
            mtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ContentValues values = new ContentValues();
                    values.put("free", "Borrowable");
                    db.update("Book", values, "name = ?", new String[]{data});
                    Toast.makeText(Book_detals.this,"success！",Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    }
}
