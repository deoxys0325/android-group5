package com.example.deoxys.schooltutor;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Department extends Fragment {
    private String value = "";
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        EventInfo eventInfo = (EventInfo) activity;
        value = "展演廳\n" +
                "12/1 106年度學生團體評鑑 \n" +
                "育樂館\n" +
                "12/7 106級校歌比賽\n" +
                "12/21 耶誕演唱會\n";
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_department, container, false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TextView txtResult = (TextView) this.getView().findViewById(R.id.text);
        txtResult.setText(value);
        txtResult.setTextColor(Color.rgb(0,0,0));
    }
}