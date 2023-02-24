package com.example.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    public String currentDateandTime = "-1";
    public String foinString = " ";
    private MyDraw myDraw;
    private DrawThread drawThread;
    public static final String APP_PREFERENCES = "mysettings";
    public static final String APP_PREFERENCES_NAME = "foin";
    //SharedPreferences mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
    //SharedPreferences.Editor editor = mSettings.edit();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        //if(mSettings.contains(APP_PREFERENCES_NAME)) {
        //    foinString = (mSettings.getString(APP_PREFERENCES_NAME, ""));
        //}
        setContentView(new MyDraw(this));
        //setContentView(R.layout.shopskin);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //editor.putInt(APP_PREFERENCES_NAME, foin);
        ///editor.apply();
    }
    @Override
    protected void onStop() {
        super.onStop();
        //SharedPreferences mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        //SharedPreferences.Editor editor = mSettings.edit();
        //editor.putInt(APP_PREFERENCES_NAME, foin);
        //editor.apply();
    }
}