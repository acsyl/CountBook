package com.example.countbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Date;


/**
 * View a Counter
 *
 *  @author Shuyang Li
 *  @version 1.0
 *  @since 1.0
 *  @see CounterList
 */

/*＊
* ViewList Class
*
* When user try to get the detailed information, MainActivity will call this method
*
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
        // get Textview
        select_name = (TextView) findViewById(R.id.view_name);
        select_date = (TextView) findViewById(R.id.view_date);
        select_initialvalue = (TextView) findViewById(R.id.view_initial_value);
        select_currentvalue = (TextView) findViewById(R.id.view_current_value);
        select_comment = (TextView) findViewById(R.id.view_comment);
        // get Intent
        Intent intent = getIntent();
        index = intent.getIntExtra("info",-1);
        selectCounter=sList.getCounter(index);
        String Name=selectCounter.getName();
        select_name.setText(Name);
        Date Date=selectCounter.getDate();
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        String reportDate = df.format(Date);
        // set view
        select_date.setText(reportDate);
        String initialvalue = selectCounter.getInitialvalue();
        select_initialvalue.setText(initialvalue);
        int currentvalue = selectCounter.getCurrentvalue();
        select_currentvalue.setText(Integer.toString(currentvalue));
        String comment = selectCounter.getComment();
        select_comment.setText(comment);


        Button EditButton = (Button) findViewById(R.id.edit_button);
        Button CancelButton = (Button) findViewById(R.id.cancel_button);
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
