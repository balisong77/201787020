package com.example.hint;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TeamOut extends AppCompatActivity {

    private EditText et_game;
    private EditText et_mem;
    private EditText et_details;
    private Button bt_put;
    private MyDatabaseHelper dbHelper;
    private TeamAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_out);
        dbHelper = new MyDatabaseHelper(this,"TeamStore.db",null,1);

        et_game = (EditText) findViewById(R.id.edit_game);
        et_mem = (EditText) findViewById(R.id.edit_member);
        et_details = (EditText) findViewById(R.id.edit_details);
        bt_put = (Button) findViewById(R.id.bt_put);

        final Intent intent= getIntent();


        bt_put.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                //game_name text, "
                //            + "team_boss text, "
                //            + "memberNum integer, "
                //            + "details text)
                if(et_game.getText().toString().equals("") || et_mem.getText().toString().equals("") || et_details.getText().toString().equals("")){
                    Toast.makeText(TeamOut.this,"请输入全部信息", Toast.LENGTH_SHORT).show();
                }else {
                    values.put("game_name",et_game.getText().toString());
                    values.put("memberNum",et_mem.getText().toString());
                    values.put("details",et_details.getText().toString());
                    values.put("team_publisher",intent.getStringExtra("RealName_TI"));
                    db.insert("Team",null,values);
                    values.clear();
                    finish();
                    Toast.makeText(TeamOut.this,"发布成功", Toast.LENGTH_SHORT).show();
                }



            }
        });

    }
}
