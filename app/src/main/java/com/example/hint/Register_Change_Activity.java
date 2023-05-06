package com.example.hint;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.ArrayList;
import java.util.List;

public class Register_Change_Activity extends AppCompatActivity {
    private EditText editText1,editText2,editText4,editText5;
    private Spinner spinner_group;
    List<String> group = new ArrayList<>();
    private List<Information>list=new ArrayList<>();
    private String str_group,name;
    private int num=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_2);
        name=getIntent().getStringExtra("real_name");
        Button button=findViewById(R.id.register2);
        Connector.getDatabase();
        editText1=findViewById(R.id.edit_1);
        editText2=findViewById(R.id.edit_2);
        spinner_group=findViewById(R.id.edit_3);
        editText4=findViewById(R.id.edit_4);
        editText5=findViewById(R.id.edit_5);
        initData();
        list= DataSupport.findAll(Information.class);
        for(Information i:list){
            num++;
            if(i.getRealName().equals(name)){
                editText1.setText(i.getNickName());
                editText2.setText(i.getRealName());
                editText4.setText(i.getIdNumber());
                editText5.setText(i.getPassWord());
                break;
            }
        }
        myAdapter(spinner_group,group);
        spinner_group.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                str_group = (String) spinner_group.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Information information=new Information();
                information.setNickName(editText1.getText().toString());
                information.setRealName(editText2.getText().toString());
                information.setGroup(str_group);
                information.setIdNumber(editText4.getText().toString());
                information.setPassWord(editText5.getText().toString());
                if(editText1.getText().toString()==null||editText2.getText().toString()==null||str_group==null||editText4.getText().toString()==null||editText5.getText().toString()==null){
                    Toast.makeText(Register_Change_Activity.this,"Incomplete information!",Toast.LENGTH_SHORT).show();
                }
                else if(editText4.getText().toString().length()!=12){
                    Toast.makeText(Register_Change_Activity.this,"Please enter the correct student ID",Toast.LENGTH_SHORT).show();
                }
                else if(editText5.getText().toString().length()!=6){
                    Toast.makeText(Register_Change_Activity.this,"Please enter a six digit password",Toast.LENGTH_SHORT).show();
                }
                else{
                    information.update(num);
                    Toast.makeText(Register_Change_Activity.this,"Registered successfully",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(Register_Change_Activity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
    private void myAdapter(Spinner spinner, List list) {

        SpinnerAdapter adapter = new SpinnerAdapter(this, R.layout.myspinner,list);
        spinner.setAdapter(adapter);
        //默认选择最后一项     support_simple_spinner_dropdown_item
        spinner.setSelection(list.size()-1,true);

    }
    private void initData(){
        group.add("DB组");
        group.add("微软组");
        group.add("宣传组");
        group.add("Geek组");
        group.add("JavaEE组");
        group.add("前端组");
        group.add("Android组");
        group.add("CPP组");
        group.add("算法组");
        group.add("iOS组");
        group.add("产品组");
        group.add("设计组");
        group.add("企划组");
        group.add("请选择你的组别");
    }

}
