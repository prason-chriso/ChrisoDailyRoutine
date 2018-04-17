package com.example.prason.dailyroutine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Prason on 5/29/2017.
 */

public class AddTaskJava extends AppCompatActivity{
    EditText from, to, task;
    Button add;
    String day;
    //creating  the instance of the data base
    DBHelper mydb ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addtask);
        mydb = new DBHelper(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        day = this.getIntent().getExtras().getString("day");
    from  = (EditText)findViewById(R.id.editFrom);
    to  = (EditText)findViewById(R.id.editTo);
    task  = (EditText)findViewById(R.id.editTask);
        add = (Button)findViewById(R.id.btnAdd);

        add.setOnClickListener(new View.OnClickListener() {
                @Override
            public void onClick(View v) {
                  //  Toast.makeText(AddTaskJava.this, day+","+from.getText().toString()+","+to.getText().toString()+","+task.getText().toString(),Toast.LENGTH_LONG).show();
                    boolean success = mydb.saveTask(day,from.getText().toString(),to.getText().toString(),task.getText().toString());
                    if(success){
                        task.setText("");
                        to.setText("");
                        from.setText("");
                        Toast.makeText(AddTaskJava.this,"data is saved",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(AddTaskJava.this,"data is not saved",Toast.LENGTH_SHORT).show();

                    }
                }
        });

    }
}
