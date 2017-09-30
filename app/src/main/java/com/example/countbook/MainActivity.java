package com.example.countbook;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.text.AlphabeticIndex;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

import static com.example.countbook.R.id.parent;

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
//        adapter = new ArrayAdapter<Counter>(this,
//                R.layout.count_list_item, TList.getCounterList());
//        OldCountsList.setAdapter(adapter);
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
        TList.loadAllRecord(context);
        countTextView.setText(String.format("shuyang2-CountBook\ncount: %s", TList.numberOfCount()));
        //Log.d("number", Integer.toString(TList.numberOfCount()));

        //TList.saveInFile()
        adapter = new ArrayAdapter<Counter>(this,
                R.layout.count_list_item, TList.getCounterList());
        OldCountsList.setAdapter(adapter);
   }


//        });
//    }


//
//    }
//    @Override
//    protected void onResume() {
//        super.onResume();
//        CountList.clear();
//        loadAllRecord();
//        adapter.notifyDataSetChanged();
//    }




}



