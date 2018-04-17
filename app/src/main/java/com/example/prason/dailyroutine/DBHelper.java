package com.example.prason.dailyroutine;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Prason on 5/29/2017.
 */

public class DBHelper  extends SQLiteOpenHelper {
    public static final String dbName = "taskDB";
    public static final int VERSION = 1;
    public String tbName = "taskList";
    public DBHelper(Context context) {
        super(context, dbName,null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL("create table "+tbName+" (id integer primary key, day text, timeFrom text, timeTo text, taskDo text)");
  //  db.execSQL("create table contacts    (id integer primary key, name text,phone text,email text, street text,place text)");
    //create table contacts " +  "(id integer primary key, name text,phone text,email text, street text,place text)"

        // String DATABASE_CREATE = "create table "+"LOGIN( " +"ID"+" integer primary key autoincrement,"+ "USERNAME  text,PASSWORD text,UNAME text); ";
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS "+tbName);
        onCreate(db);
    }



    //to save the record of the task uploaded by the user;
    public boolean saveTask(String day, String from, String to , String task){
//        Toast.makeText(DBHelper.this,day+"-"+from+"-"+to+"-"+task,Toast.LENGTH_LONG).show();

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("day",day);
        contentValues.put("timeFrom",from);
        contentValues.put("timeTo",to);
        contentValues.put("taskDo",task);
        long val = db.insert(tbName,null, contentValues);
        return  true;
    }

    public Cursor getTask(String day) {
      SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from " + tbName + " where day=?", new String[]{day});
                                    //select * from contacts where id="+id+""
        return cursor;
    }

    public int removeTask(ListViewData obj){
        SQLiteDatabase db = this.getWritableDatabase();
        String id = String.valueOf(obj.getId());
        int result = db.delete(tbName,tbName+".id = ?",new String[]{id});
        return  result;
    }
}
