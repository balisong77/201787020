package com.example.hint;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editText1,editText2;
    private Button register,login;
    private List<Information>list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LitePal.getDatabase();
        Input_SQL input_sql;
        input_sql = new Input_SQL(MainActivity.this);
        register=findViewById(R.id.register);
        login=findViewById(R.id.login);
        register.setOnClickListener(this);
        login.setOnClickListener(this);
        editText1=findViewById(R.id.first);
        editText2=findViewById(R.id.second);
    }

    @Override
    public void onClick(View view) {
        String ID=editText1.getText().toString();
        String PASS=editText2.getText().toString();
        switch(view.getId()){
            case R.id.register:
                Intent intent=new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.login:
                list= DataSupport.findAll(Information.class);
                for(Information i:list){
                    if(i.getIdNumber().equals(ID)&&i.getPassWord().equals(PASS)){
                        Intent intent1=new Intent(MainActivity.this, Fragement_home.class);
                        intent1.putExtra("RealName",i.getRealName());
                        startActivity(intent1);
                        Toast.makeText(this,"Login success",Toast.LENGTH_SHORT).show();
                        saved(i);
                        finish();
                        break;}
                    else {
                        Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
             default:break;
        }
    }
    public void saved(Information i)
    {
        Login_user login_user = new Login_user();
        login_user.setNickName(i.getNickName());
        login_user.setGroup(i.getGroup());
        login_user.setIdNumber(i.getIdNumber());
        login_user.setType("loging");
        login_user.setRealName(i.getRealName());
        login_user.updateAll("type = ?","loging");
    }
}
