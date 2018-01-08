package com.example.deoxys.schooltutor;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Others extends AppCompatActivity {
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_others);

        View v = findViewById(R.id.layout);//找到你要设透明背景的layout 的id
        v.getBackground().setAlpha(100);//0~255透明度值
        TextView text =  (TextView) findViewById(R.id.text);
        text.setText("106學年度第1學期行事曆\n" + "http://academic.ntou.edu.tw/ezfiles/3/1003/img/135/ntou-calendar-106.pdf");

    }
}
