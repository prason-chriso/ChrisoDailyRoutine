package com.example.prason.dailyroutine;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button showTask,addTask;
    public static final int TO_SHOW = 1;
    public static final int TO_ADD = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onStart() {
        super.onStart();
        showTask  = (Button)findViewById(R.id.show);
        addTask = (Button)findViewById(R.id.add);
        addTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putInt("key", TO_ADD);
                Intent i = new Intent(MainActivity.this, DaySelect.class);
                i.putExtras(b);
                startActivity(i);
            }
        });

        showTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putInt("key", TO_SHOW);
                Intent i = new Intent(MainActivity.this, DaySelect.class);
                i.putExtras(b);
                startActivity(i);
            }
        });
    }
}
