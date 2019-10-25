package com.example.jennifershiau.myapplication;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

public class Activity1_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1_3);

        SharedPreferences data = getSharedPreferences("user" , MODE_PRIVATE);
        String s = data.getString("bill", "");
        int total = data.getInt("total", 0);

        Calendar rightNow = Calendar.getInstance();
        int year = rightNow.get(Calendar.YEAR);
        int month = rightNow.get(Calendar.MONTH) + 1;

        TextView showBill = (TextView) findViewById(R.id.tv3);
        showBill.setText("                    " + year + "年" + month + "月記帳本\n");
        showBill.append(s);
        showBill.append("\nTotal: $" + total + "\n");
    }
}
