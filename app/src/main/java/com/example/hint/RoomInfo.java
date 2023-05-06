package com.example.hint;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class RoomInfo extends AppCompatActivity {

    private Button bt_apply;
    private RecyclerView recyclerView_room;

    private MyDatabaseHelper dbHelper;
    private List<Room> roomList = new ArrayList<>();
    private RoomAdapter adapter_room;

    Calendar getTimeNow = Calendar.getInstance();
    Date date = getTimeNow.getTime();
    public static String[] WEEK = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};

    private SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");

    private final int Behind_Bigger = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_info);

        dbHelper = new MyDatabaseHelper(this,"TeamStore.db",null,1);

        recyclerView_room = (RecyclerView) findViewById(R.id.recycler_view_room);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView_room.setLayoutManager(layoutManager);

        bt_apply = (Button) findViewById(R.id.button_apply);

        bt_apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RoomInfo.this,RoomApply.class);
                startActivity(intent);
            }
        });

    }

    public String DateToWeek(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayIndex = calendar.get(Calendar.DAY_OF_WEEK);
        if(dayIndex < 1 || dayIndex > 7){
            return  null;
        }
        return WEEK[dayIndex - 1];
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

    public  void InitData(){

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query("Room", null, null, null, null, null, null);
        if(cursor.moveToFirst()){
            do{
                //遍历Cursor对象，取出数据
                //              roomID text, "
                //            + "group1 text, "
                //            + "week text, "
                //            + "time text,"
                //            + "hour text)";
                if(cursor.getString(cursor.getColumnIndex("week")).equals(DateToWeek(date))){
                    Date dateNow = new Date(System.currentTimeMillis());
                    String timeNow = formatter.format(dateNow);
                    if(getTimeCompareSize(getTimeAdd(cursor.getString(cursor.getColumnIndex("time")),cursor.getString(cursor.getColumnIndex("hour"))),timeNow) == Behind_Bigger){
                        db.delete("Room","deleteID = ?",new String[]{cursor.getString(cursor.getColumnIndex("deleteID"))});
                        break;
                    }
                }

                Room room = new Room();
                room.setRoomID(cursor.getString(cursor.getColumnIndex("roomID")));
                room.setGroup(cursor.getString(cursor.getColumnIndex("group1")));
                room.setWeek(cursor.getString(cursor.getColumnIndex("week")));
                room.setTime(cursor.getString(cursor.getColumnIndex("time")));
                room.setHour(cursor.getString(cursor.getColumnIndex("hour")));
                roomList.add(room);


            }while(cursor.moveToNext());
//            recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
////            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
////            recyclerView.setLayoutManager(layoutManager);

            adapter_room = new RoomAdapter(RoomInfo.this,roomList);
            Log.d("TAG3"," " + roomList.size());
            recyclerView_room.setAdapter(adapter_room);

            //teamList.clear();

        }
        cursor.close();

    }

    @Override
    protected void onResume() {
        super.onResume();
        roomList.clear();
        InitData();
        //adapter.setData(teamList);
        //adapter.notifyDataSetChanged();


    }

}
