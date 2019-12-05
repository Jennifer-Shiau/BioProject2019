package com.example.jennifershiau.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class Activity2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    CheckBox male;
    CheckBox female;
    EditText height;
    EditText weight;
    EditText age;
    Button ok;
    Button next;

    String[] level = {"0", "1", "2", "3", "4"};
    double[] PAL = {1.2, 1.45, 1.65, 1.85, 2.2};

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
        next = (Button)findViewById(R.id.button5);

        TextView description = (TextView) findViewById(R.id.tv10);
        description.setText("\n[說明]\n");
        description.append("0：臥床\n");
        description.append("1：坐著工作，不能選擇走動，很少或沒有劇烈的休閒活動\n");
        description.append("2：坐著工作，可自由決定並要求四處走動，但很少或沒有劇烈的休閒活動\n");
        description.append("3：站著工作，例如做家務、店員\n");
        description.append("4：費力的工作或活動量大的休閒活動\n");

        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);

        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), level);
        spin.setAdapter(customAdapter);
    }

    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, final int position, long id) {
        ok.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                int h = Integer.parseInt(height.getEditableText().toString());
                int w = Integer.parseInt(weight.getEditableText().toString());
                int a = Integer.parseInt(age.getEditableText().toString());
                int gender;

                double _cal;
                int cal_t;

                if (male.isChecked()) {
                    _cal = 10.0 * w + 6.25 * h - 5.0 * a + 5;
                    gender = 1;
                }
                else {
                    _cal = 10.0 * w + 6.25 * h - 5.0 * a - 161;
                    gender = 2;
                }

                _cal *= PAL[position];
                cal_t = (int)Math.round(_cal);

                TextView result1 = (TextView)findViewById(R.id.tv7);
                result1.setText("每天所需攝取卡路里：" + cal_t + "卡");
                GlobalVariable gv = (GlobalVariable)getApplicationContext();
                gv.setCalt(cal_t);
                gv.gender = gender;
                gv.height = h;
                gv.weight = w;
                gv.age = a;
                gv.level = position;

                Calendar rightNow = Calendar.getInstance();
                int hour = rightNow.get(Calendar.HOUR_OF_DAY);
                int cal;
                if (hour>=10 && hour<=15) {
                    cal = (int)Math.round(cal_t*0.4);
                }
                else {
                    cal = (int)Math.round(cal_t*0.4);
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

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}
