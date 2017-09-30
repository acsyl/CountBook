package com.example.countbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import static android.provider.Telephony.Mms.Part.FILENAME;

//package com.example.countbook;

import android.content.Context;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.BufferedWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Date;


/**
 * Created by ACsy on 2017-09-25.
 */
public class ViewCounter extends AppCompatActivity {


    private static final String FILENAME = "file.sav";
    private CounterList sList = new CounterList();
    private Context context;
    private TextView select_name;
    private TextView select_date;
    private TextView select_initialvalue;
    private TextView select_currentvalue;
    private TextView select_comment;
    private Counter selectCounter;
    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_counter);
        context = getApplicationContext();
        sList.loadAllRecord(context);
        select_name = (TextView) findViewById(R.id.view_name);
        select_date = (TextView) findViewById(R.id.view_date);
        select_initialvalue = (TextView) findViewById(R.id.view_initial_value);
        select_currentvalue = (TextView) findViewById(R.id.view_current_value);
        select_comment = (TextView) findViewById(R.id.view_comment);
        Intent intent = getIntent();
        index = intent.getIntExtra("info",-1);
//        abc.setText(Integer.toString(index));

        selectCounter=sList.getCounter(index);
        String Name=selectCounter.getName();
        select_name.setText(Name);
        Date Date=selectCounter.getDate();
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        String reportDate = df.format(Date);
        select_date.setText(reportDate);
        String initialvalue = selectCounter.getInitialvalue();
        select_initialvalue.setText(initialvalue);
        int currentvalue = selectCounter.getCurrentvalue();
        select_currentvalue.setText(Integer.toString(currentvalue));
        String comment = selectCounter.getComment();
        select_comment.setText(comment);

        //String sindex=Integer.toString(index);

        Button EditButton = (Button) findViewById(R.id.edit_button);
        Button CancelButton = (Button) findViewById(R.id.cancel_button);
//
        EditButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent edit_intent = new Intent(ViewCounter.this, EditCounter.class);
                    edit_intent.putExtra("edit",index);
                    startActivity(edit_intent);
            }
        });
        CancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(ViewCounter.this, MainActivity.class);
                startActivity(intent3);
            }
        });
    }
}
