package com.example.jennifershiau.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton New = (ImageButton)findViewById(R.id.button1);
        ImageButton Open = (ImageButton)findViewById(R.id.button3);

        New.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                SharedPreferences data = getSharedPreferences("user" , MODE_PRIVATE);
                int cal_t = data.getInt("cal_t", 0);
                //have data
                if(cal_t!=0) {
                    Intent intent = new Intent(MainActivity.this,Activity1.class);
                    startActivity(intent);
                }
                //no data
                else {
                    Intent intent = new Intent(MainActivity.this,Activity2.class);
                    startActivity(intent);
                }

            }
        });

        Open.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                SharedPreferences data = getSharedPreferences("user" , MODE_PRIVATE);
                int cal_t = data.getInt("cal_t", 0);
                //have data
                if(cal_t!=0) {
                    Intent intent = new Intent(MainActivity.this,Activity2_3.class);
                    startActivity(intent);
                }
                //no data
                else {
                    Intent intent = new Intent(MainActivity.this,Activity2.class);
                    startActivity(intent);
                }

            }
        });
    }
}
