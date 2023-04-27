package com.example.hint;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class TeamDetails extends AppCompatActivity {

    private TextView textView;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;

    private Button bt_edit;
    private Button bt_stop;

    private MyDatabaseHelper dbHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_details);

        dbHelper = new MyDatabaseHelper(this, "TeamStore.db", null, 1);

        textView = (TextView) findViewById(R.id.game_details);
        textView2 = (TextView) findViewById(R.id.menber_details);
        textView3 = (TextView) findViewById(R.id.details_d);
        textView4 = (TextView) findViewById(R.id.boss_details);
        bt_edit = (Button) findViewById(R.id.bt_edit);
        bt_stop = (Button) findViewById(R.id.bt_stop);

        final Intent intent_get = getIntent();

        textView.setText("比赛名称：" + intent_get.getStringExtra("TeamName"));
        textView2.setText("招募人数：" + intent_get.getStringExtra("Team_member") + "人");
        textView4.setText("发布人：" + intent_get.getStringExtra("TeamPublisher"));

        textView3.setText(intent_get.getStringExtra("Team_details"));

        bt_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TeamDetails.this,TeamEdit.class);
                intent.putExtra("TeamName_old",intent_get.getStringExtra("TeamName"));
                intent.putExtra("Team_details_old",intent_get.getStringExtra("Team_details"));
                intent.putExtra("Team_member_old",intent_get.getStringExtra("Team_member"));
                startActivity(intent);
                finish();
            }
        });

        bt_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(TeamDetails.this);
                dialog.setTitle("终止招募");
                dialog.setMessage("确定终止招募？");
                dialog.setCancelable(false);
                dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SQLiteDatabase db = dbHelper.getWritableDatabase();
                        db.delete("Team", "game_name = ?" ,new String[]{intent_get.getStringExtra("TeamName")});
                        finish();
                    }
                });
            dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            dialog.show();
            }
        });

    }
}
