package com.example.hint;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RoomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Room> mlist ;
    private Context mContext;



    public RoomAdapter(Context context, List<Room> list){
        mContext = context;
        mlist = list;
        Log.d("TAG4"," " + mlist.size());
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView iv_roomID;
        TextView iv_group;
        TextView iv_week;
        TextView iv_time;
        TextView iv_hour;

        private ViewHolder (View view){
            super(view);
            iv_roomID = (TextView) view.findViewById(R.id.roomID);
            iv_group = (TextView) view.findViewById(R.id.group_name);
            iv_week = (TextView) view.findViewById(R.id.week);
            iv_time = (TextView) view.findViewById(R.id.time_room);
            iv_hour = (TextView) view.findViewById(R.id.hour);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.room_list,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;

    }



    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


            final Room room = mlist.get(position);

            ((ViewHolder) holder).iv_roomID.setText("Room ID:" + room.getRoomID());
            ((ViewHolder) holder).iv_hour.setText("Estimated occupancy time" + room.getHour());
            ((ViewHolder) holder).iv_time.setText(room.getTime());
            ((ViewHolder) holder).iv_week.setText(room.getWeek());
            ((ViewHolder) holder).iv_group.setText(room.getGroup());

        }


//        Log.d("TAG2","Book name " + team.getTeamName());
//        Log.d("TAG2","Book author " + team.getTeam_details());




    @Override
    public int getItemCount() {
        return mlist.size();
    }

}
