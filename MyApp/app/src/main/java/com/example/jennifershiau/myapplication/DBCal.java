package com.example.jennifershiau.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class DBCal extends AppCompatActivity {
    EditText Cal;
    DbAdapter_Cal helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbcal);
        // Cal = (EditText) findViewById(R.id.editText);

        helper = new DbAdapter_Cal(this);

        String data = helper.getData();

        TextView show = (TextView) findViewById(R.id.tv3);
        show.append(data);

        // Message.message(this,data);
    }
    /*
    public void addData(View view)
    {
        String cal = Cal.getText().toString();
        if(cal.isEmpty())
        {
            Message.message(getApplicationContext(),"Enter Cal");
        }
        else
        {
            Calendar now = Calendar.getInstance();
            int hour = now.get(Calendar.HOUR_OF_DAY);
            int minute = now.get(Calendar.MINUTE);
            String time = hour + ":" + minute;
            long id = helper.insertData(time, cal);
            if(id <= 0)
            {
                Message.message(getApplicationContext(),"Insertion Unsuccessful");
                Cal.setText("");
            } else
            {
                Message.message(getApplicationContext(),"Insertion Successful");
                Cal.setText("");
            }
        }
    }

    public void viewData(View view)
    {
        String data = helper.getData();

        TextView show = (TextView) findViewById(R.id.tv3);
        show.setText("Results:\n");
        show.append(data);
        show.append("\nEnd");

        Message.message(this,data);
    }
     */
}

