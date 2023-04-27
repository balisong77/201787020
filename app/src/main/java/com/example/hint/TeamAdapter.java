package com.example.hint;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class TeamAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Team> mlist ;
    private Context mContext;

    private MyDatabaseHelper dbHelper;
    private String teamPublisher;

//    private final int HEADER_ITEM = 0;
//    private final int NORMAL_ITEM = 1;

    public TeamAdapter(Context context, List<Team> list, String name){
        mContext = context;
        mlist = list;
        teamPublisher = name;
        Log.d("REAL",teamPublisher + "adapter");
        Log.d("TAG4"," " + mlist.size());
    }

//    public class ViewHolder2 extends RecyclerView.ViewHolder{
//
//        Button bt_pass1;
//
//        public ViewHolder2(@NonNull View itemView) {
//            super(itemView);
//            bt_pass1 = itemView.findViewById(R.id.button_pass1);
//        }
//    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView itemView;
        TextView itemView2;
        TextView itemView3;
        ConstraintLayout constraintLayout;

        private ViewHolder (View view){
            super(view);
            itemView = (TextView) view.findViewById(R.id.game);
            itemView2 = (TextView) view.findViewById(R.id.boss);
            itemView3 = (TextView) view.findViewById(R.id.change);
            constraintLayout = (ConstraintLayout) view.findViewById(R.id.team_list);

        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.team_list,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;

//        View view = null;
//        RecyclerView.ViewHolder holder = null;
//        if(viewType == HEADER_ITEM){
//            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.button_only,parent,false);
//            RecyclerView.ViewHolder viewHolder_h = new ViewHolder2(view);
//            holder = viewHolder_h;
//        }
//        if(viewType == NORMAL_ITEM){
//            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.team_list,parent,false);
//            RecyclerView.ViewHolder viewHolder_v = new ViewHolder(view);
//            holder = viewHolder_v;
//        }
//        return holder;

    }



    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//        if(holder instanceof ViewHolder2){
//            ((ViewHolder2) holder).bt_pass1.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(mContext,TeamOut.class);
//                    mContext.startActivity(intent);
//                }
//            });
//        }
        if(holder instanceof ViewHolder){
            final Team team = mlist.get(position );
            ((ViewHolder) holder).constraintLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(teamPublisher.equals(team.getBossName())) {
                        Intent intent2 = new Intent(mContext, TeamDetails.class);
                        intent2.putExtra("TeamName", team.getTeamName());
                        intent2.putExtra("Team_details", team.getTeam_details());
                        intent2.putExtra("Team_member", team.getMembers());
                        intent2.putExtra("TeamPublisher",team.getBossName());
                        mContext.startActivity(intent2);
                    }else{
                        Intent intent_v = new Intent(mContext,TeamDetails_Visitor.class);
                        intent_v.putExtra("TeamName", team.getTeamName());
                        intent_v.putExtra("Team_details", team.getTeam_details());
                        intent_v.putExtra("Team_member", team.getMembers());
                        intent_v.putExtra("TeamPublisher",team.getBossName());
                        mContext.startActivity(intent_v);
                    }
                }
            });
            ((ViewHolder) holder).itemView.setText(team.getTeamName());
            ((ViewHolder) holder).itemView2.setText("发起人：" + team.getBossName());
            ((ViewHolder) holder).itemView3.setText("招募中");

        }


//        Log.d("TAG2","Book name " + team.getTeamName());
//        Log.d("TAG2","Book author " + team.getTeam_details());

    }


    @Override
    public int getItemCount() {
        return mlist.size();
    }

//    @Override
//    public int getItemViewType(int position) {
//        int flag = 0;
//        if(position == 0){
//            flag = 0;
//        }else{
//            flag = 1;
//        }
//        return flag;
//    }
}
