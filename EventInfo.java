package com.example.deoxys.schooltutor;

import android.app.TabActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class EventInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_info);
/*
        setContentView(R.layout.activity_main);
        addNewTab(Club.class, "社團活動");
        addNewTab(School.class, "各系活動");
        addNewTab(Department.class, "校際活動");

        getTabHost().setCurrentTab(0);
        getTabHost().requestFocus();

    }


    public void addNewTab(Class<?> cls, String tabName){
        Intent intent = new Intent().setClass(this, cls);
        TabHost.TabSpec spec = getTabHost().newTabSpec(tabName)
                .setIndicator(tabName)
                .setContent(intent);
        getTabHost().addTab(spec);
    }*/}
}
