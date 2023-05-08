package com.example.hint;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Book {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "author")
    private String author;
    @ColumnInfo(name = "free")
    private String free;
    @ColumnInfo(name = "num")
    private int num;
    @ColumnInfo(name = "time")
    private String time;
    public Book(String name,String author,String free,int num)
    {
        this.name = name;
        this.author = author;
        this.free = free;
        this.num =num;
    }
    public String getName()
    {
        return name;
    }
    public String getAuthor()
    {
        return author;
    }
    public String getFree()
    {
        return free;
    }
    public int getNum(){return num;}
    public void setTime(String time){
        this.time = time;
    }
    public String getTime(){

        return time;
    };
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setFree(String free) {
        this.free = free;
    }

    public void setNum(int num) {
        this.num = num;
    }

}
