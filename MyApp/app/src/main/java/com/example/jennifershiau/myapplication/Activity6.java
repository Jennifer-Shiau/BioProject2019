package com.example.jennifershiau.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class Activity6 extends AppCompatActivity {

    static boolean isResult(List<Integer> result, int index) {
        int check = 0;
        for (int i = 0; i < result.size(); i++) {
            if(index==result.get(i)) {
                check = 1;
                break;
            }
        }
        if(check==1) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity6);

        LinearLayout ll = (LinearLayout)findViewById(R.id.ll1);

        TextView showResult = new TextView(this);
        Calendar rightNow = Calendar.getInstance();
        int hour = rightNow.get(Calendar.HOUR_OF_DAY);
        if (hour>=10 && hour<=15) {
            showResult.setText("午餐結果：");
        }
        else {
            showResult.setText("晚餐結果：");
        }
        showResult.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        ll.addView(showResult);

        GlobalVariable gv = (GlobalVariable) getApplicationContext();
        List<Integer> result = gv.result;
        List<Food> foods = gv.foods;
        Switch[] ss = gv.ss;
        for(int i=0;i<23;i++) {
            ss[i] = new Switch(this);
        }

        for (int i = 0; i < result.size(); i++) {
            int index = result.get(i);
            ss[index].setText(foods.get(index).getName() + " (" + foods.get(index).getCal() + "卡)");
            ss[index].setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
            ss[index].setChecked(true);
            ll.addView(ss[index]);
        }

        List<Integer> yes = new ArrayList<Integer>();
        List<Integer> no = new ArrayList<Integer>();

        for(int i=0;i<23;i++) {
            if(isResult(result, i)==true) {
                continue;
            }
            else if(gv.othList[gv.getOth()][i]<0) {
                no.add(i);
            }
            else {
                yes.add(i);
            }
        }

        TextView t1 = new TextView(this);
        t1.setText("\n您還可以吃：");
        t1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        ll.addView(t1);

        List<Element> yes_sort = new ArrayList<Element>();
        for (int i = 0; i < yes.size(); i++) {
            int index = yes.get(i);
            yes_sort.add(new Element(index, foods.get(index).getValue()));
        }
        Collections.sort(yes_sort);
        Collections.reverse(yes_sort);

        List<Integer> yesList = new ArrayList<Integer>();
        for (int i = 0; i < yes.size(); i++) {
            yesList.add(yes_sort.get(i).index);
        }

        for (int i = 0; i < yesList.size(); i++) {
            int index = yesList.get(i);
            ss[index].setText(foods.get(index).getName() + " (" + foods.get(index).getCal() + "卡)");
            ss[index].setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
            ll.addView(ss[index]);
        }

        TextView t2 = new TextView(this);
        t2.setText("\n建議您不要吃：");
        t2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        ll.addView(t2);

        if(no.size()==0) {
            TextView t = new TextView(this);
            t.setText("無");
            t.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
            ll.addView(t);
        }
        else {
            for (int i = 0; i < no.size(); i++) {
                int index = no.get(i);
                ss[index].setText(foods.get(index).getName() + " (" + foods.get(index).getCal() + "卡)");
                ss[index].setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
                ll.addView(ss[index]);
            }
        }

        TextView t3 = new TextView(this);
        t3.setText("\n\n");
        t3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        ll.addView(t3);

        Button ok = new Button(this);
        ok.setText("確定");
        LinearLayout.LayoutParams layoutParams = new  LinearLayout.LayoutParams(330, 150);
        layoutParams.setMargins(300, 0, 0, 0); // left, top, right, bottom
        ok.setLayoutParams(layoutParams);
        ll.addView(ok);

        TextView t4 = new TextView(this);
        t4.setText("\n");
        t4.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        ll.addView(t4);

        ok.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                GlobalVariable gv = (GlobalVariable) getApplicationContext();
                List<Integer> changeResult = new ArrayList<Integer>();
                for(int i=0;i<23;i++) {
                    if(gv.ss[i].isChecked()==true) {
                        changeResult.add(i);
                    }
                }
                gv.changeResult = changeResult;
                Intent intent = new Intent(Activity6.this,Activity7.class);
                startActivity(intent);
            }
        });

    }
}
