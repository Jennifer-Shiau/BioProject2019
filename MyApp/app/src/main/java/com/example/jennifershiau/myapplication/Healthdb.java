package com.example.jennifershiau.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Healthdb extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healthdb);

        ImageButton dbCal = (ImageButton)findViewById(R.id.button15);
        ImageButton dbFood = (ImageButton)findViewById(R.id.button16);

        dbCal.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(Healthdb.this,DBCal.class);
                startActivity(intent);
            }
        });

        dbFood.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(Healthdb.this,DBFood.class);
                startActivity(intent);
            }
        });
    }
}
