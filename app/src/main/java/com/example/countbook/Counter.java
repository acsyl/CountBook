package com.example.countbook;
import android.util.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ACsy on 2017-09-25.
 */

public class Counter {

    private  String name;
    private  String currentvalue;
    private  String initialvalue;
    private  String comment;
    private  Date date;

    public Counter (String name, String initialvalue, String comment){
        this.name = name;
        this.currentvalue = initialvalue;
        this.initialvalue = initialvalue;
        this.comment = comment;
        this.date = new Date();
//        this.currentvalue = initialvalue;
    }

    @Override
    public String toString(){
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        String rDate = df.format(date);
        return "Name:"+name+ "\nDate:"+rDate + "\nCurrentvalue:"+currentvalue;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInitialvalue() {
        return initialvalue;
    }

    public int getCurrentvalue(){
        Integer x=Integer.valueOf(currentvalue);
        return x;

    }
    public void setCurrentvalue(int i){
        //this.date = new Date();
        this.currentvalue=Integer.toString(i);

    }
    public void setInitialvalue(String value){
        this.initialvalue=value;

    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
