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
    private float birdX = (float) 419/1050;
    private float birdY = (float) 232/540;
    private int m = 0, n = 0, m1 = 0, m2 = 0, m3 = 0, m4 = 0, eat = 0, e = 0, eatTimer = 10, m5 = 0, p = 0, playTimer = 15, sleepTimer = 60, play = 0, sleep = 0, r1 = 0, flyBack = 0;
    private double h = (float)1/360;
    private double s = (float) 1 / 960;
    private double q = (float) 1 / 54;
    private double k = (float) 1 / 600;
    private double food = (float) 1 / 10;
    private double smile = (float) 1 / 7;
    private double qun = (float) 1 / 40;
    private float hungryRight = 0, happyRight = 0, sleepRight = 0, dirtRight = 0, lifeRight = 0;
    private int life, dirt, hungry, tired,happy;
    private boolean ea = false, pl = false, sl = false, fl = false, sle = false;
    private boolean playingTimeIsPassed = false;
    private boolean playingNeedToDrawNow = false;
    private boolean checkPlayButton = false;
    private boolean drawPlayButton = false;
    private boolean playChecker = true;
    private boolean eating = false;
    private boolean playing = false;
    private boolean flying = false;
    private boolean laying = false;
    private boolean sleeping = false;
    private boolean flyingBack = false;
    private boolean eatChecker = true;
    private boolean sleepChecker = true;
    private boolean flyChecker = true;
    private boolean checkEatButton = false;
    private boolean drawEatButton = false;
    private boolean checkSleepButton = false;
    private boolean drawSleepButton = false;
    private boolean eatingTimeIsPassed = false;
    private boolean eatingNeedToDrawNow = false;
    private boolean sleepingTimeIsPassed = false;
    private boolean sleepingNeedToDrawNow = false;
    private boolean flyingTimeIsPassed = false;
    private boolean flyingNeedToDrawNow = false;
    private boolean flyingBackTimeIsPassed = false;
    private boolean flyingBackNeedToDrawNow = false;
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
    private boolean timeIsPassedSleep1 = false;
    private boolean needToDrawNowSleep1 = false;
    private boolean timeIsPassedSleep2 = false;
    private boolean needToDrawNowSleep2 = false;
    private boolean timeIsPassedSle= false;
    private boolean needToDrawNowSle = false;
    private boolean sleepFinished = false;
    private boolean check = false;
    private boolean checkSleep = false;
    private Bitmap eat1Bitmap, eat2Bitmap, eat3Bitmap, eat4Bitmap, eat5Bitmap, eat6Bitmap, eat7Bitmap, eat8Bitmap, eat9Bitmap, eat10Bitmap;
    private Bitmap eatDarkButtonBitmap1, eatDarkButtonBitmap2, eatDarkButtonBitmap3, eatDarkButtonBitmap4, eatDarkButtonBitmap5,
            eatDarkButtonBitmap6, eatDarkButtonBitmap7, eatDarkButtonBitmap8, eatDarkButtonBitmap9, eatDarkButtonBitmap10;
    private Bitmap play1Bitmap, play2Bitmap, play3Bitmap, play4Bitmap, play5Bitmap, play6Bitmap, play7Bitmap, play8Bitmap, play9Bitmap, play10Bitmap, play11Bitmap, play12Bitmap, play13Bitmap, play14Bitmap, play15Bitmap, play16Bitmap, play17Bitmap, play18Bitmap, play19Bitmap, play20Bitmap;
    private Bitmap play1BitmapD, play2BitmapD, play3BitmapD, play4BitmapD, play5BitmapD, play6BitmapD, play7BitmapD, play8BitmapD, play9BitmapD, play10BitmapD, play11BitmapD, play12BitmapD, play13BitmapD, play14BitmapD, play15BitmapD, play16BitmapD, play17BitmapD, play18BitmapD, play19BitmapD, play20BitmapD;
    private Bitmap play1BitmapDT, play2BitmapDT, play3BitmapDT, play4BitmapDT, play5BitmapDT, play6BitmapDT, play7BitmapDT, play8BitmapDT, play9BitmapDT, play10BitmapDT, play11BitmapDT, play12BitmapDT, play13BitmapDT, play14BitmapDT, play15BitmapDT, play16BitmapDT, play17BitmapDT, play18BitmapDT, play19BitmapDT, play20BitmapDT;
    private Bitmap play1BitmapT, play2BitmapT, play3BitmapT, play4BitmapT, play5BitmapT, play6BitmapT, play7BitmapT, play8BitmapT, play9BitmapT, play10BitmapT, play11BitmapT, play12BitmapT, play13BitmapT, play14BitmapT, play15BitmapT, play16BitmapT, play17BitmapT, play18BitmapT, play19BitmapT, play20BitmapT;
    private Bitmap playDarkButtonBitmap1, playDarkButtonBitmap2, playDarkButtonBitmap3, playDarkButtonBitmap4, playDarkButtonBitmap5,
            playDarkButtonBitmap6, playDarkButtonBitmap7, playDarkButtonBitmap8, playDarkButtonBitmap9, playDarkButtonBitmap10, playDarkButtonBitmap11, playDarkButtonBitmap12, playDarkButtonBitmap13, playDarkButtonBitmap14, playDarkButtonBitmap15;
    private Bitmap playButtonBitmap, playButtonBitmap2;
    private Bitmap sleepDarkButtonBitmap1, sleepDarkButtonBitmap2, sleepDarkButtonBitmap3, sleepDarkButtonBitmap4, sleepDarkButtonBitmap5, sleepDarkButtonBitmap6, sleepDarkButtonBitmap7, sleepDarkButtonBitmap8, sleepDarkButtonBitmap9, sleepDarkButtonBitmap10,
            sleepDarkButtonBitmap11, sleepDarkButtonBitmap12, sleepDarkButtonBitmap13, sleepDarkButtonBitmap14, sleepDarkButtonBitmap15, sleepDarkButtonBitmap16, sleepDarkButtonBitmap17, sleepDarkButtonBitmap18, sleepDarkButtonBitmap19, sleepDarkButtonBitmap20,
            sleepDarkButtonBitmap21, sleepDarkButtonBitmap22, sleepDarkButtonBitmap23, sleepDarkButtonBitmap24, sleepDarkButtonBitmap25, sleepDarkButtonBitmap26, sleepDarkButtonBitmap27, sleepDarkButtonBitmap28, sleepDarkButtonBitmap29, sleepDarkButtonBitmap30,
            sleepDarkButtonBitmap31, sleepDarkButtonBitmap32, sleepDarkButtonBitmap33, sleepDarkButtonBitmap34, sleepDarkButtonBitmap35, sleepDarkButtonBitmap36, sleepDarkButtonBitmap37, sleepDarkButtonBitmap38, sleepDarkButtonBitmap39, sleepDarkButtonBitmap40,
            sleepDarkButtonBitmap41, sleepDarkButtonBitmap42, sleepDarkButtonBitmap43, sleepDarkButtonBitmap44, sleepDarkButtonBitmap45, sleepDarkButtonBitmap46, sleepDarkButtonBitmap47, sleepDarkButtonBitmap48, sleepDarkButtonBitmap49, sleepDarkButtonBitmap50,
            sleepDarkButtonBitmap51, sleepDarkButtonBitmap52, sleepDarkButtonBitmap53, sleepDarkButtonBitmap54, sleepDarkButtonBitmap55, sleepDarkButtonBitmap56, sleepDarkButtonBitmap57, sleepDarkButtonBitmap58, sleepDarkButtonBitmap59, sleepDarkButtonBitmap60;
    private Bitmap sleepButtonBitmap, sleepButtonBitmap2;
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
    private Bitmap bitmapDarkbg,bitmapDarkkust;
    private Bitmap fly1Bitmap,fly2Bitmap,layBitmap, sleepBitmap1,sleepBitmap2, fly3Bitmap, fly4Bitmap;
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
        play1BitmapD = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox1);
        play2BitmapD = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox2);
        play3BitmapD = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox3);
        play4BitmapD = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox4);
        play5BitmapD = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox5);
        play6BitmapD = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox6);
        play7BitmapD = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox7);
        play8BitmapD = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox8);
        play9BitmapD = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox9);
        play10BitmapD = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox10);
        play11BitmapD = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox11);
        play12BitmapD = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox12);
        play13BitmapD = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox13);
        play14BitmapD = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox14);
        play15BitmapD = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox15);
        play16BitmapD = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox16);
        play17BitmapD = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox17);
        play18BitmapD = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox18);
        play19BitmapD = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox19);
        play20BitmapD = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox20);
        play1BitmapT = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox1);
        play2BitmapT = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox2);
        play3BitmapT = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox3);
        play4BitmapT = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox4);
        play5BitmapT = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox5);
        play6BitmapT = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox6);
        play7BitmapT = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox7);
        play8BitmapT = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox8);
        play9BitmapT = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox9);
        play10BitmapT = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox10);
        play11BitmapT = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox11);
        play12BitmapT = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox12);
        play13BitmapT = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox13);
        play14BitmapT = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox14);
        play15BitmapT = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox15);
        play16BitmapT = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox16);
        play17BitmapT = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox17);
        play18BitmapT = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox18);
        play19BitmapT = BitmapFactory.decodeResource(context.getResources(),R.drawable.t_xaxacox19);
        play20BitmapT = BitmapFactory.decodeResource(context.getResources(),R.drawable.t_xaxacox20);
        play1BitmapDT = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox1);
        play2BitmapDT = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox2);
        play3BitmapDT = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox3);
        play4BitmapDT = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox4);
        play5BitmapDT = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox5);
        play6BitmapDT = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox6);
        play7BitmapDT = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox7);
        play8BitmapDT = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox8);
        play9BitmapDT = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox9);
        play10BitmapDT = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox10);
        play11BitmapDT = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox11);
        play12BitmapDT = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox12);
        play13BitmapDT = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox13);
        play14BitmapDT = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox14);
        play15BitmapDT = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox15);
        play16BitmapDT = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox16);
        play17BitmapDT = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox17);
        play18BitmapDT = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox18);
        play19BitmapDT = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_t_xaxacox19);
        play20BitmapDT = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_t_xaxacox20);
        fly1Bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.trnox_cit1);
        fly2Bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.trnox_cit2);
        fly3Bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.trnox_cit3);
        fly4Bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.trnox_cit4);
        layBitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.parkac);
        sleepBitmap1 = BitmapFactory.decodeResource(context.getResources(),R.drawable.qnac1);
        sleepBitmap2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.qnac2);
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
        sleepDarkButtonBitmap1 = BitmapFactory.decodeResource(context.getResources(), R.drawable.mq1);
        sleepDarkButtonBitmap2 = BitmapFactory.decodeResource(context.getResources(), R.drawable.mq2);
        sleepDarkButtonBitmap3 = BitmapFactory.decodeResource(context.getResources(), R.drawable.mq3);
        sleepDarkButtonBitmap4 = BitmapFactory.decodeResource(context.getResources(), R.drawable.mq4);
        sleepDarkButtonBitmap5 = BitmapFactory.decodeResource(context.getResources(), R.drawable.mq5);
        sleepDarkButtonBitmap6 = BitmapFactory.decodeResource(context.getResources(), R.drawable.mq6);
        sleepDarkButtonBitmap7 = BitmapFactory.decodeResource(context.getResources(), R.drawable.mq7);
        sleepDarkButtonBitmap8 = BitmapFactory.decodeResource(context.getResources(), R.drawable.mq8);
        sleepDarkButtonBitmap9 = BitmapFactory.decodeResource(context.getResources(), R.drawable.mq9);
        sleepDarkButtonBitmap10 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq10);
        sleepDarkButtonBitmap11 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq11);
        sleepDarkButtonBitmap12 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq12);
        sleepDarkButtonBitmap13 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq13);
        sleepDarkButtonBitmap14 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq14);
        sleepDarkButtonBitmap15 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq15);
        sleepDarkButtonBitmap16 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq16);
        sleepDarkButtonBitmap17 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq17);
        sleepDarkButtonBitmap18 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq18);
        sleepDarkButtonBitmap19 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq19);
        sleepDarkButtonBitmap20 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq20);
        sleepDarkButtonBitmap21 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq21);
        sleepDarkButtonBitmap22 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq22);
        sleepDarkButtonBitmap23 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq23);
        sleepDarkButtonBitmap24 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq24);
        sleepDarkButtonBitmap25 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq25);
        sleepDarkButtonBitmap26 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq26);
        sleepDarkButtonBitmap27 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq27);
        sleepDarkButtonBitmap28 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq28);
        sleepDarkButtonBitmap29 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq29);
        sleepDarkButtonBitmap30 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq30);
        sleepDarkButtonBitmap31 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq31);
        sleepDarkButtonBitmap32 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq32);
        sleepDarkButtonBitmap33 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq33);
        sleepDarkButtonBitmap34 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq34);
        sleepDarkButtonBitmap35 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq35);
        sleepDarkButtonBitmap36 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq36);
        sleepDarkButtonBitmap37 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq37);
        sleepDarkButtonBitmap38 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq38);
        sleepDarkButtonBitmap39 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq39);
        sleepDarkButtonBitmap40 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq40);
        sleepDarkButtonBitmap41 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq41);
        sleepDarkButtonBitmap42 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq42);
        sleepDarkButtonBitmap43 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq43);
        sleepDarkButtonBitmap44 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq44);
        sleepDarkButtonBitmap45 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq45);
        sleepDarkButtonBitmap46 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq46);
        sleepDarkButtonBitmap47 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq47);
        sleepDarkButtonBitmap48 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq48);
        sleepDarkButtonBitmap49 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq49);
        sleepDarkButtonBitmap50 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq50);
        sleepDarkButtonBitmap51 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq51);
        sleepDarkButtonBitmap52 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq52);
        sleepDarkButtonBitmap53 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq53);
        sleepDarkButtonBitmap54 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq54);
        sleepDarkButtonBitmap55 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq55);
        sleepDarkButtonBitmap56 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq56);
        sleepDarkButtonBitmap57 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq57);
        sleepDarkButtonBitmap58 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq58);
        sleepDarkButtonBitmap59 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq59);
        sleepDarkButtonBitmap60 = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq60);
        bitmapGrass = BitmapFactory.decodeResource(context.getResources(), R.drawable.xot);
        bitmapbg = BitmapFactory.decodeResource(context.getResources(), R.drawable.background1);
        bitmapDarkbg = BitmapFactory.decodeResource(context.getResources(), R.drawable.background2);
        bitmapDarkkust = BitmapFactory.decodeResource(context.getResources(), R.drawable.kustik2);
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
        sleepButtonBitmap =  BitmapFactory.decodeResource(context.getResources(), R.drawable.qnel);
        sleepButtonBitmap2 =  BitmapFactory.decodeResource(context.getResources(),R.drawable.qnel);
        highScoreBitmap =  BitmapFactory.decodeResource(context.getResources(),R.drawable.highscore);
        scoreBitmap =  BitmapFactory.decodeResource(context.getResources(),R.drawable.score);
        bitmap = bitmapSmile1;
        life = ResourcesCompat.getColor(context.getResources(),R.color.life,null);
        dirt = ResourcesCompat.getColor(context.getResources(),R.color.dirt,null);
        hungry = ResourcesCompat.getColor(context.getResources(),R.color.hungry,null);
        tired = ResourcesCompat.getColor(context.getResources(),R.color.sleep,null);
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
                    bitmapbg = Bitmap.createScaledBitmap(bitmapbg,canvas.getWidth(),canvas.getHeight(),true);
                    bitmapDarkbg = Bitmap.createScaledBitmap(bitmapDarkbg,canvas.getWidth(),canvas.getHeight(),true);
                    bitmapkust = Bitmap.createScaledBitmap(bitmapkust,canvas.getWidth()*245/1050,canvas.getHeight()*180/540,true);
                    bitmapDarkkust = Bitmap.createScaledBitmap(bitmapDarkkust,canvas.getWidth()*245/1050,canvas.getHeight()*180/540,true);
                    paint.setSubpixelText(true);paint.setAntiAlias(true);paintLife.setSubpixelText(true);paintLife.setAntiAlias(true);paintBlack.setSubpixelText(true);paintBlack.setAntiAlias(true);
                    //hetevi fon
                    if(!flying && !sleeping && !laying) {
                        canvas.drawBitmap(bitmapbg, 0, 0, paint);
                        canvas.drawBitmap(bitmapkust, (float) canvas.getWidth() * 29 / 1050, (float) canvas.getHeight() * 230 / 540, paint);
                    }
                    else{
                        canvas.drawBitmap(bitmapDarkbg, 0, 0, paint);
                        canvas.drawBitmap(bitmapDarkkust, (float) canvas.getWidth() * 29 / 1050, (float) canvas.getHeight() * 230 / 540, paint);
                    }
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
                    paintSleep.setColor(tired);
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
                    if(!sleepTimeIsPassed && !sleeping){
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
                    play1BitmapD = Bitmap.createScaledBitmap(play1BitmapD,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play2BitmapD = Bitmap.createScaledBitmap(play2BitmapD,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play3BitmapD = Bitmap.createScaledBitmap(play3BitmapD,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play4BitmapD = Bitmap.createScaledBitmap(play4BitmapD,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play5BitmapD = Bitmap.createScaledBitmap(play5BitmapD,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play6BitmapD = Bitmap.createScaledBitmap(play6BitmapD,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play7BitmapD = Bitmap.createScaledBitmap(play7BitmapD,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play8BitmapD = Bitmap.createScaledBitmap(play8BitmapD,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play9BitmapD = Bitmap.createScaledBitmap(play9BitmapD,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play10BitmapD =Bitmap.createScaledBitmap(play10BitmapD,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play11BitmapD =Bitmap.createScaledBitmap(play11BitmapD,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play12BitmapD =Bitmap.createScaledBitmap(play12BitmapD,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play13BitmapD =Bitmap.createScaledBitmap(play13BitmapD,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play14BitmapD =Bitmap.createScaledBitmap(play14BitmapD,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play15BitmapD =Bitmap.createScaledBitmap(play15BitmapD,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play16BitmapD =Bitmap.createScaledBitmap(play16BitmapD,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play17BitmapD =Bitmap.createScaledBitmap(play17BitmapD,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play18BitmapD =Bitmap.createScaledBitmap(play18BitmapD,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play19BitmapD =Bitmap.createScaledBitmap(play19BitmapD,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play20BitmapD =Bitmap.createScaledBitmap(play20BitmapD,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play1BitmapDT = Bitmap.createScaledBitmap(play1BitmapDT,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play2BitmapDT = Bitmap.createScaledBitmap(play2BitmapDT,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play3BitmapDT = Bitmap.createScaledBitmap(play3BitmapDT,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play4BitmapDT = Bitmap.createScaledBitmap(play4BitmapDT,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play5BitmapDT = Bitmap.createScaledBitmap(play5BitmapDT,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play6BitmapDT = Bitmap.createScaledBitmap(play6BitmapDT,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play7BitmapDT = Bitmap.createScaledBitmap(play7BitmapDT,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play8BitmapDT = Bitmap.createScaledBitmap(play8BitmapDT,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play9BitmapDT = Bitmap.createScaledBitmap(play9BitmapDT,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play10BitmapDT =Bitmap.createScaledBitmap(play10BitmapDT,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play11BitmapDT =Bitmap.createScaledBitmap(play11BitmapDT,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play12BitmapDT =Bitmap.createScaledBitmap(play12BitmapDT,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play13BitmapDT =Bitmap.createScaledBitmap(play13BitmapDT,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play14BitmapDT =Bitmap.createScaledBitmap(play14BitmapDT,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play15BitmapDT =Bitmap.createScaledBitmap(play15BitmapDT,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play16BitmapDT =Bitmap.createScaledBitmap(play16BitmapDT,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play17BitmapDT =Bitmap.createScaledBitmap(play17BitmapDT,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play18BitmapDT =Bitmap.createScaledBitmap(play18BitmapDT,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play19BitmapDT =Bitmap.createScaledBitmap(play19BitmapDT,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play20BitmapDT =Bitmap.createScaledBitmap(play20BitmapDT,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play1BitmapT = Bitmap.createScaledBitmap(play1BitmapT,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play2BitmapT = Bitmap.createScaledBitmap(play2BitmapT,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play3BitmapT = Bitmap.createScaledBitmap(play3BitmapT,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play4BitmapT = Bitmap.createScaledBitmap(play4BitmapT,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play5BitmapT = Bitmap.createScaledBitmap(play5BitmapT,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play6BitmapT = Bitmap.createScaledBitmap(play6BitmapT,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play7BitmapT = Bitmap.createScaledBitmap(play7BitmapT,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play8BitmapT = Bitmap.createScaledBitmap(play8BitmapT,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play9BitmapT = Bitmap.createScaledBitmap(play9BitmapT,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play10BitmapT =Bitmap.createScaledBitmap(play10BitmapT,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play11BitmapT =Bitmap.createScaledBitmap(play11BitmapT,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play12BitmapT =Bitmap.createScaledBitmap(play12BitmapT,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play13BitmapT =Bitmap.createScaledBitmap(play13BitmapT,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play14BitmapT =Bitmap.createScaledBitmap(play14BitmapT,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play15BitmapT =Bitmap.createScaledBitmap(play15BitmapT,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play16BitmapT =Bitmap.createScaledBitmap(play16BitmapT,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play17BitmapT =Bitmap.createScaledBitmap(play17BitmapT,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play18BitmapT =Bitmap.createScaledBitmap(play18BitmapT,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play19BitmapT =Bitmap.createScaledBitmap(play19BitmapT,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    play20BitmapT =Bitmap.createScaledBitmap(play20BitmapT,canvas.getWidth() * 189 / 1050,canvas.getHeight()*172/540,true);
                    // qnox cit
                    fly1Bitmap = Bitmap.createScaledBitmap(fly1Bitmap,canvas.getWidth() * 145 / 1050,canvas.getHeight()*179/540,true);
                    fly2Bitmap = Bitmap.createScaledBitmap(fly2Bitmap,canvas.getWidth() * 145 / 1050,canvas.getHeight()*179/540,true);
                    fly3Bitmap = Bitmap.createScaledBitmap(fly3Bitmap,canvas.getWidth() * 145 / 1050,canvas.getHeight()*179/540,true);
                    fly4Bitmap = Bitmap.createScaledBitmap(fly4Bitmap,canvas.getWidth() * 145 / 1050,canvas.getHeight()*179/540,true);
                    layBitmap = Bitmap.createScaledBitmap(layBitmap,canvas.getWidth() * 195 / 1050,canvas.getHeight()*166/540,true);
                    sleepBitmap1 =  Bitmap.createScaledBitmap(sleepBitmap1,canvas.getWidth() * 195 / 1050,canvas.getHeight()*166/540,true);
                    sleepBitmap2 =  Bitmap.createScaledBitmap(sleepBitmap2,canvas.getWidth() * 195 / 1050,canvas.getHeight()*166/540,true);
                    // cit
                    canvas.drawBitmap(bitmap,(float) canvas.getWidth() *birdX,(float) canvas.getHeight()*birdY,paint);
                    //shnchel
                    if(!eating && !playing && !flying && !sleeping && !laying) {
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
                    //qnelu knopken
                    int sleepButtonWidth = canvas.getWidth()*106/1050;
                    int sleepButtonHeight = canvas.getHeight()*101/540;
                    float sleepButtonLeft = (float) canvas.getWidth()*241/1050;
                    float sleepButtonTop = (float) canvas.getHeight()*427/540;
                    sleepDarkButtonBitmap1 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap1,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap2 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap2,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap3 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap3,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap4 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap4,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap5 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap5,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap6 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap6,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap7 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap7,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap8 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap8,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap9 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap9,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap10 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap10,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap11 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap11,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap12 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap12,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap13 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap13,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap14 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap14,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap15 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap15,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap16 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap16,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap17 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap17,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap18 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap18,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap19 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap19,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap20 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap20,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap21 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap21,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap22 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap22,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap23 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap23,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap24 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap24,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap25 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap25,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap26 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap26,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap27 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap27,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap28 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap28,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap29 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap29,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap30 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap30,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap31 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap31,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap32 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap32,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap33 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap33,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap34 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap34,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap35 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap35,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap36 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap36,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap37 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap37,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap38 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap38,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap39 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap39,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap40 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap40,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap41 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap41,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap42 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap42,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap43 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap43,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap44 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap44,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap45 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap45,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap46 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap46,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap47 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap47,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap48 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap48,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap49 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap49,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap50 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap50,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap51 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap51,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap52 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap52,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap53 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap53,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap54 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap54,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap55 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap55,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap56 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap56,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap57 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap57,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap58 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap58,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap59 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap59,sleepButtonWidth, sleepButtonHeight,true);
                    sleepDarkButtonBitmap60 = Bitmap.createScaledBitmap(sleepDarkButtonBitmap60,sleepButtonWidth, sleepButtonHeight,true);
                    sleepButtonBitmap = Bitmap.createScaledBitmap(sleepButtonBitmap,sleepButtonWidth, sleepButtonHeight,true);
                    sleepButtonBitmap2 = Bitmap.createScaledBitmap(sleepButtonBitmap2,sleepButtonWidth, sleepButtonHeight,true);
                    if(!sleepChecker && checkSleepButton){
                        new SleepDarkButtonThread().start();
                        canvas.drawCircle(100,100,100,paintDirt);
                        checkSleepButton = false;
                    }
                    if(drawSleepButton){
                        switch (sleepTimer){
                            case 59:
                                sleepButtonBitmap = sleepDarkButtonBitmap59;
                                break;
                            case 58:
                                sleepButtonBitmap = sleepDarkButtonBitmap58;
                                break;
                            case 57:
                                sleepButtonBitmap = sleepDarkButtonBitmap57;
                                break;
                            case 56:
                                sleepButtonBitmap = sleepDarkButtonBitmap56;
                                break;
                            case 55:
                                sleepButtonBitmap = sleepDarkButtonBitmap55;
                                break;
                            case 54:
                                sleepButtonBitmap = sleepDarkButtonBitmap54;
                                break;
                            case 53:
                                sleepButtonBitmap = sleepDarkButtonBitmap53;
                                break;
                            case 52:
                                sleepButtonBitmap = sleepDarkButtonBitmap52;
                                break;
                            case 51:
                                sleepButtonBitmap = sleepDarkButtonBitmap51;
                                break;
                            case 50:
                                sleepButtonBitmap = sleepDarkButtonBitmap50;
                                break;
                            case 49:
                                sleepButtonBitmap = sleepDarkButtonBitmap49;
                                break;
                            case 48:
                                sleepButtonBitmap = sleepDarkButtonBitmap48;
                                break;
                            case 47:
                                sleepButtonBitmap = sleepDarkButtonBitmap47;
                                break;
                            case 46:
                                sleepButtonBitmap = sleepDarkButtonBitmap46;
                                break;
                            case 45:
                                sleepButtonBitmap = sleepDarkButtonBitmap45;
                                break;
                            case 44:
                                sleepButtonBitmap = sleepDarkButtonBitmap44;
                                break;
                            case 43:
                                sleepButtonBitmap = sleepDarkButtonBitmap43;
                                break;
                            case 42:
                                sleepButtonBitmap = sleepDarkButtonBitmap42;
                                break;
                            case 41:
                                sleepButtonBitmap = sleepDarkButtonBitmap41;
                                break;
                            case 40:
                                sleepButtonBitmap = sleepDarkButtonBitmap40;
                                break;
                            case 39:
                                sleepButtonBitmap = sleepDarkButtonBitmap39;
                                break;
                            case 38:
                                sleepButtonBitmap = sleepDarkButtonBitmap38;
                                break;
                            case 37:
                                sleepButtonBitmap = sleepDarkButtonBitmap37;
                                break;
                            case 36:
                                sleepButtonBitmap = sleepDarkButtonBitmap36;
                                break;
                            case 35:
                                sleepButtonBitmap = sleepDarkButtonBitmap35;
                                break;
                            case 34:
                                sleepButtonBitmap = sleepDarkButtonBitmap34;
                                break;
                            case 33:
                                sleepButtonBitmap = sleepDarkButtonBitmap33;
                                break;
                            case 32:
                                sleepButtonBitmap = sleepDarkButtonBitmap32;
                                break;
                            case 31:
                                sleepButtonBitmap = sleepDarkButtonBitmap31;
                                break;
                            case 30:
                                sleepButtonBitmap = sleepDarkButtonBitmap30;
                                break;
                            case 29:
                                sleepButtonBitmap = sleepDarkButtonBitmap29;
                                break;
                            case 28:
                                sleepButtonBitmap = sleepDarkButtonBitmap28;
                                break;
                            case 27:
                                sleepButtonBitmap = sleepDarkButtonBitmap27;
                                break;
                            case 26:
                                sleepButtonBitmap = sleepDarkButtonBitmap26;
                                break;
                            case 25:
                                sleepButtonBitmap = sleepDarkButtonBitmap25;
                                break;
                            case 24:
                                sleepButtonBitmap = sleepDarkButtonBitmap24;
                                break;
                            case 23:
                                sleepButtonBitmap = sleepDarkButtonBitmap23;
                                break;
                            case 22:
                                sleepButtonBitmap = sleepDarkButtonBitmap22;
                                break;
                            case 21:
                                sleepButtonBitmap = sleepDarkButtonBitmap21;
                                break;
                            case 20:
                                sleepButtonBitmap = sleepDarkButtonBitmap20;
                                break;
                            case 19:
                                sleepButtonBitmap = sleepDarkButtonBitmap19;
                                break;
                            case 18:
                                sleepButtonBitmap = sleepDarkButtonBitmap18;
                                break;
                            case 17:
                                sleepButtonBitmap = sleepDarkButtonBitmap17;
                                break;
                            case 16:
                                sleepButtonBitmap = sleepDarkButtonBitmap16;
                                break;
                            case 15:
                                sleepButtonBitmap = sleepDarkButtonBitmap15;
                                break;
                            case 14:
                                sleepButtonBitmap = sleepDarkButtonBitmap14;
                                break;
                            case 13:
                                sleepButtonBitmap = sleepDarkButtonBitmap13;
                                break;
                            case 12:
                                sleepButtonBitmap = sleepDarkButtonBitmap12;
                                break;
                            case 11:
                                sleepButtonBitmap = sleepDarkButtonBitmap11;
                                break;
                            case 10:
                                sleepButtonBitmap = sleepDarkButtonBitmap10;
                                break;
                            case 9:
                                sleepButtonBitmap = sleepDarkButtonBitmap9;
                                break;
                            case 8:
                                sleepButtonBitmap = sleepDarkButtonBitmap8;
                                break;
                            case 7:
                                sleepButtonBitmap = sleepDarkButtonBitmap7;
                                break;
                            case 6:
                                sleepButtonBitmap = sleepDarkButtonBitmap6;
                                break;
                            case 5:
                                sleepButtonBitmap = sleepDarkButtonBitmap5;
                                break;
                            case 4:
                                sleepButtonBitmap = sleepDarkButtonBitmap4;
                                break;
                            case 3:
                                sleepButtonBitmap = sleepDarkButtonBitmap3;
                                break;
                            case 2:
                                sleepButtonBitmap = sleepDarkButtonBitmap2;
                                break;
                            case 1:
                                sleepButtonBitmap = sleepDarkButtonBitmap1;
                                sleepChecker = true;
                                lastTouchX = 0;
                                lastTouchY = 0;
                                m5 = 0;
                                break;
                            case 0:
                                sleepButtonBitmap = sleepButtonBitmap2;
                                break;
                        }
                    }
                    canvas.drawBitmap(sleepButtonBitmap,sleepButtonLeft,sleepButtonTop,paint);
                    // utel
                    if(lastTouchX >= eatButtonLeft && lastTouchX <= eatButtonLeft + eatButtonWidth && lastTouchY >= eatButtonTop && lastTouchY <= eatButtonTop + eatButtonHeight && eatChecker && !playing && !sleeping && !laying && !flying && !flyingBack) {
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
                    if(lastTouchX >= playButtonLeft && lastTouchX <= playButtonLeft + playButtonWidth && lastTouchY >= playButtonTop && lastTouchY <= playButtonTop + playButtonHeight && playChecker && !eating && !sleeping && !laying && !flying && !flyingBack) {
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
                                if(bitmap1 == bitmapDT1 || bitmap1 == bitmapDTH1 || bitmap1 == bitmapDTS1 || bitmap1 == bitmapDTSH1) bitmap = play1BitmapDT;
                                else if(bitmap1 == bitmapD1 || bitmap1 == bitmapDH1 || bitmap1 == bitmapDS1 || bitmap1 == bitmapDSH1) bitmap = play1BitmapD;
                                else if(bitmap1 == bitmapT1 || bitmap1 == bitmapTH1 || bitmap1 == bitmapTS1 || bitmap1 == bitmapTSH1) bitmap = play1BitmapT;
                                else if(bitmap1 == bitmapUsual1 || bitmap1 == bitmapH1 || bitmap1 == bitmapS1 || bitmap1 == bitmapSmile1) bitmap = play1Bitmap;
                                break;
                            case 2:
                                if(bitmap1 == bitmapDT1 || bitmap1 == bitmapDTH1 || bitmap1 == bitmapDTS1 || bitmap1 == bitmapDTSH1)                bitmap = play2BitmapDT;
                                else if(bitmap1 == bitmapD1 || bitmap1 == bitmapDH1 || bitmap1 == bitmapDS1 || bitmap1 == bitmapDSH1)               bitmap = play2BitmapD;
                                else if(bitmap1 == bitmapT1 || bitmap1 == bitmapTH1 || bitmap1 == bitmapTS1 || bitmap1 == bitmapTSH1)               bitmap = play2BitmapT;
                                else if(bitmap1==bitmapUsual1||bitmap1== bitmapH1||bitmap1==bitmapS1||bitmap1 == bitmapSmile1||bitmap1 == bitmapSH1)bitmap = play2Bitmap;
                                break;
                            case 3:
                                if(bitmap1 == bitmapDT1 || bitmap1 == bitmapDTH1 || bitmap1 == bitmapDTS1 || bitmap1 == bitmapDTSH1)                bitmap = play3BitmapDT;
                                else if(bitmap1 == bitmapD1 || bitmap1 == bitmapDH1 || bitmap1 == bitmapDS1 || bitmap1 == bitmapDSH1)               bitmap = play3BitmapD;
                                else if(bitmap1 == bitmapT1 || bitmap1 == bitmapTH1 || bitmap1 == bitmapTS1 || bitmap1 == bitmapTSH1)               bitmap = play3BitmapT;
                                else if(bitmap1==bitmapUsual1||bitmap1== bitmapH1||bitmap1==bitmapS1||bitmap1 == bitmapSmile1||bitmap1 == bitmapSH1)bitmap = play3Bitmap;
                                break;
                            case 4:
                                if(bitmap1 == bitmapDT1 || bitmap1 == bitmapDTH1 || bitmap1 == bitmapDTS1 || bitmap1 == bitmapDTSH1)                bitmap = play4BitmapDT;
                                else if(bitmap1 == bitmapD1 || bitmap1 == bitmapDH1 || bitmap1 == bitmapDS1 || bitmap1 == bitmapDSH1)               bitmap = play4BitmapD;
                                else if(bitmap1 == bitmapT1 || bitmap1 == bitmapTH1 || bitmap1 == bitmapTS1 || bitmap1 == bitmapTSH1)               bitmap = play4BitmapT;
                                else if(bitmap1==bitmapUsual1||bitmap1== bitmapH1||bitmap1==bitmapS1||bitmap1 == bitmapSmile1||bitmap1 == bitmapSH1)bitmap = play4Bitmap;
                                break;
                            case 5:
                                if(bitmap1 == bitmapDT1 || bitmap1 == bitmapDTH1 || bitmap1 == bitmapDTS1 || bitmap1 == bitmapDTSH1)                bitmap = play5BitmapDT;
                                else if(bitmap1 == bitmapD1 || bitmap1 == bitmapDH1 || bitmap1 == bitmapDS1 || bitmap1 == bitmapDSH1)               bitmap = play5BitmapD;
                                else if(bitmap1 == bitmapT1 || bitmap1 == bitmapTH1 || bitmap1 == bitmapTS1 || bitmap1 == bitmapTSH1)               bitmap = play5BitmapT;
                                else if(bitmap1==bitmapUsual1||bitmap1== bitmapH1||bitmap1==bitmapS1||bitmap1 == bitmapSmile1||bitmap1 == bitmapSH1)bitmap = play5Bitmap;
                                break;
                            case 6:
                                if(bitmap1 == bitmapDT1 || bitmap1 == bitmapDTH1 || bitmap1 == bitmapDTS1 || bitmap1 == bitmapDTSH1)                bitmap = play6BitmapDT;
                                else if(bitmap1 == bitmapD1 || bitmap1 == bitmapDH1 || bitmap1 == bitmapDS1 || bitmap1 == bitmapDSH1)               bitmap = play6BitmapD;
                                else if(bitmap1 == bitmapT1 || bitmap1 == bitmapTH1 || bitmap1 == bitmapTS1 || bitmap1 == bitmapTSH1)               bitmap = play6BitmapT;
                                else if(bitmap1==bitmapUsual1||bitmap1== bitmapH1||bitmap1==bitmapS1||bitmap1 == bitmapSmile1||bitmap1 == bitmapSH1)bitmap = play6Bitmap;
                                break;
                            case 7:
                                if(bitmap1 == bitmapDT1 || bitmap1 == bitmapDTH1 || bitmap1 == bitmapDTS1 || bitmap1 == bitmapDTSH1)                bitmap = play7BitmapDT;
                                else if(bitmap1 == bitmapD1 || bitmap1 == bitmapDH1 || bitmap1 == bitmapDS1 || bitmap1 == bitmapDSH1)               bitmap = play7BitmapD;
                                else if(bitmap1 == bitmapT1 || bitmap1 == bitmapTH1 || bitmap1 == bitmapTS1 || bitmap1 == bitmapTSH1)               bitmap = play7BitmapT;
                                else if(bitmap1==bitmapUsual1||bitmap1== bitmapH1||bitmap1==bitmapS1||bitmap1 == bitmapSmile1||bitmap1 == bitmapSH1)bitmap = play7Bitmap;
                                break;
                            case 8:
                                if(bitmap1 == bitmapDT1 || bitmap1 == bitmapDTH1 || bitmap1 == bitmapDTS1 || bitmap1 == bitmapDTSH1)                bitmap = play8BitmapDT;
                                else if(bitmap1 == bitmapD1 || bitmap1 == bitmapDH1 || bitmap1 == bitmapDS1 || bitmap1 == bitmapDSH1)               bitmap = play8BitmapD;
                                else if(bitmap1 == bitmapT1 || bitmap1 == bitmapTH1 || bitmap1 == bitmapTS1 || bitmap1 == bitmapTSH1)               bitmap = play8BitmapT;
                                else if(bitmap1==bitmapUsual1||bitmap1== bitmapH1||bitmap1==bitmapS1||bitmap1 == bitmapSmile1||bitmap1 == bitmapSH1)bitmap = play8Bitmap;
                                break;
                            case 9:
                                if(bitmap1 == bitmapDT1 || bitmap1 == bitmapDTH1 || bitmap1 == bitmapDTS1 || bitmap1 == bitmapDTSH1)                bitmap = play9BitmapDT;
                                else if(bitmap1 == bitmapD1 || bitmap1 == bitmapDH1 || bitmap1 == bitmapDS1 || bitmap1 == bitmapDSH1)               bitmap = play9BitmapD;
                                else if(bitmap1 == bitmapT1 || bitmap1 == bitmapTH1 || bitmap1 == bitmapTS1 || bitmap1 == bitmapTSH1)               bitmap = play9BitmapT;
                                else if(bitmap1==bitmapUsual1||bitmap1== bitmapH1||bitmap1==bitmapS1||bitmap1 == bitmapSmile1||bitmap1 == bitmapSH1)bitmap = play9Bitmap;
                                break;
                            case 10:
                                if(bitmap1 == bitmapDT1 || bitmap1 == bitmapDTH1 || bitmap1 == bitmapDTS1 || bitmap1 == bitmapDTSH1)                bitmap = play10BitmapDT;
                                else if(bitmap1 == bitmapD1 || bitmap1 == bitmapDH1 || bitmap1 == bitmapDS1 || bitmap1 == bitmapDSH1)               bitmap = play10BitmapD;
                                else if(bitmap1 == bitmapT1 || bitmap1 == bitmapTH1 || bitmap1 == bitmapTS1 || bitmap1 == bitmapTSH1)               bitmap = play10BitmapT;
                                else if(bitmap1==bitmapUsual1||bitmap1== bitmapH1||bitmap1==bitmapS1||bitmap1 == bitmapSmile1||bitmap1 == bitmapSH1)bitmap = play10Bitmap;
                                break;
                            case 11:
                                if(bitmap1 == bitmapDT1 || bitmap1 == bitmapDTH1 || bitmap1 == bitmapDTS1 || bitmap1 == bitmapDTSH1)                bitmap = play11BitmapDT;
                                else if(bitmap1 == bitmapD1 || bitmap1 == bitmapDH1 || bitmap1 == bitmapDS1 || bitmap1 == bitmapDSH1)               bitmap = play11BitmapD;
                                else if(bitmap1 == bitmapT1 || bitmap1 == bitmapTH1 || bitmap1 == bitmapTS1 || bitmap1 == bitmapTSH1)               bitmap = play11BitmapT;
                                else if(bitmap1==bitmapUsual1||bitmap1== bitmapH1||bitmap1==bitmapS1||bitmap1 == bitmapSmile1||bitmap1 == bitmapSH1)bitmap = play11Bitmap;
                                break;
                            case 12:
                                if(bitmap1 == bitmapDT1 || bitmap1 == bitmapDTH1 || bitmap1 == bitmapDTS1 || bitmap1 == bitmapDTSH1)                bitmap = play12BitmapDT;
                                else if(bitmap1 == bitmapD1 || bitmap1 == bitmapDH1 || bitmap1 == bitmapDS1 || bitmap1 == bitmapDSH1)               bitmap = play12BitmapD;
                                else if(bitmap1 == bitmapT1 || bitmap1 == bitmapTH1 || bitmap1 == bitmapTS1 || bitmap1 == bitmapTSH1)               bitmap = play12BitmapT;
                                else if(bitmap1==bitmapUsual1||bitmap1== bitmapH1||bitmap1==bitmapS1||bitmap1 == bitmapSmile1||bitmap1 == bitmapSH1)bitmap = play12Bitmap;
                                break;
                            case 13:
                                if(bitmap1 == bitmapDT1 || bitmap1 == bitmapDTH1 || bitmap1 == bitmapDTS1 || bitmap1 == bitmapDTSH1)                bitmap = play13BitmapDT;
                                else if(bitmap1 == bitmapD1 || bitmap1 == bitmapDH1 || bitmap1 == bitmapDS1 || bitmap1 == bitmapDSH1)               bitmap = play13BitmapD;
                                else if(bitmap1 == bitmapT1 || bitmap1 == bitmapTH1 || bitmap1 == bitmapTS1 || bitmap1 == bitmapTSH1)               bitmap = play13BitmapT;
                                else if(bitmap1==bitmapUsual1||bitmap1== bitmapH1||bitmap1==bitmapS1||bitmap1 == bitmapSmile1||bitmap1 == bitmapSH1)bitmap = play13Bitmap;
                                break;
                            case 14:
                                if(bitmap1 == bitmapDT1 || bitmap1 == bitmapDTH1 || bitmap1 == bitmapDTS1 || bitmap1 == bitmapDTSH1)                bitmap = play14BitmapDT;
                                else if(bitmap1 == bitmapD1 || bitmap1 == bitmapDH1 || bitmap1 == bitmapDS1 || bitmap1 == bitmapDSH1)               bitmap = play14BitmapD;
                                else if(bitmap1 == bitmapT1 || bitmap1 == bitmapTH1 || bitmap1 == bitmapTS1 || bitmap1 == bitmapTSH1)               bitmap = play14BitmapT;
                                else if(bitmap1==bitmapUsual1||bitmap1== bitmapH1||bitmap1==bitmapS1||bitmap1 == bitmapSmile1||bitmap1 == bitmapSH1)bitmap = play14Bitmap;
                                break;
                            case 15:
                                if(bitmap1 == bitmapDT1 || bitmap1 == bitmapDTH1 || bitmap1 == bitmapDTS1 || bitmap1 == bitmapDTSH1)                bitmap = play15BitmapDT;
                                else if(bitmap1 == bitmapD1 || bitmap1 == bitmapDH1 || bitmap1 == bitmapDS1 || bitmap1 == bitmapDSH1)               bitmap = play15BitmapD;
                                else if(bitmap1 == bitmapT1 || bitmap1 == bitmapTH1 || bitmap1 == bitmapTS1 || bitmap1 == bitmapTSH1)               bitmap = play15BitmapT;
                                else if(bitmap1==bitmapUsual1||bitmap1== bitmapH1||bitmap1==bitmapS1||bitmap1 == bitmapSmile1||bitmap1 == bitmapSH1)bitmap = play15Bitmap;
                                break;
                            case 16:
                                if(bitmap1 == bitmapDT1 || bitmap1 == bitmapDTH1 || bitmap1 == bitmapDTS1 || bitmap1 == bitmapDTSH1)                bitmap = play16BitmapDT;
                                else if(bitmap1 == bitmapD1 || bitmap1 == bitmapDH1 || bitmap1 == bitmapDS1 || bitmap1 == bitmapDSH1)               bitmap = play16BitmapD;
                                else if(bitmap1 == bitmapT1 || bitmap1 == bitmapTH1 || bitmap1 == bitmapTS1 || bitmap1 == bitmapTSH1)               bitmap = play16BitmapT;
                                else if(bitmap1==bitmapUsual1||bitmap1== bitmapH1||bitmap1==bitmapS1||bitmap1 == bitmapSmile1||bitmap1 == bitmapSH1)bitmap = play16Bitmap;
                                break;
                            case 17:
                                if(bitmap1 == bitmapDT1 || bitmap1 == bitmapDTH1 || bitmap1 == bitmapDTS1 || bitmap1 == bitmapDTSH1)                bitmap = play17BitmapDT;
                                else if(bitmap1 == bitmapD1 || bitmap1 == bitmapDH1 || bitmap1 == bitmapDS1 || bitmap1 == bitmapDSH1)               bitmap = play17BitmapD;
                                else if(bitmap1 == bitmapT1 || bitmap1 == bitmapTH1 || bitmap1 == bitmapTS1 || bitmap1 == bitmapTSH1)               bitmap = play17BitmapT;
                                else if(bitmap1==bitmapUsual1||bitmap1== bitmapH1||bitmap1==bitmapS1||bitmap1 == bitmapSmile1||bitmap1 == bitmapSH1)bitmap = play17Bitmap;
                                break;
                            case 18:
                                if(bitmap1 == bitmapDT1 || bitmap1 == bitmapDTH1 || bitmap1 == bitmapDTS1 || bitmap1 == bitmapDTSH1)                bitmap = play18BitmapDT;
                                else if(bitmap1 == bitmapD1 || bitmap1 == bitmapDH1 || bitmap1 == bitmapDS1 || bitmap1 == bitmapDSH1)               bitmap = play18BitmapD;
                                else if(bitmap1 == bitmapT1 || bitmap1 == bitmapTH1 || bitmap1 == bitmapTS1 || bitmap1 == bitmapTSH1)               bitmap = play18BitmapT;
                                else if(bitmap1==bitmapUsual1||bitmap1== bitmapH1||bitmap1==bitmapS1||bitmap1 == bitmapSmile1||bitmap1 == bitmapSH1)bitmap = play18Bitmap;
                                break;
                            case 19:
                                if(bitmap1 == bitmapDT1 || bitmap1 == bitmapDTH1 || bitmap1 == bitmapDTS1 || bitmap1 == bitmapDTSH1)                bitmap = play19BitmapDT;
                                else if(bitmap1 == bitmapD1 || bitmap1 == bitmapDH1 || bitmap1 == bitmapDS1 || bitmap1 == bitmapDSH1)               bitmap = play19BitmapD;
                                else if(bitmap1 == bitmapT1 || bitmap1 == bitmapTH1 || bitmap1 == bitmapTS1 || bitmap1 == bitmapTSH1)               bitmap = play19BitmapT;
                                else if(bitmap1==bitmapUsual1||bitmap1== bitmapH1||bitmap1==bitmapS1||bitmap1 == bitmapSmile1||bitmap1 == bitmapSH1)bitmap = play19Bitmap;
                                break;
                            case 20:
                                if(bitmap1 == bitmapDT1 || bitmap1 == bitmapDTH1 || bitmap1 == bitmapDTS1 || bitmap1 == bitmapDTSH1)                bitmap = play20BitmapDT;
                                else if(bitmap1 == bitmapD1 || bitmap1 == bitmapDH1 || bitmap1 == bitmapDS1 || bitmap1 == bitmapDSH1)               bitmap = play20BitmapD;
                                else if(bitmap1 == bitmapT1 || bitmap1 == bitmapTH1 || bitmap1 == bitmapTS1 || bitmap1 == bitmapTSH1)               bitmap = play20BitmapT;
                                else if(bitmap1==bitmapUsual1||bitmap1== bitmapH1||bitmap1==bitmapS1||bitmap1 == bitmapSmile1||bitmap1 == bitmapSH1)bitmap = play20Bitmap;
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
                    //qnel
                    if(lastTouchX >= sleepButtonLeft && lastTouchX <= sleepButtonLeft + sleepButtonWidth && lastTouchY >= sleepButtonTop && lastTouchY <= sleepButtonTop + sleepButtonHeight && !sleepFinished && sleepChecker && !playing && !eating) {
                        fl = true;
                    }
                    if(!flyingTimeIsPassed && fl && !sleepFinished) {
                        new FlyingThread().start();
                        flying = true;
                        flyingTimeIsPassed = true;
                    }
                    if(flyingNeedToDrawNow && flying && !sleepFinished) {
                        switch (sleep){
                            case 1:
                                bitmap = fly1Bitmap;
                                break;
                            case 2:
                                bitmap = fly2Bitmap;
                                birdX = (float)353/1050;
                                birdY = (float)238/540;
                                break;
                            case 3:
                                bitmap = fly1Bitmap;
                                birdX = (float)287/1050;
                                birdY = (float)226/540;
                                break;
                            case 4:
                                bitmap = fly2Bitmap;
                                birdX = (float)230/1050;
                                birdY = (float)232/540;
                                break;
                            case 5:
                                bitmap = fly1Bitmap;
                                birdX = (float)159/1050;
                                birdY = (float)193/540;
                                break;
                            case 6:
                                bitmap = bitmap1;
                                birdX = (float)48/1050;
                                birdY = (float)218/540;
                                break;
                            case 7:
                                bitmap = layBitmap;
                                birdX = (float)60/1050;
                                birdY = (float)207/540;
                                laying = true;
                                flying = false;
                                bitmap = sleepBitmap1;
                                sleepButtonBitmap = sleepDarkButtonBitmap60;
                                checkSleepButton = true;
                                sleepChecker = false;
                                sleeping = true;
                                sleepTimer = 60;
                                break;
                        }
                    }
                    if(laying && !sleepFinished) {
                        if (!timeIsPassedSleep1 && !checkSleep) {
                            new ThreadSleepBird1().start();
                            timeIsPassedSleep1 = true;
                        }
                        if (needToDrawNowSleep1 && !checkSleep) {
                            bitmap = sleepBitmap1;
                        }
                        if (!timeIsPassedSleep2 && checkSleep) {
                            new ThreadSleepBird2().start();
                            timeIsPassedSleep2 = true;
                        }
                        if (needToDrawNowSleep2 && checkSleep) {
                            bitmap = sleepBitmap2;
                        }
                        if(!timeIsPassedSle){
                            new Sleep().start();
                            timeIsPassedSle = true;
                        }
                        if(needToDrawNowSle && r1 == 1){
                            qun *= (sleepRight2 - sleepLeft);
                            if (sleepRight + qun > sleepRight2) {
                                sleepRight = sleepRight2;
                                sleepFinished = true;
                                sleeping = false;
                                laying = false;
                            } else {
                                sleepRight += qun;
                            }
                            qun /= (sleepRight2 - sleepLeft);
                            r1 = 0;
                        }
                    }
                    if(sleepFinished) {
                        if(!flyingBackTimeIsPassed){
                            new FlyingBackThread().start();
                            flyingBackTimeIsPassed = true;
                            flyingBack = true;
                        }
                        if(flyingBackNeedToDrawNow && flyingBack){
                            switch (flyBack){
                                case 1:
                                    bitmap = bitmap1;
                                    birdX = (float)48/1050;
                                    birdY = (float)218/540;
                                    break;
                                case 2:
                                    bitmap = fly3Bitmap;
                                    birdX = (float)159/1050;
                                    birdY = (float)193/540;
                                    break;
                                case 3:
                                    bitmap = fly4Bitmap;
                                    birdX = (float)230/1050;
                                    birdY = (float)232/540;
                                    break;
                                case 4:
                                    bitmap = fly3Bitmap;
                                    birdX = (float)287/1050;
                                    birdY = (float)226/540;
                                    break;
                                case 5:
                                    bitmap = fly4Bitmap;
                                    birdX = (float)353/1050;
                                    birdY = (float)238/540;
                                    break;
                                case 6:
                                    bitmap = fly3Bitmap;
                                    birdX = (float) 419/1050;
                                    birdY = (float) 232/540;
                                    break;
                                case 7:
                                    bitmap = bitmap1;
                                    birdX = (float) 419/1050;
                                    birdY = (float) 232/540;
                                    flyingBack = false;
                                    flyBack = 0;
                                    sleeping = false;
                                    sleepFinished = false;
                                    sleep = 0;
                                    lastTouchY = 0;
                                    lastTouchX = 0;
                                    sl = false;
                                    fl = false;
                                    flying = false;
                                    flyingTimeIsPassed = false;
                                    break;
                            }
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
    class ThreadSleepBird1 extends Thread{
        @Override
        public void run() {
            try {
                sleep(1500);
                timeIsPassedSleep1 = false;
                needToDrawNowSleep1 = true;
                checkSleep = true;
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    class ThreadSleepBird2 extends Thread{
        @Override
        public void run() {
            try {
                sleep(1000);
                timeIsPassedSleep2 = false;
                needToDrawNowSleep2 = true;
                checkSleep = false;
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    class Sleep extends Thread{
        @Override
        public void run() {
            try {
                sleep(600);
                timeIsPassedSle = false;
                needToDrawNowSle = true;
                r1 = 1;
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
    class FlyingThread extends Thread{
        @Override
        public void run() {
            try {
                if(sleep<7) {
                    sleep++;
                    sleep(300);
                    flyingTimeIsPassed = false;
                    flyingNeedToDrawNow = true;
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    class FlyingBackThread extends Thread{
        @Override
        public void run() {
            try {
                if(flyBack<7) {
                    flyBack++;
                    sleep(300);
                    flyingBackTimeIsPassed = false;
                    flyingBackNeedToDrawNow = true;
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
    class SleepDarkButtonThread extends Thread{
        @Override
        public void run() {
            try {
                if(sleepTimer>=0) {
                    sleep(1000);
                    checkSleepButton = true;
                    drawSleepButton = true;
                    sleepTimer--;
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

