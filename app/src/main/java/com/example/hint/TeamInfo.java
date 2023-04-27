package com.example.hint;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class TeamInfo extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TeamAdapter adapter;
    private MyDatabaseHelper dbHelper;
    private List<Team> teamList = new ArrayList<>();
    private String namePublisher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_info);
        dbHelper = new MyDatabaseHelper(this,"TeamStore.db",null,1);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Intent intent_get = getIntent();
        namePublisher = intent_get.getStringExtra("RealName_myFrag");
        Log.d("RRR_INFO",namePublisher);

        //InitData();

//        adapter = new TeamAdapter(TeamInfo.this,teamList);
//        Log.d("TAG3"," " + teamList.size());
//        recyclerView.setAdapter(adapter);




        Button bt_putTeam = (Button) findViewById(R.id.team_put);
        bt_putTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TeamInfo.this, TeamOut.class);
                Intent intent_get = getIntent();
                intent.putExtra("RealName_TI",namePublisher);
                startActivity(intent);
            }
        });

//        TextView textView = (TextView) findViewById(R.id.game);
//        textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent2 = new Intent(TeamInfo.this,TeamDetails.class);
//                startActivity(intent2);
//            }
//        });
    }

    public  void InitData(){

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query("Team", null, null, null, null, null, null);
        if(cursor.moveToFirst()){
            do{
                //遍历Cursor对象，取出数据
                //"game_name text, "
                //            + "team_boss text, "
                //            + "memberNum text, "
                //            + "details text)";
                Team team = new Team();
                team.setTeamName(cursor.getString(cursor.getColumnIndex("game_name")));
                team.setMembers(cursor.getString(cursor.getColumnIndex("memberNum")));
                team.setTeam_details(cursor.getString(cursor.getColumnIndex("details")));
                team.setBossName(cursor.getString(cursor.getColumnIndex("team_publisher")));
                teamList.add(team);


                Log.d("TAG","Book name " + team.getTeamName());
                Log.d("TAG","Book author " + team.getMembers());
                Log.d("TAG","Book pages " + team.getTeam_details());
                Log.d("TAG","Book price " + team.getBossName());

            }while(cursor.moveToNext());
//            recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
////            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
////            recyclerView.setLayoutManager(layoutManager);

//            adapter = new TeamAdapter(TeamInfo.this,teamList);
//            Log.d("TAG3"," " + teamList.size());
//            recyclerView.setAdapter(adapter);

            //teamList.clear();

        }
        cursor.close();

    }

    @Override
    protected void onResume() {
        super.onResume();
        teamList.clear();
        InitData();
        adapter = new TeamAdapter(TeamInfo.this,teamList,namePublisher);
        Log.d("REAL",namePublisher + "TI");
        Log.d("TAG3"," " + teamList.size());
        recyclerView.setAdapter(adapter);
        //adapter.setData(teamList);
        //adapter.notifyDataSetChanged();


    }
}
