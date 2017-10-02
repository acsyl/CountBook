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

    /**
     * return the string
     * @return name, fomatting date,currentcalue
     */

    public String toString(){
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        String rDate = df.format(date);
        return "Name:"+name+ "\nDate:"+rDate + "\nCurrentvalue:"+currentvalue;}

    /**
     * get the name of the counter
     * @return name
     */

    public String getName() {
        return name;
    }

    /**
     * set the name of the counter
     * @param name the user wants to update
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * get the initial value of the counter
     * @return initial value
     */

    public String getInitialvalue() {
        return initialvalue;
    }

    /**
     * get the current value of the counter
     * @return current value
     */

    public int getCurrentvalue(){
        // Taken from https://stackoverflow.com/questions/5585779/how-to-convert-a-string-to-an-int-in-java
        // 2017-09-26
        Integer x=Integer.valueOf(currentvalue); // string change to integer
        return x;

    }
    /**
     * set the current value of the counter
     * @param i the user wants to update value in current value
     */
    public void setCurrentvalue(int i){
        this.currentvalue=Integer.toString(i);

    }

    /**
     * set the initial value of the counter
     * @param value the user wants to update value in initial value
     */

    public void setInitialvalue(String value){
        this.initialvalue=value;

    }

    /**
     * get the comment of the counter
     * @return comment
     */

    public String getComment() {
        return comment;
    }

    /**
     * set the comment of the counter
     * @param comment the user wants to update comment
     */

    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * get the date of the counter
     * @return date
     */

    public Date getDate() {
        return date;
    }

    /**
     * set the date of the counter
     * @param date the user wants to update date
     */


    public void setDate(Date date) {
        this.date = date;
    }
}
