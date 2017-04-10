package com.example.nawaralqadhy.myapplication;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;


public class Note extends Activity{
    EditText e1, e2;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        //get content from edittext
        final EditText e1 = (EditText) findViewById(R.id.editText);
        final EditText e2 = (EditText) findViewById(R.id.editText2);
        //save on click
        Button b = (Button) findViewById(R.id.save);
        b.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                String title = e1.getText().toString();
                String note = e2.getText().toString();
                Log.d("supernotes","title is --> "+title);
                Log.d("supernotes","note is --> "+note);

                // 3. after saving, we will read the data v

                BufferedWriter writer = null;

                try {
                    //writing to a file using fileoutputstream and file will be saved in data folder as notes
                    FileOutputStream openedFile = openFileOutput("notes", MODE_APPEND);

                    writer = new BufferedWriter(new OutputStreamWriter(openedFile));

                    String eol = System.getProperty("line.separator");
                    writer.append(title + eol);
                    writer.append(note + eol);
                    writer.append(eol);
                    writer.close();

                    // go to ReadActivity to read the file
                    //gotoRead();

                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }



            }
        });

    }

//this was the other way i tried to perform save was not quite successfull so commented.

}

//        String note = load();
//        if(note == null) {
//            Toast.makeText(this, "Everything is wrong", Toast.LENGTH_LONG).show();
//
//        }
//        if(note != null) {
//            String[] arr = note.split("%");
//            try {
//                e1.setText(arr[0]);
//                e2.setText(arr[1]);
//            }catch (IndexOutOfBoundsException e) {
//                Toast.makeText(this, "Something is wrong", Toast.LENGTH_LONG).show();
//            }
//        }
//        b.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //saving the text entered
//                saveNote(e1.getText().toString(), e2.getText().toString());
//            }
//        });
//    }
//
//    private String load() {
//        String note = "";
//        try {
//            File f = new File("notes.txt");
//            FileInputStream fs = new FileInputStream(f);
//            int content;
//            char c;
//            while((content = fs.read()) != -1) {
//                c = (char) content;
//                note += c;
//            }
//        }catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//        return note;
//    }
//    private void saveNote(String title, String note) {
//        //if nothing is entered
//        if (title == "" || note == "") {
//            Toast.makeText(this, "Text field is empty", Toast.LENGTH_LONG).show();
//        }
//        note = title + "%" + note;
//        //else
//        try {
//            byte[] s = note.getBytes();
//            FileOutputStream fo = openFileOutput("notes.txt", MODE_WORLD_WRITEABLE);
//            fo.write(s);
//            fo.close();
//            Toast.makeText(this, "Save successfull", Toast.LENGTH_LONG).show();
//        }
//        catch ( IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
