package com.example.hint;

public class Book {
    private String name;
    private String author;
    private String free;
    private int num;
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

}
