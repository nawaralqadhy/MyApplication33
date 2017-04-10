package com.example.nawaralqadhy.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Time_now extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        TextView tv;
        tv = (TextView) findViewById(R.id.time_display);
        //time using simpledateformat
        SimpleDateFormat df = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm");
        //getting date into string
        String s = df.format(Calendar.getInstance().getTime());
        //setting it to textview
        tv.setText(s);
    }
}
