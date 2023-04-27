package com.example.hint;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Timetrans {
    String curtime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        Date date = new Date(System.currentTimeMillis());
        return simpleDateFormat.format(date);
    }
    String borrow_time(int t){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        Date date = new Date(System.currentTimeMillis()+(long)(t)*24*3600*1000);
        return simpleDateFormat.format(date);
    }
}
