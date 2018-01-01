package com.example.deoxys.schooltutor;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class School extends Fragment {
    private String value = "";
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        EventInfo eventInfo = (EventInfo) activity;
        value = "海洋廳\n" +
                "12/26  18:00-21:00  商船之夜\n" +
                "展演廳\n" +
                "12/27  18:00-21:00  聖誕趴-耶癲瘋Merry\n";
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_school, container, false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TextView txtResult = (TextView) this.getView().findViewById(R.id.text);
        txtResult.setText(value);
        txtResult.setTextColor(Color.rgb(0,0,0));
    }
}