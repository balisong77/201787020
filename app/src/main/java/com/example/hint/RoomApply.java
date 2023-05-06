package com.example.hint;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class RoomApply extends AppCompatActivity {

    private Spinner spinner_roomID;
    private Spinner spinner_week;
    private Spinner spinner_time;
    private Spinner spinner_hour;
    private Spinner spinner_group;

    private Button bt_apply;

    private MyDatabaseHelper dbHelper;

    List<String> roomID = new ArrayList<>();
    List<String> week = new ArrayList<>();
    List<String> time = new ArrayList<>();
    List<String> hour = new ArrayList<>();
    List<String> group = new ArrayList<>();

    private String str_roomID;
    private String str_week;
    private String str_group;
    private String str_time;
    private String str_hour;

    private final int HDQ = 3;
    //private final int HXQ = 3;

    //private int COUNT_ROOM = 0;

    private SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_apply);

        dbHelper = new MyDatabaseHelper(this,"TeamStore.db",null,1);

        spinner_roomID = (Spinner) findViewById(R.id.spinner_roomID);
        spinner_week = (Spinner) findViewById(R.id.spinner_week);
        spinner_time = (Spinner) findViewById(R.id.spinner_time);
        spinner_hour = (Spinner) findViewById(R.id.spinner_hour);
        spinner_group = (Spinner) findViewById(R.id.spinner_group);

        bt_apply = (Button) findViewById(R.id.button_apply);

        initData();

        myAdapter(spinner_roomID,roomID);
        myAdapter(spinner_week,week);
        myAdapter(spinner_time,time);
        myAdapter(spinner_hour,hour);
        myAdapter(spinner_group,group);

        spinner_roomID.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                str_roomID = (String) spinner_roomID.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner_group.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                str_group = (String) spinner_group.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner_week.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                str_week = (String) spinner_week.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner_time.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                str_time = (String) spinner_time.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner_hour.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                str_hour = (String) spinner_hour.getSelectedItem();
                Log.d("STR","2" + str_hour + "3");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        bt_apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(str_roomID == null || str_group == null || str_hour == null || str_time == null || str_week == null){
                    Toast.makeText(RoomApply.this,"Select Full Info", Toast.LENGTH_SHORT).show();
                }
                else {
                    if(judge()){
                        SQLiteDatabase db = dbHelper.getWritableDatabase();
                        ContentValues values = new ContentValues();
                        //COUNT_ROOM ++;
                        //Cursor cursor = db.query("Room", null, null, null, null, null, null);
                        //              roomID text, "
                        //            + "group1 text, "
                        //            + "week text, "
                        //            + "time text,"
                        //            + "hour text)";
                        values.put("roomID",str_roomID);
                        values.put("group1",str_group);
                        values.put("week",str_week);
                        values.put("time",str_time);
                        values.put("hour",str_hour);
                        values.put("deleteID",str_week + str_roomID + str_time + str_hour);
                        Log.d("COUNT","****" + str_week + str_roomID + str_time + str_hour + "*****");
                        db.insert("Room",null,values);
                        values.clear();
                        Toast.makeText(RoomApply.this,"申请成功", Toast.LENGTH_SHORT).show();
                        finish();
                    }else {
                        Toast.makeText(RoomApply.this,"该时段与其它组会议冲突！", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }
    /*
    * 1.可申请
    * 当 申请的时间 大于 存在的会议时间加上持续时长
    * 当 申请的时间加上持续时长 小于 存在的会议时间
    *
    * 2.不可申请
    * 当 申请的时间 小于 存在的会议时间加上持续时长
    * 当 申请的时间加上持续时长 大于 存在的会议时间
    *
    * */
    private boolean judge(){

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query("Room",null,null,null,null,null,null);
        if(cursor.moveToFirst()){
            do{
                String roomID = cursor.getString(cursor.getColumnIndex("roomID"));
                String group = cursor.getString(cursor.getColumnIndex("group1"));
                String week = cursor.getString(cursor.getColumnIndex("week"));
                String time = cursor.getString(cursor.getColumnIndex("time"));
                String hour = cursor.getString(cursor.getColumnIndex("hour"));

                if(str_roomID.equals(roomID) && str_week.equals(week)){

                    if (getTimeCompareSize(time,str_time) == HDQ && getTimeCompareSize(str_time,getTimeAdd(time,hour)) == HDQ){
                        //Toast.makeText(RoomApply.this,"该时段与其它会议冲突！",Toast.LENGTH_SHORT).show();
                        return false;

                    }else if (getTimeCompareSize(str_time,time) == HDQ && getTimeCompareSize(time,getTimeAdd(str_time,str_hour)) == HDQ){
                        //Toast.makeText(RoomApply.this,"该时段与其它会议冲突！",Toast.LENGTH_SHORT).show();
                        return false;
                    }
                }
            }while (cursor.moveToNext());
        }
        return true;
    }

    public String getTimeAdd(String time, String hour){
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(formatter.parse(time));
        }catch (ParseException e){
            e.printStackTrace();
        }
        if(hour.equals("0.5h")){
            calendar.add(Calendar.MINUTE,30);
        }
        if(hour.equals("1h")){
            calendar.add(Calendar.HOUR,1);
        }
        if (hour.equals("1.5h")){
            calendar.add(Calendar.HOUR,1);
            calendar.add(Calendar.MINUTE,30);
        }
        if(hour.equals("2h")){
            calendar.add(Calendar.HOUR,2);
        }
        return formatter.format(calendar.getTime());
    }

    public static int getTimeCompareSize(String startTime, String endTime){
        int i=0;

// 年-月-日 时-分 可设置
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        try {
            Date date1 = dateFormat.parse(startTime);//开始时间
            Date date2 = dateFormat.parse(endTime);//结束时间
// 1 结束时间小于开始时间 2 开始时间与结束时间相同 3 结束时间大于开始时间
            if (date2.getTime() < date1.getTime()) {
                i=1;

            }

            else if (date2.getTime()>date1.getTime() || date2.getTime() == date1.getTime()){
    //正常情况下的逻辑操作.
                i=3;
            }
        }catch (ParseException e) {
            e.printStackTrace();
        }
    return  i;
    }

    private void myAdapter(Spinner spinner, List list) {

        SpinnerAdapter adapter = new SpinnerAdapter(this,R.layout.myspinner,list);
        spinner.setAdapter(adapter);
        //默认选择最后一项     support_simple_spinner_dropdown_item
        spinner.setSelection(list.size()-1,true);

    }

    private void initData(){

        roomID.add("8106");
        roomID.add("8108");
        roomID.add("8314");
        roomID.add("Select Room");

        week.add("Monday");
        week.add("Tuesday");
        week.add("Wednesday");
        week.add("Thursday");
        week.add("Friday");
        week.add("Saturday");
        week.add("Sunday");
        week.add("Select Which Day");

        time.add("8:00");
        time.add("8:30");
        time.add("9:00");
        time.add("9:30");
        time.add("10:00");
        time.add("10:30");
        time.add("11:00");
        time.add("11:30");
        time.add("12:00");
        time.add("12:30");
        time.add("13:00");
        time.add("13:30");
        time.add("14:00");
        time.add("14:30");
        time.add("15:00");
        time.add("15:30");
        time.add("16:00");
        time.add("16:30");
        time.add("17:00");
        time.add("17:30");
        time.add("18:00");
        time.add("18:30");
        time.add("19:00");
        time.add("19:30");
        time.add("20:00");
        time.add("20:30");
        time.add("21:00");
        time.add("Start Time");

        hour.add("0.5h");
        hour.add("1h");
        hour.add("1.5h");
        hour.add("2h");
        hour.add("Duration");

        group.add("Information Technology");
        group.add("Artificial Intelligence");
        group.add("Industry Design");
        group.add("International Business");
        group.add("Select Your Group");



    }
}
