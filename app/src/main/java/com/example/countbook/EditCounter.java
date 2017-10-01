package com.example.countbook;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Edit a Counter
 *
 *  @author Shuyang Li
 *  @version 1.0
 *  @since 1.0
 *  @see CounterList
 */


public class EditCounter extends AppCompatActivity {


    private static final String FILENAME = "file.sav";
    private CounterList eList = new CounterList();
    private Context context;
    private EditText edit_name;
    private EditText edit_initialvalue;
    private EditText edit_currentvalue;
    private EditText edit_comment;
    private Counter  editCounter;
    int eindex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_count);
        context = getApplicationContext();
        Intent intent = getIntent();
        //get index from ViewCounter
        eindex = intent.getIntExtra("edit",-1);
        //load recorder to an empty counterList
        eList.loadAllRecord(context);
        //get this counterlist
        editCounter=eList.getCounter(eindex);
        //set text to EditText
        edit_name = (EditText) findViewById(R.id.edit_name);
        edit_name.setText(editCounter.getName());


        edit_initialvalue = (EditText) findViewById(R.id.edit_initial_value);
        edit_initialvalue.setText(editCounter.getInitialvalue());

        edit_comment = (EditText) findViewById(R.id.edit_comment);
        edit_comment.setText(editCounter.getComment());

        edit_currentvalue = (EditText) findViewById(R.id.edit_current_value);
        edit_currentvalue.setText(Integer.toString(editCounter.getCurrentvalue()));

        //implement Button
        Button deleteButton = (Button) findViewById(R.id.delete_button);
        Button incrementButton = (Button) findViewById(R.id.increase_button);
        Button decrementButton = (Button) findViewById(R.id.decrease_button);
        Button finishButton = (Button) findViewById(R.id.finish_button);
        Button resetButton = (Button) findViewById(R.id.reset_button);

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eList.deleteCounter(eindex);
                eList.saveInFile(context);
                Intent Intent1 = new Intent(EditCounter.this, MainActivity.class);
                startActivity(Intent1);
            }


        });

        decrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eList.decrementCurrentValue(eindex);
                eList.saveInFile(context);
                edit_currentvalue.setText(Integer.toString(editCounter.getCurrentvalue()));

            }


        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eList.resetCurrentValue(eindex);
                eList.saveInFile(context);
                edit_currentvalue.setText(Integer.toString(editCounter.getCurrentvalue()));

            }


        });

        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eList.incrementCurrentValue(eindex);
                eList.saveInFile(context);
                edit_currentvalue.setText(Integer.toString(editCounter.getCurrentvalue()));

            }

        });

        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tedit_name = edit_name.getText().toString();
                String tedit_comment = edit_comment.getText().toString();
                String tedit_initialvalue = edit_initialvalue.getText().toString();
                String tedit_currentvalue = edit_currentvalue.getText().toString();

                int a = Integer.parseInt(tedit_currentvalue);
                if (a != editCounter.getCurrentvalue()) {

                    eList.editCurrentvalue(eindex,a);

                }
                eList.editContents(eindex, tedit_name, tedit_comment,tedit_initialvalue);
                eList.saveInFile(context);
                Intent Intent2 = new Intent(EditCounter.this, MainActivity.class);
                startActivity(Intent2);

            }

        });


        


    }
}