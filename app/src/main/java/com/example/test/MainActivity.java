package com.example.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Window;
import android.view.WindowManager;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    private int timePassed = 0;
    //private Context context = this;
    //private SharedPreferences timePassedsp = getApplicationContext().getSharedPreferences("TIMEPASSED", MODE_PRIVATE);
    //private SharedPreferences.Editor editor = timePassedsp.edit();
    //private Date currentDate;
    //private DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss",Locale.getDefault());
    //private String timeText = timeFormat.format(currentDate);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        //timePassed = timePassedsp.getInt("TIMEPASSED", 0);
        setContentView(new MyDraw(this, 0));
        //setContentView(R.layout.shopskin);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //timeText = timeFormat.format(currentDate);
        //timePassed = ((timeText.indexOf(0)*10+timeText.indexOf(1))*3600)+((timeText.indexOf(3)*10+timeText.indexOf(4))*60)+((timeText.indexOf(6)*10+timeText.indexOf(7)));
        //editor.putInt("TIMEPASSED",timePassed);
    }
    @Override
    protected void onStop() {
        super.onStop();
        //timeText = timeFormat.format(currentDate);
        //timePassed = ((timeText.indexOf(0)*10+timeText.indexOf(1))*3600)+((timeText.indexOf(3)*10+timeText.indexOf(4))*60)+((timeText.indexOf(6)*10+timeText.indexOf(7)));
        //editor.putInt("TIMEPASSED",timePassed);
    }
}