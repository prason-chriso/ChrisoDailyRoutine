package com.example.prason.dailyroutine;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Prason on 5/29/2017.
 */

public class DaySelect extends AppCompatActivity implements View.OnClickListener{
    public String DAY = "";
    Button sun, mon, tue, wed, thu, fri, sat;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_routine);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //now,initializing the components;
        sun = (Button)findViewById(R.id.sun);
        mon = (Button)findViewById(R.id.mon);
        tue = (Button)findViewById(R.id.tue);
        wed = (Button)findViewById(R.id.wed);
        thu = (Button)findViewById(R.id.thu);
        fri = (Button)findViewById(R.id.fri);
        sat = (Button)findViewById(R.id.sat);

        sun.setOnClickListener((View.OnClickListener) this);
        mon.setOnClickListener((View.OnClickListener) this);
        tue.setOnClickListener((View.OnClickListener) this);
        wed.setOnClickListener((View.OnClickListener) this);
        thu.setOnClickListener((View.OnClickListener) this);
        fri.setOnClickListener((View.OnClickListener) this);
        sat.setOnClickListener((View.OnClickListener) this);
        //sun.setOnClickListener((View.OnClickListener) this);

    }


    @Override
    public void onClick(View v) {
        if(v == sun){
            DAY = "sun";
           loadActivity(getvalue());
        }
        else if(v == mon){
            DAY = "mon";
            loadActivity(getvalue());
        }
        else if(v == tue){
            DAY = "tue";
            loadActivity(getvalue());
        }
        else if(v == wed){
            DAY = "wed";
            loadActivity(getvalue());

        }
        else if(v == thu){
            DAY = "thu";
            loadActivity(getvalue());

        }
        else if(v == fri){
            DAY = "fri";
            loadActivity(getvalue());

        }
        else if(v == sat){
            DAY = "sat";
            loadActivity(getvalue());

        }

    }
    public void loadActivity(int val){
        //if the parent button is the add then do this
        if(val==0){
            //if 0 then execute the add
            Bundle b = new Bundle();
            b.putString("day",DAY);
            Intent i = new Intent(DaySelect.this,AddTaskJava.class);
            i.putExtras(b);
            startActivity(i);
        }
        else if(val == 1){
            Toast.makeText(this,"Request To show for "+DAY, Toast.LENGTH_LONG).show();
            //if 1 then execute the show
            Bundle b1 = new Bundle();
            b1.putString("day",DAY);
            Intent i = new Intent(DaySelect.this, ShowTask.class);
            i.putExtras(b1);
            startActivity(i);
        }
        else{
            Toast.makeText(this,"Error in the code ", Toast.LENGTH_LONG).show();
        }
    }

    public int getvalue(){
        int i = this.getIntent().getExtras().getInt("key");
        return i;

    }
}
