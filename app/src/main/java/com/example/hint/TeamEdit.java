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

public class TeamEdit extends AppCompatActivity {

    private EditText et_game;
    private EditText et_mem;
    private EditText et_details;
    private Button bt_edit;

    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_edit);

        et_game = (EditText) findViewById(R.id.edit_game2);
        et_mem = (EditText) findViewById(R.id.edit_member2);
        et_details = (EditText) findViewById(R.id.edit_details2);
        bt_edit = (Button) findViewById(R.id.bt_put2);

        dbHelper = new MyDatabaseHelper(this,"TeamStore.db",null,1);

        final Intent intent_getOld = getIntent();


        et_game.setText(intent_getOld.getStringExtra("TeamName_old"));
        et_mem.setText(intent_getOld.getStringExtra("Team_member_old"));
        et_details.setText(intent_getOld.getStringExtra("Team_details_old"));

        bt_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values_name = new ContentValues();
//                ContentValues values_num = new ContentValues();
//                ContentValues values_details = new ContentValues();
                values_name.put("game_name",et_game.getText().toString());
                values_name.put("memberNum",et_mem.getText().toString());
                values_name.put("details",et_details.getText().toString());
//                db.update("Team",values_details,"game_name = ?",new String[] {intent_getOld.getStringExtra("TeamName_old")});
//                db.update("Team",values_num,"game_name = ?",new String[] {intent_getOld.getStringExtra("TeamName_old")});
                db.update("Team",values_name,"game_name = ?",new String[] {intent_getOld.getStringExtra("TeamName_old")});
                Toast.makeText(TeamEdit.this,"修改成功", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}
