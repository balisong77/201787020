package com.example.hint;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class System_Recruit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system__recruit);

        final Intent intent = getIntent();

        Button bt_jump = (Button) findViewById(R.id.jump);
        Button bt_jump2 = (Button) findViewById(R.id.jump2);

        bt_jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent_jump = new Intent(Intent.ACTION_VIEW);
//                intent_jump.setData(Uri.parse(intent.getStringExtra("WebLink")));
//                startActivity(intent_jump);
                Intent intent_test = new Intent(System_Recruit.this,Web_Recruit.class);
                intent_test.putExtra("Link",intent.getStringExtra("WebLink"));
                startActivity(intent_test);
            }
        });

        bt_jump2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_jump = new Intent(Intent.ACTION_VIEW);
                intent_jump.setData(Uri.parse(intent.getStringExtra("WebLink")));
                startActivity(intent_jump);
            }
        });

    }
}
