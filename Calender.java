package com.example.nawaralqadhy.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

public class Calender extends AppCompatActivity {
    CalendarView simpleCalendarView;
// Nawar Alqadhy n
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);

        simpleCalendarView = (CalendarView) findViewById(R.id.simpleCalendarView); // get the reference of CalendarView
        simpleCalendarView.setFocusedMonthDateColor(Color.RED); // set the red color for the dates of  focused month
        simpleCalendarView.setUnfocusedMonthDateColor(Color.BLUE); // set the yellow color for the dates of an unfocused month
        simpleCalendarView.setSelectedWeekBackgroundColor(Color.RED); // red color for the selected week's background
        simpleCalendarView.setWeekSeparatorLineColor(Color.GREEN); // green color for the week separator line
        // perform setOnDateChangeListener event on CalendarView

        simpleCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                // display the selected date by using a toast
                Toast.makeText(getApplicationContext(), dayOfMonth + "/" + month + "/" + year, Toast.LENGTH_LONG).show();
            }
        });

    }
}
