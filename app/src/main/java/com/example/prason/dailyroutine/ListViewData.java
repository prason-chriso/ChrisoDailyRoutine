package com.example.prason.dailyroutine;

import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Prason on 5/30/2017.
 */

public class ListViewData {
    String timeFrom,timeTo, task, day;
    int id;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ListViewData(String timeFrom, String timeTo, String task, int id, String day) {
        this.timeTo = timeTo;
        this.timeFrom = timeFrom;
        this.task = task;
        this.id = id;
        this.day = day;
    }

    public String getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(String timeFrom) {
        this.timeFrom = timeFrom;
    }

    public String getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(String timeTo) {
        this.timeTo = timeTo;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
