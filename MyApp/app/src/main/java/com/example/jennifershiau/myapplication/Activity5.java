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

public class Activity5 extends AppCompatActivity {

    DbAdapter_Cal helper;
    DbAdapter_Food helper_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity5);

        helper = new DbAdapter_Cal(this);
        helper_2 = new DbAdapter_Food(this);

        TextView showResult = (TextView) findViewById(R.id.tv13);
        Calendar rightNow = Calendar.getInstance();
        int hour = rightNow.get(Calendar.HOUR_OF_DAY);
        if (hour>=10 && hour<=15) {
            showResult.setText("午餐結果： \n");
        }
        else {
            showResult.setText("晚餐結果： \n");
        }

        GlobalVariable gv = (GlobalVariable) getApplicationContext();
        List<Integer> result = gv.result;
        List<Food> foods = gv.foods;

        for (int i = 0; i < result.size(); i++) {
            int index = result.get(i);
            showResult.append(foods.get(index).getName() + " (" + foods.get(index).getCal() + "卡) \n");
        }

        showResult.append("白飯 (230卡) \n");
        showResult.append("總卡路里 = " + gv.calorie + "卡 \n");

        //optional reminder
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i) == 14) {
                showResult.append("請不要喝乳酸飲料！ \n");
            }
        }

        final String _cal = Integer.toString(gv.calorie);
        String food = "";
        for (int i = 0; i < result.size(); i++) {
            int index = result.get(i);
            food = food.concat(foods.get(index).getName() + "\n");
        }
        final String _food = food;

        Button save = (Button)findViewById(R.id.button9);
        Button change = (Button)findViewById(R.id.button);
        Button record = (Button)findViewById(R.id.button11);
        Button recipe = (Button)findViewById(R.id.button12);
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
        home.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(Activity5.this,MainActivity.class);
                startActivity(intent);
            }
        });
        change.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(Activity5.this,Activity6.class);
                startActivity(intent);
            }
        });
        recipe.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(Activity5.this,Activity8.class);
                startActivity(intent);
            }
        });
    }
}
