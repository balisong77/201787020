package com.example.hint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class About_new_thread extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_new_thread);
        TextView textView=findViewById(R.id.about);
        textView.setMovementMethod(new ScrollingMovementMethod());
    }
}
