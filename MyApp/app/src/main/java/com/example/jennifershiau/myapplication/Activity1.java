package com.example.jennifershiau.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

public class Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1);

        SharedPreferences data = getSharedPreferences("user" , MODE_PRIVATE);

        int gender = data.getInt("gender", 0);
        TextView g = (TextView) findViewById(R.id.tv1);
        if(gender==1) {
            g.setText("性別：男");
        }
        else {
            g.setText("性別：女");
        }

        int height = data.getInt("height", 0);
        TextView h = (TextView) findViewById(R.id.tv2);
        h.setText("身高：" + height);

        int weight = data.getInt("weight", 0);
        TextView w = (TextView) findViewById(R.id.tv3);
        w.setText("體重：" + weight);

        int age = data.getInt("age", 0);
        TextView a = (TextView) findViewById(R.id.tv4);
        a.setText("年齡：" + age);

        int level = data.getInt("level", 0);
        TextView l = (TextView) findViewById(R.id.tv5);
        if(level==0) {
            l.setText("活動程度：臥床");
        }
        else if(level==1) {
            l.setText("活動程度：坐著工作，不能選擇走動，很少或沒有劇烈的休閒活動");
        }
        else if(level==2) {
            l.setText("活動程度：坐著工作，可自由決定並要求四處走動，但很少或沒有劇烈的休閒活動");
        }
        else if(level==3) {
            l.setText("活動程度：站著工作，例如做家務、店員");
        }
        else {
            l.setText("活動程度：費力的工作或活動量大的休閒活動");
        }

        int oth = data.getInt("oth", 0);
        TextView o = (TextView) findViewById(R.id.tv6);
        if(oth==0) {
            o.setText("健康需求：無");
        }
        else if(oth==1) {
            o.setText("健康需求：少油");
        }
        else if(oth==2) {
            o.setText("健康需求：高血壓");
        }
        else if(oth==3) {
            o.setText("健康需求：高膽固醇");
        }
        else if(oth==4) {
            o.setText("健康需求：痛風");
        }

        int cal_t = data.getInt("cal_t", 0);
        TextView ct = (TextView) findViewById(R.id.tv7);
        ct.setText("每天所需攝取卡路里：" + cal_t + "卡");

        Calendar rightNow = Calendar.getInstance();
        int hour = rightNow.get(Calendar.HOUR_OF_DAY);
        int cal;
        if (hour>=10 && hour<=15) {
            cal = (int)Math.round(cal_t*0.4);
        }
        else {
            cal = (int)Math.round(cal_t*0.4);
        }
        TextView c = (TextView) findViewById(R.id.tv8);
        c.setText("此餐所需攝取卡路里：" + cal + "卡");

        Button change = (Button)findViewById(R.id.button1);
        Button inf = (Button)findViewById(R.id.button2);

        change.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(Activity1.this,Activity2.class);
                startActivity(intent);
            }
        });
        inf.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                //Intent intent = new Intent(Activity1.this,Activity1_2.class);
                Intent intent = new Intent(Activity1.this,Healthdb.class);
                startActivity(intent);
            }
        });
    }
}
