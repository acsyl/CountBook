package com.example.countbook;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



/**
 * Create a Counter
 *
 *  @author Shuyang Li
 *  @version 1.0
 *  @since 1.0
 *  @see Counter
 */

/*＊
* CreateCounter Class
*
* This class is for create new counter
* When user create counter, this class will call Counter to create and put it in CounterList
*
*/

public class CreateCounter extends AppCompatActivity {

    private EditText create_name;
    private EditText create_initialvalue;
    private EditText create_comment;
    private static final String FILENAME = "file.sav";
    private CounterList tlist = new CounterList();
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_count);

        context = getApplicationContext();

        create_name = (EditText) findViewById(R.id.add_name);
        create_initialvalue = (EditText) findViewById(R.id.add_initial_value);
        create_comment = (EditText) findViewById(R.id.add_comment);
        Button FinishButton = (Button) findViewById(R.id.finish_button);

        FinishButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tlist.loadAllRecord(context);
                setResult(RESULT_OK);
                String name = create_name.getText().toString();
                String initialvalue = create_initialvalue.getText().toString();
                String comment = create_comment.getText().toString();
                Counter counter = new Counter(name, initialvalue, comment);
                tlist.addCounter(counter);
                tlist.saveInFile(context);
                finish();
            }
        });
    }



}
