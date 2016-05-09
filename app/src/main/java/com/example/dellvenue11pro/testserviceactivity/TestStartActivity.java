package com.example.dellvenue11pro.testserviceactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class TestStartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startServiceBtn = (Button)findViewById(R.id.startServiceBtn);
        Button stopServiceBtn = (Button)findViewById(R.id.stopServiceBtn);

        startServiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myStartService(v);
            }
        });

        stopServiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myStopService(v);
            }
        });

    }

    public void myStartService(View view){
        startService(new Intent(this, TestStartService.class));
    }

    public void myStopService(View view){
        stopService(new Intent(this, TestStartService.class));
    }
}
