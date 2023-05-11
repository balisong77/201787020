package com.example.hint;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;

public class DrawerActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private DrawerLayout drawer_layout;
    private ListView list_left_drawer;
    private ArrayList<Item> menuLists;
    private MyAdapter<Item> myAdapter = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        drawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);
        list_left_drawer = (ListView) findViewById(R.id.list_left_drawer);

        menuLists = new ArrayList<Item>();
        menuLists.add(new Item(R.drawable.star,"weather"));
        myAdapter = new MyAdapter<Item>(menuLists,R.layout.item_list) {
            @Override
            public void bindView(ViewHolder holder, Item obj) {
                holder.setImageResource(R.id.img_icon,obj.getIconId());
                holder.setText(R.id.txt_content, obj.getIconName());
            }
        };
        list_left_drawer.setAdapter(myAdapter);
        list_left_drawer.setOnItemClickListener(this);
    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        drawer_layout.closeDrawer(list_left_drawer);
        Intent intent = new Intent(this.getApplicationContext(),BarchartActivity.class);
        startActivity(intent);
    }
}
