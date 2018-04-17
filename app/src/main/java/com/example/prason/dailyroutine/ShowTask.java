package com.example.prason.dailyroutine;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Prason on 5/29/2017.
 */

public class ShowTask extends AppCompatActivity {
    DBHelper mydb;
    String day;
    TextView title;
    ListView myList;
    List<ListViewData> taskList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
        mydb = new DBHelper(this);
        taskList = new ArrayList<ListViewData>();
    }

    @Override
    protected void onStart() {
        super.onStart();
        day = this.getIntent().getExtras().getString("day");
        title = (TextView) findViewById(R.id.dayTitle);
        title.setText(day);
        if(showTask()){
            myList = (ListView) findViewById(R.id.myList);
            MyAdapterClass adapterClass = new MyAdapterClass(ShowTask.this, taskList,mydb);
            myList.setAdapter(adapterClass);
        //Toast.makeText(getApplicationContext(),taskList.get(0).getTask()+"-"+taskList.get(0).getId(),Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"cannot display data ",Toast.LENGTH_LONG).show();
        }
    }


    public boolean showTask() {

        Cursor cursor = mydb.getTask(day);
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int id = cursor.getInt(cursor.getColumnIndex("id"));
                String day = cursor.getString(cursor.getColumnIndex("day"));
                String from = cursor.getString(cursor.getColumnIndex("timeFrom"));
                String to = cursor.getString(cursor.getColumnIndex("timeTo"));
                String task = cursor.getString(cursor.getColumnIndex("taskDo"));
                ListViewData obj = new ListViewData(from, to, task, id,day);
                obj.setTask(task);
                obj.setTimeFrom(from);
                obj.setTimeTo(to);
                obj.setId(id);
                obj.setDay(day);
                taskList.add(obj);
            }
        } else {
            Toast.makeText(this, "No data to show", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
