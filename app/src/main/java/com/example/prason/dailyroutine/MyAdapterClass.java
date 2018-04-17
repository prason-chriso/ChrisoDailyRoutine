package com.example.prason.dailyroutine;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Prason on 6/2/2017.
 */

public class MyAdapterClass extends BaseAdapter {
    Context context;
  //  int resource;
    List<ListViewData> myData;
    LayoutInflater inflater;
    DBHelper dbHelper;

    MyAdapterClass(ShowTask context, List<ListViewData> myData, DBHelper dbHelper){
        this.context = context;
    //    this.resource = resource;
        this.dbHelper = dbHelper;
        this.myData = myData;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return myData.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position,  View convertView, final ViewGroup parent) {
        convertView = inflater.inflate(R.layout.viewlayout, parent, false);
      //  final int viewIndex  = parent.indexOfChild(convertView);
        TextView tv1 = (TextView) convertView.findViewById(R.id.fromTo);
        TextView tv2 = (TextView) convertView.findViewById(R.id.taskDetail);
        Button delete = (Button) convertView.findViewById(R.id.btndelete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.removeTask(myData.get(position));
               removeItem(myData.get(position));


            }
        });
        tv1.setText(myData.get(position).getTimeFrom() + " To " + myData.get(position).getTimeTo());
        tv2.setText(myData.get(position).getTask());
        return convertView;

    }

    public void removeItem(ListViewData index){
        Toast.makeText(context,index+" is deleted ",Toast.LENGTH_LONG).show();
        myData.remove(index);
        notifyDataSetChanged();
  }
}

