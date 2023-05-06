package com.example.hint;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PagerFragment extends Fragment {

    private MyDatabaseHelper dbHelper;
    private List<Team> teamList = new ArrayList<>();
    private String RealName;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vp,container,false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        RealName = (String)getArguments().get("RealName");
        Log.d("AAA",RealName);
        dbHelper = new MyDatabaseHelper(getActivity(),"TeamStore.db",null,1);
        InitData();
        TeamAdapter adapter = new TeamAdapter(getActivity(),teamList,RealName);
        recyclerView.setAdapter(adapter);
        return view;
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
                if(RealName.equals(cursor.getString(cursor.getColumnIndex("team_publisher")))){
                    Team team = new Team();
                    team.setTeamName(cursor.getString(cursor.getColumnIndex("game_name")));
                    team.setMembers(cursor.getString(cursor.getColumnIndex("memberNum")));
                    team.setTeam_details(cursor.getString(cursor.getColumnIndex("details")));
                    team.setBossName(cursor.getString(cursor.getColumnIndex("team_publisher")));
                    teamList.add(team);
                }

            }while(cursor.moveToNext());
        }
        cursor.close();

    }

}
