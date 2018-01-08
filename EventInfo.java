package com.example.deoxys.schooltutor;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.View;

public class EventInfo extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_info);

        View v = findViewById(R.id.layout);//找到你要设透明背景的layout 的id
        v.getBackground().setAlpha(100);//0~255透明度值
        FragmentTabHost tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        tabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        //1
        tabHost.addTab(tabHost.newTabSpec("社團活動")
                        .setIndicator("社團活動"),
                Club.class,
                null);
        //2
        tabHost.addTab(tabHost.newTabSpec("系上活動")
                        .setIndicator("系上活動"),
                School.class,
                null);
        //3
        tabHost.addTab(tabHost.newTabSpec("校際活動")
                        .setIndicator("校際活動"),
                Department.class,
                null);
    }

}