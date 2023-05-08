package com.example.hint;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.litepal.crud.DataSupport;

// 个人信息类
@Entity
public class Information extends DataSupport {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "nickName")
    private String nickName;
    @ColumnInfo(name = "realName")
    private String realName;
    @ColumnInfo(name = "group")
    private String group;
    @ColumnInfo(name = "idNumber")
    private String idNumber;
    @ColumnInfo(name = "passWord")
    private String passWord;

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdNumber(String id) {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
