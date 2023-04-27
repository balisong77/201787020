package com.example.hint;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TeamDetails_Visitor extends AppCompatActivity {

    private TextView textView;
    private TextView textView2;
    private TextView textView3;
    private TextView textView_publisher;

    private Button bt_apply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_details__visitor);

        textView = (TextView) findViewById(R.id.game_details);
        textView2 = (TextView) findViewById(R.id.menber_details);
        textView3 = (TextView) findViewById(R.id.details_d);
        textView_publisher = findViewById(R.id.boss_details);
        bt_apply = findViewById(R.id.bt_apply);
//        bt_edit = (Button) findViewById(R.id.bt_edit);
//        bt_stop = (Button) findViewById(R.id.bt_stop);

        final Intent intent_get = getIntent();

        textView.setText("比赛名称：" + intent_get.getStringExtra("TeamName"));
        textView2.setText("招募人数：" + intent_get.getStringExtra("Team_member") + "人");
        textView_publisher.setText("发布人:" + intent_get.getStringExtra("TeamPublisher"));
        textView3.setText(intent_get.getStringExtra("Team_details"));

        bt_apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TeamDetails_Visitor.this,"已发送申请",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
