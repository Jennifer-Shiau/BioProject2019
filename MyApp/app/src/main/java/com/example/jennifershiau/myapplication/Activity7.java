package com.example.jennifershiau.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.List;

public class Activity7 extends AppCompatActivity {

    DbAdapter_Cal helper;
    DbAdapter_Food helper_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity7);

        helper = new DbAdapter_Cal(this);
        helper_2 = new DbAdapter_Food(this);

        GlobalVariable gv = (GlobalVariable) getApplicationContext();
        TextView showResult = (TextView) findViewById(R.id.tv);
        Calendar rightNow = Calendar.getInstance();
        int hour = rightNow.get(Calendar.HOUR_OF_DAY);
        int cal;
        if (hour>=10 && hour<=15) {
            showResult.setText("午餐結果： \n");
            cal = (int)Math.round(gv.getCalt()*0.4);
        }
        else {
            showResult.setText("晚餐結果： \n");
            cal = (int)Math.round(gv.getCalt()*0.4);
        }

        // List<Integer> result = gv.changeResult;
        List<Integer> result = gv.result;
        List<Food> foods = gv.foods;

        int calorie = 0;
        for (int i = 0; i < result.size(); i++) {
            int index = result.get(i);
            showResult.append(foods.get(index).getName() + " (" + foods.get(index).getCal() + "卡) \n");
            calorie += foods.get(index).getCal();
        }
        calorie += 230;

        showResult.append("白飯 (230卡) \n");
        showResult.append("總卡路里 = " + calorie + "卡 \n");
        showResult.append("標準卡路里 = " + cal + "卡 \n");

        //optional reminder
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i) == 14) {
                showResult.append("請不要喝乳酸飲料！ \n");
            }
        }

        final String _cal = Integer.toString(calorie);
        String food = "";
        for (int i = 0; i < result.size(); i++) {
            int index = result.get(i);
            food = food.concat(foods.get(index).getName() + "\n");
        }
        final String _food = food;

        Button save = (Button)findViewById(R.id.button1);
        Button record = (Button)findViewById(R.id.button3);
        Button recipe = (Button)findViewById(R.id.button4);
        ImageButton home = (ImageButton)findViewById(R.id.Button2);

        save.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                GlobalVariable gv = (GlobalVariable) getApplicationContext();
                SharedPreferences data = getSharedPreferences("user" , MODE_PRIVATE);
                data.edit().putInt("gender", gv.gender).apply();
                data.edit().putInt("height", gv.height).apply();
                data.edit().putInt("weight", gv.weight).apply();
                data.edit().putInt("age", gv.age).apply();
                data.edit().putInt("level", gv.level).apply();
                data.edit().putInt("cal_t", gv.getCalt()).apply();
                data.edit().putInt("oth", gv.getOth()).apply();

                for (int i=0;i<23;i++) {
                    String s = Integer.toString(i);
                    data.edit().putInt(s, gv.pre[i]).apply();
                    String s2 = "n" + Integer.toString(i);
                    data.edit().putInt(s2, gv.no[i]).apply();
                }
                Toast.makeText(getApplicationContext(), "資料已儲存！", Toast.LENGTH_SHORT).show();
            }
        });
        record.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                Calendar now = Calendar.getInstance();
                int month = now.get(Calendar.MONTH) + 1;
                int day = now.get(Calendar.DAY_OF_MONTH);
                String hour = String.format("%02d", now.get(Calendar.HOUR_OF_DAY));
                String minute = String.format("%02d", now.get(Calendar.MINUTE));
                String time = month + "/" + day + "  " + hour + ":" + minute;
                helper.insertData(time, _cal);
                helper_2.insertData(time, _food);
                Message.message(getApplicationContext(),"記錄完成！");
            }
        });
        recipe.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(Activity7.this,Activity8.class);
                startActivity(intent);
            }
        });
        home.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(Activity7.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
