package com.example.hint;

import android.content.Context;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Team {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "bossName")
    private String bossName;
    @ColumnInfo(name = "teamName")
    private String teamName;
    @ColumnInfo(name = "team_details")
    private String team_details;
    @ColumnInfo(name = "members")
    private String members;
    private Context mContext;

    public Team(Context context, String bossName, String teamName, String team_details, String members){
        mContext = context;
        this.teamName = teamName;
        this.bossName = bossName;
        this.team_details = team_details;
        this.members = members;
    }

    public Team(){

    }

    public String getBossName() {
        return bossName;
    }

    public void setBossName(String bossName) {
        this.bossName = bossName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeam_details() {
        return team_details;
    }

    public void setTeam_details(String team_details) {
        this.team_details = team_details;
    }

    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Context getmContext() {
        return mContext;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }
}
