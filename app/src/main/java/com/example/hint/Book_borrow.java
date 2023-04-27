package com.example.hint;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.litepal.crud.DataSupport;

import androidx.appcompat.app.AppCompatActivity;

public class Book_borrow extends AppCompatActivity {
    private Title_layout title_layout;
    private  SQL_helper myhelper;
    private Spinner msp = null;
    private Button mbt;
    private TextView tx1,tx2,tx3;
    private  int t=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_borrow);
        title_layout = findViewById(R.id.title_Book_borrow);
        title_layout.setTitleText("确认租借：");
        Login_user login_user = DataSupport.findFirst(Login_user.class);
        tx1 = findViewById(R.id.book_borrow_name);
        tx2 = findViewById(R.id.book_borrow_number);
        tx3 = findViewById(R.id.book_borrow_lender);
        Intent intent2 = getIntent();
        tx1.setText("租借书籍："+intent2.getStringExtra("name"));
        tx2.setText("租借人学号："+login_user.getIdNumber());
        tx3.setText("租借人姓名："+login_user.getRealName());
        myhelper = new SQL_helper(this,"BOOKSTORE",null,1);
        myhelper.getWritableDatabase();
        final SQLiteDatabase db = myhelper.getWritableDatabase();
        final Intent intent = getIntent();
        final String data = intent.getStringExtra("name");
        String[] arr = {"7天","14天","一个月","两个月"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,arr);
        msp = findViewById(R.id.myspin);
        msp.setAdapter(adapter);
        msp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    t=7;
                }
                if(i==1){
                    t=14;
                }
                if(i==2){
                    t=30;
                }
                if(i==3){
                    t=60;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        mbt = findViewById(R.id.book_borrow_btn);
        mbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues values = new ContentValues();
                values.put("free", "我已借");
                Timetrans time= new Timetrans();
                values.put("time",time.borrow_time(t));
                db.update("Book", values, "name = ?", new String[]{data});
                Toast.makeText(Book_borrow.this,"租借成功！",Toast.LENGTH_SHORT).show();
                finish();

            }
        });
    }
}
