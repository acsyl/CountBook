package com.example.countbook;

import android.content.Context;
import android.util.Log;
import android.widget.EditText;

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
import java.util.Date;

/**
 * Represent a CounterList
 *
 *  @author shuyang2
 *  @version 1.0
 *  @since 1.0
 *  @see Counter, CreateCounter, EditCounter, ViewCounter
 */

public class CounterList {
    private static final String FILENAME = "file.sav";
    private ArrayList<Counter> counterList;
    private Date date;

    public CounterList() {
        this.counterList = new ArrayList<Counter>();
    }

    public ArrayList<Counter> getCounterList(){
        return this.counterList;
    }

    // methods here
    public void addCounter(Counter newcounter){
        counterList.add(newcounter);


    }
    /**
     * delete Counter
     * @param i counterindex
     *
     */

    public void deleteCounter(int i){
        counterList.remove(i);
    }
    /**
     * increase Counter currentvalue
     * @param i counterindex
     *
     */
    public void incrementCurrentValue(int i){
        Counter incrementItem = counterList.get(i);
        date = new Date();
        incrementItem.setDate(date);
        int origin1 = incrementItem.getCurrentvalue();
        int increby1 = origin1+1;
        incrementItem.setCurrentvalue(increby1);
    }
    /**
     * decrease Counter currentvalue
     * @param i counterindex
     *
     */

    public void decrementCurrentValue(int i){
        Counter decrementItem = counterList.get(i);
        date = new Date();
        decrementItem.setDate(date);
        int origin2 = decrementItem.getCurrentvalue();
        int decreby1 = origin2-1;
        if (decreby1 == -1){
            decreby1=0;
        }
        decrementItem.setCurrentvalue(decreby1);
    }
    /**
     * reset Counter currentvalue
     * @param i counterindex
     *
     */

    public void resetCurrentValue(int i){
        Counter resetItem = counterList.get(i);
        date = new Date();
        resetItem.setDate(date);
        int inva = Integer.parseInt(resetItem.getInitialvalue());
        resetItem.setCurrentvalue(inva);


    }
    /**
     * edit Counter contents
     * @param i counterindex
     * @param name counter name
     * @param comment counter comment
     * @param initialvalue counter initialvalue
     */

    public void editContents(int i, String name, String comment, String initialvalue){
        Counter editItem = counterList.get(i);
        editItem.setName(name);
        editItem.setComment(comment);
        editItem.setInitialvalue(initialvalue);

    }
    /**
     * edit Counter currentvalue
     * @param i counterindex
     * @param currentvalue
     */

    public void editCurrentvalue(int i, int currentvalue){
        Counter editItem1 = counterList.get(i);
        //Log.d("sdfsdfs","sdffsf");
        date = new Date();
        editItem1.setDate(date);
        editItem1.setCurrentvalue(currentvalue);
    }

    public Counter getCounter(int i){
        return counterList.get(i);
    }

    public int numberOfCount(){
        return counterList.size();
    }

    /**
     * load Counter from file
     * @param context
     *
     */
    public void loadAllRecord(Context context) {
        try {
            //Log.d("number", "apple");
            FileInputStream fis = context.openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            // load the records to record list
            Gson gson = new Gson();
            // Taken from http://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylist
            // 2017-09-26
            Type listType =new TypeToken<ArrayList<Counter>>(){}.getType();
            //Log.d("number", "apple");
            this.counterList = gson.fromJson(in,listType);

        } catch (FileNotFoundException e) {
            this.counterList = new ArrayList<Counter>();
        }
//        catch (IOException e) {
//            // TODO Auto-generated catch block
//            throw new RuntimeException();
//        }

    }

    /**
     * save Counter to file
     * @param context
     *
     */


    public void saveInFile(Context context) {
        try {
            FileOutputStream fos = context.openFileOutput(FILENAME,
                    Context.MODE_PRIVATE);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
            Gson gson = new Gson();
            gson.toJson(this.counterList, out);
            out.flush();
            fos.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }
    }


}