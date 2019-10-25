package com.example.jennifershiau.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class Activity2 extends AppCompatActivity {
    CheckBox male;
    CheckBox female;
    EditText height;
    EditText weight;
    EditText age;
    Button ok;
    CheckBox norm;
    CheckBox gain;
    CheckBox lose;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        male = (CheckBox) findViewById(R.id.cb1);
        female = (CheckBox) findViewById(R.id.cb2);
        height = (EditText)findViewById(R.id.etHeight);
        weight = (EditText)findViewById(R.id.etWeight);
        age = (EditText)findViewById(R.id.etAge);
        ok = (Button)findViewById(R.id.button4);
        norm = (CheckBox) findViewById(R.id.cb3);
        gain = (CheckBox) findViewById(R.id.cb4);
        lose = (CheckBox) findViewById(R.id.cb5);
        next = (Button)findViewById(R.id.button5);

        ok.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                int h = Integer.parseInt(height.getEditableText().toString());
                int w = Integer.parseInt(weight.getEditableText().toString());
                int a = Integer.parseInt(age.getEditableText().toString());
                int gender;
                int mode;

                double _cal;
                int cal_t;

                if (male.isChecked()) {
                    _cal = (66 + 13.7*w + 5.0*h - 6.8*a)/0.75;
                    cal_t = (int)Math.round(_cal);
                    gender = 1;
                }
                else {
                    _cal = (655 + 9.6*w + 1.7*h - 4.7*a)/0.75;
                    cal_t = (int)Math.round(_cal);
                    gender = 2;
                }

                if (gain.isChecked()) {
                    cal_t+=500;
                    mode = 1;
                }
                else if(lose.isChecked()) {
                    cal_t-=500;
                    mode = -1;
                }
                else {
                    //normal
                    mode = 0;
                }

                TextView result1 = (TextView)findViewById(R.id.tv7);
                result1.setText("每天所需攝取卡路里：" + cal_t + "卡");
                GlobalVariable gv = (GlobalVariable)getApplicationContext();
                gv.setCalt(cal_t);
                gv.gender = gender;
                gv.height = h;
                gv.weight = w;
                gv.age = a;
                gv.mode = mode;

                Calendar rightNow = Calendar.getInstance();
                int hour = rightNow.get(Calendar.HOUR_OF_DAY);
                int cal;
                if (hour>=10 && hour<=15) {
                     cal = (int)Math.round(cal_t*0.4);
                }
                else {
                    cal = (int)Math.round(cal_t*0.3);
                }
                gv.setCal(cal);

                TextView result2 = (TextView)findViewById(R.id.tv8);
                result2.setText("此餐所需攝取卡路里：" + cal + "卡");

            }
        });

        next.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(Activity2.this,Activity3.class);
                startActivity(intent);
            }
        });
    }
}
