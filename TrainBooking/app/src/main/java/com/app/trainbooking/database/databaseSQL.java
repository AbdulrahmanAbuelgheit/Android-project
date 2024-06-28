package com.app.trainbooking.database;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class databaseSQL extends SQLiteOpenHelper {
    public static final String nanmeDatabaseSql="app.db";
    public databaseSQL(Context con) {
        super(con,nanmeDatabaseSql, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users(id INTEGER primary key AUTOINCREMENT , name TEXT , password TEXT ,email TEXT  ) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS student");
        onCreate(db);
    }
    public String insertdata(String n, String p,String e){
        SQLiteDatabase s=this.getReadableDatabase();
        ContentValues values=new ContentValues();
        values.put("name",n);
        values.put("password",p);
        values.put("email",e);

        long res=  s.insert("users",null,values);
        if (res==-1)
            return "error";

        else
            return "inserted row";
    }
    public ArrayList Getdata() {
        ArrayList  arrayList = new ArrayList ();
        SQLiteDatabase s=this.getReadableDatabase();
        Cursor c=s.rawQuery("select * from users",null);
        c.moveToFirst();

        while (c.isAfterLast()==false){
            arrayList.add(c.getString(1));
            c.moveToNext();
        }
        return arrayList;
    }
    public Boolean checkdatasaved(String name, String password){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from users where name = ? and password = ?", new String[]{name, password});
        if (cursor.getCount() > 0) {
            return true;
        }else {
            return false;
        }
    }
}

