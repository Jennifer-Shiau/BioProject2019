package com.example.jennifershiau.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DBCal extends AppCompatActivity {
    DbAdapter_Cal helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbcal);

        helper = new DbAdapter_Cal(this);

        String data = helper.getData();

        TextView show = (TextView) findViewById(R.id.tv3);
        show.append(data);

        // Message.message(this,data);
    }
}
