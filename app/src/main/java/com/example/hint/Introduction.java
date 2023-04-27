package com.example.hint;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Introduction extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Title_layout title_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);
        recyclerView = findViewById(R.id.intro_rec);
        title_layout = findViewById(R.id.intro_title);
        title_layout.setTitleText("组别介绍");
        recyclerView.setLayoutManager(new LinearLayoutManager(Introduction.this));
        recyclerView.setAdapter(new Adapter_intro(Introduction.this));
    }
}
