package com.example.countbook;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


/**
 *  view Counter ListView
 *
 *  @author Shuyang Li
 *  @version 1.0
 *  @since 1.0
 *  @see ViewCounter
 */



/*＊
 * MainActivity
 *
 * The main activity for the application, mainly responsible for displaying
 * the ListView of counter.
 *
 *
 */
public class MainActivity extends AppCompatActivity {
    private static final String FILENAME = "file.sav";
    private ListView OldCountsList;
    private ArrayAdapter<Counter> adapter;
    private TextView countTextView;
    private CounterList TList = new CounterList();
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();
        countTextView = (TextView) findViewById(R.id.textView2);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, CreateCounter.class);
                startActivity(intent1);

            }
        });
        OldCountsList = (ListView) findViewById(R.id.OldCountsList);
        TList.loadAllRecord(context);
        countTextView.setText(String.format("shuyang2-CountBook\ncount: %s", TList.numberOfCount()));
        // when listview clicked, intent to ViewCounter class
        OldCountsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent infoIntent = new Intent(MainActivity.this, ViewCounter.class);
                infoIntent.putExtra("info",position);
                //Log.d("index:","sd");
                startActivity(infoIntent);
            }
        });

}
    @Override
    protected void onStart() {
        super.onStart();
        //update the view
        TList.loadAllRecord(context);
        countTextView.setText(String.format("shuyang2-CountBook\ncount: %s", TList.numberOfCount()));

        adapter = new ArrayAdapter<Counter>(this,
                R.layout.count_list_item, TList.getCounterList());
        OldCountsList.setAdapter(adapter);
   }




}



