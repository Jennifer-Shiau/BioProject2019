package com.example.jennifershiau.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Activity2_3 extends AppCompatActivity {

    static int chooseEgg(List<Food> foods) {
        int egg = 0;
        int a = foods.get(10).getValue();
        int b = foods.get(11).getValue();

        if (a>b) {
            egg = 10;
        }
        else if (b>a) {
            egg = 11;
        }
        else {
            Random ran = new Random();
            int r = ran.nextInt(2); //r = 0 or 1
            egg = r + 10;
        }
        return egg; //egg = 10 or 11
    }

    static int chooseFish(List<Food> foods) {
        int fish = 0;
        int a = foods.get(20).getValue();
        int b = foods.get(21).getValue();
        int c = foods.get(22).getValue();

        if ( (a>b) && (a>c) ) {
            fish = 20;
        }
        else if ( (b>a) && (b>c) ) {
            fish = 21;
        }
        else if ( (c>a) && (c>b) ) {
            fish = 22;
        }
        else if ( (a>c) && (b>c) && (a==b) ) {
            Random ran = new Random();
            int r = ran.nextInt(2); //r = 0 or 1
            fish = r + 20; //fish = 20 or 21
        }
        else if ( (a>b) && (c>b) && (a==c) ) {
            Random ran = new Random();
            int r = ran.nextInt(2); //r = 0 or 1
            if (r==0) {
                fish = 20;
            }
            else {
                fish = 22;
            }
        }
        else if ( (b>a) && (c>a) && (b==c) ) {
            Random ran = new Random();
            int r = ran.nextInt(2); //r = 0 or 1
            fish = r + 21; //fish = 21 or 22
        }
        else if ( (a==b) && (b==c) ) {
            Random ran = new Random();
            int r = ran.nextInt(3); //r = 0 or 1 or 2
            fish = r + 20; //fish = 20 or 21 or 22
        }
        else {
            //System.out.println("error");
        }

        return fish; //fish = 20 or 21 or 22
    }

    DbAdapter_Cal helper;
    DbAdapter_Food helper_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_3);

        helper = new DbAdapter_Cal(this);
        helper_2 = new DbAdapter_Food(this);

        GlobalVariable gv = (GlobalVariable)getApplicationContext();
        List<Food> foods = gv.foods;

        SharedPreferences data = getSharedPreferences("user" , MODE_PRIVATE);
        int cal_t = data.getInt("cal_t", 0);
        int oth = data.getInt("oth", 0);

        gv.setCalt(cal_t);
        gv.setOth(oth);

        Calendar rightNow = Calendar.getInstance();
        int hour = rightNow.get(Calendar.HOUR_OF_DAY);
        int cal;
        Random ran = new Random();
        int r = ran.nextInt(200) - 100; // -100 ~ +100
        if (hour>=10 && hour<=15) {
            cal = (int)Math.round(cal_t*0.4) + r;
        }
        else {
            cal = (int)Math.round(cal_t*0.4) + r;
        }

        for (int i=0;i<23;i++) {
            Food fo = new Food();
            fo.setName(gv.nameList[i]);
            fo.setCal(gv.calList[i]);
            fo.setOther(gv.othList[oth][i]);
            fo.setNut(gv.nutList[i]);

            foods.add(fo);
        }

        for (int i=0;i<23;i++) {
            String s = Integer.toString(i);
            if (data.getInt(s, 0)==1) {
                foods.get(i).setPre(90);
            }
            String s2 = "n" + Integer.toString(i);
            if (data.getInt(s2, 0)==1) {
                foods.get(i).setPre(-300);
            }
        }

        //random vegetables
        int t1;
        while (true)
        {
            t1 = ran.nextInt(13) % 9;
            if (foods.get(t1).getValue() >= 0)
                break;
        }
        if (t1 <= 3)
            foods.get(t1).setNut(100);
        else
            foods.get(t1).setNut(90);

        int max = 0;
        for(int i=0;i<9;i++) {
            if (foods.get(i).getValue() > max)
            {
                max = foods.get(i).getValue();
            }
        }

        List<Integer> _temp = new ArrayList<Integer>();
        for(int i=0;i<9;i++) {
            if (foods.get(i).getValue() == max)
            {
                _temp.add(i);
            }
        }

        int v1 = ran.nextInt(_temp.size());
        int vegetable = _temp.get(v1);

        int t2;
        while (true)
        {
            t2 = ran.nextInt(9);
            if ((foods.get(t2).getValue() >= 0) && (t2 != vegetable))
                break;
        }
        foods.get(t2).setNut(10);

        //start calculating

        int calorie = 0;

        //rice
        calorie += 230;

        calorie += foods.get(vegetable).getCal();

        //other foods
        int check = 0;
        if (vegetable==8 || t2==8) { check = 1; }

        int[] oth_index;

        int egg = chooseEgg(foods); //egg = 10 or 11
        int fish = chooseFish(foods); //fish = 20 or 21 or 22

        if (check==0) {
            int[] index = {t2, 9, egg, 12, 13, 14, 15, 16, 17, 18, 19, fish};
            oth_index = index;
        }
        else {
            int[] index = {t2, egg, 12, 13, 14, 15, 16, 17, 18, 19, fish};
            oth_index = index;
        }

        int n = oth_index.length;
        int W = (cal-calorie)/10;
        int[] w = new int[n];
        int[] v = new int[n];

        for(int i=0;i<n;i++) {
            w[i] = ( foods.get(oth_index[i]).getCal() )/10;
            v[i] = foods.get(oth_index[i]).getValue();
        }

        int[][] table = new int[n+1][W+1];
        for(int i=0;i<=n;i++) {
            for(int j=0;j<=W;j++) {
                table[i][j] = 0;
            }
        }
        for(int i=1;i<=n;i++) {
            for(int j=0;j<=W;j++) {
                if (w[i-1]>j) {
                    table[i][j] = table[i-1][j];
                }
                else {
                    table[i][j] = Math.max(table[i-1][j], v[i-1]+table[i-1][j-w[i-1]]);
                }
            }
        }

        List<Integer> s = new ArrayList<Integer>();
        int j = W;
        for(int i=n;i>0;i--) {
            if (table[i][j]>table[i-1][j]) {
                j = j-w[i-1];
                s.add(i-1);
            }
        }
        for(int i=0;i<s.size();i++) {
            int temp = oth_index[s.get(i)];
            s.set(i, temp);
            calorie += foods.get(temp).getCal();
        }
        Collections.reverse(s);

        //result
        List<Integer> result = new ArrayList<Integer>();
        result.add(vegetable);

        for(int i=0;i<s.size();i++) {
            result.add(s.get(i));
        }
        Collections.sort(result);
        gv.result = result;

        TextView showResult = (TextView) findViewById(R.id.tv17);
        if (hour>=10 && hour<=15) {
            showResult.setText("午餐結果： \n");
        }
        else {
            showResult.setText("晚餐結果： \n");
        }

        for (int i = 0; i < result.size(); i++) {
            int index = result.get(i);
            showResult.append(foods.get(index).getName() + " (" + foods.get(index).getCal() + "卡) \n");
        }

        showResult.append("白飯 (230卡) \n");
        showResult.append("總卡路里 = " + calorie + "卡 \n");

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

        Button change = (Button)findViewById(R.id.button11);
        Button record = (Button)findViewById(R.id.button13);
        Button recipe = (Button)findViewById(R.id.button14);

        change.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(Activity2_3.this,Activity6.class);
                startActivity(intent);
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
                Intent intent = new Intent(Activity2_3.this,Activity8.class);
                startActivity(intent);
            }
        });
    }
}
