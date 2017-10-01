package com.example.countbook;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
* Represent a Counter
*
*  @author shuyang2
*  @version 1.0
*  @since 1.0
*  @see CounterList, CreateCounter, EditCounter,ViewCounter
 */



/*＊
* constructs Counter objects
*
* @param String Counter name
* @param String Counter currentvalue
* @param String Counter comment
* @param String Counter Date
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
    }


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
        // Taken from https://stackoverflow.com/questions/5585779/how-to-convert-a-string-to-an-int-in-java
        // 2017-09-26
        Integer x=Integer.valueOf(currentvalue); // string change to integer
        return x;

    }
    public void setCurrentvalue(int i){
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
