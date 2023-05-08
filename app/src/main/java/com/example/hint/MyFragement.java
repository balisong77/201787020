package com.example.hint;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class MyFragement extends Fragment {
    private int type;
    private String namePublisher;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private TextView tx1,tx2,tx3,tx4,tx5;

    MyFragement(int i, String name){
        type = i;
        namePublisher = name;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = null;
        //左侧签到页
        if (type==1) {
            Intent intent = new Intent(getContext(), BarchartActivity.class);
            startActivity(intent);
//            view = inflater.inflate(R.layout.frage_fistpage, container, false);
//            btn1 = view.findViewById(R.id.frag_qiandao);
//            btn1.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent intent = new Intent(getContext(),BarchartActivity.class);
//                    startActivity(intent);
//                }
//            });
        }
        //个人信息页
        if (type==2){
            view = inflater.inflate(R.layout.frag_my_home, container, false);
            tx1 = view.findViewById(R.id.frag_home_shuji);
            tx2 = view.findViewById(R.id.home_ziliao);
            tx3 = view.findViewById(R.id.home_myteam);
            tx4 = view.findViewById(R.id.home_id);
            tx5 = view.findViewById(R.id.home_identy);
            Login_user login_user = DataSupport.findFirst(Login_user.class);
            tx4.setText(login_user.getNickName());
            tx5.setText(login_user.getGroup());
            tx1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getContext(), Show_mybook.class);
                    startActivity(intent);
                }
            });
            tx2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getContext(), Register_Change_Activity.class);
                    intent.putExtra("real_name",namePublisher);
                    startActivity(intent);
                }
            });
            tx3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getContext(), MyTeam.class);
                    intent.putExtra("RealName_myFrag",namePublisher);
                    startActivity(intent);
                }
            });
        }
        // 加号首页
        if (type==3){
            view = inflater.inflate(R.layout.menu, container, false);
            btn2 = view.findViewById(R.id.frag_book);
            btn3 = view.findViewById(R.id.frag_huiyi);
            btn4 = view.findViewById(R.id.frag_team);
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getContext(), Show_allbooks.class);
                    startActivity(intent);
                }
            });
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getContext(), RoomInfo.class);
                    startActivity(intent);
                }
            });
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getContext(), TeamInfo.class);
                    intent.putExtra("RealName_myFrag",namePublisher);
                    startActivity(intent);
                }
            });
        }
        return view;
    }
}
