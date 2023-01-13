package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        class Timer extends CountDownTimer {
            public Timer() {
                super(3000, 1000);
            }

            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                Intent i = new Intent(IntroActivity.this, MainActivity.class);
                startActivity(i);
            }
        }
        Timer t = new Timer();
        t.start();
    }
}
