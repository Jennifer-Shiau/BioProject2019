package com.example.jennifershiau.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class DBFood extends AppCompatActivity {

    DbAdapter_Food helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbfood);

        helper = new DbAdapter_Food(this);

        String data = helper.getData();

        TextView show = (TextView) findViewById(R.id.viewFood);
        show.append(data);

        // Message.message(this,data);
    }

}
