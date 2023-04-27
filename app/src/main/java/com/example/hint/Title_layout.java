package com.example.hint;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Title_layout extends LinearLayout {
    private ImageButton titleBack;
    private TextView titleText;
    public Title_layout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.layout_mytitlte,this);
        titleBack = findViewById(R.id.title_btn);
        titleText = findViewById(R.id.title_text);
        titleBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Activity)getContext()).finish();
            }
        });
    }
    public void setTitleText(String text){
        titleText.setText(text);
    }
}
