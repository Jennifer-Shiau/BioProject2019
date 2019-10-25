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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_3);

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
        if (hour>=10 && hour<=15) {
            cal = (int)Math.round(cal_t*0.4);
        }
        else {
            cal = (int)Math.round(cal_t*0.3);
        }

        for (int i=0;i<23;i++) {
            Food fo = new Food();
            fo.setName(gv.nameList[i]);
            fo.setCal(gv.calList[i]);
            fo.setOther(gv.othList[oth][i]);
            fo.setNut(gv.nutList[i]);
            fo.setPrice(gv.priceList[i]);

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
        int[] a = new int[3];
        int[] b = new int[2];
        int[] c = new int[4];
        Random ran = new Random();
        int t1 = ran.nextInt(3);
        int t2 = ran.nextInt(2);
        int t3 = ran.nextInt(4);
        for(int i=0;i<3;i++) {
            if(i==t1) { a[i] = 120; }
            else { a[i] = 10; }
        }
        for(int i=0;i<2;i++) {
            if(i==t2) { b[i] = 90; }
            else { b[i] = 10; }
        }
        for(int i=0;i<4;i++) {
            if(i==t3) { c[i] = 20; }
            else { c[i] = 10; }
        }

        foods.get(0).setNut(b[0]);
        foods.get(1).setNut(a[0]);
        foods.get(2).setNut(a[1]);
        foods.get(3).setNut(a[2]);
        foods.get(4).setNut(c[0]);
        foods.get(5).setNut(b[1]);
        foods.get(6).setNut(c[1]);
        foods.get(7).setNut(c[2]);
        foods.get(8).setNut(c[3]);

        //start calculating

        int calorie = 0;

        //rice
        calorie += 230;

        //vegetables
        int[] vege_val = new int[9];
        for(int i=0;i<9;i++) {
            vege_val[i] = foods.get(i).getValue();
        }
        //sort vegetables
        List<Element> vege_sort = new ArrayList<Element>();
        for (int i = 0; i < vege_val.length; i++) {
            vege_sort.add(new Element(i, vege_val[i]));
        }
        Collections.sort(vege_sort);
        Collections.reverse(vege_sort);

        //result
        int[] vegetables = {vege_sort.get(0).index, vege_sort.get(1).index, vege_sort.get(2).index};
        Arrays.sort(vegetables);
        for(int i=0;i<3;i++) {
            calorie += foods.get(vegetables[i]).getCal();
        }

        //other foods
        int check = 0;
        for(int i=0;i<3;i++) {
            if (vegetables[i]==8) { check = 1; }
        }
        int[] oth_index;

        int egg = chooseEgg(foods); //egg = 10 or 11
        int fish = chooseFish(foods); //fish = 20 or 21 or 22

        if (check==0) {
            int[] index = {9, egg, 12, 13, 14, 15, 16, 17, 18, 19, fish};
            oth_index = index;
        }
        else {
            int[] index = {egg, 12, 13, 14, 15, 16, 17, 18, 19, fish};
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
        for(int i=0;i<3;i++) {
            result.add(vegetables[i]);
        }
        for(int i=0;i<s.size();i++) {
            result.add(s.get(i));
        }
        gv.result = result;

        TextView showResult = (TextView) findViewById(R.id.tv17);
        if (hour>=10 && hour<=15) {
            showResult.setText("午餐結果： \n");
        }
        else {
            showResult.setText("晚餐結果： \n");
        }

        int price = 0;
        for (int i = 0; i < result.size(); i++) {
            int index = result.get(i);
            showResult.append(foods.get(index).getName() + " (" + foods.get(index).getCal() + "卡) \n");
            price += foods.get(index).getPrice();
        }
        price += 8;
        gv.price = price;

        showResult.append("白飯 (230卡) \n");
        showResult.append("總卡路里 = " + calorie + "卡 \n");
        showResult.append("價格：$" + gv.price + "\n");

        //optional reminder
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i) == 14) {
                showResult.append("請不要喝乳酸飲料！ \n");
            }
        }

        Button change = (Button)findViewById(R.id.button11);
        //Button home = (Button)findViewById(R.id.button12);
        Button money = (Button)findViewById(R.id.button13);

        change.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(Activity2_3.this,Activity6.class);
                startActivity(intent);
            }
        });
        money.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                GlobalVariable gv = (GlobalVariable) getApplicationContext();
                SharedPreferences data = getSharedPreferences("user" , MODE_PRIVATE);
                String s = data.getString("bill", "");
                int total = data.getInt("total", 0);
                Calendar rightNow = Calendar.getInstance();
                int year = rightNow.get(Calendar.YEAR);
                int month = rightNow.get(Calendar.MONTH) + 1;
                int day = rightNow.get(Calendar.DAY_OF_MONTH);
                int hour = rightNow.get(Calendar.HOUR_OF_DAY);
                if (hour>=10 && hour<=15) {
                    s = s + "\n" + year + "/" + month + "/" + day + "   午餐  $" + Integer.toString(gv.price) + "\n";
                }
                else {
                    s = s + "\n" + year + "/" + month + "/" + day + "   晚餐  $" + Integer.toString(gv.price) + "\n";
                }
                total = total + gv.price;
                data.edit().putString("bill", s).apply();
                data.edit().putInt("total", total).apply();

                Toast.makeText(getApplicationContext(), "記帳完成！", Toast.LENGTH_SHORT).show();
            }
        });
        /*
        home.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(Activity2_3.this,MainActivity.class);
                startActivity(intent);
            }
        });
        */
    }

}
