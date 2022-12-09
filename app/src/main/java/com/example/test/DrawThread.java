package com.example.test;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

import androidx.core.content.res.ResourcesCompat;

public class DrawThread extends Thread {
    private  SurfaceHolder surfaceHolder;
    private float lastTouchX = 0;
    private float lastTouchY = 0;
    private int m = 0, n = 0, m1 = 0, m2 = 0, m3 = 0, m4 = 0, eat = 0, e = 0, eatTimer = 10, m5 = 0, p = 0, playTimer = 15, play = 0;
    private double h = (float)1/36;
    private double s = (float) 1 / 96;
    private double q = (float) 1 / 54;
    private double k = (float) 1 / 60;
    private double food = (float) 1 / 10;
    private double smile = (float) 1 / 7;
    private float hungryRight = 0, happyRight = 0, sleepRight = 0, dirtRight = 0, lifeRight = 0;
    private int life, dirt, hungry, sleep,happy;
    private boolean ea = false, pl = false;
    private boolean playingTimeIsPassed = false;
    private boolean playingNeedToDrawNow = false;
    private boolean checkPlayButton = false;
    private boolean drawPlayButton = false;
    private boolean playChecker = true;
    private boolean eating = false;
    private boolean playing = false;
    private boolean eatChecker = true;
    private boolean checkEatButton = false;
    private boolean drawEatButton = false;
    private boolean eatingTimeIsPassed = false;
    private boolean eatingNeedToDrawNow = false;
    private boolean hungryTimeIsPassed = false;
    private boolean hungryNeedToDrawNow = false;
    private boolean happyTimeIsPassed = false;
    private boolean happyNeedToDrawNow = false;
    private boolean sleepTimeIsPassed = false;
    private boolean sleepNeedToDrawNow = false;
    private boolean dirtTimeIsPassed = false;
    private boolean dirtNeedToDrawNow = false;
    private boolean timeIsPassed1 = false;
    private boolean needToDrawNow1 = false;
    private boolean timeIsPassed2 = false;
    private boolean needToDrawNow2 = false;
    private boolean check = false;
    private Bitmap eat1Bitmap, eat2Bitmap, eat3Bitmap, eat4Bitmap, eat5Bitmap, eat6Bitmap, eat7Bitmap, eat8Bitmap, eat9Bitmap, eat10Bitmap;
    private Bitmap eatDarkButtonBitmap1, eatDarkButtonBitmap2, eatDarkButtonBitmap3, eatDarkButtonBitmap4, eatDarkButtonBitmap5,
            eatDarkButtonBitmap6, eatDarkButtonBitmap7, eatDarkButtonBitmap8, eatDarkButtonBitmap9, eatDarkButtonBitmap10;
    private Bitmap play1Bitmap, play2Bitmap, play3Bitmap, play4Bitmap, play5Bitmap, play6Bitmap, play7Bitmap, play8Bitmap, play9Bitmap, play10Bitmap, play11Bitmap, play12Bitmap, play13Bitmap, play14Bitmap, play15Bitmap, play16Bitmap, play17Bitmap, play18Bitmap, play19Bitmap, play20Bitmap;
    private Bitmap playDarkButtonBitmap1, playDarkButtonBitmap2, playDarkButtonBitmap3, playDarkButtonBitmap4, playDarkButtonBitmap5,
            playDarkButtonBitmap6, playDarkButtonBitmap7, playDarkButtonBitmap8, playDarkButtonBitmap9, playDarkButtonBitmap10, playDarkButtonBitmap11, playDarkButtonBitmap12, playDarkButtonBitmap13, playDarkButtonBitmap14, playDarkButtonBitmap15;
    private Bitmap playButtonBitmap, playButtonBitmap2;
    private Bitmap bitmapGrass,bitmapbg,bitmapkust,bitmapHeart, bitmapDirt, bitmapHungry,bitmapSleep, bitmapHappy, eatButtonBitmap, eatButtonBitmap2, highScoreBitmap, scoreBitmap;
    private Bitmap bitmap, bitmapDTSH1, bitmapDTSH2, bitmapDTS1, bitmapDTS2, bitmapDTH1, bitmapDTH2, bitmapDSH1, bitmapDSH2, bitmapTSH1, bitmapTSH2,
            bitmapDH1, bitmapDH2, bitmapDS1, bitmapDS2, bitmapDT1, bitmapDT2, bitmapSH1, bitmapSH2, bitmapTH1,bitmapTH2,bitmapTS1,bitmapTS2
            ,bitmapD1,bitmapD2,bitmapT1,bitmapT2,bitmapS1,bitmapS2,bitmapH1,bitmapH2,bitmapSmile1,bitmapSmile2,bitmapUsual1,bitmapUsual2, bitmap1, bitmap2;
    private Bitmap eat1BitmapD, eat2BitmapD, eat3BitmapD, eat4BitmapD, eat5BitmapD, eat6BitmapD, eat7BitmapD, eat8BitmapD, eat9BitmapD, eat10BitmapD;
    private Bitmap eat1BitmapDS, eat2BitmapDS, eat3BitmapDS, eat4BitmapDS, eat5BitmapDS, eat6BitmapDS, eat7BitmapDS, eat8BitmapDS, eat9BitmapDS, eat10BitmapDS;
    private Bitmap eat1BitmapDT, eat2BitmapDT, eat3BitmapDT, eat4BitmapDT, eat5BitmapDT, eat6BitmapDT, eat7BitmapDT, eat8BitmapDT, eat9BitmapDT, eat10BitmapDT;
    private Bitmap eat1BitmapDTS, eat2BitmapDTS, eat3BitmapDTS, eat4BitmapDTS, eat5BitmapDTS, eat6BitmapDTS, eat7BitmapDTS, eat8BitmapDTS, eat9BitmapDTS, eat10BitmapDTS;
    private Bitmap eat1BitmapS, eat2BitmapS, eat3BitmapS, eat4BitmapS, eat5BitmapS, eat6BitmapS, eat7BitmapS, eat8BitmapS, eat9BitmapS, eat10BitmapS;
    private Bitmap eat1BitmapT, eat2BitmapT, eat3BitmapT, eat4BitmapT, eat5BitmapT, eat6BitmapT, eat7BitmapT, eat8BitmapT, eat9BitmapT, eat10BitmapT;
    private Bitmap eat1BitmapTS, eat2BitmapTS, eat3BitmapTS, eat4BitmapTS, eat5BitmapTS, eat6BitmapTS, eat7BitmapTS, eat8BitmapTS, eat9BitmapTS, eat10BitmapTS;
    private Bitmap eat1BitmapSmile, eat2BitmapSmile, eat3BitmapSmile, eat4BitmapSmile, eat5BitmapSmile, eat6BitmapSmile, eat7BitmapSmile, eat8BitmapSmile, eat9BitmapSmile, eat10BitmapSmile;
    private volatile boolean running = true;
    Paint paint = new Paint();
    Paint paintLife = new Paint();
    Paint paintDirt = new Paint();
    Paint paintHungry = new Paint();
    Paint paintSleep = new Paint();
    Paint paintHappy = new Paint();
    Paint paintBlack = new Paint();
    public DrawThread(Context context, SurfaceHolder surfaceHolder) {
        this.surfaceHolder = surfaceHolder;
        bitmapUsual1 = BitmapFactory.decodeResource(context.getResources(),R.drawable.sovorakan1);
        bitmapUsual2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.sovorakan2);
        bitmapDTSH1 = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_t_s_h_1);
        bitmapDTSH2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_t_s_h_2);
        bitmapDTS1 = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_t_s_1);
        bitmapDTS2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_t_s_2);
        bitmapDTH1 = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_t_h_1);
        bitmapDTH2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_t_h_2);
        bitmapDSH1 = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_s_h_1);
        bitmapDSH2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_s_h_2);
        bitmapTSH1 = BitmapFactory.decodeResource(context.getResources(),R.drawable.t_s_h_1);
        bitmapTSH2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.t_s_h_2);
        bitmapDH1 = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_h_1);
        bitmapDH2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_h_2);
        bitmapDS1 = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_s_1);
        bitmapDS2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_s_2);
        bitmapDT1 = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_t_1);
        bitmapDT2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_t_2);
        bitmapSH1 = BitmapFactory.decodeResource(context.getResources(),R.drawable.s_h_1);
        bitmapSH2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.s_h_2);
        bitmapTH1 = BitmapFactory.decodeResource(context.getResources(),R.drawable.t_h_1);
        bitmapTH2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.t_h_2);
        bitmapTS1 = BitmapFactory.decodeResource(context.getResources(),R.drawable.t_s_1);
        bitmapTS2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.t_s_2);
        bitmapD1 = BitmapFactory.decodeResource(context.getResources(),R.drawable.kextot1);
        bitmapD2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.kextot2);
        bitmapT1 = BitmapFactory.decodeResource(context.getResources(),R.drawable.hognac1);
        bitmapT2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.hognac2);
        bitmapS1 = BitmapFactory.decodeResource(context.getResources(),R.drawable.txur1);
        bitmapS2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.txur2);
        bitmapH1 = BitmapFactory.decodeResource(context.getResources(),R.drawable.sovac1);
        bitmapH2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.sovac2);
        bitmapSmile1 = BitmapFactory.decodeResource(context.getResources(),R.drawable.urax1);
        bitmapSmile2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.urax2);
        eat1Bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.utox1);
        eat2Bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.utox2);
        eat3Bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.utox3);
        eat4Bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.utox4);
        eat5Bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.utox5);
        eat6Bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.utox6);
        eat7Bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.utox7);
        eat8Bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.utox8);
        eat9Bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.utox9);
        eat10Bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.utox10);
        play1Bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox1);
        play2Bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox2);
        play3Bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox3);
        play4Bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox4);
        play5Bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox5);
        play6Bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox6);
        play7Bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox7);
        play8Bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox8);
        play9Bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox9);
        play10Bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox10);
        play11Bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox11);
        play12Bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox12);
        play13Bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox13);
        play14Bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox14);
        play15Bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox15);
        play16Bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox16);
        play17Bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox17);
        play18Bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox18);
        play19Bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox19);
        play20Bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox20);
        eat1BitmapD = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_1);
        eat2BitmapD = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_2);
        eat3BitmapD = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_3);
        eat4BitmapD = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_4);
        eat5BitmapD = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_5);
        eat6BitmapD = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_6);
        eat7BitmapD = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_7);
        eat8BitmapD = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_8);
        eat9BitmapD = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_9);
        eat10BitmapD = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_10);
        eat1BitmapDS = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_s_1);
        eat2BitmapDS = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_s_2);
        eat3BitmapDS = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_s_3);
        eat4BitmapDS = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_s_4);
        eat5BitmapDS = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_s_5);
        eat6BitmapDS = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_s_6);
        eat7BitmapDS = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_s_7);
        eat8BitmapDS = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_s_8);
        eat9BitmapDS = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_s_9);
        eat10BitmapDS = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_s_10);
        eat1BitmapDT = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_t_1);
        eat2BitmapDT = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_t_2);
        eat3BitmapDT = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_t_3);
        eat4BitmapDT = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_t_4);
        eat5BitmapDT = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_t_5);
        eat6BitmapDT = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_t_6);
        eat7BitmapDT = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_t_7);
        eat8BitmapDT = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_t_8);
        eat9BitmapDT = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_t_9);
        eat10BitmapDT = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_t_10);
        eat1BitmapDTS = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_t_s_1);
        eat2BitmapDTS = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_t_s_2);
        eat3BitmapDTS = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_t_s_3);
        eat4BitmapDTS = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_t_s_4);
        eat5BitmapDTS = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_t_s_5);
        eat6BitmapDTS = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_t_s_6);
        eat7BitmapDTS = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_t_s_7);
        eat8BitmapDTS = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_t_s_8);
        eat9BitmapDTS = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_t_s_9);
        eat10BitmapDTS = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_t_s_10);
        eat1BitmapS = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_s_1);
        eat2BitmapS = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_s_2);
        eat3BitmapS = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_s_3);
        eat4BitmapS = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_s_4);
        eat5BitmapS = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_s_5);
        eat6BitmapS = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_s_6);
        eat7BitmapS = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_s_7);
        eat8BitmapS = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_s_8);
        eat9BitmapS = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_s_9);
        eat10BitmapS = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_s_10);
        eat1BitmapT = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_t_1);
        eat2BitmapT = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_t_2);
        eat3BitmapT = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_t_3);
        eat4BitmapT = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_t_4);
        eat5BitmapT = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_t_5);
        eat6BitmapT = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_t_6);
        eat7BitmapT = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_t_7);
        eat8BitmapT = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_t_8);
        eat9BitmapT = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_t_9);
        eat10BitmapT = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_t_10);
        eat1BitmapTS = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_t_s_1);
        eat2BitmapTS = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_t_s_2);
        eat3BitmapTS = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_t_s_3);
        eat4BitmapTS = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_t_s_4);
        eat5BitmapTS = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_t_s_5);
        eat6BitmapTS = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_t_s_6);
        eat7BitmapTS = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_t_s_7);
        eat8BitmapTS = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_t_s_8);
        eat9BitmapTS = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_t_s_9);
        eat10BitmapTS = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_t_s_10);
        eat1BitmapSmile = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_hp_1);
        eat2BitmapSmile = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_hp_2);
        eat3BitmapSmile = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_hp_3);
        eat4BitmapSmile = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_hp_4);
        eat5BitmapSmile = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_hp_5);
        eat6BitmapSmile = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_hp_6);
        eat7BitmapSmile = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_hp_7);
        eat8BitmapSmile = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_hp_8);
        eat9BitmapSmile = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_hp_9);
        eat10BitmapSmile = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_hp_10);
        eatDarkButtonBitmap1 = BitmapFactory.decodeResource(context.getResources(), R.drawable.mc1);
        eatDarkButtonBitmap2 = BitmapFactory.decodeResource(context.getResources(), R.drawable.mc2);
        eatDarkButtonBitmap3 = BitmapFactory.decodeResource(context.getResources(), R.drawable.mc3);
        eatDarkButtonBitmap4 = BitmapFactory.decodeResource(context.getResources(), R.drawable.mc4);
        eatDarkButtonBitmap5 = BitmapFactory.decodeResource(context.getResources(), R.drawable.mc5);
        eatDarkButtonBitmap6 = BitmapFactory.decodeResource(context.getResources(), R.drawable.mc6);
        eatDarkButtonBitmap7 = BitmapFactory.decodeResource(context.getResources(), R.drawable.mc7);
        eatDarkButtonBitmap8 = BitmapFactory.decodeResource(context.getResources(), R.drawable.mc8);
        eatDarkButtonBitmap9 = BitmapFactory.decodeResource(context.getResources(), R.drawable.mc9);
        eatDarkButtonBitmap10 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mc10);
        playDarkButtonBitmap1 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mp1);
        playDarkButtonBitmap2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mp2);
        playDarkButtonBitmap3 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mp3);
        playDarkButtonBitmap4 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mp4);
        playDarkButtonBitmap5 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mp5);
        playDarkButtonBitmap6 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mp6);
        playDarkButtonBitmap7 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mp7);
        playDarkButtonBitmap8 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mp8);
        playDarkButtonBitmap9 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mp9);
        playDarkButtonBitmap10 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mp10);
        playDarkButtonBitmap11 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mp11);
        playDarkButtonBitmap12 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mp12);
        playDarkButtonBitmap13 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mp13);
        playDarkButtonBitmap14 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mp14);
        playDarkButtonBitmap15 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mp15);
        bitmapGrass = BitmapFactory.decodeResource(context.getResources(), R.drawable.xot);
        bitmapbg = BitmapFactory.decodeResource(context.getResources(), R.drawable.erkinq);
        bitmapkust = BitmapFactory.decodeResource(context.getResources(), R.drawable.kustik);
        bitmapHeart = BitmapFactory.decodeResource(context.getResources(), R.drawable.srtik);
        bitmapDirt = BitmapFactory.decodeResource(context.getResources(),R.drawable.kextik);
        bitmapHungry = BitmapFactory.decodeResource(context.getResources(),R.drawable.tarelka);
        bitmapSleep = BitmapFactory.decodeResource(context.getResources(),R.drawable.zzz);
        bitmapHappy = BitmapFactory.decodeResource(context.getResources(),R.drawable.smilik);
        eatButtonBitmap =  BitmapFactory.decodeResource(context.getResources(), R.drawable.chervyak);
        eatButtonBitmap2 =  BitmapFactory.decodeResource(context.getResources(),R.drawable.chervyak);
        playButtonBitmap =  BitmapFactory.decodeResource(context.getResources(), R.drawable.petur);
        playButtonBitmap2 =  BitmapFactory.decodeResource(context.getResources(),R.drawable.petur);
        highScoreBitmap =  BitmapFactory.decodeResource(context.getResources(),R.drawable.highscore);
        scoreBitmap =  BitmapFactory.decodeResource(context.getResources(),R.drawable.score);
        bitmap = bitmapSmile1;
        life = ResourcesCompat.getColor(context.getResources(),R.color.life,null);
        dirt = ResourcesCompat.getColor(context.getResources(),R.color.dirt,null);
        hungry = ResourcesCompat.getColor(context.getResources(),R.color.hungry,null);
        sleep = ResourcesCompat.getColor(context.getResources(),R.color.sleep,null);
        happy = ResourcesCompat.getColor(context.getResources(),R.color.happy,null);
    }

    public DrawThread() {}

    public void setTouch(int x, int y){
        lastTouchX = x;
        lastTouchY = y;
    }
    public void requestStop() {
        running = false;
    }
    @Override
    public void run() {
        while (running) {
            Canvas canvas = surfaceHolder.lockCanvas();
            if (canvas != null) {
                try {
                    paintBlack.setColor(Color.BLACK);
                    paintBlack.setStyle(Paint.Style.STROKE);
                    paintBlack.setStrokeWidth((float) canvas.getWidth()/540);
                    // background
                    bitmapGrass = Bitmap.createScaledBitmap(bitmapGrass,canvas.getWidth(),canvas.getHeight()/2,true);
                    bitmapbg = Bitmap.createScaledBitmap(bitmapbg,canvas.getWidth(),canvas.getHeight(),true);
                    bitmapkust = Bitmap.createScaledBitmap(bitmapkust,canvas.getWidth()*245/1050,canvas.getHeight()*180/540,true);
                    paint.setSubpixelText(true);paint.setAntiAlias(true);paintLife.setSubpixelText(true);paintLife.setAntiAlias(true);paintBlack.setSubpixelText(true);paintBlack.setAntiAlias(true);
                    //hetevi fon
                    canvas.drawBitmap(bitmapbg,0,0,paint);
                    canvas.drawBitmap(bitmapGrass,0,(float)canvas.getHeight() / 2,paint);
                    canvas.drawBitmap(bitmapkust,(float) canvas.getWidth()*29/1050,(float)canvas.getHeight() *230/540,paint);
                    // highscore/score
                    highScoreBitmap = Bitmap.createScaledBitmap(highScoreBitmap,canvas.getWidth()*212/1050,canvas.getHeight()*53/540,true);
                    canvas.drawBitmap(highScoreBitmap,0,(float)canvas.getHeight()*10/540,paint);
                    scoreBitmap = Bitmap.createScaledBitmap(scoreBitmap,canvas.getWidth()*119/1050,canvas.getHeight()*43/540,true);
                    canvas.drawBitmap(scoreBitmap,0,(float)canvas.getHeight()*67/540,paint);
                    // kyanqy
                    float lifeLeft = (float) canvas.getWidth()*844/1050;
                    float lifeTop = (float)canvas.getHeight()*8/540;
                    if(m2 == 0){lifeRight = (float)canvas.getWidth()*1040/1050; m2 = 1;}
                    float lifeRight2 = (float)canvas.getWidth()*1040/1050;
                    float lifeBottom = (float)canvas.getHeight()*42/540;
                    paintLife.setColor(life);
                    canvas.drawRect((float) canvas.getWidth()*843/1050,(float)canvas.getHeight()*7/540,
                            (float)canvas.getWidth()*1041/1050,(float)canvas.getHeight()*43/540,paintBlack);
                    canvas.drawRect(lifeLeft,lifeTop,lifeRight,lifeBottom,paintLife);
                    // kextotutyun
                    paintDirt.setColor(dirt);
                    float dirtLeft = (float) canvas.getWidth()*877/1050;
                    float dirtTop = (float) canvas.getHeight()*55/540;
                    float dirtRight2 = (float) canvas.getWidth()*1040/1050;
                    float dirtWeight = dirtRight2 - dirtLeft;
                    if(m3 == 0){dirtRight = (float) canvas.getWidth()*1040/1050;m3 = 1;}
                    float dirtBottom = (float) canvas.getHeight()*79/540;
                    canvas.drawRect( (float) canvas.getWidth()*876/1050, (float) canvas.getHeight()*54/540,
                            (float) canvas.getWidth()*1041/1050, (float) canvas.getHeight()*80/540,paintBlack);
                    canvas.drawRect(dirtLeft,dirtTop,dirtRight,dirtBottom,paintDirt);
                    // kexti timer
                    if(!dirtTimeIsPassed){
                        new DirtTimerThread().start();
                        dirtTimeIsPassed = true;
                    }
                    if (dirtNeedToDrawNow){
                        if(dirtRight - k* dirtWeight >= dirtLeft) {
                            k *= dirtWeight;
                            dirtRight -= k;
                            canvas.drawRect(dirtLeft,dirtTop,dirtRight,dirtBottom,paintDirt);
                            k/=  dirtWeight;
                        }
                        if(dirtRight >= dirtLeft && dirtRight - k* dirtWeight < dirtLeft) {
                            dirtRight = dirtLeft;
                            canvas.drawRect(dirtLeft,dirtTop,dirtRight,dirtBottom,paintDirt);
                        }
                        dirtNeedToDrawNow = false;
                    }
                    // sov
                    paintHungry.setColor(hungry);
                    float hungryLeft = (float) canvas.getWidth()*877/1050;
                    float hungryTop = (float) canvas.getHeight()*92/540;
                    if(n == 0) {hungryRight = (float) canvas.getWidth()*1040/1050;n = 1;}
                    float hungryRight2 = (float) canvas.getWidth()*1040/1050;
                    float hungryWeight = hungryRight2 - hungryLeft;
                    float hungryBottom = (float) canvas.getHeight()*116/540;
                    canvas.drawRect( (float) canvas.getWidth()*876/1050, (float) canvas.getHeight()*91/540,
                            (float) canvas.getWidth()*1041/1050, (float) canvas.getHeight()*117/540,paintBlack);
                    canvas.drawRect(hungryLeft,hungryTop,hungryRight,hungryBottom,paintHungry);
                    // sovi timer
                    if(!hungryTimeIsPassed){
                        new HungryTimerThread().start();
                        hungryTimeIsPassed = true;
                    }
                    if (hungryNeedToDrawNow){
                        if(hungryRight - h*hungryWeight >= hungryLeft) {
                            h *= hungryWeight;
                            hungryRight -= h;
                            canvas.drawRect(hungryLeft,hungryTop,hungryRight,hungryBottom,paintHungry);
                            h/= hungryWeight;
                        }
                        if(hungryRight >= hungryLeft && hungryRight - h*hungryWeight < hungryLeft) {
                            hungryRight = hungryLeft;
                            canvas.drawRect(hungryLeft,hungryTop,hungryRight,hungryBottom,paintHungry);
                        }
                        hungryNeedToDrawNow = false;
                    }
                    // qun
                    paintSleep.setColor(sleep);
                    float sleepLeft = (float) canvas.getWidth()*877/1050;
                    float sleepTop = (float) canvas.getHeight()*129/540;
                    float sleepRight2 = (float) canvas.getWidth()*1040/1050;
                    float sleepWeight = sleepRight2 - sleepLeft;
                    if(m4 == 0){sleepRight = (float) canvas.getWidth()*1040/1050;m4 = 1;}
                    float sleepBottom = (float) canvas.getHeight()*153/540;
                    canvas.drawRect( (float) canvas.getWidth()*876/1050, (float) canvas.getHeight()*128/540,
                            (float) canvas.getWidth()*1041/1050, (float) canvas.getHeight()*154/540,paintBlack);
                    canvas.drawRect(sleepLeft, sleepTop, sleepRight, sleepBottom, paintSleep);
                    // qni timer
                    if(!sleepTimeIsPassed){
                        new SleepTimerThread().start();
                        sleepTimeIsPassed = true;
                    }
                    if (sleepNeedToDrawNow){
                        if(sleepRight - q*sleepWeight >= sleepLeft) {
                            q *= sleepWeight;
                            sleepRight -= q;
                            canvas.drawRect(sleepLeft,sleepTop,sleepRight,sleepBottom,paintSleep);
                            q /= sleepWeight;
                        }
                        if(sleepRight >= sleepLeft && sleepRight - q*sleepWeight < sleepLeft) {
                            sleepRight = sleepLeft;
                            canvas.drawRect(sleepLeft,sleepTop,sleepRight,sleepBottom,paintSleep);
                        }
                        sleepNeedToDrawNow = false;
                    }

                    // uraxutyun
                    paintHappy.setColor(happy);
                    float happyLeft = (float) canvas.getWidth()*877/1050;
                    float happyTop = (float) canvas.getHeight()*166/540;
                    if(m1 == 0) {happyRight = (float) canvas.getWidth()*1040/1050;m1 = 1;}
                    float happyRight2 = (float) canvas.getWidth()*1040/1050;
                    float happyWeight = happyRight2 - happyLeft;
                    float happyBottom = (float) canvas.getHeight()*190/540;
                    canvas.drawRect( (float) canvas.getWidth()*876/1050, (float) canvas.getHeight()*165/540,
                            (float) canvas.getWidth()*1041/1050, (float) canvas.getHeight()*191/540,paintBlack);
                    canvas.drawRect(happyLeft,happyTop,happyRight,happyBottom,paintHappy);
                    // uraxutyan timer
                    if(!happyTimeIsPassed){
                        new HappyTimerThread().start();
                        happyTimeIsPassed = true;
                    }
                    if (happyNeedToDrawNow){
                        if(happyRight - s*happyWeight >= happyLeft) {
                            s *= happyWeight;
                            happyRight -= s;
                            canvas.drawRect(happyLeft,happyTop,happyRight,happyBottom,paintHappy);
                            s /= happyWeight;
                        }
                        if(happyRight >= happyLeft && happyRight - s*happyWeight < happyLeft) {
                            happyRight = happyLeft;
                            canvas.drawRect(happyLeft,happyTop,happyRight,happyBottom,paintHappy);
                        }
                        happyNeedToDrawNow = false;
                    }
                    // srtik
                    bitmapHeart = Bitmap.createScaledBitmap(bitmapHeart,canvas.getWidth()*49/1050,canvas.getHeight()*46/540,true);
                    canvas.drawBitmap(bitmapHeart,(float) canvas.getWidth()*816/1050,0,paint);
                    // kext
                    bitmapDirt = Bitmap.createScaledBitmap(bitmapDirt,canvas.getWidth()*60/1050,canvas.getHeight()*51/540,true);
                    canvas.drawBitmap(bitmapDirt,(float) canvas.getWidth()*840/1050,(float) canvas.getHeight()*41/540,paint);
                    // tarelka
                    bitmapHungry = Bitmap.createScaledBitmap(bitmapHungry,canvas.getWidth()*46/1050,canvas.getHeight()*33/540,true);
                    canvas.drawBitmap(bitmapHungry,(float) canvas.getWidth()*850/1050,(float) canvas.getHeight()*87/540,paint);
                    // Zzz
                    bitmapSleep = Bitmap.createScaledBitmap(bitmapSleep,canvas.getWidth()*52/1050,canvas.getHeight()*57/540,true);
                    canvas.drawBitmap(bitmapSleep,(float) canvas.getWidth()*853/1050,(float) canvas.getHeight()*110/540,paint);
                    // Smilik
                    bitmapHappy = Bitmap.createScaledBitmap(bitmapHappy,canvas.getWidth()*34/1050,canvas.getHeight()*35/540,true);
                    canvas.drawBitmap(bitmapHappy,(float) canvas.getWidth()*862/1050,(float) canvas.getHeight()*161/540,paint);
                    // cter
                    bitmapUsual1 = Bitmap.createScaledBitmap(bitmapUsual1,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapUsual2 = Bitmap.createScaledBitmap(bitmapUsual2,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapDTSH1 = Bitmap.createScaledBitmap(bitmapDTSH1,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapDTSH2 = Bitmap.createScaledBitmap(bitmapDTSH2,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapDTS1 = Bitmap.createScaledBitmap(bitmapDTS1,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapDTS2 = Bitmap.createScaledBitmap(bitmapDTS2,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapDTH1 = Bitmap.createScaledBitmap(bitmapDTH1,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapDTH2 = Bitmap.createScaledBitmap(bitmapDTH2,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapDSH1 = Bitmap.createScaledBitmap(bitmapDSH1,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapDSH2 = Bitmap.createScaledBitmap(bitmapDSH2,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapTSH1 = Bitmap.createScaledBitmap(bitmapTSH1,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapTSH2 = Bitmap.createScaledBitmap(bitmapTSH2,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapDH1 = Bitmap.createScaledBitmap(bitmapDH1,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapDH2 = Bitmap.createScaledBitmap(bitmapDH2,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapDS1 = Bitmap.createScaledBitmap(bitmapDS1,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapDS2 = Bitmap.createScaledBitmap(bitmapDS2,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapDT1 = Bitmap.createScaledBitmap(bitmapDT1,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapDT2 = Bitmap.createScaledBitmap(bitmapDT2,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapSH1 = Bitmap.createScaledBitmap(bitmapSH1,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapSH2 = Bitmap.createScaledBitmap(bitmapSH2,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapTH1 = Bitmap.createScaledBitmap(bitmapTH1,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapTH2 = Bitmap.createScaledBitmap(bitmapTH2,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapTS1 = Bitmap.createScaledBitmap(bitmapTS1,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapTS2 = Bitmap.createScaledBitmap(bitmapTS2,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapD1 = Bitmap.createScaledBitmap(bitmapD1,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapD2 = Bitmap.createScaledBitmap(bitmapD2,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapT1 = Bitmap.createScaledBitmap(bitmapT1,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapT2 = Bitmap.createScaledBitmap(bitmapT2,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapS1 = Bitmap.createScaledBitmap(bitmapS1,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapS2 = Bitmap.createScaledBitmap(bitmapS2,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapH1 = Bitmap.createScaledBitmap(bitmapH1,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapH2 = Bitmap.createScaledBitmap(bitmapH2,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapSmile1 = Bitmap.createScaledBitmap(bitmapSmile1,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapSmile2 = Bitmap.createScaledBitmap(bitmapSmile2,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    if(hungryRight - hungryLeft < hungryWeight / 2. && dirtRight - dirtLeft< dirtWeight / 2. && happyRight - happyLeft < happyWeight / 3. && sleepRight - sleepLeft< sleepWeight / 2.) {
                        bitmap1 = bitmapDTSH1;
                        bitmap2 = bitmapDTSH2;
                    }
                    else if (dirtRight  - dirtLeft< dirtWeight / 2. && happyRight - happyLeft < happyWeight / 3. && sleepRight - sleepLeft< sleepWeight / 2.) {
                        bitmap1 = bitmapDTS1;
                        bitmap2 = bitmapDTS2;
                    }
                    else if (hungryRight - hungryLeft < hungryWeight / 2. && happyRight - happyLeft < happyWeight / 3. && sleepRight - sleepLeft < sleepWeight / 2.) {
                        bitmap1 = bitmapTSH1;
                        bitmap2 = bitmapTSH2;
                    }
                    else if (hungryRight - hungryLeft < hungryWeight / 2. && dirtRight - dirtLeft< dirtWeight / 2. && sleepRight - sleepLeft < sleepWeight / 2.) {
                        bitmap1 = bitmapDTH1;
                        bitmap2 = bitmapDTH2;
                    }
                    else if (hungryRight - hungryLeft < hungryWeight / 2. && dirtRight - dirtLeft < dirtWeight / 2. && happyRight - happyLeft < happyWeight / 3.) {
                        bitmap1 = bitmapDSH1;
                        bitmap2 = bitmapDSH2;
                    }
                    else if (hungryRight - hungryLeft < hungryWeight / 2. && dirtRight - dirtLeft < dirtWeight / 2.) {
                        bitmap1 = bitmapDH1;
                        bitmap2 = bitmapDH2;
                    }
                    else if (dirtRight - dirtLeft < dirtWeight / 2. && happyRight - happyLeft < happyWeight / 3.) {
                        bitmap1 = bitmapDS1;
                        bitmap2 = bitmapDS2;
                    }
                    else if (dirtRight - dirtLeft < dirtWeight / 2. && sleepRight - sleepLeft < sleepWeight / 2.) {
                        bitmap1 = bitmapDT1;
                        bitmap2 = bitmapDT2;
                    }
                    else if (hungryRight - hungryLeft < hungryWeight / 2. && happyRight - happyLeft < happyWeight / 3.) {
                        bitmap1 = bitmapSH1;
                        bitmap2 = bitmapSH2;
                    }
                    else if (sleepRight - sleepLeft < sleepWeight / 2. && hungryRight - hungryLeft < hungryWeight / 2.) {
                        bitmap1 = bitmapTH1;
                        bitmap2 = bitmapTH2;
                    }
                    else if (sleepRight - sleepLeft < sleepWeight / 2. && happyRight - happyLeft < happyWeight / 3.) {
                        bitmap1 = bitmapTS1;
                        bitmap2 = bitmapTS2;
                    }
                    else if (dirtRight - dirtLeft < dirtWeight / 2.) {
                        bitmap1 = bitmapD1;
                        bitmap2 = bitmapD2;
                    }
                    else if (sleepRight - sleepLeft < sleepWeight / 2.) {
                        bitmap1 = bitmapT1;
                        bitmap2 = bitmapT2;
                    }
                    else if (happyRight - happyLeft < happyWeight / 3.) {
                        bitmap1 = bitmapS1;
                        bitmap2 = bitmapS2;
                    }
                    else if (hungryRight - hungryLeft < hungryWeight / 2.) {
                        bitmap1 = bitmapH1;
                        bitmap2 = bitmapH2;
                    }
                    else if(happyRight - happyLeft < (2.)*happyWeight/3.) {
                        bitmap1 = bitmapUsual1;
                        bitmap2 = bitmapUsual2;
                    }
                    else {
                        bitmap1 = bitmapSmile1;
                        bitmap2 = bitmapSmile2;
                    }
                    if(m == 0) {bitmap = bitmap1;m = 1;}
                    //utox cit
                    eat1Bitmap = Bitmap.createScaledBitmap(eat1Bitmap,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat2Bitmap = Bitmap.createScaledBitmap(eat2Bitmap,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat3Bitmap = Bitmap.createScaledBitmap(eat3Bitmap,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat4Bitmap = Bitmap.createScaledBitmap(eat4Bitmap,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat5Bitmap = Bitmap.createScaledBitmap(eat5Bitmap,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat6Bitmap = Bitmap.createScaledBitmap(eat6Bitmap,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat7Bitmap = Bitmap.createScaledBitmap(eat7Bitmap,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat8Bitmap = Bitmap.createScaledBitmap(eat8Bitmap,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat9Bitmap = Bitmap.createScaledBitmap(eat9Bitmap,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat10Bitmap = Bitmap.createScaledBitmap(eat10Bitmap,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat1BitmapSmile = Bitmap.createScaledBitmap(eat1BitmapSmile,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat2BitmapSmile = Bitmap.createScaledBitmap(eat2BitmapSmile,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat3BitmapSmile = Bitmap.createScaledBitmap(eat3BitmapSmile,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat4BitmapSmile = Bitmap.createScaledBitmap(eat4BitmapSmile,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat5BitmapSmile = Bitmap.createScaledBitmap(eat5BitmapSmile,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat6BitmapSmile = Bitmap.createScaledBitmap(eat6BitmapSmile,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat7BitmapSmile = Bitmap.createScaledBitmap(eat7BitmapSmile,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat8BitmapSmile = Bitmap.createScaledBitmap(eat8BitmapSmile,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat9BitmapSmile = Bitmap.createScaledBitmap(eat9BitmapSmile,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat10BitmapSmile = Bitmap.createScaledBitmap(eat10BitmapSmile,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat1BitmapD = Bitmap.createScaledBitmap(eat1BitmapD,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat2BitmapD = Bitmap.createScaledBitmap(eat2BitmapD,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat3BitmapD = Bitmap.createScaledBitmap(eat3BitmapD,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat4BitmapD = Bitmap.createScaledBitmap(eat4BitmapD,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat5BitmapD = Bitmap.createScaledBitmap(eat5BitmapD,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat6BitmapD = Bitmap.createScaledBitmap(eat6BitmapD,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat7BitmapD = Bitmap.createScaledBitmap(eat7BitmapD,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat8BitmapD = Bitmap.createScaledBitmap(eat8BitmapD,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat9BitmapD = Bitmap.createScaledBitmap(eat9BitmapD,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat10BitmapD = Bitmap.createScaledBitmap(eat10BitmapD,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat1BitmapDS = Bitmap.createScaledBitmap(eat1BitmapDS,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat2BitmapDS = Bitmap.createScaledBitmap(eat2BitmapDS,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat3BitmapDS = Bitmap.createScaledBitmap(eat3BitmapDS,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat4BitmapDS = Bitmap.createScaledBitmap(eat4BitmapDS,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat5BitmapDS = Bitmap.createScaledBitmap(eat5BitmapDS,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat6BitmapDS = Bitmap.createScaledBitmap(eat6BitmapDS,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat7BitmapDS = Bitmap.createScaledBitmap(eat7BitmapDS,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat8BitmapDS = Bitmap.createScaledBitmap(eat8BitmapDS,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat9BitmapDS = Bitmap.createScaledBitmap(eat9BitmapDS,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat10BitmapDS = Bitmap.createScaledBitmap(eat10BitmapDS,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat1BitmapDT = Bitmap.createScaledBitmap(eat1BitmapDT,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat2BitmapDT = Bitmap.createScaledBitmap(eat2BitmapDT,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat3BitmapDT = Bitmap.createScaledBitmap(eat3BitmapDT,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat4BitmapDT = Bitmap.createScaledBitmap(eat4BitmapDT,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat5BitmapDT = Bitmap.createScaledBitmap(eat5BitmapDT,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat6BitmapDT = Bitmap.createScaledBitmap(eat6BitmapDT,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat7BitmapDT = Bitmap.createScaledBitmap(eat7BitmapDT,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat8BitmapDT = Bitmap.createScaledBitmap(eat8BitmapDT,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat9BitmapDT = Bitmap.createScaledBitmap(eat9BitmapDT,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat10BitmapDT = Bitmap.createScaledBitmap(eat10BitmapDT,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat1BitmapDTS = Bitmap.createScaledBitmap(eat1BitmapDTS,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat2BitmapDTS = Bitmap.createScaledBitmap(eat2BitmapDTS,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat3BitmapDTS = Bitmap.createScaledBitmap(eat3BitmapDTS,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat4BitmapDTS = Bitmap.createScaledBitmap(eat4BitmapDTS,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat5BitmapDTS = Bitmap.createScaledBitmap(eat5BitmapDTS,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat6BitmapDTS = Bitmap.createScaledBitmap(eat6BitmapDTS,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat7BitmapDTS = Bitmap.createScaledBitmap(eat7BitmapDTS,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat8BitmapDTS = Bitmap.createScaledBitmap(eat8BitmapDTS,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat9BitmapDTS = Bitmap.createScaledBitmap(eat9BitmapDTS,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat10BitmapDTS = Bitmap.createScaledBitmap(eat10BitmapDTS,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat1BitmapS = Bitmap.createScaledBitmap(eat1BitmapS,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat2BitmapS = Bitmap.createScaledBitmap(eat2BitmapS,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat3BitmapS = Bitmap.createScaledBitmap(eat3BitmapS,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat4BitmapS = Bitmap.createScaledBitmap(eat4BitmapS,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat5BitmapS = Bitmap.createScaledBitmap(eat5BitmapS,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat6BitmapS = Bitmap.createScaledBitmap(eat6BitmapS,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat7BitmapS = Bitmap.createScaledBitmap(eat7BitmapS,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat8BitmapS = Bitmap.createScaledBitmap(eat8BitmapS,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat9BitmapS = Bitmap.createScaledBitmap(eat9BitmapS,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat10BitmapS = Bitmap.createScaledBitmap(eat10BitmapS,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat1BitmapT = Bitmap.createScaledBitmap(eat1BitmapT,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat2BitmapT = Bitmap.createScaledBitmap(eat2BitmapT,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat3BitmapT = Bitmap.createScaledBitmap(eat3BitmapT,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat4BitmapT = Bitmap.createScaledBitmap(eat4BitmapT,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat5BitmapT = Bitmap.createScaledBitmap(eat5BitmapT,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat6BitmapT = Bitmap.createScaledBitmap(eat6BitmapT,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat7BitmapT = Bitmap.createScaledBitmap(eat7BitmapT,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat8BitmapT = Bitmap.createScaledBitmap(eat8BitmapT,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat9BitmapT = Bitmap.createScaledBitmap(eat9BitmapT,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat10BitmapT = Bitmap.createScaledBitmap(eat10BitmapT,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat1BitmapTS = Bitmap.createScaledBitmap(eat1BitmapTS,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat2BitmapTS = Bitmap.createScaledBitmap(eat2BitmapTS,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat3BitmapTS = Bitmap.createScaledBitmap(eat3BitmapTS,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat4BitmapTS = Bitmap.createScaledBitmap(eat4BitmapTS,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat5BitmapTS = Bitmap.createScaledBitmap(eat5BitmapTS,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat6BitmapTS = Bitmap.createScaledBitmap(eat6BitmapTS,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat7BitmapTS = Bitmap.createScaledBitmap(eat7BitmapTS,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat8BitmapTS = Bitmap.createScaledBitmap(eat8BitmapTS,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat9BitmapTS = Bitmap.createScaledBitmap(eat9BitmapTS,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat10BitmapTS = Bitmap.createScaledBitmap(eat10BitmapTS,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    // urax cit
                    play1Bitmap = Bitmap.createScaledBitmap(play1Bitmap,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play2Bitmap = Bitmap.createScaledBitmap(play2Bitmap,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play3Bitmap = Bitmap.createScaledBitmap(play3Bitmap,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play4Bitmap = Bitmap.createScaledBitmap(play4Bitmap,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play5Bitmap = Bitmap.createScaledBitmap(play5Bitmap,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play6Bitmap = Bitmap.createScaledBitmap(play6Bitmap,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play7Bitmap = Bitmap.createScaledBitmap(play7Bitmap,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play8Bitmap = Bitmap.createScaledBitmap(play8Bitmap,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play9Bitmap = Bitmap.createScaledBitmap(play9Bitmap,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play10Bitmap =Bitmap.createScaledBitmap(play10Bitmap,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play11Bitmap =Bitmap.createScaledBitmap(play11Bitmap,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play12Bitmap =Bitmap.createScaledBitmap(play12Bitmap,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play13Bitmap =Bitmap.createScaledBitmap(play13Bitmap,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play14Bitmap =Bitmap.createScaledBitmap(play14Bitmap,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play15Bitmap =Bitmap.createScaledBitmap(play15Bitmap,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play16Bitmap =Bitmap.createScaledBitmap(play16Bitmap,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play17Bitmap =Bitmap.createScaledBitmap(play17Bitmap,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play18Bitmap =Bitmap.createScaledBitmap(play18Bitmap,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play19Bitmap =Bitmap.createScaledBitmap(play19Bitmap,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play20Bitmap =Bitmap.createScaledBitmap(play20Bitmap,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    // cit
                    canvas.drawBitmap(bitmap,(float) canvas.getWidth() * 419/1050,(float) canvas.getHeight()*232/540,paint);
                    //shnchel
                    if(!eating && !playing) {
                        if (!timeIsPassed1 && !check) {
                            new ThreadBird1().start();
                            timeIsPassed1 = true;
                        }
                        if (needToDrawNow1 && !check) {
                            bitmap = bitmap1;
                        }
                        if (!timeIsPassed2 && check) {
                            new ThreadBird2().start();
                            timeIsPassed2 = true;
                        }
                        if (needToDrawNow2 && check) {
                            bitmap = bitmap2;
                        }
                    }
                    // utelu knopken
                    int eatButtonWidth = canvas.getWidth()*106/1050;
                    int eatButtonHeight = canvas.getHeight()*101/540;
                    float eatButtonLeft = (float) canvas.getWidth()*19/1050;
                    float eatButtonTop = (float) canvas.getHeight()*427/540;
                    eatDarkButtonBitmap1 = Bitmap.createScaledBitmap(eatDarkButtonBitmap1,eatButtonWidth, eatButtonHeight,true);
                    eatDarkButtonBitmap2 = Bitmap.createScaledBitmap(eatDarkButtonBitmap2,eatButtonWidth, eatButtonHeight,true);
                    eatDarkButtonBitmap3 = Bitmap.createScaledBitmap(eatDarkButtonBitmap3,eatButtonWidth, eatButtonHeight,true);
                    eatDarkButtonBitmap4 = Bitmap.createScaledBitmap(eatDarkButtonBitmap4,eatButtonWidth, eatButtonHeight,true);
                    eatDarkButtonBitmap5 = Bitmap.createScaledBitmap(eatDarkButtonBitmap5,eatButtonWidth, eatButtonHeight,true);
                    eatDarkButtonBitmap6 = Bitmap.createScaledBitmap(eatDarkButtonBitmap6,eatButtonWidth, eatButtonHeight,true);
                    eatDarkButtonBitmap7 = Bitmap.createScaledBitmap(eatDarkButtonBitmap7,eatButtonWidth, eatButtonHeight,true);
                    eatDarkButtonBitmap8 = Bitmap.createScaledBitmap(eatDarkButtonBitmap8,eatButtonWidth, eatButtonHeight,true);
                    eatDarkButtonBitmap9 = Bitmap.createScaledBitmap(eatDarkButtonBitmap9,eatButtonWidth, eatButtonHeight,true);
                    eatDarkButtonBitmap10 = Bitmap.createScaledBitmap(eatDarkButtonBitmap10,eatButtonWidth, eatButtonHeight,true);
                    eatButtonBitmap = Bitmap.createScaledBitmap(eatButtonBitmap,eatButtonWidth, eatButtonHeight,true);
                    eatButtonBitmap2 = Bitmap.createScaledBitmap(eatButtonBitmap2,eatButtonWidth, eatButtonHeight,true);
                    if(!eatChecker && checkEatButton) {
                        new EatDarkButtonThread().start();
                        checkEatButton = false;
                    }
                    if(drawEatButton) {
                        switch (eatTimer){
                            case 9:
                                eatButtonBitmap = eatDarkButtonBitmap9;
                                break;
                            case 8:
                                eatButtonBitmap = eatDarkButtonBitmap8;
                                break;
                            case 7:
                                eatButtonBitmap = eatDarkButtonBitmap7;
                                break;
                            case 6:
                                eatButtonBitmap = eatDarkButtonBitmap6;
                                break;
                            case 5:
                                eatButtonBitmap = eatDarkButtonBitmap5;
                                break;
                            case 4:
                                eatButtonBitmap = eatDarkButtonBitmap4;
                                break;
                            case 3:
                                eatButtonBitmap = eatDarkButtonBitmap3;
                                break;
                            case 2:
                                eatButtonBitmap = eatDarkButtonBitmap2;
                                break;
                            case 1:
                                eatButtonBitmap = eatDarkButtonBitmap1;
                                eatChecker = true;
                                lastTouchX = 0;
                                lastTouchY = 0;
                                break;
                            case 0:
                                eatButtonBitmap = eatButtonBitmap2;
                        }
                    }
                    canvas.drawBitmap(eatButtonBitmap,eatButtonLeft,eatButtonTop,paint);
                    // xaxalu knopken
                    int playButtonWidth = canvas.getWidth()*106/1050;
                    int playButtonHeight = canvas.getHeight()*101/540;
                    float playButtonLeft = (float) canvas.getWidth()*130/1050;
                    float playButtonTop = (float) canvas.getHeight()*427/540;
                    playDarkButtonBitmap1 = Bitmap.createScaledBitmap(playDarkButtonBitmap1,playButtonWidth, playButtonHeight,true);
                    playDarkButtonBitmap2 = Bitmap.createScaledBitmap(playDarkButtonBitmap2,playButtonWidth, playButtonHeight,true);
                    playDarkButtonBitmap3 = Bitmap.createScaledBitmap(playDarkButtonBitmap3,playButtonWidth, playButtonHeight,true);
                    playDarkButtonBitmap4 = Bitmap.createScaledBitmap(playDarkButtonBitmap4,playButtonWidth, playButtonHeight,true);
                    playDarkButtonBitmap5 = Bitmap.createScaledBitmap(playDarkButtonBitmap5,playButtonWidth, playButtonHeight,true);
                    playDarkButtonBitmap6 = Bitmap.createScaledBitmap(playDarkButtonBitmap6,playButtonWidth, playButtonHeight,true);
                    playDarkButtonBitmap7 = Bitmap.createScaledBitmap(playDarkButtonBitmap7,playButtonWidth, playButtonHeight,true);
                    playDarkButtonBitmap8 = Bitmap.createScaledBitmap(playDarkButtonBitmap8,playButtonWidth, playButtonHeight,true);
                    playDarkButtonBitmap9 = Bitmap.createScaledBitmap(playDarkButtonBitmap9,playButtonWidth, playButtonHeight,true);
                    playDarkButtonBitmap10 = Bitmap.createScaledBitmap(playDarkButtonBitmap10,playButtonWidth, playButtonHeight,true);
                    playDarkButtonBitmap11 = Bitmap.createScaledBitmap(playDarkButtonBitmap11,playButtonWidth, playButtonHeight,true);
                    playDarkButtonBitmap12 = Bitmap.createScaledBitmap(playDarkButtonBitmap12,playButtonWidth, playButtonHeight,true);
                    playDarkButtonBitmap13 = Bitmap.createScaledBitmap(playDarkButtonBitmap13,playButtonWidth, playButtonHeight,true);
                    playDarkButtonBitmap14 = Bitmap.createScaledBitmap(playDarkButtonBitmap14,playButtonWidth, playButtonHeight,true);
                    playDarkButtonBitmap15 = Bitmap.createScaledBitmap(playDarkButtonBitmap15,playButtonWidth, playButtonHeight,true);
                    playButtonBitmap = Bitmap.createScaledBitmap(playButtonBitmap,playButtonWidth, playButtonHeight,true);
                    playButtonBitmap2 = Bitmap.createScaledBitmap(playButtonBitmap2,playButtonWidth, playButtonHeight,true);
                    if(!playChecker && checkPlayButton){
                        new PlayDarkButtonThread().start();
                        checkPlayButton = false;
                    }
                    if(drawPlayButton){
                        switch (playTimer){
                            case 14:
                                playButtonBitmap = playDarkButtonBitmap14;
                                break;
                            case 13:
                                playButtonBitmap = playDarkButtonBitmap13;
                                break;
                            case 12:
                                playButtonBitmap = playDarkButtonBitmap12;
                                break;
                            case 11:
                                playButtonBitmap = playDarkButtonBitmap11;
                                break;
                            case 10:
                                playButtonBitmap = playDarkButtonBitmap10;
                                break;
                            case 9:
                                playButtonBitmap = playDarkButtonBitmap9;
                                break;
                            case 8:
                                playButtonBitmap = playDarkButtonBitmap8;
                                break;
                            case 7:
                                playButtonBitmap = playDarkButtonBitmap7;
                                break;
                            case 6:
                                playButtonBitmap = playDarkButtonBitmap6;
                                break;
                            case 5:
                                playButtonBitmap = playDarkButtonBitmap5;
                                break;
                            case 4:
                                playButtonBitmap = playDarkButtonBitmap4;
                                break;
                            case 3:
                                playButtonBitmap = playDarkButtonBitmap3;
                                break;
                            case 2:
                                playButtonBitmap = playDarkButtonBitmap2;
                                break;
                            case 1:
                                playButtonBitmap = playDarkButtonBitmap1;
                                playChecker = true;
                                lastTouchX = 0;
                                lastTouchY = 0;
                                break;
                            case 0:
                                playButtonBitmap = playButtonBitmap2;
                                break;
                        }
                    }
                    canvas.drawBitmap(playButtonBitmap,playButtonLeft,playButtonTop,paint);
                    // utel
                    if(lastTouchX >= eatButtonLeft && lastTouchX <= eatButtonLeft + eatButtonWidth && lastTouchY >= eatButtonTop && lastTouchY <= eatButtonTop + eatButtonHeight && eatChecker && !playing) {
                        if(e == 0) {
                            food *= (hungryRight2 - hungryLeft);
                            if (hungryRight + food > hungryRight2) {
                                hungryRight = hungryRight2;
                            } else {
                                hungryRight += food;
                            }
                            food /= (hungryRight2 - hungryLeft);
                            e = 1;
                        }
                        ea = true;
                    }
                    if(!eatingTimeIsPassed && ea) {
                        new EatingThread().start();
                        eating = true;
                        eatingTimeIsPassed = true;
                    }
                    if(eatingNeedToDrawNow && eating){
                        switch (eat){
                            case 1:
                                if (bitmap1 == bitmapDTS1 || bitmap1 == bitmapDTSH1) bitmap = eat1BitmapDTS;
                                else if (bitmap1 == bitmapDT1 || bitmap1 == bitmapDTH1) bitmap = eat1BitmapDT;
                                else if (bitmap1 == bitmapDS1 || bitmap1 == bitmapDSH1) bitmap = eat1BitmapDS;
                                else if (bitmap1 == bitmapTS1 || bitmap1 == bitmapTSH1) bitmap = eat1BitmapTS;
                                else if (bitmap1 == bitmapD1 || bitmap1 == bitmapDH1) bitmap = eat1BitmapD;
                                else if (bitmap1 == bitmapS1 || bitmap1 == bitmapSH1) bitmap = eat1BitmapS;
                                else if (bitmap1 == bitmapT1 || bitmap1 == bitmapTH1) bitmap = eat1BitmapT;
                                else if (bitmap1 == bitmapUsual1 || bitmap1 == bitmapH1) bitmap = eat1Bitmap;
                                else if (bitmap1 == bitmapSmile1) bitmap = eat1BitmapSmile;
                                break;
                            case 2:
                                if (bitmap1 == bitmapDTS1 || bitmap1 == bitmapDTSH1) bitmap = eat2BitmapDTS;
                                else if (bitmap1 == bitmapDT1 || bitmap1 == bitmapDTH1) bitmap = eat2BitmapDT;
                                else if (bitmap1 == bitmapDS1 || bitmap1 == bitmapDSH1) bitmap = eat2BitmapDS;
                                else if (bitmap1 == bitmapTS1 || bitmap1 == bitmapTSH1) bitmap = eat2BitmapTS;
                                else if (bitmap1 == bitmapD1 || bitmap1 == bitmapDH1) bitmap = eat2BitmapD;
                                else if (bitmap1 == bitmapS1 || bitmap1 == bitmapSH1) bitmap = eat2BitmapS;
                                else if (bitmap1 == bitmapT1 || bitmap1 == bitmapTH1) bitmap = eat2BitmapT;
                                else if (bitmap1 == bitmapUsual1 || bitmap1 == bitmapH1) bitmap = eat2Bitmap;
                                else if (bitmap1 == bitmapSmile1) bitmap = eat2BitmapSmile;
                                break;
                            case 3:
                                if (bitmap1 == bitmapDTS1 || bitmap1 == bitmapDTSH1) bitmap = eat3BitmapDTS;
                                else if (bitmap1 == bitmapDT1 || bitmap1 == bitmapDTH1) bitmap = eat3BitmapDT;
                                else if (bitmap1 == bitmapDS1 || bitmap1 == bitmapDSH1) bitmap = eat3BitmapDS;
                                else if (bitmap1 == bitmapTS1 || bitmap1 == bitmapTSH1) bitmap = eat3BitmapTS;
                                else if (bitmap1 == bitmapD1 || bitmap1 == bitmapDH1) bitmap = eat3BitmapD;
                                else if (bitmap1 == bitmapS1 || bitmap1 == bitmapSH1) bitmap = eat3BitmapS;
                                else if (bitmap1 == bitmapT1 || bitmap1 == bitmapTH1) bitmap = eat3BitmapT;
                                else if (bitmap1 == bitmapUsual1 || bitmap1 == bitmapH1) bitmap = eat3Bitmap;
                                else if (bitmap1 == bitmapSmile1) bitmap = eat3BitmapSmile;
                                break;
                            case 4:
                                if (bitmap1 == bitmapDTS1 || bitmap1 == bitmapDTSH1) bitmap = eat4BitmapDTS;
                                else if (bitmap1 == bitmapDT1 || bitmap1 == bitmapDTH1) bitmap = eat4BitmapDT;
                                else if (bitmap1 == bitmapDS1 || bitmap1 == bitmapDSH1) bitmap = eat4BitmapDS;
                                else if (bitmap1 == bitmapTS1 || bitmap1 == bitmapTSH1) bitmap = eat4BitmapTS;
                                else if (bitmap1 == bitmapD1 || bitmap1 == bitmapDH1) bitmap = eat4BitmapD;
                                else if (bitmap1 == bitmapS1 || bitmap1 == bitmapSH1) bitmap = eat4BitmapS;
                                else if (bitmap1 == bitmapT1 || bitmap1 == bitmapTH1) bitmap = eat4BitmapT;
                                else if (bitmap1 == bitmapUsual1 || bitmap1 == bitmapH1) bitmap = eat4Bitmap;
                                else if (bitmap1 == bitmapSmile1) bitmap = eat4BitmapSmile;
                                break;
                            case 5:
                                if (bitmap1 == bitmapDTS1 || bitmap1 == bitmapDTSH1) bitmap = eat5BitmapDTS;
                                else if (bitmap1 == bitmapDT1 || bitmap1 == bitmapDTH1) bitmap = eat5BitmapDT;
                                else if (bitmap1 == bitmapDS1 || bitmap1 == bitmapDSH1) bitmap = eat5BitmapDS;
                                else if (bitmap1 == bitmapTS1 || bitmap1 == bitmapTSH1) bitmap = eat5BitmapTS;
                                else if (bitmap1 == bitmapD1 || bitmap1 == bitmapDH1) bitmap = eat5BitmapD;
                                else if (bitmap1 == bitmapS1 || bitmap1 == bitmapSH1) bitmap = eat5BitmapS;
                                else if (bitmap1 == bitmapT1 || bitmap1 == bitmapTH1) bitmap = eat5BitmapT;
                                else if (bitmap1 == bitmapUsual1 || bitmap1 == bitmapH1) bitmap = eat5Bitmap;
                                else if (bitmap1 == bitmapSmile1) bitmap = eat5BitmapSmile;
                                break;
                            case 6:
                                if (bitmap1 == bitmapDTS1 || bitmap1 == bitmapDTSH1) bitmap = eat6BitmapDTS;
                                else if (bitmap1 == bitmapDT1 || bitmap1 == bitmapDTH1) bitmap = eat6BitmapDT;
                                else if (bitmap1 == bitmapDS1 || bitmap1 == bitmapDSH1) bitmap = eat6BitmapDS;
                                else if (bitmap1 == bitmapTS1 || bitmap1 == bitmapTSH1) bitmap = eat6BitmapTS;
                                else if (bitmap1 == bitmapD1 || bitmap1 == bitmapDH1) bitmap = eat6BitmapD;
                                else if (bitmap1 == bitmapS1 || bitmap1 == bitmapSH1) bitmap = eat6BitmapS;
                                else if (bitmap1 == bitmapT1 || bitmap1 == bitmapTH1) bitmap = eat6BitmapT;
                                else if (bitmap1 == bitmapUsual1 || bitmap1 == bitmapH1) bitmap = eat6Bitmap;
                                else if (bitmap1 == bitmapSmile1) bitmap = eat6BitmapSmile;
                                break;
                            case 7:
                                if (bitmap1 == bitmapDTS1 || bitmap1 == bitmapDTSH1) bitmap = eat7BitmapDTS;
                                else if (bitmap1 == bitmapDT1 || bitmap1 == bitmapDTH1) bitmap = eat7BitmapDT;
                                else if (bitmap1 == bitmapDS1 || bitmap1 == bitmapDSH1) bitmap = eat7BitmapDS;
                                else if (bitmap1 == bitmapTS1 || bitmap1 == bitmapTSH1) bitmap = eat7BitmapTS;
                                else if (bitmap1 == bitmapD1 || bitmap1 == bitmapDH1) bitmap = eat7BitmapD;
                                else if (bitmap1 == bitmapS1 || bitmap1 == bitmapSH1) bitmap = eat7BitmapS;
                                else if (bitmap1 == bitmapT1 || bitmap1 == bitmapTH1) bitmap = eat7BitmapT;
                                else if (bitmap1 == bitmapUsual1 || bitmap1 == bitmapH1) bitmap = eat7Bitmap;
                                else if (bitmap1 == bitmapSmile1) bitmap = eat7BitmapSmile;
                                break;
                            case 8:
                                if (bitmap1 == bitmapDTS1 || bitmap1 == bitmapDTSH1) bitmap = eat8BitmapDTS;
                                else if (bitmap1 == bitmapDT1 || bitmap1 == bitmapDTH1) bitmap = eat8BitmapDT;
                                else if (bitmap1 == bitmapDS1 || bitmap1 == bitmapDSH1) bitmap = eat8BitmapDS;
                                else if (bitmap1 == bitmapTS1 || bitmap1 == bitmapTSH1) bitmap = eat8BitmapTS;
                                else if (bitmap1 == bitmapD1 || bitmap1 == bitmapDH1) bitmap = eat8BitmapD;
                                else if (bitmap1 == bitmapS1 || bitmap1 == bitmapSH1) bitmap = eat8BitmapS;
                                else if (bitmap1 == bitmapT1 || bitmap1 == bitmapTH1) bitmap = eat8BitmapT;
                                else if (bitmap1 == bitmapUsual1 || bitmap1 == bitmapH1) bitmap = eat8Bitmap;
                                else if (bitmap1 == bitmapSmile1) bitmap = eat8BitmapSmile;
                                break;
                            case 9:
                                if (bitmap1 == bitmapDTS1 || bitmap1 == bitmapDTSH1) bitmap = eat9BitmapDTS;
                                else if (bitmap1 == bitmapDT1 || bitmap1 == bitmapDTH1) bitmap = eat9BitmapDT;
                                else if (bitmap1 == bitmapDS1 || bitmap1 == bitmapDSH1) bitmap = eat9BitmapDS;
                                else if (bitmap1 == bitmapTS1 || bitmap1 == bitmapTSH1) bitmap = eat9BitmapTS;
                                else if (bitmap1 == bitmapD1 || bitmap1 == bitmapDH1) bitmap = eat9BitmapD;
                                else if (bitmap1 == bitmapS1 || bitmap1 == bitmapSH1) bitmap = eat9BitmapS;
                                else if (bitmap1 == bitmapT1 || bitmap1 == bitmapTH1) bitmap = eat9BitmapT;
                                else if (bitmap1 == bitmapUsual1 || bitmap1 == bitmapH1) bitmap = eat9Bitmap;
                                else if (bitmap1 == bitmapSmile1) bitmap = eat9BitmapSmile;
                                break;
                            case 10:
                                if (bitmap1 == bitmapDTS1 || bitmap1 == bitmapDTSH1) bitmap = eat10BitmapDTS;
                                else if (bitmap1 == bitmapDT1 || bitmap1 == bitmapDTH1) bitmap = eat10BitmapDT;
                                else if (bitmap1 == bitmapDS1 || bitmap1 == bitmapDSH1) bitmap = eat10BitmapDS;
                                else if (bitmap1 == bitmapTS1 || bitmap1 == bitmapTSH1) bitmap = eat10BitmapTS;
                                else if (bitmap1 == bitmapD1 || bitmap1 == bitmapDH1) bitmap = eat10BitmapD;
                                else if (bitmap1 == bitmapS1 || bitmap1 == bitmapSH1) bitmap = eat10BitmapS;
                                else if (bitmap1 == bitmapT1 || bitmap1 == bitmapTH1) bitmap = eat10BitmapT;
                                else if (bitmap1 == bitmapUsual1 || bitmap1 == bitmapH1) bitmap = eat10Bitmap;
                                else if (bitmap1 == bitmapSmile1) bitmap = eat10BitmapSmile;
                                eating = false;
                                eat = 0;
                                lastTouchY = 0;
                                lastTouchX = 0;
                                eatChecker = false;
                                checkEatButton = true;
                                e = 0;
                                ea = false;
                                eatButtonBitmap = eatDarkButtonBitmap10;
                                eatTimer = 10;
                                break;
                        }
                    }
                    //xndal
                    if(lastTouchX >= playButtonLeft && lastTouchX <= playButtonLeft + playButtonWidth && lastTouchY >= playButtonTop && lastTouchY <= playButtonTop + playButtonHeight && playChecker && !eating) {
                        if(p == 0) {
                            smile *= (happyRight2 - happyLeft);
                            if (happyRight + smile > happyRight2) {
                                happyRight = happyRight2;
                            } else {
                                happyRight += smile;
                            }
                            smile /= (happyRight2 - happyLeft);
                            p = 1;
                        }
                        pl = true;
                    }
                    if(!playingTimeIsPassed && pl) {
                        new PlayingThread().start();
                        playing = true;
                        playingTimeIsPassed = true;
                    }
                    if(playingNeedToDrawNow && playing){
                        switch (play){
                            case 1:
                                bitmap = play1Bitmap;
                                break;
                            case 2:
                                bitmap = play2Bitmap;
                                break;
                            case 3:
                                bitmap = play3Bitmap;
                                break;
                            case 4:
                                bitmap = play4Bitmap;
                                break;
                            case 5:
                                bitmap = play5Bitmap;
                                break;
                            case 6:
                                bitmap = play6Bitmap;
                                break;
                            case 7:
                                bitmap = play7Bitmap;
                                break;
                            case 8:
                                bitmap = play8Bitmap;
                                break;
                            case 9:
                                bitmap = play9Bitmap;
                                break;
                            case 10:
                                bitmap = play10Bitmap;
                                break;
                            case 11:
                                bitmap = play11Bitmap;
                                break;
                            case 12:
                                bitmap = play12Bitmap;
                                break;
                            case 13:
                                bitmap = play13Bitmap;
                                break;
                            case 14:
                                bitmap = play14Bitmap;
                                break;
                            case 15:
                                bitmap = play15Bitmap;
                                break;
                            case 16:
                                bitmap = play16Bitmap;
                                break;
                            case 17:
                                bitmap = play17Bitmap;
                                break;
                            case 18:
                                bitmap = play18Bitmap;
                                break;
                            case 19:
                                bitmap = play19Bitmap;
                                break;
                            case 20:
                                bitmap = play20Bitmap;
                                playing = false;
                                playChecker = false;
                                checkPlayButton = true;
                                play = 0;
                                lastTouchY = 0;
                                lastTouchX = 0;
                                p = 0;
                                pl = false;
                                playButtonBitmap = playDarkButtonBitmap15;
                                playTimer = 15;
                                break;
                        }
                    }
                } finally {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }
    class DirtTimerThread extends  Thread{
        @Override
        public void run() {
            try {
                sleep(1000);
                dirtTimeIsPassed = false;
                dirtNeedToDrawNow = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    class HungryTimerThread extends  Thread{
        @Override
        public void run() {
            try {
                sleep(1000);
                hungryTimeIsPassed = false;
                hungryNeedToDrawNow = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    class SleepTimerThread extends  Thread{
        @Override
        public void run() {
            try {
                sleep(1000);
                sleepTimeIsPassed = false;
                sleepNeedToDrawNow = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    class HappyTimerThread extends  Thread{
        @Override
        public void run() {
            try {
                sleep(1000);
                happyTimeIsPassed = false;
                happyNeedToDrawNow = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    class ThreadBird1 extends Thread{
        @Override
        public void run() {
            try {
                sleep(1500);
                timeIsPassed1 = false;
                needToDrawNow1 = true;
                check = true;
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    class ThreadBird2 extends Thread{
        @Override
        public void run() {
            try {
                sleep(1000);
                timeIsPassed2 = false;
                needToDrawNow2 = true;
                check = false;
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    class EatingThread extends Thread{
        @Override
        public void run() {
            try {
                if(eat<10) {
                    eat++;
                    sleep(190);
                    eatingTimeIsPassed = false;
                    eatingNeedToDrawNow = true;
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    class PlayingThread extends Thread{
        @Override
        public void run() {
            try {
                if(play<20) {
                    play++;
                    sleep(100);
                    playingTimeIsPassed = false;
                    playingNeedToDrawNow = true;
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    class EatDarkButtonThread extends Thread{
        @Override
        public void run() {
            try {
                if(eatTimer>=0) {
                    sleep(1000);
                    checkEatButton = true;
                    drawEatButton = true;
                    eatTimer--;
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    class PlayDarkButtonThread extends Thread{
        @Override
        public void run() {
            try {
                if(playTimer>=0) {
                    sleep(1000);
                    checkPlayButton = true;
                    drawPlayButton = true;
                    playTimer--;
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

