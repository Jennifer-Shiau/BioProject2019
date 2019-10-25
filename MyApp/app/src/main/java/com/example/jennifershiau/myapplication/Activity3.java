package com.example.jennifershiau.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

public class Activity3 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button next;

    String[] countryNames={"無","少油","高血壓","高膽固醇","痛風"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3);

        next = (Button)findViewById(R.id.button6);

        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);

        CustomAdapter customAdapter=new CustomAdapter(getApplicationContext(),countryNames);
        spin.setAdapter(customAdapter);
    }

    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id) {
        //Toast.makeText(getApplicationContext(), countryNames[position], Toast.LENGTH_LONG).show();
        GlobalVariable gv = (GlobalVariable)getApplicationContext();
        gv.setOth(position);
        next.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                GlobalVariable gv = (GlobalVariable)getApplicationContext();
                //TextView oth = (TextView)findViewById(R.id.tv10);
                //oth.setText("Selected: " + countryNames[gv.getOth()]);

                Intent intent = new Intent(Activity3.this,Activity4.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}
