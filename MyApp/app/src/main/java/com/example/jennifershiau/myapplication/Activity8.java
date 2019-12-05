package com.example.jennifershiau.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.content.Context;

import java.util.List;

public class Activity8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_8);

        GlobalVariable gv = (GlobalVariable) getApplicationContext();
        List<Integer> result = gv.result;

        Context c = getApplicationContext();

        LinearLayout ll = (LinearLayout)findViewById(R.id.ll);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        lp.setMargins(0, 20, 0, 20);

        for (int i = 0; i < result.size(); i++) {
            String imageName = "r" + String.format("%02d", result.get(i));
            ImageView image = new ImageView(this);
            int id = c.getResources().getIdentifier("drawable/"+imageName, null, c.getPackageName());
            image.setImageResource(id);
            image.setLayoutParams(lp);
            image.setAdjustViewBounds(true);
            ll.addView(image);
        }
    }
}
