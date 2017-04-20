package com.example.nawaralqadhy.myapplication;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Read_Notes extends Activity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read);

        //read the file and set the text of the textview

        BufferedReader reader = null;

        try {
            FileInputStream noteFile = openFileInput("notes");

            reader = new BufferedReader(new InputStreamReader(noteFile));
            String eol = System.getProperty("line.separator");
            String line;
            StringBuilder sb = new StringBuilder();

            TextView tvNotes = (TextView) findViewById(R.id.notes);

            while((line = reader.readLine()) != null){
                sb.append(line).append(eol);
            }

            tvNotes.setText(sb.toString());

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //clear the file
        final String text = "";
        Button button = (Button) findViewById(R.id.clear);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                try {
                    FileOutputStream fileout=openFileOutput("notes",0); //false will set the append mode to false
                    OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
                    outputWriter.write(text);
                    outputWriter.close();
                    Toast.makeText(getApplicationContext(), "file cleared successfully",
                            Toast.LENGTH_LONG).show();
                    TextView m = (TextView) findViewById(R.id.notes);
                    m.setText("");
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        Intent i = new Intent(this, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }

}
