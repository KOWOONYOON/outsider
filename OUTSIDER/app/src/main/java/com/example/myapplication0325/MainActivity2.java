package com.example.myapplication0325;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity2 extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv = findViewById(R.id.tv);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/DD HH:mm:ss");
        String time = sdf.format(new Date(System.currentTimeMillis())).toString();

        tv.setText(time);
    }
}