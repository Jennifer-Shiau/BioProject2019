package com.example.jennifershiau.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Activity4 extends AppCompatActivity {

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
        setContentView(R.layout.activity4);

        Button next = (Button)findViewById(R.id.button7);
        Button view = (Button)findViewById(R.id.button12);

        view.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(Activity4.this,Activity4_2.class);
                startActivity(intent);
            }
        });

        next.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                GlobalVariable gv = (GlobalVariable)getApplicationContext();
                List<Food> foods = gv.foods;
                int oth = gv.getOth();
                int cal = gv.getCal();

                for (int i=0;i<23;i++) {
                    Food fo = new Food();
                    fo.setName(gv.nameList[i]);
                    fo.setCal(gv.calList[i]);
                    fo.setOther(gv.othList[oth][i]);
                    fo.setNut(gv.nutList[i]);
                    fo.setPrice(gv.priceList[i]);

                    foods.add(fo);
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

                //like
                CheckBox c0 = (CheckBox) findViewById(R.id.c0);
                CheckBox c1 = (CheckBox) findViewById(R.id.c1);
                CheckBox c2 = (CheckBox) findViewById(R.id.c2);
                CheckBox c3 = (CheckBox) findViewById(R.id.c3);
                CheckBox c4 = (CheckBox) findViewById(R.id.c4);
                CheckBox c5 = (CheckBox) findViewById(R.id.c5);
                CheckBox c6 = (CheckBox) findViewById(R.id.c6);
                CheckBox c7 = (CheckBox) findViewById(R.id.c7);
                CheckBox c8 = (CheckBox) findViewById(R.id.c8);
                CheckBox c9 = (CheckBox) findViewById(R.id.c9);
                CheckBox c10 = (CheckBox) findViewById(R.id.c10);
                CheckBox c11 = (CheckBox) findViewById(R.id.c11);
                CheckBox c12 = (CheckBox) findViewById(R.id.c12);
                CheckBox c13 = (CheckBox) findViewById(R.id.c13);
                CheckBox c14 = (CheckBox) findViewById(R.id.c14);
                CheckBox c15 = (CheckBox) findViewById(R.id.c15);
                CheckBox c16 = (CheckBox) findViewById(R.id.c16);
                CheckBox c17 = (CheckBox) findViewById(R.id.c17);
                CheckBox c18 = (CheckBox) findViewById(R.id.c18);
                CheckBox c19 = (CheckBox) findViewById(R.id.c19);
                CheckBox c20 = (CheckBox) findViewById(R.id.c20);
                CheckBox c21 = (CheckBox) findViewById(R.id.c21);
                CheckBox c22 = (CheckBox) findViewById(R.id.c22);
                //don't like
                CheckBox ch0 = (CheckBox) findViewById(R.id.ch0);
                CheckBox ch1 = (CheckBox) findViewById(R.id.ch1);
                CheckBox ch2 = (CheckBox) findViewById(R.id.ch2);
                CheckBox ch3 = (CheckBox) findViewById(R.id.ch3);
                CheckBox ch4 = (CheckBox) findViewById(R.id.ch4);
                CheckBox ch5 = (CheckBox) findViewById(R.id.ch5);
                CheckBox ch6 = (CheckBox) findViewById(R.id.ch6);
                CheckBox ch7 = (CheckBox) findViewById(R.id.ch7);
                CheckBox ch8 = (CheckBox) findViewById(R.id.ch8);
                CheckBox ch9 = (CheckBox) findViewById(R.id.ch9);
                CheckBox ch10 = (CheckBox) findViewById(R.id.ch10);
                CheckBox ch11 = (CheckBox) findViewById(R.id.ch11);
                CheckBox ch12 = (CheckBox) findViewById(R.id.ch12);
                CheckBox ch13 = (CheckBox) findViewById(R.id.ch13);
                CheckBox ch14 = (CheckBox) findViewById(R.id.ch14);
                CheckBox ch15 = (CheckBox) findViewById(R.id.ch15);
                CheckBox ch16 = (CheckBox) findViewById(R.id.ch16);
                CheckBox ch17 = (CheckBox) findViewById(R.id.ch17);
                CheckBox ch18 = (CheckBox) findViewById(R.id.ch18);
                CheckBox ch19 = (CheckBox) findViewById(R.id.ch19);
                CheckBox ch20 = (CheckBox) findViewById(R.id.ch20);
                CheckBox ch21 = (CheckBox) findViewById(R.id.ch21);
                CheckBox ch22 = (CheckBox) findViewById(R.id.ch22);

                if(c0.isChecked()){foods.get(0).setPre(90); gv.pre[0] = 1;}
                else if(ch0.isChecked()){foods.get(0).setPre(-300); gv.no[0] = 1;}
                else{foods.get(0).setPre(0); gv.pre[0] = 0; gv.no[0] = 0;}

                if(c1.isChecked()){foods.get(1).setPre(90); gv.pre[1] = 1;}
                else if(ch1.isChecked()){foods.get(1).setPre(-300); gv.no[1] = 1;}
                else{foods.get(1).setPre(0); gv.pre[1] = 0; gv.no[1] = 0;}

                if(c2.isChecked()){foods.get(2).setPre(90); gv.pre[2] = 1;}
                else if(ch2.isChecked()){foods.get(2).setPre(-300); gv.no[2] = 1;}
                else{foods.get(2).setPre(0); gv.pre[2] = 0; gv.no[2] = 0;}

                if(c3.isChecked()){foods.get(3).setPre(90); gv.pre[3] = 1;}
                else if(ch3.isChecked()){foods.get(3).setPre(-300); gv.no[3] = 1;}
                else{foods.get(3).setPre(0); gv.pre[3] = 0; gv.no[3] = 0;}

                if(c4.isChecked()){foods.get(4).setPre(90); gv.pre[4] = 1;}
                else if(ch4.isChecked()){foods.get(4).setPre(-300); gv.no[4] = 1;}
                else{foods.get(4).setPre(0); gv.pre[4] = 0; gv.no[4] = 0;}

                if(c5.isChecked()){foods.get(5).setPre(90); gv.pre[5] = 1;}
                else if(ch5.isChecked()){foods.get(5).setPre(-300); gv.no[5] = 1;}
                else{foods.get(5).setPre(0); gv.pre[5] = 0; gv.no[5] = 0;}

                if(c6.isChecked()){foods.get(6).setPre(90); gv.pre[6] = 1;}
                else if(ch6.isChecked()){foods.get(6).setPre(-300); gv.no[6] = 1;}
                else{foods.get(6).setPre(0); gv.pre[6] = 0; gv.no[6] = 0;}

                if(c7.isChecked()){foods.get(7).setPre(90); gv.pre[7] = 1;}
                else if(ch7.isChecked()){foods.get(7).setPre(-300); gv.no[7] = 1;}
                else{foods.get(7).setPre(0); gv.pre[7] = 0; gv.no[7] = 0;}

                if(c8.isChecked()){foods.get(8).setPre(90); gv.pre[8] = 1;}
                else if(ch8.isChecked()){foods.get(8).setPre(-300); gv.no[8] = 1;}
                else{foods.get(8).setPre(0); gv.pre[8] = 0; gv.no[8] = 0;}

                if(c9.isChecked()){foods.get(9).setPre(90); gv.pre[9] = 1;}
                else if(ch9.isChecked()){foods.get(9).setPre(-300); gv.no[9] = 1;}
                else{foods.get(9).setPre(0); gv.pre[9] = 0; gv.no[9] = 0;}

                if(c10.isChecked()){foods.get(10).setPre(90); gv.pre[10] = 1;}
                else if(ch10.isChecked()){foods.get(10).setPre(-300); gv.no[10] = 1;}
                else{foods.get(10).setPre(0); gv.pre[10] = 0; gv.no[10] = 0;}

                if(c11.isChecked()){foods.get(11).setPre(90); gv.pre[11] = 1;}
                else if(ch11.isChecked()){foods.get(11).setPre(-300); gv.no[11] = 1;}
                else{foods.get(11).setPre(0); gv.pre[11] = 0; gv.no[11] = 0;}

                if(c12.isChecked()){foods.get(12).setPre(90); gv.pre[12] = 1;}
                else if(ch12.isChecked()){foods.get(12).setPre(-300); gv.no[12] = 1;}
                else{foods.get(12).setPre(0); gv.pre[12] = 0; gv.no[12] = 0;}

                if(c13.isChecked()){foods.get(13).setPre(90); gv.pre[13] = 1;}
                else if(ch13.isChecked()){foods.get(13).setPre(-300); gv.no[13] = 1;}
                else{foods.get(13).setPre(0); gv.pre[13] = 0; gv.no[13] = 0;}

                if(c14.isChecked()){foods.get(14).setPre(90); gv.pre[14] = 1;}
                else if(ch14.isChecked()){foods.get(14).setPre(-300); gv.no[14] = 1;}
                else{foods.get(14).setPre(0); gv.pre[14] = 0; gv.no[14] = 0;}

                if(c15.isChecked()){foods.get(15).setPre(90); gv.pre[15] = 1;}
                else if(ch15.isChecked()){foods.get(15).setPre(-300); gv.no[15] = 1;}
                else{foods.get(15).setPre(0); gv.pre[15] = 0; gv.no[15] = 0;}

                if(c16.isChecked()){foods.get(16).setPre(90); gv.pre[16] = 1;}
                else if(ch16.isChecked()){foods.get(16).setPre(-300); gv.no[16] = 1;}
                else{foods.get(16).setPre(0); gv.pre[16] = 0; gv.no[16] = 0;}

                if(c17.isChecked()){foods.get(17).setPre(90); gv.pre[17] = 1;}
                else if(ch17.isChecked()){foods.get(17).setPre(-300); gv.no[17] = 1;}
                else{foods.get(17).setPre(0); gv.pre[17] = 0; gv.no[17] = 0;}

                if(c18.isChecked()){foods.get(18).setPre(90); gv.pre[18] = 1;}
                else if(ch18.isChecked()){foods.get(18).setPre(-300); gv.no[18] = 1;}
                else{foods.get(18).setPre(0); gv.pre[18] = 0; gv.no[18] = 0;}

                if(c19.isChecked()){foods.get(19).setPre(90); gv.pre[19] = 1;}
                else if(ch19.isChecked()){foods.get(19).setPre(-300); gv.no[19] = 1;}
                else{foods.get(19).setPre(0); gv.pre[19] = 0; gv.no[19] = 0;}

                if(c20.isChecked()){foods.get(20).setPre(90); gv.pre[20] = 1;}
                else if(ch20.isChecked()){foods.get(20).setPre(-300); gv.no[20] = 1;}
                else{foods.get(20).setPre(0); gv.pre[20] = 0; gv.no[20] = 0;}

                if(c21.isChecked()){foods.get(21).setPre(90); gv.pre[21] = 1;}
                else if(ch21.isChecked()){foods.get(21).setPre(-300); gv.no[21] = 1;}
                else{foods.get(21).setPre(0); gv.pre[21] = 0; gv.no[21] = 0;}

                if(c22.isChecked()){foods.get(22).setPre(90); gv.pre[22] = 1;}
                else if(ch22.isChecked()){foods.get(22).setPre(-300); gv.no[22] = 1;}
                else{foods.get(22).setPre(0); gv.pre[22] = 0; gv.no[22] = 0;}

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
                gv.calorie = calorie;

                Intent intent = new Intent(Activity4.this,Activity5.class);
                startActivity(intent);
            }
        });
    }
}
