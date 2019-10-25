package com.example.jennifershiau.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Calendar;

public class Activity2_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_2);

        Button next = (Button)findViewById(R.id.button8);
        next.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                EditText c = (EditText)findViewById(R.id.etCal);
                int cal = Integer.parseInt(c.getEditableText().toString());
                GlobalVariable gv = (GlobalVariable)getApplicationContext();
                gv.setCal(cal);

                Calendar rightNow = Calendar.getInstance();
                int hour = rightNow.get(Calendar.HOUR_OF_DAY);
                int cal_t;
                if (hour>=10 && hour<=15) {
                    cal_t = cal*5/2;
                }
                else {
                    cal_t = cal*10/3;
                }
                gv.setCalt(cal_t);

                Intent intent = new Intent(Activity2_2.this,Activity3.class);
                startActivity(intent);
            }
        });
    }
}
