package com.example.nawaralqadhy.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calculator, calender, time, note,read;
        // Nawar Alqadhy n


// get the reference of Button's
        calculator = (Button) findViewById(R.id.calculator);
        calender = (Button) findViewById(R.id.calender);
        time = (Button) findViewById(R.id.time);
        note = (Button) findViewById(R.id.note);
        read = (Button) findViewById(R.id.read);
// perform setOnClickListener event on First Button
        calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// load First Activity
                calculator();
            }
        });
// perform setOnClickListener event on Second Button
        calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// load Second Activity
                calender();
            }
        });
        //setonclicklistner for third button
        time.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //load third activity
                time();
            }
        });
        //setonclicklistner for fourth button
        note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // load fourth activity
                note();
            }
        });
//setonclicklistner for fifth button
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // load fifth activity
                read();
            }
        });

    }
    private void calculator() {

        Intent intent1 = new Intent(this, Calculator.class);
        startActivity(intent1);
    }
    private void calender() {

        Intent intent2 = new Intent(this, Calender.class);
        startActivity(intent2);
    }
    private void time() {
        Intent intent= new Intent(this, Time_now.class);
        startActivity(intent);
    }
    private void note() {
        Intent intent = new Intent(this, Note.class);
        startActivity(intent);
    }

    protected void read() {
        Intent i = new Intent(this, Read_Notes.class);
        startActivity(i);
    }

}
