package com.example.hint;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Fragement_home extends AppCompatActivity {
    LinearLayout homeLinear;
    LinearLayout listLinear;
    private ImageView plus;
    MyFragement fragmentHome,fragmentList,fragmentplus,fragmentUser;
    private FragmentManager mfragmentManger;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragement_home);
        homeLinear = findViewById(R.id.frage_home);
        listLinear = findViewById(R.id.frage_intro);
        plus = findViewById(R.id.frage_plus);
        mfragmentManger = getSupportFragmentManager();

        final Intent intent_get = getIntent();


        homeLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = mfragmentManger.beginTransaction();//只能是局部变量，不能为全局变量，否则不能重复commi
                hideAllFragment(fragmentTransaction);
                setAllFalse();
                homeLinear.setSelected(true);
                fragmentHome = new MyFragement(2,intent_get.getStringExtra("RealName"));
                fragmentTransaction.replace(R.id.frage_fra, fragmentHome);
                fragmentTransaction.commit();
            }
        });
        listLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = mfragmentManger.beginTransaction();//只能是局部变量，不能为全局变量，否则不能重复commi
                hideAllFragment(fragmentTransaction);
                setAllFalse();
                listLinear.setSelected(true);
                fragmentList=new MyFragement(1,intent_get.getStringExtra("RealName"));
                fragmentTransaction.replace(R.id.frage_fra,fragmentList);
                fragmentTransaction.commit();
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = mfragmentManger.beginTransaction();//只能是局部变量，不能为全局变量，否则不能重复commi
                hideAllFragment(fragmentTransaction);
                setAllFalse();
                plus.setSelected(true);
                fragmentplus=new MyFragement(3,intent_get.getStringExtra("RealName"));
                fragmentTransaction.replace(R.id.frage_fra,fragmentplus);
                fragmentTransaction.commit();
            }
        });
        listLinear.performClick();
    }
    private void hideAllFragment(FragmentTransaction fragmentTransaction) {
        if(fragmentHome!=null){
            fragmentTransaction.hide(fragmentHome);
        }
        if(fragmentUser!=null){
            fragmentTransaction.hide(fragmentUser);
        }
    }
    private void setAllFalse() {
        homeLinear.setSelected(false);
        listLinear.setSelected(false);
        plus.setSelected(false);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder=new AlertDialog.Builder(Fragement_home.this);
        builder.setMessage("Sure to exit？");
        builder.setTitle("dialog");
        builder.setPositiveButton("confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.setNegativeButton("cancel",null);
        builder.create().show();
    }
}
