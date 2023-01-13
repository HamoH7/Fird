package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;

public class Screenshot extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Приложение name, скачивай от сюда - ссылка");
        sendIntent.setType("text/plain");
        startActivity(Intent.createChooser(sendIntent,"Поделиться"));class Timer extends CountDownTimer {
            public Timer() {
                super(8000, 1000);
            }

            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                Intent i = new Intent(Screenshot.this, MainActivity.class);
                startActivity(i);
            }
        }
        Timer t = new Timer();
        t.start();
        //setContentView(R.layout.activity_main);
    }
}
