package com.example.hint;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Input_SQL {
    private SQL_helper myhelper;
    private Context mcontext;
    public Input_SQL(Context context)
    {
        mcontext = context;
        myhelper = new SQL_helper(mcontext,"BOOKSTORE",null,1);
        myhelper.getWritableDatabase();
        SQLiteDatabase db= myhelper.getWritableDatabase();
        Cursor cursor =db.query("Book",null,null,null,null,null,null);
        if (!cursor.moveToFirst()) {
            Input("《三国演义》", "罗贯中", "Borrowable",R.drawable.book1,db);
            Input("《红楼梦》", "曹雪芹", "Borrowed",R.drawable.book3,db);
            Input("《大学物理（上）》", "佚名", "Borrowed",R.drawable.book2,db);
            Input("《大学物理（下）》", "佚名", "Borrowable",R.drawable.book6,db);
            Input("《高等数学》","佚名","Borrowed",R.drawable.book3,db);
            Input("《十万个为什么？》", "佚名", "Borrowed",R.drawable.book4,db);
            Input("《阳光劫匪日常与袭击》", "伊坂幸太郎", "Borrowable",R.drawable.book2,db);
            Input("《追风筝的人》", "卡勒德 胡赛尼", "Borrowed",R.drawable.book1,db);
            Input("《明朝那些事》", "当年明月", "Borrowed",R.drawable.book6,db);
            Input("《浪花少年侦探团》", "东野奎吾", "Borrowable",R.drawable.book5,db);
            Input("《三体（上）》", "刘慈欣", "  Borrowed",R.drawable.book1,db);
            Input("《三体（中）》", "刘慈欣", "Borrowed",R.drawable.book4,db);
            Input("《三体（下）》", "刘慈欣", "Borrowable",R.drawable.book3,db);
            Input("《龙族》", "江南", "Borrowed",R.drawable.book2,db);
            Login_user login_user = new Login_user();
            login_user.setType("loging");
            login_user.setIdNumber("000000000000");
            login_user.setGroup(null);
            login_user.setNickName("admin");
            login_user.save();
        }
    }
    public void Input(String a,String b,String c,int d,SQLiteDatabase db){

        ContentValues values = new ContentValues();
        values.put("name",a);
        values.put("author",b);
        values.put("free",c);
        values.put("num",d);
        db.insert("Book",null,values);
    }
}
