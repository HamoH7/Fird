package com.example.test;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.SurfaceHolder;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

public class DrawThread extends Thread {
    private  SurfaceHolder surfaceHolder;
    private static  final int REQUEST_CODE = 1;
    public MainActivity mainActivity = new MainActivity();
    public MyDraw myDraw;
    public Screenshot screenshot = new Screenshot();
    private Context context;
    private float lastTouchX = 0;
    private float lastTouchY = 0;
    private float birdX = (float) 419/1050;
    private float birdY = (float) 232/540;
    private float birdWidth = (float) 150 / 1050;
    private float birdHeight = (float) 172/540;
    private float screenshotWidth = (float) 73 / 1050;
    private float screenshotHeight = (float) 73/540;
    private float screenshotX = (float) 962/1050;
    private float screenshotY = (float) 461/540;
    private int disgust = 1, eatScore = 0, wash = 1, hit = 1,poop1=1,poop2=1,poop3=0, m = 0, n = 0, m1 = 0, m2 = 0, m3 = 0, m4 = 0,m6 = 0, eat = 1, e = 0, eatTimer = 10, m5 = 0, p = 0, playTimer = 15, sleepTimer = 60, play = 0, sleep = 0, r1 = 0, flyBack = 0;
    private double h = (float)1/100;
    private double s = (float) 1 / 100;
    private double q = (float) 1 / 100;
    private double k = (float) 1 / 100;
    private double food = (float) 1 / 10;
    private double smile = (float) 1 / 60;
    private double qun = (float) 1 / 40;
    private float hungryRight = 0, happyRight = 0, sleepRight = 0, dirtRight = 0, lifeRight = 0;
    private int life, dirt, hungry, tired,happy;
    private boolean ea = false, pl = false, sl = false, fl = false, sle = false, hi = false, wa = false, pop = false, po = false;
    private boolean playingTimeIsPassed = false;
    private boolean playingNeedToDrawNow = false;
    private boolean checkPlayButton = false;
    private boolean drawPlayButton = false;
    private boolean playChecker = true;
    private boolean hitting = false;
    private boolean eating = false;
    private boolean playing = false;
    private boolean flying = false;
    private boolean laying = false;
    private boolean sleeping = false;
    private boolean isScreen = false;
    private boolean flyingBack = false;
    private boolean washing = false;
    private boolean pooping = false;
    private boolean disgusting = false;
    private boolean flyPoop = false;
    private boolean flyBackPoop = false;
    private boolean eatChecker = true;
    private boolean sleepChecker = true;
    private boolean checkEatButton = false;
    private boolean drawEatButton = false;
    private boolean checkSleepButton = false;
    private boolean drawSleepButton = false;
    private boolean eatingTimeIsPassed = false;
    private boolean eatingNeedToDrawNow = false;
    private boolean flyingTimeIsPassed = false;
    private boolean flyingNeedToDrawNow = false;
    private boolean poopingTimeIsPassed1 = false;
    private boolean poopingNeedToDrawNow1 = false;
    private boolean poopingTimeIsPassed2 = false;
    private boolean poopingNeedToDrawNow2 = false;
    private boolean poopingTimeIsPassed3 = false;
    private boolean poopingNeedToDrawNow3 = false;
    private boolean disgustingTimeIsPassed = false;
    private boolean disgustingNeedToDrawNow = false;
    private boolean flyingBackTimeIsPassed = false;
    private boolean flyingBackNeedToDrawNow = false;
    private boolean washingTimeIsPassed = false;
    private boolean washingNeedToDrawNow = false;
    private boolean hitTimeIsPassed = false;
    private boolean hitNeedToDrawNow = false;
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
    private boolean isTouched = false;
    private View view;
    private Bitmap playButtonBitmap,playButtonBitmap2, playButtonBitmapA;
    private Bitmap sleepButtonBitmap,sleepButtonBitmap2,sleepButtonBitmapA;
    private Bitmap washButtonBitmap, washButtonBitmap2,washButtonBitmap3,washButtonBitmapA;
    private Bitmap bitmapbg,bitmapkust,bitmapHeart, bitmapDirt, bitmapHungry,bitmapSleep, bitmapHappy, eatButtonBitmap,eatButtonBitmap2,eatButtonBitmapA, highScoreBitmap, scoreBitmap;
    private Bitmap bitmap, bitmapDTSH1, bitmapDTSH2, bitmapDTS1, bitmapDTS2, bitmapDTH1, bitmapDTH2, bitmapDSH1, bitmapDSH2, bitmapTSH1, bitmapTSH2,
            bitmapDH1, bitmapDH2, bitmapDS1, bitmapDS2, bitmapDT1, bitmapDT2, bitmapSH1, bitmapSH2, bitmapTH1,bitmapTH2,bitmapTS1,bitmapTS2
            ,bitmapD1,bitmapD2,bitmapT1,bitmapT2,bitmapS1,bitmapS2,bitmapH1,bitmapH2,bitmapSmile1,bitmapSmile2,bitmapUsual1,bitmapUsual2, bitmap1, bitmap2;
    private Bitmap bitmapDarkbg,bitmapDarkkust;
    private Bitmap sleepDarkButtonBitmap[] = new Bitmap[61];
    private Bitmap eatDarkButtonBitmap[] = new Bitmap[11];
    private Bitmap playDarkButtonBitmap[] = new Bitmap[16];
    private Bitmap poopBitmap[] = new Bitmap[5];
    private Bitmap washDarkButtonBitmap;
    private Bitmap screenshotBitmap;
    private Bitmap hitBitmap[] = new Bitmap[15], hitBitmapH[] = new Bitmap[15], hitBitmapD[] = new Bitmap[15], hitBitmapDH[] = new Bitmap[15];
    private Bitmap eatBitmap[] = new Bitmap[11],eatBitmapD[] = new Bitmap[11], eatBitmapS[] = new Bitmap[11], eatBitmapT[] = new Bitmap[11], eatBitmapTS[] = new Bitmap[11], eatBitmapDS[] = new Bitmap[11], eatBitmapDT[] = new Bitmap[11], eatBitmapDTS[] = new Bitmap[11], eatBitmapSmile[] = new Bitmap[11];
    private Bitmap playBitmap[] = new Bitmap[21],playBitmapD[] = new Bitmap[21],playBitmapT[] = new Bitmap[21],playBitmapDT[] = new Bitmap[21];
    private Bitmap flyBitmapUsual[] = new Bitmap[5], flyBitmapDH[] = new Bitmap[5],flyBitmapDS[] = new Bitmap[5],flyBitmapD[] = new Bitmap[5], flyBitmapH[] = new Bitmap[5],flyBitmapSmile[] = new Bitmap[5], flyBitmapSDH[] = new Bitmap[5], flyBitmapSH[] = new Bitmap[5], flyBitmapS[] = new Bitmap[5], flyBitmapTDH[] = new Bitmap[5], flyBitmapTDSH[] = new Bitmap[5], flyBitmapTDS[] = new Bitmap[5], flyBitmapTD[] = new Bitmap[5], flyBitmapTH[] = new Bitmap[5], flyBitmapTSH[] = new Bitmap[5], flyBitmapTS[] = new Bitmap[5], flyBitmapT[] = new Bitmap[5];
    private Bitmap washBitmap[] = new Bitmap[26];
    private Bitmap poopingBitmapUsual[] = new Bitmap[11],poopingBitmapDSH[] = new Bitmap[11],poopingBitmapDH[] = new Bitmap[11],poopingBitmapDS[] = new Bitmap[11],poopingBitmapDTH[] = new Bitmap[11],poopingBitmapDTSH[] = new Bitmap[11],poopingBitmapDTS[] = new Bitmap[11],poopingBitmapDT[] = new Bitmap[11],poopingBitmapD[] = new Bitmap[11],poopingBitmapHS[] = new Bitmap[11],poopingBitmapH[] = new Bitmap[11],poopingBitmapTH[] = new Bitmap[11],poopingBitmapS[] = new Bitmap[11],poopingBitmapTHS[] = new Bitmap[11],poopingBitmapTS[] = new Bitmap[11],poopingBitmapT[] = new Bitmap[11];
    private Bitmap sleepUsual1, sleepUsual2, sleepDH1, sleepDH2, sleepDSH1, sleepDSH2, sleepDS1, sleepDS2, sleepD1, sleepD2, sleepH1, sleepH2, sleepSmile1, sleepSmile2, sleepSH1, sleepSH2, sleepS1, sleepS2;
    private volatile boolean running = true;
    private Class<Activity> activityClass;
    Paint paint = new Paint();
    Paint paintLife = new Paint();
    Paint paintDirt = new Paint();
    Paint paintHungry = new Paint();
    Paint paintSleep = new Paint();
    Paint paintHappy = new Paint();
    Paint paintBlack = new Paint();
    public DrawThread(Context context, SurfaceHolder surfaceHolder, MyDraw myDraw) {
        this.view = view;
        this.activityClass = activityClass;
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
        eatBitmap[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.utox1);
        eatBitmap[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.utox2);
        eatBitmap[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.utox3);
        eatBitmap[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.utox4);
        eatBitmap[5] = BitmapFactory.decodeResource(context.getResources(),R.drawable.utox5);
        eatBitmap[6] = BitmapFactory.decodeResource(context.getResources(),R.drawable.utox6);
        eatBitmap[7] = BitmapFactory.decodeResource(context.getResources(),R.drawable.utox7);
        eatBitmap[8] = BitmapFactory.decodeResource(context.getResources(),R.drawable.utox8);
        eatBitmap[9] = BitmapFactory.decodeResource(context.getResources(),R.drawable.utox9);
        eatBitmap[10] = BitmapFactory.decodeResource(context.getResources(),R.drawable.utox10);
        playBitmap[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox1);
        playBitmap[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox2);
        playBitmap[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox3);
        playBitmap[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox4);
        playBitmap[5] = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox5);
        playBitmap[6] = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox6);
        playBitmap[7] = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox7);
        playBitmap[8] = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox8);
        playBitmap[9] = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox9);
        playBitmap[10] = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox10);
        playBitmap[11] = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox11);
        playBitmap[12] = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox12);
        playBitmap[13] = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox13);
        playBitmap[14] = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox14);
        playBitmap[15] = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox15);
        playBitmap[16] = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox16);
        playBitmap[17] = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox17);
        playBitmap[18] = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox18);
        playBitmap[19] = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox19);
        playBitmap[20] = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox20);
        playBitmapD[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox1);
        playBitmapD[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox2);
        playBitmapD[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox3);
        playBitmapD[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox4);
        playBitmapD[5] = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox5);
        playBitmapD[6] = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox6);
        playBitmapD[7] = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox7);
        playBitmapD[8] = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox8);
        playBitmapD[9] = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox9);
        playBitmapD[10] = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox10);
        playBitmapD[11] = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox11);
        playBitmapD[12] = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox12);
        playBitmapD[13] = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox13);
        playBitmapD[14] = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox14);
        playBitmapD[15] = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox15);
        playBitmapD[16] = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox16);
        playBitmapD[17] = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox17);
        playBitmapD[18] = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox18);
        playBitmapD[19] = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox19);
        playBitmapD[20] = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox20);
        playBitmapT[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox1);
        playBitmapT[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox2);
        playBitmapT[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox3);
        playBitmapT[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox4);
        playBitmapT[5] = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox5);
        playBitmapT[6] = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox6);
        playBitmapT[7] = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox7);
        playBitmapT[8] = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox8);
        playBitmapT[9] = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox9);
        playBitmapT[10] = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox10);
        playBitmapT[11] = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox11);
        playBitmapT[12] = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox12);
        playBitmapT[13] = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox13);
        playBitmapT[14] = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox14);
        playBitmapT[15] = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox15);
        playBitmapT[16] = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox16);
        playBitmapT[17] = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox17);
        playBitmapT[18] = BitmapFactory.decodeResource(context.getResources(),R.drawable.xaxacox18);
        playBitmapT[19] = BitmapFactory.decodeResource(context.getResources(),R.drawable.t_xaxacox19);
        playBitmapT[20] = BitmapFactory.decodeResource(context.getResources(),R.drawable.t_xaxacox20);
        playBitmapDT[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox1);
        playBitmapDT[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox2);
        playBitmapDT[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox3);
        playBitmapDT[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox4);
        playBitmapDT[5] = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox5);
        playBitmapDT[6] = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox6);
        playBitmapDT[7] = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox7);
        playBitmapDT[8] = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox8);
        playBitmapDT[9] = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox9);
        playBitmapDT[10] = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox10);
        playBitmapDT[11] = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox11);
        playBitmapDT[12] = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox12);
        playBitmapDT[13] = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox13);
        playBitmapDT[14] = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox14);
        playBitmapDT[15] = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox15);
        playBitmapDT[16] = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox16);
        playBitmapDT[17] = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox17);
        playBitmapDT[18] = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_xaxacox18);
        playBitmapDT[19] = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_t_xaxacox19);
        playBitmapDT[20] = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_t_xaxacox20);
        flyBitmapUsual[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.trnox_cit1);
        flyBitmapUsual[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.trnox_cit2);
        flyBitmapUsual[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.trnox_cit3);
        flyBitmapUsual[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.trnox_cit4);
        flyBitmapDH[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_d_h1);
        flyBitmapDH[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_d_h2);
        flyBitmapDH[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_d_h3);
        flyBitmapDH[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_d_h4);
        flyBitmapD[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_d1);
        flyBitmapD[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_d2);
        flyBitmapD[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_d3);
        flyBitmapD[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_d4);
        flyBitmapDS[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_d_s1);
        flyBitmapDS[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_d_s2);
        flyBitmapDS[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_d_s3);
        flyBitmapDS[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_d_s4);
        flyBitmapH[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_h1);
        flyBitmapH[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_h2);
        flyBitmapH[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_h3);
        flyBitmapH[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_h4);
        flyBitmapSmile[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_hp1);
        flyBitmapSmile[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_hp2);
        flyBitmapSmile[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_hp3);
        flyBitmapSmile[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_hp4);
        flyBitmapSDH[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_s_d_h1);
        flyBitmapSDH[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_s_d_h2);
        flyBitmapSDH[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_s_d_h3);
        flyBitmapSDH[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_s_d_h4);
        flyBitmapSH[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_s_h1);
        flyBitmapSH[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_s_h2);
        flyBitmapSH[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_s_h3);
        flyBitmapSH[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_s_h4);
        flyBitmapS[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_s1);
        flyBitmapS[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_s2);
        flyBitmapS[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_s3);
        flyBitmapS[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_s4);
        flyBitmapTDH[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_t_d_h1);
        flyBitmapTDH[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_t_d_h2);
        flyBitmapTDH[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_d_h3);
        flyBitmapTDH[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_d_h4);
        flyBitmapTDSH[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_t_d_s_h1);
        flyBitmapTDSH[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_t_d_s_h2);
        flyBitmapTDSH[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_s_d_h3);
        flyBitmapTDSH[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_s_d_h4);
        flyBitmapTDS[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_t_d_s1);
        flyBitmapTDS[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_t_d_s2);
        flyBitmapTDS[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_d_s3);
        flyBitmapTDS[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_d_s4);
        flyBitmapTD[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_t_d1);
        flyBitmapTD[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_t_d2);
        flyBitmapTD[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_d3);
        flyBitmapTD[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_d4);
        flyBitmapTH[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_t_h1);
        flyBitmapTH[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_t_h2);
        flyBitmapTH[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_h3);
        flyBitmapTH[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_h4);
        flyBitmapTSH[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_t_s_h1);
        flyBitmapTSH[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_t_s_h2);
        flyBitmapTSH[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_s_h3);
        flyBitmapTSH[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_s_h4);
        flyBitmapTS[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_t_s1);
        flyBitmapTS[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_t_s2);
        flyBitmapTS[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_s3);
        flyBitmapTS[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_s4);
        flyBitmapT[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_t1);
        flyBitmapT[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.f_t2);
        flyBitmapT[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.trnox_cit3);
        flyBitmapT[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.trnox_cit4);
        hitBitmap[1] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.tprtacox1);
        hitBitmap[2] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.tprtacox2);
        hitBitmap[3] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.tprtacox3);
        hitBitmap[4] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.tprtacox4);
        hitBitmap[5] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.tprtacox5);
        hitBitmap[6] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.tprtacox6);
        hitBitmap[7] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.tprtacox7);
        hitBitmap[8] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.tprtacox8);
        hitBitmap[9] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.tprtacox9);
        hitBitmap[10] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.tprtacox10);
        hitBitmap[11] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.tprtacox11);
        hitBitmap[12] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.tprtacox12);
        hitBitmap[13] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.tprtacox13);
        hitBitmap[14] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.tprtacox14);
        hitBitmapD[1] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.ht_d1);
        hitBitmapD[2] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.ht_d2);
        hitBitmapD[3] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.ht_d3);
        hitBitmapD[4] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.ht_d4);
        hitBitmapD[5] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.ht_d5);
        hitBitmapD[6] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.ht_d6);
        hitBitmapD[7] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.ht_d7);
        hitBitmapD[8] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.ht_d8);
        hitBitmapD[9] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.ht_d9);
        hitBitmapD[10] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.ht_d10);
        hitBitmapD[11] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.ht_d11);
        hitBitmapD[12] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.ht_d12);
        hitBitmapD[13] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.ht_d13);
        hitBitmapD[14] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.ht_d14);
        hitBitmapH[1] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.ht_h1);
        hitBitmapH[2] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.ht_h2);
        hitBitmapH[3] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.ht_h3);
        hitBitmapH[4] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.ht_h4);
        hitBitmapH[5] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.ht_h5);
        hitBitmapH[6] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.ht_h6);
        hitBitmapH[7] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.ht_h7);
        hitBitmapH[8] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.ht_h8);
        hitBitmapH[9] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.ht_h9);
        hitBitmapH[10] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.ht_h10);
        hitBitmapH[11] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.ht_h11);
        hitBitmapH[12] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.ht_h12);
        hitBitmapH[13] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.ht_h13);
        hitBitmapH[14] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.ht_h14);
        hitBitmapDH[1] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.ht_d_h1);
        hitBitmapDH[2] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.ht_d_h2);
        hitBitmapDH[3] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.ht_d_h3);
        hitBitmapDH[4] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.ht_d_h4);
        hitBitmapDH[5] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.ht_d_h5);
        hitBitmapDH[6] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.ht_d_h6);
        hitBitmapDH[7] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.ht_d_h7);
        hitBitmapDH[8] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.ht_d_h8);
        hitBitmapDH[9] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.ht_d_h9);
        hitBitmapDH[10] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.ht_d_h10);
        hitBitmapDH[11] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.ht_d_h11);
        hitBitmapDH[12] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.ht_d_h12);
        hitBitmapDH[13] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.ht_d_h13);
        hitBitmapDH[14] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.ht_d_h14);
        washBitmap[1] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.lvacvox1);
        washBitmap[2] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.lvacvox2);
        washBitmap[3] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.lvacvox3);
        washBitmap[4] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.lvacvox4);
        washBitmap[5] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.lvacvox5);
        washBitmap[6] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.lvacvox6);
        washBitmap[7] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.lvacvox7);
        washBitmap[8] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.lvacvox8);
        washBitmap[9] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.lvacvox9);
        washBitmap[10] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.lvacvox10);
        washBitmap[11] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.lvacvox11);
        washBitmap[12] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.lvacvox12);
        washBitmap[13] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.lvacvox13);
        washBitmap[14] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.lvacvox14);
        washBitmap[15] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.lvacvox15);
        washBitmap[16] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.lvacvox16);
        washBitmap[17] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.lvacvox17);
        washBitmap[18] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.lvacvox18);
        washBitmap[19] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.lvacvox19);
        washBitmap[20] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.lvacvox20);
        washBitmap[21] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.lvacvox21);
        washBitmap[22] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.lvacvox22);
        washBitmap[23] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.lvacvox23);
        washBitmap[24] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.lvacvox24);
        washBitmap[25] =  BitmapFactory.decodeResource(context.getResources(),R.drawable.lvacvox25);
        sleepUsual1 = BitmapFactory.decodeResource(context.getResources(),R.drawable.qnac1);
        sleepUsual2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.qnac2);
        sleepDH1 = BitmapFactory.decodeResource(context.getResources(),R.drawable.sl_d_h1);
        sleepDH2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.sl_d_h2);
        sleepDSH1 = BitmapFactory.decodeResource(context.getResources(),R.drawable.sl_d_s_h1);
        sleepDSH2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.sl_d_s_h2);
        sleepDS1 = BitmapFactory.decodeResource(context.getResources(),R.drawable.sl_d_s1);
        sleepDS2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.sl_d_s2);
        sleepDH1 = BitmapFactory.decodeResource(context.getResources(),R.drawable.sl_d_h1);
        sleepDH2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.sl_d_h2);
        sleepD1 = BitmapFactory.decodeResource(context.getResources(),R.drawable.sl_d1);
        sleepD2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.sl_d2);
        sleepH1 = BitmapFactory.decodeResource(context.getResources(),R.drawable.sl_h1);
        sleepH2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.sl_h2);
        sleepSmile1 = BitmapFactory.decodeResource(context.getResources(),R.drawable.sl_hp1);
        sleepSmile2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.sl_hp2);
        sleepSH1 = BitmapFactory.decodeResource(context.getResources(),R.drawable.sl_s_h1);
        sleepSH2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.sl_s_h2);
        sleepS1 = BitmapFactory.decodeResource(context.getResources(),R.drawable.sl_s1);
        sleepS2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.sl_s2);
        eatBitmapD[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_1);
        eatBitmapD[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_2);
        eatBitmapD[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_3);
        eatBitmapD[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_4);
        eatBitmapD[5] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_5);
        eatBitmapD[6] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_6);
        eatBitmapD[7] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_7);
        eatBitmapD[8] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_8);
        eatBitmapD[9] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_9);
        eatBitmapD[10] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_10);
        eatBitmapDS[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_s_1);
        eatBitmapDS[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_s_2);
        eatBitmapDS[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_s_3);
        eatBitmapDS[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_s_4);
        eatBitmapDS[5] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_s_5);
        eatBitmapDS[6] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_s_6);
        eatBitmapDS[7] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_s_7);
        eatBitmapDS[8] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_s_8);
        eatBitmapDS[9] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_s_9);
        eatBitmapDS[10] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_s_10);
        eatBitmapDT[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_t_1);
        eatBitmapDT[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_t_2);
        eatBitmapDT[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_t_3);
        eatBitmapDT[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_t_4);
        eatBitmapDT[5] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_t_5);
        eatBitmapDT[6] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_t_6);
        eatBitmapDT[7] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_t_7);
        eatBitmapDT[8] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_t_8);
        eatBitmapDT[9] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_t_9);
        eatBitmapDT[10] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_t_10);
        eatBitmapDTS[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_t_s_1);
        eatBitmapDTS[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_t_s_2);
        eatBitmapDTS[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_t_s_3);
        eatBitmapDTS[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_t_s_4);
        eatBitmapDTS[5] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_t_s_5);
        eatBitmapDTS[6] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_t_s_6);
        eatBitmapDTS[7] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_t_s_7);
        eatBitmapDTS[8] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_t_s_8);
        eatBitmapDTS[9] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_t_s_9);
        eatBitmapDTS[10] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_d_t_s_10);
        eatBitmapS[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_s_1);
        eatBitmapS[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_s_2);
        eatBitmapS[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_s_3);
        eatBitmapS[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_s_4);
        eatBitmapS[5] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_s_5);
        eatBitmapS[6] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_s_6);
        eatBitmapS[7] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_s_7);
        eatBitmapS[8] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_s_8);
        eatBitmapS[9] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_s_9);
        eatBitmapS[10] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_s_10);
        eatBitmapT[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_t_1);
        eatBitmapT[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_t_2);
        eatBitmapT[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_t_3);
        eatBitmapT[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_t_4);
        eatBitmapT[5] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_t_5);
        eatBitmapT[6] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_t_6);
        eatBitmapT[7] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_t_7);
        eatBitmapT[8] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_t_8);
        eatBitmapT[9] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_t_9);
        eatBitmapT[10] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_t_10);
        eatBitmapTS[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_t_s_1);
        eatBitmapTS[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_t_s_2);
        eatBitmapTS[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_t_s_3);
        eatBitmapTS[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_t_s_4);
        eatBitmapTS[5] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_t_s_5);
        eatBitmapTS[6] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_t_s_6);
        eatBitmapTS[7] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_t_s_7);
        eatBitmapTS[8] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_t_s_8);
        eatBitmapTS[9] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_t_s_9);
        eatBitmapTS[10] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_t_s_10);
        eatBitmapSmile[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_hp_1);
        eatBitmapSmile[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_hp_2);
        eatBitmapSmile[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_hp_3);
        eatBitmapSmile[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_hp_4);
        eatBitmapSmile[5] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_hp_5);
        eatBitmapSmile[6] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_hp_6);
        eatBitmapSmile[7] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_hp_7);
        eatBitmapSmile[8] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_hp_8);
        eatBitmapSmile[9] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_hp_9);
        eatBitmapSmile[10] = BitmapFactory.decodeResource(context.getResources(),R.drawable.e_hp_10);
        eatDarkButtonBitmap[0] = BitmapFactory.decodeResource(context.getResources(), R.drawable.chervyak);
        eatDarkButtonBitmap[1] = BitmapFactory.decodeResource(context.getResources(), R.drawable.mc1);
        eatDarkButtonBitmap[2] = BitmapFactory.decodeResource(context.getResources(), R.drawable.mc2);
        eatDarkButtonBitmap[3] = BitmapFactory.decodeResource(context.getResources(), R.drawable.mc3);
        eatDarkButtonBitmap[4] = BitmapFactory.decodeResource(context.getResources(), R.drawable.mc4);
        eatDarkButtonBitmap[5] = BitmapFactory.decodeResource(context.getResources(), R.drawable.mc5);
        eatDarkButtonBitmap[6] = BitmapFactory.decodeResource(context.getResources(), R.drawable.mc6);
        eatDarkButtonBitmap[7] = BitmapFactory.decodeResource(context.getResources(), R.drawable.mc7);
        eatDarkButtonBitmap[8] = BitmapFactory.decodeResource(context.getResources(), R.drawable.mc8);
        eatDarkButtonBitmap[9] = BitmapFactory.decodeResource(context.getResources(), R.drawable.mc9);
        eatDarkButtonBitmap[10] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mc10);
        playDarkButtonBitmap[0] = BitmapFactory.decodeResource(context.getResources(),R.drawable.petur);
        playDarkButtonBitmap[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mp1);
        playDarkButtonBitmap[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mp2);
        playDarkButtonBitmap[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mp3);
        playDarkButtonBitmap[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mp4);
        playDarkButtonBitmap[5] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mp5);
        playDarkButtonBitmap[6] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mp6);
        playDarkButtonBitmap[7] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mp7);
        playDarkButtonBitmap[8] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mp8);
        playDarkButtonBitmap[9] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mp9);
        playDarkButtonBitmap[10] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mp10);
        playDarkButtonBitmap[11] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mp11);
        playDarkButtonBitmap[12] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mp12);
        playDarkButtonBitmap[13] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mp13);
        playDarkButtonBitmap[14] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mp14);
        playDarkButtonBitmap[15] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mp15);
        sleepDarkButtonBitmap[0] = BitmapFactory.decodeResource(context.getResources(), R.drawable.qnel);
        sleepDarkButtonBitmap[1] = BitmapFactory.decodeResource(context.getResources(), R.drawable.mq1);
        sleepDarkButtonBitmap[2] = BitmapFactory.decodeResource(context.getResources(), R.drawable.mq2);
        sleepDarkButtonBitmap[3] = BitmapFactory.decodeResource(context.getResources(), R.drawable.mq3);
        sleepDarkButtonBitmap[4] = BitmapFactory.decodeResource(context.getResources(), R.drawable.mq4);
        sleepDarkButtonBitmap[5] = BitmapFactory.decodeResource(context.getResources(), R.drawable.mq5);
        sleepDarkButtonBitmap[6] = BitmapFactory.decodeResource(context.getResources(), R.drawable.mq6);
        sleepDarkButtonBitmap[7] = BitmapFactory.decodeResource(context.getResources(), R.drawable.mq7);
        sleepDarkButtonBitmap[8] = BitmapFactory.decodeResource(context.getResources(), R.drawable.mq8);
        sleepDarkButtonBitmap[9] = BitmapFactory.decodeResource(context.getResources(), R.drawable.mq9);
        sleepDarkButtonBitmap[10] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq10);
        sleepDarkButtonBitmap[11] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq11);
        sleepDarkButtonBitmap[12] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq12);
        sleepDarkButtonBitmap[13] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq13);
        sleepDarkButtonBitmap[14] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq14);
        sleepDarkButtonBitmap[15] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq15);
        sleepDarkButtonBitmap[16] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq16);
        sleepDarkButtonBitmap[17] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq17);
        sleepDarkButtonBitmap[18] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq18);
        sleepDarkButtonBitmap[19] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq19);
        sleepDarkButtonBitmap[20] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq20);
        sleepDarkButtonBitmap[21] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq21);
        sleepDarkButtonBitmap[22] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq22);
        sleepDarkButtonBitmap[23] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq23);
        sleepDarkButtonBitmap[24] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq24);
        sleepDarkButtonBitmap[25] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq25);
        sleepDarkButtonBitmap[26] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq26);
        sleepDarkButtonBitmap[27] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq27);
        sleepDarkButtonBitmap[28] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq28);
        sleepDarkButtonBitmap[29] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq29);
        sleepDarkButtonBitmap[30] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq30);
        sleepDarkButtonBitmap[31] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq31);
        sleepDarkButtonBitmap[32] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq32);
        sleepDarkButtonBitmap[33] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq33);
        sleepDarkButtonBitmap[34] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq34);
        sleepDarkButtonBitmap[35] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq35);
        sleepDarkButtonBitmap[36] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq36);
        sleepDarkButtonBitmap[37] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq37);
        sleepDarkButtonBitmap[38] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq38);
        sleepDarkButtonBitmap[39] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq39);
        sleepDarkButtonBitmap[40] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq40);
        sleepDarkButtonBitmap[41] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq41);
        sleepDarkButtonBitmap[42] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq42);
        sleepDarkButtonBitmap[43] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq43);
        sleepDarkButtonBitmap[44] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq44);
        sleepDarkButtonBitmap[45] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq45);
        sleepDarkButtonBitmap[46] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq46);
        sleepDarkButtonBitmap[47] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq47);
        sleepDarkButtonBitmap[48] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq48);
        sleepDarkButtonBitmap[49] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq49);
        sleepDarkButtonBitmap[50] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq50);
        sleepDarkButtonBitmap[51] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq51);
        sleepDarkButtonBitmap[52] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq52);
        sleepDarkButtonBitmap[53] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq53);
        sleepDarkButtonBitmap[54] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq54);
        sleepDarkButtonBitmap[55] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq55);
        sleepDarkButtonBitmap[56] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq56);
        sleepDarkButtonBitmap[57] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq57);
        sleepDarkButtonBitmap[58] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq58);
        sleepDarkButtonBitmap[59] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq59);
        sleepDarkButtonBitmap[60] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mq60);
        poopBitmap[1] = BitmapFactory.decodeResource(context.getResources(), R.drawable.qaq1);
        poopBitmap[2] = BitmapFactory.decodeResource(context.getResources(), R.drawable.qaq2);
        poopBitmap[3] = BitmapFactory.decodeResource(context.getResources(), R.drawable.qaq3);
        poopBitmap[4] = BitmapFactory.decodeResource(context.getResources(), R.drawable.qaq4);
        poopingBitmapUsual[1] = BitmapFactory.decodeResource(context.getResources(), R.drawable.qaqox1);
        poopingBitmapUsual[2] = BitmapFactory.decodeResource(context.getResources(), R.drawable.qaqox2);
        poopingBitmapUsual[3] = BitmapFactory.decodeResource(context.getResources(), R.drawable.qaqox3);
        poopingBitmapUsual[4] = BitmapFactory.decodeResource(context.getResources(), R.drawable.qaqox4);
        poopingBitmapUsual[5] = BitmapFactory.decodeResource(context.getResources(), R.drawable.qaqox5);
        poopingBitmapUsual[6] = BitmapFactory.decodeResource(context.getResources(), R.drawable.qaqox6);
        poopingBitmapUsual[7] = BitmapFactory.decodeResource(context.getResources(), R.drawable.qaqox7);
        poopingBitmapUsual[8] = BitmapFactory.decodeResource(context.getResources(), R.drawable.qaqox8);
        poopingBitmapUsual[9] = BitmapFactory.decodeResource(context.getResources(), R.drawable.qaqox9);
        poopingBitmapUsual[10] = BitmapFactory.decodeResource(context.getResources(), R.drawable.qaqox10);
        poopingBitmapDH[1] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_h1);
        poopingBitmapDH[2] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_h2);
        poopingBitmapDH[3] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_h3);
        poopingBitmapDH[4] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_h4);
        poopingBitmapDH[5] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_h5);
        poopingBitmapDH[6] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_h6);
        poopingBitmapDH[7] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_h7);
        poopingBitmapDH[8] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_h8);
        poopingBitmapDH[9] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_h9);
        poopingBitmapDH[10] =BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_h10);
        poopingBitmapDSH[1] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_s_h1);
        poopingBitmapDSH[2] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_s_h2);
        poopingBitmapDSH[3] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_s_h3);
        poopingBitmapDSH[4] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_s_h4);
        poopingBitmapDSH[5] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_s_h5);
        poopingBitmapDSH[6] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_s_h6);
        poopingBitmapDSH[7] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_s_h7);
        poopingBitmapDSH[8] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_s_h8);
        poopingBitmapDSH[9] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_s_h9);
        poopingBitmapDSH[10] =BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_s_h10);
        poopingBitmapDS[1] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_s1);
        poopingBitmapDS[2] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_s2);
        poopingBitmapDS[3] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_s3);
        poopingBitmapDS[4] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_s4);
        poopingBitmapDS[5] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_s5);
        poopingBitmapDS[6] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_s6);
        poopingBitmapDS[7] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_s7);
        poopingBitmapDS[8] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_s8);
        poopingBitmapDS[9] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_s9);
        poopingBitmapDS[10] =BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_s10);
        poopingBitmapDTH[1] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_t_h1);
        poopingBitmapDTH[2] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_t_h2);
        poopingBitmapDTH[3] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_t_h3);
        poopingBitmapDTH[4] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_t_h4);
        poopingBitmapDTH[5] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_t_h5);
        poopingBitmapDTH[6] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_t_h6);
        poopingBitmapDTH[7] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_t_h7);
        poopingBitmapDTH[8] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_t_h8);
        poopingBitmapDTH[9] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_t_h9);
        poopingBitmapDTH[10] =BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_t_h10);
        poopingBitmapDTSH[1] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_t_s_h1);
        poopingBitmapDTSH[2] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_t_s_h2);
        poopingBitmapDTSH[3] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_t_s_h3);
        poopingBitmapDTSH[4] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_t_s_h4);
        poopingBitmapDTSH[5] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_t_s_h5);
        poopingBitmapDTSH[6] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_t_s_h6);
        poopingBitmapDTSH[7] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_t_s_h7);
        poopingBitmapDTSH[8] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_t_s_h8);
        poopingBitmapDTSH[9] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_t_s_h9);
        poopingBitmapDTSH[10] =BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_t_s_h10);
        poopingBitmapDTS[1] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_t_s1);
        poopingBitmapDTS[2] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_t_s2);
        poopingBitmapDTS[3] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_t_s3);
        poopingBitmapDTS[4] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_t_s4);
        poopingBitmapDTS[5] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_t_s5);
        poopingBitmapDTS[6] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_t_s6);
        poopingBitmapDTS[7] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_t_s7);
        poopingBitmapDTS[8] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_t_s8);
        poopingBitmapDTS[9] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_t_s9);
        poopingBitmapDTS[10] =BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_t_s10);
        poopingBitmapDT[1] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_t1);
        poopingBitmapDT[2] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_t2);
        poopingBitmapDT[3] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_t3);
        poopingBitmapDT[4] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_t4);
        poopingBitmapDT[5] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_t5);
        poopingBitmapDT[6] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_t6);
        poopingBitmapDT[7] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_t7);
        poopingBitmapDT[8] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_t8);
        poopingBitmapDT[9] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_t9);
        poopingBitmapDT[10] =BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d_t10);
        poopingBitmapD[1] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d1);
        poopingBitmapD[2] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d2);
        poopingBitmapD[3] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d3);
        poopingBitmapD[4] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d4);
        poopingBitmapD[5] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d5);
        poopingBitmapD[6] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d6);
        poopingBitmapD[7] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d7);
        poopingBitmapD[8] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d8);
        poopingBitmapD[9] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d9);
        poopingBitmapD[10] =BitmapFactory.decodeResource(context.getResources(), R.drawable.p_d10);
        poopingBitmapHS[1] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_h_s1);
        poopingBitmapHS[2] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_h_s2);
        poopingBitmapHS[3] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_h_s3);
        poopingBitmapHS[4] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_h_s4);
        poopingBitmapHS[5] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_h_s5);
        poopingBitmapHS[6] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_h_s6);
        poopingBitmapHS[7] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_h_s7);
        poopingBitmapHS[8] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_h_s8);
        poopingBitmapHS[9] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_h_s9);
        poopingBitmapHS[10] =BitmapFactory.decodeResource(context.getResources(), R.drawable.p_h_s10);
        poopingBitmapH[1] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_h1);
        poopingBitmapH[2] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_h2);
        poopingBitmapH[3] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_h3);
        poopingBitmapH[4] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_h4);
        poopingBitmapH[5] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_h5);
        poopingBitmapH[6] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_h6);
        poopingBitmapH[7] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_h7);
        poopingBitmapH[8] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_h8);
        poopingBitmapH[9] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_h9);
        poopingBitmapH[10] =BitmapFactory.decodeResource(context.getResources(), R.drawable.p_h10);
        poopingBitmapS[1] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_s1);
        poopingBitmapS[2] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_s2);
        poopingBitmapS[3] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_s3);
        poopingBitmapS[4] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_s4);
        poopingBitmapS[5] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_s5);
        poopingBitmapS[6] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_s6);
        poopingBitmapS[7] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_s7);
        poopingBitmapS[8] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_s8);
        poopingBitmapS[9] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_s9);
        poopingBitmapS[10] =BitmapFactory.decodeResource(context.getResources(), R.drawable.p_s10);
        poopingBitmapTH[1] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_t_h1);
        poopingBitmapTH[2] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_t_h2);
        poopingBitmapTH[3] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_t_h3);
        poopingBitmapTH[4] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_t_h4);
        poopingBitmapTH[5] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_t_h5);
        poopingBitmapTH[6] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_t_h6);
        poopingBitmapTH[7] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_t_h7);
        poopingBitmapTH[8] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_t_h8);
        poopingBitmapTH[9] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_t_h9);
        poopingBitmapTH[10] =BitmapFactory.decodeResource(context.getResources(), R.drawable.p_t_h10);
        poopingBitmapTHS[1] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_t_s_h1);
        poopingBitmapTHS[2] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_t_s_h2);
        poopingBitmapTHS[3] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_t_s_h3);
        poopingBitmapTHS[4] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_t_s_h4);
        poopingBitmapTHS[5] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_t_s_h5);
        poopingBitmapTHS[6] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_t_s_h6);
        poopingBitmapTHS[7] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_t_s_h7);
        poopingBitmapTHS[8] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_t_s_h8);
        poopingBitmapTHS[9] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_t_s_h9);
        poopingBitmapTHS[10] =BitmapFactory.decodeResource(context.getResources(), R.drawable.p_t_s_h10);
        poopingBitmapTS[1] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_t_s1);
        poopingBitmapTS[2] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_t_s2);
        poopingBitmapTS[3] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_t_s3);
        poopingBitmapTS[4] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_t_s4);
        poopingBitmapTS[5] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_t_s5);
        poopingBitmapTS[6] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_t_s6);
        poopingBitmapTS[7] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_t_s7);
        poopingBitmapTS[8] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_t_s8);
        poopingBitmapTS[9] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_t_s9);
        poopingBitmapTS[10] =BitmapFactory.decodeResource(context.getResources(), R.drawable.p_t_s10);
        poopingBitmapT[1] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_h1);
        poopingBitmapT[2] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_t2);
        poopingBitmapT[3] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_t3);
        poopingBitmapT[4] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_t4);
        poopingBitmapT[5] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_t5);
        poopingBitmapT[6] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_t6);
        poopingBitmapT[7] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_t7);
        poopingBitmapT[8] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_t8);
        poopingBitmapT[9] = BitmapFactory.decodeResource(context.getResources(), R.drawable.p_t9);
        poopingBitmapT[10] =BitmapFactory.decodeResource(context.getResources(), R.drawable.p_t10);
        washButtonBitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.lvacvelu_knopka);
        washButtonBitmap2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.lvacvelu_knopka);
        washButtonBitmapA = BitmapFactory.decodeResource(context.getResources(),R.drawable.lvacvelu_knopkaa);
        washDarkButtonBitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.lvacvelu_knopka_mug);
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
        playButtonBitmap =  BitmapFactory.decodeResource(context.getResources(), R.drawable.petur);
        sleepButtonBitmap =  BitmapFactory.decodeResource(context.getResources(), R.drawable.qnel);
        eatButtonBitmapA =  BitmapFactory.decodeResource(context.getResources(), R.drawable.utelu_knopkaa);
        playButtonBitmapA =  BitmapFactory.decodeResource(context.getResources(), R.drawable.xaxalu_knopkaa);
        sleepButtonBitmapA =  BitmapFactory.decodeResource(context.getResources(), R.drawable.qnelu_knopkaa);
        highScoreBitmap =  BitmapFactory.decodeResource(context.getResources(),R.drawable.highscore);
        scoreBitmap =  BitmapFactory.decodeResource(context.getResources(),R.drawable.score);
        screenshotBitmap =  BitmapFactory.decodeResource(context.getResources(),R.drawable.screenshot);
        bitmap = bitmapSmile1;
        life = ResourcesCompat.getColor(context.getResources(),R.color.life,null);
        dirt = ResourcesCompat.getColor(context.getResources(),R.color.dirt,null);
        hungry = ResourcesCompat.getColor(context.getResources(),R.color.hungry,null);
        tired = ResourcesCompat.getColor(context.getResources(),R.color.sleep,null);
        happy = ResourcesCompat.getColor(context.getResources(),R.color.happy,null);
    }
    public void takeScreenshot() {
        Date now = new Date();
        android.text.format.DateFormat.format("yyyy-MM-dd_hh:mm:ss", now);
        try {
            String mPath = Environment.getExternalStorageDirectory().toString() + "/" + now + ".jpg";
            View v1 = ((Activity)context).getWindow().getDecorView().getRootView();
            v1.setDrawingCacheEnabled(true);
            Bitmap bitmap = Bitmap.createBitmap(v1.getDrawingCache());
            v1.setDrawingCacheEnabled(false);
            File imageFile = new File(mPath);
            FileOutputStream outputStream = new FileOutputStream(imageFile);
            int quality = 100;
            bitmap.compress(Bitmap.CompressFormat.JPEG, quality, outputStream);
            outputStream.flush();
            outputStream.close();
            screen(imageFile);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
    public void screen(File file){
        if(ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
            saveImage();
        }
        else {
            ActivityCompat.requestPermissions((Activity)context,new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
            },REQUEST_CODE);
        }
        // Uri uri = Uri.fromFile(file);
        // Intent sendIntent = new Intent();
        // sendIntent.setAction(Intent.ACTION_SEND);
        // sendIntent.putExtra(Intent.EXTRA_STREAM, uri);
        // sendIntent.setType("image/jpg");
        // context.startActivity(Intent.createChooser(sendIntent," "));
    }

    private void saveImage() {

    }

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
                    int ButtonWidth = canvas.getWidth()*106/1050;
                    int ButtonHeight = canvas.getHeight()*101/540;
                    paintBlack.setColor(Color.BLACK);
                    paintBlack.setStyle(Paint.Style.STROKE);
                    paintBlack.setStrokeWidth((float) canvas.getWidth() / 540);
                    // background
                    bitmapbg = Bitmap.createScaledBitmap(bitmapbg, canvas.getWidth(), canvas.getHeight(), true);
                    bitmapDarkbg = Bitmap.createScaledBitmap(bitmapDarkbg, canvas.getWidth(), canvas.getHeight(), true);
                    bitmapkust = Bitmap.createScaledBitmap(bitmapkust, canvas.getWidth() * 245 / 1050, canvas.getHeight() * 180 / 540, true);
                    bitmapDarkkust = Bitmap.createScaledBitmap(bitmapDarkkust, canvas.getWidth() * 245 / 1050, canvas.getHeight() * 180 / 540, true);
                    paint.setSubpixelText(true);
                    paint.setAntiAlias(true);
                    paintLife.setSubpixelText(true);
                    paintLife.setAntiAlias(true);
                    paintBlack.setSubpixelText(true);
                    paintBlack.setAntiAlias(true);
                    //hetevi fon
                    if (!flying && !sleeping && !laying) {
                        canvas.drawBitmap(bitmapbg, 0, 0, paint);
                        canvas.drawBitmap(bitmapkust, (float) canvas.getWidth() * 29 / 1050, (float) canvas.getHeight() * 230 / 540, paint);
                    } else {
                        canvas.drawBitmap(bitmapDarkbg, 0, 0, paint);
                        canvas.drawBitmap(bitmapDarkkust, (float) canvas.getWidth() * 29 / 1050, (float) canvas.getHeight() * 230 / 540, paint);
                    }
                    //// highscore/score
                    //highScoreBitmap = Bitmap.createScaledBitmap(highScoreBitmap,canvas.getWidth()*212/1050,canvas.getHeight()*53/540,true);
                    //canvas.drawBitmap(highScoreBitmap,0,(float)canvas.getHeight()*10/540,paint);
                    //scoreBitmap = Bitmap.createScaledBitmap(scoreBitmap,canvas.getWidth()*119/1050,canvas.getHeight()*43/540,true);
                    //canvas.drawBitmap(scoreBitmap,0,(float)canvas.getHeight()*67/540,paint);
                    // kyanqy
                    float lifeLeft = (float) canvas.getWidth() * 844 / 1050;
                    float lifeTop = (float) canvas.getHeight() * 8 / 540;
                    if (m2 == 0) {
                        lifeRight = (float) canvas.getWidth() * 1040 / 1050;
                        m2 = 1;
                    }
                    float lifeRight2 = (float) canvas.getWidth() * 1040 / 1050;
                    float lifeBottom = (float) canvas.getHeight() * 42 / 540;
                    paintLife.setColor(life);
                    canvas.drawRect((float) canvas.getWidth() * 843 / 1050, (float) canvas.getHeight() * 7 / 540,
                            (float) canvas.getWidth() * 1041 / 1050, (float) canvas.getHeight() * 43 / 540, paintBlack);
                    canvas.drawRect(lifeLeft, lifeTop, lifeRight, lifeBottom, paintLife);
                    // kextotutyun
                    paintDirt.setColor(dirt);
                    float dirtLeft = (float) canvas.getWidth() * 877 / 1050;
                    float dirtTop = (float) canvas.getHeight() * 55 / 540;
                    float dirtRight2 = (float) canvas.getWidth() * 1040 / 1050;
                    float dirtWeight = dirtRight2 - dirtLeft;
                    if (m3 == 0) {
                        dirtRight = (float) canvas.getWidth() * 1040 / 1050;
                        m3 = 1;
                    }
                    float dirtBottom = (float) canvas.getHeight() * 79 / 540;
                    canvas.drawRect((float) canvas.getWidth() * 876 / 1050, (float) canvas.getHeight() * 54 / 540,
                            (float) canvas.getWidth() * 1041 / 1050, (float) canvas.getHeight() * 80 / 540, paintBlack);
                    canvas.drawRect(dirtLeft, dirtTop, dirtRight, dirtBottom, paintDirt);
                    // kexti timer
                    if (!dirtTimeIsPassed) {
                        new DirtTimerThread().start();
                        dirtTimeIsPassed = true;
                    }
                    if (dirtNeedToDrawNow) {
                        if (dirtRight - k * dirtWeight >= dirtLeft) {
                            k *= dirtWeight;
                            dirtRight -= k;
                            canvas.drawRect(dirtLeft, dirtTop, dirtRight, dirtBottom, paintDirt);
                            k /= dirtWeight;
                        }
                        if (dirtRight >= dirtLeft && dirtRight - k * dirtWeight < dirtLeft) {
                            dirtRight = dirtLeft;
                            canvas.drawRect(dirtLeft, dirtTop, dirtRight, dirtBottom, paintDirt);
                        }
                        dirtNeedToDrawNow = false;
                    }
                    // sov
                    paintHungry.setColor(hungry);
                    float hungryLeft = (float) canvas.getWidth() * 877 / 1050;
                    float hungryTop = (float) canvas.getHeight() * 92 / 540;
                    if (n == 0) {
                        hungryRight = (float) canvas.getWidth() * 1040 / 1050;
                        n = 1;
                    }
                    float hungryRight2 = (float) canvas.getWidth() * 1040 / 1050;
                    float hungryWeight = hungryRight2 - hungryLeft;
                    float hungryBottom = (float) canvas.getHeight() * 116 / 540;
                    canvas.drawRect((float) canvas.getWidth() * 876 / 1050, (float) canvas.getHeight() * 91 / 540,
                            (float) canvas.getWidth() * 1041 / 1050, (float) canvas.getHeight() * 117 / 540, paintBlack);
                    canvas.drawRect(hungryLeft, hungryTop, hungryRight, hungryBottom, paintHungry);
                    // sovi timer
                    if (!hungryTimeIsPassed) {
                        new HungryTimerThread().start();
                        hungryTimeIsPassed = true;
                    }
                    if (hungryNeedToDrawNow) {
                        if (hungryRight - h * hungryWeight >= hungryLeft) {
                            h *= hungryWeight;
                            hungryRight -= h;
                            canvas.drawRect(hungryLeft, hungryTop, hungryRight, hungryBottom, paintHungry);
                            h /= hungryWeight;
                        }
                        if (hungryRight >= hungryLeft && hungryRight - h * hungryWeight < hungryLeft) {
                            hungryRight = hungryLeft;
                            canvas.drawRect(hungryLeft, hungryTop, hungryRight, hungryBottom, paintHungry);
                        }
                        hungryNeedToDrawNow = false;
                    }
                    // qun
                    paintSleep.setColor(tired);
                    float sleepLeft = (float) canvas.getWidth() * 877 / 1050;
                    float sleepTop = (float) canvas.getHeight() * 129 / 540;
                    float sleepRight2 = (float) canvas.getWidth() * 1040 / 1050;
                    float sleepWeight = sleepRight2 - sleepLeft;
                    if (m4 == 0) {
                        sleepRight = (float) canvas.getWidth() * 1040 / 1050;
                        m4 = 1;
                    }
                    float sleepBottom = (float) canvas.getHeight() * 153 / 540;
                    canvas.drawRect((float) canvas.getWidth() * 876 / 1050, (float) canvas.getHeight() * 128 / 540,
                            (float) canvas.getWidth() * 1041 / 1050, (float) canvas.getHeight() * 154 / 540, paintBlack);
                    canvas.drawRect(sleepLeft, sleepTop, sleepRight, sleepBottom, paintSleep);
                    // qni timer
                    if (!sleepTimeIsPassed && !sleeping) {
                        new SleepTimerThread().start();
                        sleepTimeIsPassed = true;
                    }
                    if (sleepNeedToDrawNow) {
                        if (sleepRight - q * sleepWeight >= sleepLeft) {
                            q *= sleepWeight;
                            sleepRight -= q;
                            canvas.drawRect(sleepLeft, sleepTop, sleepRight, sleepBottom, paintSleep);
                            q /= sleepWeight;
                        }
                        if (sleepRight >= sleepLeft && sleepRight - q * sleepWeight < sleepLeft) {
                            sleepRight = sleepLeft;
                            canvas.drawRect(sleepLeft, sleepTop, sleepRight, sleepBottom, paintSleep);
                        }
                        sleepNeedToDrawNow = false;
                    }

                    // uraxutyun
                    paintHappy.setColor(happy);
                    float happyLeft = (float) canvas.getWidth() * 877 / 1050;
                    float happyTop = (float) canvas.getHeight() * 166 / 540;
                    if (m1 == 0) {
                        happyRight = (float) canvas.getWidth() * 1040 / 1050;
                        m1 = 1;
                    }
                    float happyRight2 = (float) canvas.getWidth() * 1040 / 1050;
                    float happyWeight = happyRight2 - happyLeft;
                    float happyBottom = (float) canvas.getHeight() * 190 / 540;
                    canvas.drawRect((float) canvas.getWidth() * 876 / 1050, (float) canvas.getHeight() * 165 / 540,
                            (float) canvas.getWidth() * 1041 / 1050, (float) canvas.getHeight() * 191 / 540, paintBlack);
                    canvas.drawRect(happyLeft, happyTop, happyRight, happyBottom, paintHappy);
                    // uraxutyan timer
                    if (!happyTimeIsPassed) {
                        new HappyTimerThread().start();
                        happyTimeIsPassed = true;
                    }
                    if (happyNeedToDrawNow) {
                        if (happyRight - s * happyWeight >= happyLeft) {
                            s *= happyWeight;
                            happyRight -= s;
                            canvas.drawRect(happyLeft, happyTop, happyRight, happyBottom, paintHappy);
                            s /= happyWeight;
                        }
                        if (happyRight >= happyLeft && happyRight - s * happyWeight < happyLeft) {
                            happyRight = happyLeft;
                            canvas.drawRect(happyLeft, happyTop, happyRight, happyBottom, paintHappy);
                        }
                        happyNeedToDrawNow = false;
                    }
                    // srtik
                    bitmapHeart = Bitmap.createScaledBitmap(bitmapHeart, canvas.getWidth() * 49 / 1050, canvas.getHeight() * 46 / 540, true);
                    canvas.drawBitmap(bitmapHeart, (float) canvas.getWidth() * 816 / 1050, 0, paint);
                    // kext
                    bitmapDirt = Bitmap.createScaledBitmap(bitmapDirt, canvas.getWidth() * 60 / 1050, canvas.getHeight() * 51 / 540, true);
                    canvas.drawBitmap(bitmapDirt, (float) canvas.getWidth() * 840 / 1050, (float) canvas.getHeight() * 41 / 540, paint);
                    // tarelka
                    bitmapHungry = Bitmap.createScaledBitmap(bitmapHungry, canvas.getWidth() * 46 / 1050, canvas.getHeight() * 33 / 540, true);
                    canvas.drawBitmap(bitmapHungry, (float) canvas.getWidth() * 850 / 1050, (float) canvas.getHeight() * 87 / 540, paint);
                    // Zzz
                    bitmapSleep = Bitmap.createScaledBitmap(bitmapSleep, canvas.getWidth() * 52 / 1050, canvas.getHeight() * 57 / 540, true);
                    canvas.drawBitmap(bitmapSleep, (float) canvas.getWidth() * 853 / 1050, (float) canvas.getHeight() * 110 / 540, paint);
                    // Smilik
                    bitmapHappy = Bitmap.createScaledBitmap(bitmapHappy, canvas.getWidth() * 34 / 1050, canvas.getHeight() * 35 / 540, true);
                    canvas.drawBitmap(bitmapHappy, (float) canvas.getWidth() * 862 / 1050, (float) canvas.getHeight() * 161 / 540, paint);
                    // cter
                    bitmapUsual1 = Bitmap.createScaledBitmap(bitmapUsual1, (int) (birdWidth * canvas.getWidth()), (int) (canvas.getHeight() * birdHeight), true);
                    bitmapUsual2 = Bitmap.createScaledBitmap(bitmapUsual2, (int) (birdWidth * canvas.getWidth()), (int) (canvas.getHeight() * birdHeight), true);
                    bitmapDTSH1 = Bitmap.createScaledBitmap(bitmapDTSH1, (int) (birdWidth * canvas.getWidth()), (int) (canvas.getHeight() * birdHeight), true);
                    bitmapDTSH2 = Bitmap.createScaledBitmap(bitmapDTSH2, (int) (birdWidth * canvas.getWidth()), (int) (canvas.getHeight() * birdHeight), true);
                    bitmapDTS1 = Bitmap.createScaledBitmap(bitmapDTS1, (int) (birdWidth * canvas.getWidth()), (int) (canvas.getHeight() * birdHeight), true);
                    bitmapDTS2 = Bitmap.createScaledBitmap(bitmapDTS2, (int) (birdWidth * canvas.getWidth()), (int) (canvas.getHeight() * birdHeight), true);
                    bitmapDTH1 = Bitmap.createScaledBitmap(bitmapDTH1, (int) (birdWidth * canvas.getWidth()), (int) (canvas.getHeight() * birdHeight), true);
                    bitmapDTH2 = Bitmap.createScaledBitmap(bitmapDTH2, (int) (birdWidth * canvas.getWidth()), (int) (canvas.getHeight() * birdHeight), true);
                    bitmapDSH1 = Bitmap.createScaledBitmap(bitmapDSH1, (int) (birdWidth * canvas.getWidth()), (int) (canvas.getHeight() * birdHeight), true);
                    bitmapDSH2 = Bitmap.createScaledBitmap(bitmapDSH2, (int) (birdWidth * canvas.getWidth()), (int) (canvas.getHeight() * birdHeight), true);
                    bitmapTSH1 = Bitmap.createScaledBitmap(bitmapTSH1, (int) (birdWidth * canvas.getWidth()), (int) (canvas.getHeight() * birdHeight), true);
                    bitmapTSH2 = Bitmap.createScaledBitmap(bitmapTSH2, (int) (birdWidth * canvas.getWidth()), (int) (canvas.getHeight() * birdHeight), true);
                    bitmapDH1 = Bitmap.createScaledBitmap(bitmapDH1, (int) (birdWidth * canvas.getWidth()), (int) (canvas.getHeight() * birdHeight), true);
                    bitmapDH2 = Bitmap.createScaledBitmap(bitmapDH2, (int) (birdWidth * canvas.getWidth()), (int) (canvas.getHeight() * birdHeight), true);
                    bitmapDS1 = Bitmap.createScaledBitmap(bitmapDS1, (int) (birdWidth * canvas.getWidth()), (int) (canvas.getHeight() * birdHeight), true);
                    bitmapDS2 = Bitmap.createScaledBitmap(bitmapDS2, (int) (birdWidth * canvas.getWidth()), (int) (canvas.getHeight() * birdHeight), true);
                    bitmapDT1 = Bitmap.createScaledBitmap(bitmapDT1, (int) (birdWidth * canvas.getWidth()), (int) (canvas.getHeight() * birdHeight), true);
                    bitmapDT2 = Bitmap.createScaledBitmap(bitmapDT2, (int) (birdWidth * canvas.getWidth()), (int) (canvas.getHeight() * birdHeight), true);
                    bitmapSH1 = Bitmap.createScaledBitmap(bitmapSH1, (int) (birdWidth * canvas.getWidth()), (int) (canvas.getHeight() * birdHeight), true);
                    bitmapSH2 = Bitmap.createScaledBitmap(bitmapSH2, (int) (birdWidth * canvas.getWidth()), (int) (canvas.getHeight() * birdHeight), true);
                    bitmapTH1 = Bitmap.createScaledBitmap(bitmapTH1, (int) (birdWidth * canvas.getWidth()), (int) (canvas.getHeight() * birdHeight), true);
                    bitmapTH2 = Bitmap.createScaledBitmap(bitmapTH2, (int) (birdWidth * canvas.getWidth()), (int) (canvas.getHeight() * birdHeight), true);
                    bitmapTS1 = Bitmap.createScaledBitmap(bitmapTS1, (int) (birdWidth * canvas.getWidth()), (int) (canvas.getHeight() * birdHeight), true);
                    bitmapTS2 = Bitmap.createScaledBitmap(bitmapTS2, (int) (birdWidth * canvas.getWidth()), (int) (canvas.getHeight() * birdHeight), true);
                    bitmapD1 = Bitmap.createScaledBitmap(bitmapD1, (int) (birdWidth * canvas.getWidth()), (int) (canvas.getHeight() * birdHeight), true);
                    bitmapD2 = Bitmap.createScaledBitmap(bitmapD2, (int) (birdWidth * canvas.getWidth()), (int) (canvas.getHeight() * birdHeight), true);
                    bitmapT1 = Bitmap.createScaledBitmap(bitmapT1, (int) (birdWidth * canvas.getWidth()), (int) (canvas.getHeight() * birdHeight), true);
                    bitmapT2 = Bitmap.createScaledBitmap(bitmapT2, (int) (birdWidth * canvas.getWidth()), (int) (canvas.getHeight() * birdHeight), true);
                    bitmapS1 = Bitmap.createScaledBitmap(bitmapS1, (int) (birdWidth * canvas.getWidth()), (int) (canvas.getHeight() * birdHeight), true);
                    bitmapS2 = Bitmap.createScaledBitmap(bitmapS2, (int) (birdWidth * canvas.getWidth()), (int) (canvas.getHeight() * birdHeight), true);
                    bitmapH1 = Bitmap.createScaledBitmap(bitmapH1, (int) (birdWidth * canvas.getWidth()), (int) (canvas.getHeight() * birdHeight), true);
                    bitmapH2 = Bitmap.createScaledBitmap(bitmapH2, (int) (birdWidth * canvas.getWidth()), (int) (canvas.getHeight() * birdHeight), true);
                    bitmapSmile1 = Bitmap.createScaledBitmap(bitmapSmile1, (int) (birdWidth * canvas.getWidth()), (int) (canvas.getHeight() * birdHeight), true);
                    bitmapSmile2 = Bitmap.createScaledBitmap(bitmapSmile2, (int) (birdWidth * canvas.getWidth()), (int) (canvas.getHeight() * birdHeight), true);
                    if (hungryRight - hungryLeft < hungryWeight / 2. && dirtRight - dirtLeft < dirtWeight / 2. && happyRight - happyLeft < happyWeight / 3. && sleepRight - sleepLeft < sleepWeight / 2.) {
                        bitmap1 = bitmapDTSH1;
                        bitmap2 = bitmapDTSH2;
                    } else if (dirtRight - dirtLeft < dirtWeight / 2. && happyRight - happyLeft < happyWeight / 3. && sleepRight - sleepLeft < sleepWeight / 2.) {
                        bitmap1 = bitmapDTS1;
                        bitmap2 = bitmapDTS2;
                    } else if (hungryRight - hungryLeft < hungryWeight / 2. && happyRight - happyLeft < happyWeight / 3. && sleepRight - sleepLeft < sleepWeight / 2.) {
                        bitmap1 = bitmapTSH1;
                        bitmap2 = bitmapTSH2;
                    } else if (hungryRight - hungryLeft < hungryWeight / 2. && dirtRight - dirtLeft < dirtWeight / 2. && sleepRight - sleepLeft < sleepWeight / 2.) {
                        bitmap1 = bitmapDTH1;
                        bitmap2 = bitmapDTH2;
                    } else if (hungryRight - hungryLeft < hungryWeight / 2. && dirtRight - dirtLeft < dirtWeight / 2. && happyRight - happyLeft < happyWeight / 3.) {
                        bitmap1 = bitmapDSH1;
                        bitmap2 = bitmapDSH2;
                    } else if (hungryRight - hungryLeft < hungryWeight / 2. && dirtRight - dirtLeft < dirtWeight / 2.) {
                        bitmap1 = bitmapDH1;
                        bitmap2 = bitmapDH2;
                    } else if (dirtRight - dirtLeft < dirtWeight / 2. && happyRight - happyLeft < happyWeight / 3.) {
                        bitmap1 = bitmapDS1;
                        bitmap2 = bitmapDS2;
                    } else if (dirtRight - dirtLeft < dirtWeight / 2. && sleepRight - sleepLeft < sleepWeight / 2.) {
                        bitmap1 = bitmapDT1;
                        bitmap2 = bitmapDT2;
                    } else if (hungryRight - hungryLeft < hungryWeight / 2. && happyRight - happyLeft < happyWeight / 3.) {
                        bitmap1 = bitmapSH1;
                        bitmap2 = bitmapSH2;
                    } else if (sleepRight - sleepLeft < sleepWeight / 2. && hungryRight - hungryLeft < hungryWeight / 2.) {
                        bitmap1 = bitmapTH1;
                        bitmap2 = bitmapTH2;
                    } else if (sleepRight - sleepLeft < sleepWeight / 2. && happyRight - happyLeft < happyWeight / 3.) {
                        bitmap1 = bitmapTS1;
                        bitmap2 = bitmapTS2;
                    } else if (dirtRight - dirtLeft < dirtWeight / 2.) {
                        bitmap1 = bitmapD1;
                        bitmap2 = bitmapD2;
                    } else if (sleepRight - sleepLeft < sleepWeight / 2.) {
                        bitmap1 = bitmapT1;
                        bitmap2 = bitmapT2;
                    } else if (happyRight - happyLeft < happyWeight / 3.) {
                        bitmap1 = bitmapS1;
                        bitmap2 = bitmapS2;
                    } else if (hungryRight - hungryLeft < hungryWeight / 2.) {
                        bitmap1 = bitmapH1;
                        bitmap2 = bitmapH2;
                    } else if (happyRight - happyLeft < (2.) * happyWeight / 3.) {
                        bitmap1 = bitmapUsual1;
                        bitmap2 = bitmapUsual2;
                    } else {
                        bitmap1 = bitmapSmile1;
                        bitmap2 = bitmapSmile2;
                    }
                    if (m == 0) {
                        bitmap = bitmap1;
                        m = 1;
                    }
                    //utox cit
                    for (int i = 1; i < 11; i++) {
                        eatBitmap[i] = Bitmap.createScaledBitmap(eatBitmap[i], (int) (canvas.getWidth() * birdWidth), (int) (canvas.getHeight() * birdHeight), true);
                    }
                    for (int i = 1; i < 11; i++) {
                        eatBitmapSmile[i] = Bitmap.createScaledBitmap(eatBitmapSmile[i], (int) (canvas.getWidth() * birdWidth), (int) (canvas.getHeight() * birdHeight), true);
                    }
                    for (int i = 1; i < 11; i++) {
                        eatBitmapD[i] = Bitmap.createScaledBitmap(eatBitmapD[i], (int) (canvas.getWidth() * birdWidth), (int) (canvas.getHeight() * birdHeight), true);
                    }
                    for (int i = 1; i < 11; i++) {
                        eatBitmapDS[i] = Bitmap.createScaledBitmap(eatBitmapDS[i], (int) (canvas.getWidth() * birdWidth), (int) (canvas.getHeight() * birdHeight), true);
                    }
                    for (int i = 1; i < 11; i++) {
                        eatBitmapDT[i] = Bitmap.createScaledBitmap(eatBitmapDT[i], (int) (canvas.getWidth() * birdWidth), (int) (canvas.getHeight() * birdHeight), true);
                    }
                    for (int i = 1; i < 11; i++) {
                        eatBitmapDTS[i] = Bitmap.createScaledBitmap(eatBitmapDTS[i], (int) (canvas.getWidth() * birdWidth), (int) (canvas.getHeight() * birdHeight), true);
                    }
                    for (int i = 1; i < 11; i++) {
                        eatBitmapS[i] = Bitmap.createScaledBitmap(eatBitmapS[i], (int) (canvas.getWidth() * birdWidth), (int) (canvas.getHeight() * birdHeight), true);
                    }
                    for (int i = 1; i < 11; i++) {
                        eatBitmapT[i] = Bitmap.createScaledBitmap(eatBitmapT[i], (int) (canvas.getWidth() * birdWidth), (int) (canvas.getHeight() * birdHeight), true);
                    }
                    for (int i = 1; i < 11; i++) {
                        eatBitmapTS[i] = Bitmap.createScaledBitmap(eatBitmapTS[i], (int) (canvas.getWidth() * birdWidth), (int) (canvas.getHeight() * birdHeight), true);
                    }
                    // urax cit
                    for (int i = 1; i < 21; i++) {
                        playBitmap[i] = Bitmap.createScaledBitmap(playBitmap[i], canvas.getWidth() * 194 / 1050, canvas.getHeight() * 172 / 540, true);
                    }
                    for (int i = 1; i < 21; i++) {
                        playBitmapD[i] = Bitmap.createScaledBitmap(playBitmapD[i], canvas.getWidth() * 194 / 1050, canvas.getHeight() * 172 / 540, true);
                    }
                    for (int i = 1; i < 21; i++) {
                        playBitmapDT[i] = Bitmap.createScaledBitmap(playBitmapDT[i], canvas.getWidth() * 194 / 1050, canvas.getHeight() * 172 / 540, true);
                    }
                    for (int i = 1; i < 21; i++) {
                        playBitmapT[i] = Bitmap.createScaledBitmap(playBitmapT[i], canvas.getWidth() * 194 / 1050, canvas.getHeight() * 172 / 540, true);
                    }
                    // qnox cit
                    for (int i = 1; i < 5; i++) {
                        flyBitmapSmile[i] = Bitmap.createScaledBitmap(flyBitmapSmile[i], canvas.getWidth() * 150 / 1050, canvas.getHeight() * 179 / 540, true);
                    }
                    for (int i = 1; i < 5; i++) {
                        flyBitmapDH[i] = Bitmap.createScaledBitmap(flyBitmapDH[i], canvas.getWidth() * 150 / 1050, canvas.getHeight() * 179 / 540, true);
                    }
                    for (int i = 1; i < 5; i++) {
                        flyBitmapDS[i] = Bitmap.createScaledBitmap(flyBitmapDS[i], canvas.getWidth() * 150 / 1050, canvas.getHeight() * 179 / 540, true);
                    }
                    for (int i = 1; i < 5; i++) {
                        flyBitmapD[i] = Bitmap.createScaledBitmap(flyBitmapD[i], canvas.getWidth() * 150 / 1050, canvas.getHeight() * 179 / 540, true);
                    }
                    for (int i = 1; i < 5; i++) {
                        flyBitmapH[i] = Bitmap.createScaledBitmap(flyBitmapH[i], canvas.getWidth() * 150 / 1050, canvas.getHeight() * 179 / 540, true);
                    }
                    for (int i = 1; i < 5; i++) {
                        flyBitmapSDH[i] = Bitmap.createScaledBitmap(flyBitmapSDH[i], canvas.getWidth() * 150 / 1050, canvas.getHeight() * 179 / 540, true);
                    }
                    for (int i = 1; i < 5; i++) {
                        flyBitmapSH[i] = Bitmap.createScaledBitmap(flyBitmapSH[i], canvas.getWidth() * 150 / 1050, canvas.getHeight() * 179 / 540, true);
                    }
                    for (int i = 1; i < 5; i++) {
                        flyBitmapS[i] = Bitmap.createScaledBitmap(flyBitmapS[i], canvas.getWidth() * 150 / 1050, canvas.getHeight() * 179 / 540, true);
                    }
                    for (int i = 1; i < 5; i++) {
                        flyBitmapTDH[i] = Bitmap.createScaledBitmap(flyBitmapTDH[i], canvas.getWidth() * 150 / 1050, canvas.getHeight() * 179 / 540, true);
                    }
                    for (int i = 1; i < 5; i++) {
                        flyBitmapTDSH[i] = Bitmap.createScaledBitmap(flyBitmapTDSH[i], canvas.getWidth() * 150 / 1050, canvas.getHeight() * 179 / 540, true);
                    }
                    for (int i = 1; i < 5; i++) {
                        flyBitmapTDS[i] = Bitmap.createScaledBitmap(flyBitmapTDS[i], canvas.getWidth() * 150 / 1050, canvas.getHeight() * 179 / 540, true);
                    }
                    for (int i = 1; i < 5; i++) {
                        flyBitmapTD[i] = Bitmap.createScaledBitmap(flyBitmapTD[i], canvas.getWidth() * 150 / 1050, canvas.getHeight() * 179 / 540, true);
                    }
                    for (int i = 1; i < 5; i++) {
                        flyBitmapTH[i] = Bitmap.createScaledBitmap(flyBitmapTH[i], canvas.getWidth() * 150 / 1050, canvas.getHeight() * 179 / 540, true);
                    }
                    for (int i = 1; i < 5; i++) {
                        flyBitmapTSH[i] = Bitmap.createScaledBitmap(flyBitmapTSH[i], canvas.getWidth() * 150 / 1050, canvas.getHeight() * 179 / 540, true);
                    }
                    for (int i = 1; i < 5; i++) {
                        flyBitmapTS[i] = Bitmap.createScaledBitmap(flyBitmapTS[i], canvas.getWidth() * 150 / 1050, canvas.getHeight() * 179 / 540, true);
                    }
                    for (int i = 1; i < 5; i++) {
                        flyBitmapT[i] = Bitmap.createScaledBitmap(flyBitmapDH[i], canvas.getWidth() * 150 / 1050, canvas.getHeight() * 179 / 540, true);
                    }
                    for (int i = 1; i < 5; i++) {
                        flyBitmapUsual[i] = Bitmap.createScaledBitmap(flyBitmapUsual[i], canvas.getWidth() * 150 / 1050, canvas.getHeight() * 179 / 540, true);
                    }
                    sleepUsual1 = Bitmap.createScaledBitmap(sleepUsual1, canvas.getWidth() * 200 / 1050, canvas.getHeight() * 166 / 540, true);
                    sleepUsual2 = Bitmap.createScaledBitmap(sleepUsual2, canvas.getWidth() * 200 / 1050, canvas.getHeight() * 166 / 540, true);
                    sleepDH1 = Bitmap.createScaledBitmap(sleepDH1, canvas.getWidth() * 200 / 1050, canvas.getHeight() * 166 / 540, true);
                    sleepDH2 = Bitmap.createScaledBitmap(sleepDH2, canvas.getWidth() * 200 / 1050, canvas.getHeight() * 166 / 540, true);
                    sleepDSH1 = Bitmap.createScaledBitmap(sleepDSH1, canvas.getWidth() * 200 / 1050, canvas.getHeight() * 166 / 540, true);
                    sleepDSH2 = Bitmap.createScaledBitmap(sleepDSH2, canvas.getWidth() * 200 / 1050, canvas.getHeight() * 166 / 540, true);
                    sleepDS1 = Bitmap.createScaledBitmap(sleepDS1, canvas.getWidth() * 200 / 1050, canvas.getHeight() * 166 / 540, true);
                    sleepDS2 = Bitmap.createScaledBitmap(sleepDS2, canvas.getWidth() * 200 / 1050, canvas.getHeight() * 166 / 540, true);
                    sleepD1 = Bitmap.createScaledBitmap(sleepD1, canvas.getWidth() * 200 / 1050, canvas.getHeight() * 166 / 540, true);
                    sleepD2 = Bitmap.createScaledBitmap(sleepD2, canvas.getWidth() * 200 / 1050, canvas.getHeight() * 166 / 540, true);
                    sleepH1 = Bitmap.createScaledBitmap(sleepH1, canvas.getWidth() * 200 / 1050, canvas.getHeight() * 166 / 540, true);
                    sleepH2 = Bitmap.createScaledBitmap(sleepH2, canvas.getWidth() * 200 / 1050, canvas.getHeight() * 166 / 540, true);
                    sleepSmile1 = Bitmap.createScaledBitmap(sleepSmile1, canvas.getWidth() * 200 / 1050, canvas.getHeight() * 166 / 540, true);
                    sleepSmile2 = Bitmap.createScaledBitmap(sleepSmile2, canvas.getWidth() * 200 / 1050, canvas.getHeight() * 166 / 540, true);
                    sleepSH1 = Bitmap.createScaledBitmap(sleepSH1, canvas.getWidth() * 200 / 1050, canvas.getHeight() * 166 / 540, true);
                    sleepSH2 = Bitmap.createScaledBitmap(sleepSH2, canvas.getWidth() * 200 / 1050, canvas.getHeight() * 166 / 540, true);
                    sleepS1 = Bitmap.createScaledBitmap(sleepS1, canvas.getWidth() * 200 / 1050, canvas.getHeight() * 166 / 540, true);
                    sleepS2 = Bitmap.createScaledBitmap(sleepS2, canvas.getWidth() * 200 / 1050, canvas.getHeight() * 166 / 540, true);
                    //loxacox cit
                    for (int i = 1; i < 26; i++) {
                        washBitmap[i] = Bitmap.createScaledBitmap(washBitmap[i], canvas.getWidth() * 341 / 1050, canvas.getHeight() * 378 / 540, true);
                    }
                    //shnchel
                    if(!eating && !playing && !flying && !sleeping && !laying && !hitting && !washing && !pooping && !flyPoop && !disgusting && !flyBackPoop) {
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
                    float eatButtonLeft = (float) canvas.getWidth()*19/1050;
                    float eatButtonTop = (float) canvas.getHeight()*427/540;
                    for (int i = 0; i < 11; i++) {
                        eatDarkButtonBitmap[i] = Bitmap.createScaledBitmap(eatDarkButtonBitmap[i],ButtonWidth, ButtonHeight,true);
                    }
                    eatButtonBitmap = Bitmap.createScaledBitmap(eatButtonBitmap,ButtonWidth, ButtonHeight,true);
                    if(!eatChecker && checkEatButton && !pooping && !flyPoop && !disgusting && !flyBackPoop) {
                        new EatDarkButtonThread().start();
                        checkEatButton = false;
                    }
                    if(drawEatButton && !pooping && !flyPoop && !disgusting && !flyBackPoop) {
                        eatButtonBitmap = eatDarkButtonBitmap[eatTimer];
                        if(eatTimer == 1) {
                            eatChecker = true;
                            lastTouchX = 0;
                            lastTouchY = 0;
                        }
                    }
                    canvas.drawBitmap(eatButtonBitmap,eatButtonLeft,eatButtonTop,paint);
                    // xaxalu knopken
                    float playButtonLeft = (float) canvas.getWidth()*130/1050;
                    float playButtonTop = (float) canvas.getHeight()*427/540;
                    for (int i = 0; i < 16; i++) {
                        playDarkButtonBitmap[i] = Bitmap.createScaledBitmap(playDarkButtonBitmap[i],ButtonWidth, ButtonHeight,true);

                    }
                    playButtonBitmap = Bitmap.createScaledBitmap(playButtonBitmap,ButtonWidth, ButtonHeight,true);
                    if(!playChecker && checkPlayButton && !pooping && !flyPoop && !disgusting && !flyBackPoop){
                        new PlayDarkButtonThread().start();
                        checkPlayButton = false;
                    }
                    if(drawPlayButton && !pooping && !flyPoop && !disgusting && !flyBackPoop){
                        playButtonBitmap = playDarkButtonBitmap[playTimer];
                        if(playTimer == 1) {
                            playChecker = true;
                            lastTouchX = 0;
                            lastTouchY = 0;
                        }
                    }
                    canvas.drawBitmap(playButtonBitmap,playButtonLeft,playButtonTop,paint);
                    //qnelu knopken
                    float sleepButtonLeft = (float) canvas.getWidth()*241/1050;
                    float sleepButtonTop = (float) canvas.getHeight()*427/540;
                    sleepButtonBitmap = Bitmap.createScaledBitmap(sleepButtonBitmap,ButtonWidth, ButtonHeight,true);
                    for (int i = 0; i < 61; i++) {
                        sleepDarkButtonBitmap[i] = Bitmap.createScaledBitmap(sleepDarkButtonBitmap[i],ButtonWidth, ButtonHeight,true);
                    }
                    if(!sleepChecker && checkSleepButton && !pooping && !flyPoop && !disgusting && !flyBackPoop){
                        new SleepDarkButtonThread().start();
                        checkSleepButton = false;
                    }
                    if(drawSleepButton && !pooping && !flyPoop && !disgusting && !flyBackPoop){
                        if(sleepTimer >= 0) sleepButtonBitmap = sleepDarkButtonBitmap[sleepTimer];
                        if(sleepTimer == 0) {
                            sleepChecker = true;
                            lastTouchX = 0;
                            lastTouchY = 0;
                            m5 = 0;
                        }
                    }
                    canvas.drawBitmap(sleepButtonBitmap,sleepButtonLeft,sleepButtonTop,paint);
                    // maqrvelu knopka
                    float dirtButtonLeft = (float) canvas.getWidth()*352/1050;
                    float dirtButtonTop = (float) canvas.getHeight()*427/540;
                    washButtonBitmap = Bitmap.createScaledBitmap(washButtonBitmap,ButtonWidth, ButtonHeight,true);
                    washButtonBitmap2 = Bitmap.createScaledBitmap(washButtonBitmap2,ButtonWidth, ButtonHeight,true);
                    washDarkButtonBitmap = Bitmap.createScaledBitmap(washDarkButtonBitmap,ButtonWidth, ButtonHeight,true);
                    if(dirtRight - dirtLeft >= dirtWeight / 2. && !pooping && !flyPoop && !disgusting && !flyBackPoop) washButtonBitmap = washDarkButtonBitmap;
                    if(dirtRight - dirtLeft <= dirtWeight / 2. && !pooping && !flyPoop && !disgusting && !flyBackPoop) washButtonBitmap = washButtonBitmap2;
                    canvas.drawBitmap(washButtonBitmap,dirtButtonLeft,dirtButtonTop,paint);
                    //qaqel
                    eatButtonBitmapA = Bitmap.createScaledBitmap(eatButtonBitmapA,ButtonWidth, ButtonHeight,true);
                    playButtonBitmapA = Bitmap.createScaledBitmap(playButtonBitmapA,ButtonWidth, ButtonHeight,true);
                    washButtonBitmapA = Bitmap.createScaledBitmap(washButtonBitmapA,ButtonWidth, ButtonHeight,true);
                    sleepButtonBitmapA = Bitmap.createScaledBitmap(sleepButtonBitmapA,ButtonWidth, ButtonHeight,true);
                    float poopX = (float) (canvas.getWidth() * 450 / 1050);
                    float poopY = (float) (canvas.getHeight() * 309 / 540);
                    float poopWidth = (float) (canvas.getWidth() * 94 / 1050);
                    float poopHeight = (float) (canvas.getHeight() * 94 / 540);
                    for (int i = 1; i < 5; i++) {
                        poopBitmap[i] = Bitmap.createScaledBitmap(poopBitmap[i], canvas.getWidth() * 94 / 1050, canvas.getHeight() * 94 / 540, true);
                    }
                    for (int i = 1; i < 11; i++) {
                        poopingBitmapUsual[i] = Bitmap.createScaledBitmap(poopingBitmapUsual[i], (int) (canvas.getWidth() * birdWidth), (int) (canvas.getHeight() * birdHeight), true);
                    }
                    for (int i = 1; i < 11; i++) {
                        poopingBitmapDTSH[i] = Bitmap.createScaledBitmap(poopingBitmapDTSH[i], (int) (canvas.getWidth() * birdWidth), (int) (canvas.getHeight() * birdHeight), true);
                    }
                    for (int i = 1; i < 11; i++) {
                        poopingBitmapDSH[i] = Bitmap.createScaledBitmap(poopingBitmapDSH[i], (int) (canvas.getWidth() * birdWidth), (int) (canvas.getHeight() * birdHeight), true);
                    }
                    for (int i = 1; i < 11; i++) {
                        poopingBitmapDTH[i] = Bitmap.createScaledBitmap(poopingBitmapDTH[i], (int) (canvas.getWidth() * birdWidth), (int) (canvas.getHeight() * birdHeight), true);
                    }
                    for (int i = 1; i < 11; i++) {
                        poopingBitmapDTS[i] = Bitmap.createScaledBitmap(poopingBitmapDTS[i], (int) (canvas.getWidth() * birdWidth), (int) (canvas.getHeight() * birdHeight), true);
                    }
                    for (int i = 1; i < 11; i++) {
                        poopingBitmapTHS[i] = Bitmap.createScaledBitmap(poopingBitmapTHS[i], (int) (canvas.getWidth() * birdWidth), (int) (canvas.getHeight() * birdHeight), true);
                    }
                    for (int i = 1; i < 11; i++) {
                        poopingBitmapDH[i] = Bitmap.createScaledBitmap(poopingBitmapDH[i], (int) (canvas.getWidth() * birdWidth), (int) (canvas.getHeight() * birdHeight), true);
                    }
                    for (int i = 1; i < 11; i++) {
                        poopingBitmapDT[i] = Bitmap.createScaledBitmap(poopingBitmapDT[i], (int) (canvas.getWidth() * birdWidth), (int) (canvas.getHeight() * birdHeight), true);
                    }
                    for (int i = 1; i < 11; i++) {
                        poopingBitmapDS[i] = Bitmap.createScaledBitmap(poopingBitmapDS[i], (int) (canvas.getWidth() * birdWidth), (int) (canvas.getHeight() * birdHeight), true);
                    }
                    for (int i = 1; i < 11; i++) {
                        poopingBitmapD[i] = Bitmap.createScaledBitmap(poopingBitmapD[i], (int) (canvas.getWidth() * birdWidth), (int) (canvas.getHeight() * birdHeight), true);
                    }
                    for (int i = 1; i < 11; i++) {
                        poopingBitmapTH[i] = Bitmap.createScaledBitmap(poopingBitmapTH[i], (int) (canvas.getWidth() * birdWidth), (int) (canvas.getHeight() * birdHeight), true);
                    }
                    for (int i = 1; i < 11; i++) {
                        poopingBitmapHS[i] = Bitmap.createScaledBitmap(poopingBitmapHS[i], (int) (canvas.getWidth() * birdWidth), (int) (canvas.getHeight() * birdHeight), true);
                    }
                    for (int i = 1; i < 11; i++) {
                        poopingBitmapTS[i] = Bitmap.createScaledBitmap(poopingBitmapTS[i], (int) (canvas.getWidth() * birdWidth), (int) (canvas.getHeight() * birdHeight), true);
                    }
                    for (int i = 1; i < 11; i++) {
                        poopingBitmapT[i] = Bitmap.createScaledBitmap(poopingBitmapT[i], (int) (canvas.getWidth() * birdWidth), (int) (canvas.getHeight() * birdHeight), true);
                    }
                    for (int i = 1; i < 11; i++) {
                        poopingBitmapH[i] = Bitmap.createScaledBitmap(poopingBitmapH[i], (int) (canvas.getWidth() * birdWidth), (int) (canvas.getHeight() * birdHeight), true);
                    }
                    for (int i = 1; i < 11; i++) {
                        poopingBitmapS[i] = Bitmap.createScaledBitmap(poopingBitmapS[i], (int) (canvas.getWidth() * birdWidth), (int) (canvas.getHeight() * birdHeight), true);
                    }
                    if (m5 == 0) {
                        new Minute().start();
                        m5 = 1;
                    }
                    if (eatScore >= 1 && pop && !pooping && !eating && !playing && !flying && !sleeping && !laying && !hitting && !washing) {
                        eatButtonBitmap2 = eatButtonBitmap;
                        sleepButtonBitmap2 = sleepButtonBitmap;
                        playButtonBitmap2 = playButtonBitmap;
                        washButtonBitmap3 = washButtonBitmap;
                        eatButtonBitmap = eatButtonBitmapA;
                        sleepButtonBitmap = sleepButtonBitmapA;
                        playButtonBitmap = playButtonBitmapA;
                        washButtonBitmap = washButtonBitmapA;
                        po = true;
                    }
                    if (po && !isTouched) {
                        if (poop1 > 4) {
                            poop1 = 1;
                        }
                        canvas.drawBitmap(poopBitmap[poop1], poopX, poopY, paint);
                    }
                    if (po && !poopingTimeIsPassed1) {
                        new PoopThread().start();
                        pooping = true;
                        poopingTimeIsPassed1 = true;
                    }
                    if (po && !poopingTimeIsPassed2) {
                        new PoopFlyThread().start();
                        flyPoop = true;
                        poopingTimeIsPassed2 = true;
                    }
                    if (poopingNeedToDrawNow2 && flyPoop) {
                        switch (poop2) {
                            case 1:
                                if (bitmap1 == bitmapDTSH1) bitmap = flyBitmapTDSH[4];else if (bitmap1 == bitmapDH1) bitmap = flyBitmapDH[4];else if (bitmap1 == bitmapDS1) bitmap = flyBitmapDS[4];else if (bitmap1 == bitmapD1) bitmap = flyBitmapD[4];else if (bitmap1 == bitmapH1) bitmap = flyBitmapH[4];else if (bitmap1 == bitmapSmile1) bitmap = flyBitmapSmile[4];else if (bitmap1 == bitmapSH1) bitmap = flyBitmapSH[4];else if (bitmap1 == bitmapDSH1) bitmap = flyBitmapSDH[4];else if (bitmap1 == bitmapS1) bitmap = flyBitmapS[4];else if (bitmap1 == bitmapDTH1) bitmap = flyBitmapTDH[4];else if (bitmap1 == bitmapDTS1) bitmap = flyBitmapTDS[4];else if (bitmap1 == bitmapDT1) bitmap = flyBitmapTD[4];else if (bitmap1 == bitmapTH1) bitmap = flyBitmapTH[4];else if (bitmap1 == bitmapTSH1) bitmap = flyBitmapTSH[4];else if (bitmap1 == bitmapTS1) bitmap = flyBitmapTS[4];else if (bitmap1 == bitmapT1) bitmap = flyBitmapT[4];else if (bitmap1 == bitmapUsual1) bitmap = flyBitmapUsual[4];
                                break;
                            case 2:
                                if (bitmap1 == bitmapDTSH1) bitmap = flyBitmapTDSH[3];else if (bitmap1 == bitmapDH1) bitmap = flyBitmapDH[3];else if (bitmap1 == bitmapDS1) bitmap = flyBitmapDS[3];else if (bitmap1 == bitmapD1) bitmap = flyBitmapD[3];else if (bitmap1 == bitmapH1) bitmap = flyBitmapH[3];else if (bitmap1 == bitmapSmile1) bitmap = flyBitmapSmile[3];else if (bitmap1 == bitmapSH1) bitmap = flyBitmapSH[3];else if (bitmap1 == bitmapDSH1) bitmap = flyBitmapSDH[3];else if (bitmap1 == bitmapS1) bitmap = flyBitmapS[3];else if (bitmap1 == bitmapDTH1) bitmap = flyBitmapTDH[3];else if (bitmap1 == bitmapDTS1) bitmap = flyBitmapTDS[3];else if (bitmap1 == bitmapDT1) bitmap = flyBitmapTD[3];else if (bitmap1 == bitmapTH1) bitmap = flyBitmapTH[3];else if (bitmap1 == bitmapTSH1) bitmap = flyBitmapTSH[3];else if (bitmap1 == bitmapTS1) bitmap = flyBitmapTS[3];else if (bitmap1 == bitmapT1) bitmap = flyBitmapT[3];else if (bitmap1 == bitmapUsual1) bitmap = flyBitmapUsual[3];
                                birdX = (float) 548 / 1050;
                                birdY = (float) 176 / 540;
                                break;
                            case 3:
                                if (bitmap1 == bitmapDTSH1) bitmap = flyBitmapTDSH[4];else if (bitmap1 == bitmapDH1) bitmap = flyBitmapDH[4];else if (bitmap1 == bitmapDS1) bitmap = flyBitmapDS[4];else if (bitmap1 == bitmapD1) bitmap = flyBitmapD[4];else if (bitmap1 == bitmapH1) bitmap = flyBitmapH[4];else if (bitmap1 == bitmapSmile1) bitmap = flyBitmapSmile[4];else if (bitmap1 == bitmapSH1) bitmap = flyBitmapSH[4];else if (bitmap1 == bitmapDSH1) bitmap = flyBitmapSDH[4];else if (bitmap1 == bitmapS1) bitmap = flyBitmapS[4];else if (bitmap1 == bitmapDTH1) bitmap = flyBitmapTDH[4];else if (bitmap1 == bitmapDTS1) bitmap = flyBitmapTDS[4];else if (bitmap1 == bitmapDT1) bitmap = flyBitmapTD[4];else if (bitmap1 == bitmapTH1) bitmap = flyBitmapTH[4];else if (bitmap1 == bitmapTSH1) bitmap = flyBitmapTSH[4];else if (bitmap1 == bitmapTS1) bitmap = flyBitmapTS[4];else if (bitmap1 == bitmapT1) bitmap = flyBitmapT[4];else if (bitmap1 == bitmapUsual1) bitmap = flyBitmapUsual[4];
                                birdX = (float) 625 / 1050;
                                birdY = (float) 203 / 540;
                                break;
                            case 4:
                                if (bitmap1 == bitmapDTSH1) bitmap = flyBitmapTDSH[3];else if (bitmap1 == bitmapDH1) bitmap = flyBitmapDH[3];else if (bitmap1 == bitmapDS1) bitmap = flyBitmapDS[3];else if (bitmap1 == bitmapD1) bitmap = flyBitmapD[3];else if (bitmap1 == bitmapH1) bitmap = flyBitmapH[3];else if (bitmap1 == bitmapSmile1) bitmap = flyBitmapSmile[3];else if (bitmap1 == bitmapSH1) bitmap = flyBitmapSH[3];else if (bitmap1 == bitmapDSH1) bitmap = flyBitmapSDH[3];else if (bitmap1 == bitmapS1) bitmap = flyBitmapS[3];else if (bitmap1 == bitmapDTH1) bitmap = flyBitmapTDH[3];else if (bitmap1 == bitmapDTS1) bitmap = flyBitmapTDS[3];else if (bitmap1 == bitmapDT1) bitmap = flyBitmapTD[3];else if (bitmap1 == bitmapTH1) bitmap = flyBitmapTH[3];else if (bitmap1 == bitmapTSH1) bitmap = flyBitmapTSH[3];else if (bitmap1 == bitmapTS1) bitmap = flyBitmapTS[3];else if (bitmap1 == bitmapT1) bitmap = flyBitmapT[3];else if (bitmap1 == bitmapUsual1) bitmap = flyBitmapUsual[3];
                                birdX = (float) 715 / 1050;
                                birdY = (float) 195 / 540;
                                break;
                            case 5:
                                if (bitmap1 == bitmapDTSH1) bitmap = flyBitmapTDSH[4];else if (bitmap1 == bitmapDH1) bitmap = flyBitmapDH[4];else if (bitmap1 == bitmapDS1) bitmap = flyBitmapDS[4];else if (bitmap1 == bitmapD1) bitmap = flyBitmapD[4];else if (bitmap1 == bitmapH1) bitmap = flyBitmapH[4];else if (bitmap1 == bitmapSmile1) bitmap = flyBitmapSmile[4];else if (bitmap1 == bitmapSH1) bitmap = flyBitmapSH[4];else if (bitmap1 == bitmapDSH1) bitmap = flyBitmapSDH[4];else if (bitmap1 == bitmapS1) bitmap = flyBitmapS[4];else if (bitmap1 == bitmapDTH1) bitmap = flyBitmapTDH[4];else if (bitmap1 == bitmapDTS1) bitmap = flyBitmapTDS[4];else if (bitmap1 == bitmapDT1) bitmap = flyBitmapTD[4];else if (bitmap1 == bitmapTH1) bitmap = flyBitmapTH[4];else if (bitmap1 == bitmapTSH1) bitmap = flyBitmapTSH[4];else if (bitmap1 == bitmapTS1) bitmap = flyBitmapTS[4];else if (bitmap1 == bitmapT1) bitmap = flyBitmapT[4];else if (bitmap1 == bitmapUsual1) bitmap = flyBitmapUsual[4];
                                birdX = (float) 795 / 1050;
                                birdY = (float) 232 / 540;
                                break;
                            case 6:
                                disgusting = true;
                                flyPoop = false;
                                break;
                        }
                    }
                    if (disgusting && !disgustingTimeIsPassed) {
                        new DisgustThread().start();
                        disgustingTimeIsPassed = true;
                    }
                    if (disgustingNeedToDrawNow && disgusting) {
                        if (disgust >= 11) {
                            disgust = 1;
                        }
                        if(bitmap1 == bitmapUsual1 || bitmap1 == bitmapSmile1) bitmap = poopingBitmapDTSH[disgust];else if(bitmap1 == bitmapDSH1) bitmap = poopingBitmapDSH[disgust];else if(bitmap1 == bitmapDTS1) bitmap = poopingBitmapDTS[disgust];else if(bitmap1 == bitmapDTH1) bitmap = poopingBitmapDTH[disgust];else if(bitmap1 == bitmapDH1) bitmap = poopingBitmapDH[disgust];else if(bitmap1 == bitmapDT1) bitmap = poopingBitmapDT[disgust];else if(bitmap1 == bitmapDS1) bitmap = poopingBitmapDS[disgust];else if(bitmap1 == bitmapD1) bitmap = poopingBitmapD[disgust];else if(bitmap1 == bitmapTSH1) bitmap = poopingBitmapTHS[disgust];else if(bitmap1 == bitmapSH1) bitmap = poopingBitmapHS[disgust];else if(bitmap1 == bitmapTH1) bitmap = poopingBitmapTH[disgust];else if(bitmap1 == bitmapH1) bitmap = poopingBitmapH[disgust];else if(bitmap1 == bitmapTS1) bitmap = poopingBitmapTS[disgust];else if(bitmap1 == bitmapT1) bitmap = poopingBitmapT[disgust];else if(bitmap1 == bitmapS1) bitmap = poopingBitmapS[disgust];
                    }
                    if (disgusting && lastTouchX >= poopX && lastTouchX <= poopX + poopWidth && lastTouchY >= poopY && lastTouchY <= poopY + poopHeight) {
                        new PoopFlyBackThread().start();
                        isTouched = true;
                        disgusting = false;
                        flyBackPoop = true;
                    }
                    if (isTouched && !poopingTimeIsPassed3) {
                        new PoopFlyBackThread().start();
                        poopingTimeIsPassed3 = true;
                    }
                    if (poopingNeedToDrawNow3 && flyBackPoop) {
                        switch (poop3) {
                            case 1:
                                if (bitmap1 == bitmapDTSH1) bitmap = flyBitmapTDSH[2];else if (bitmap1 == bitmapDH1) bitmap = flyBitmapDH[2];else if (bitmap1 == bitmapDS1) bitmap = flyBitmapDS[2];else if (bitmap1 == bitmapD1) bitmap = flyBitmapD[2];else if (bitmap1 == bitmapH1) bitmap = flyBitmapH[2];else if (bitmap1 == bitmapSmile1) bitmap = flyBitmapSmile[2];else if (bitmap1 == bitmapSH1) bitmap = flyBitmapSH[2];else if (bitmap1 == bitmapDSH1) bitmap = flyBitmapSDH[2];else if (bitmap1 == bitmapS1) bitmap = flyBitmapS[2];else if (bitmap1 == bitmapDTH1) bitmap = flyBitmapTDH[2];else if (bitmap1 == bitmapDTS1) bitmap = flyBitmapTDS[2];else if (bitmap1 == bitmapDT1) bitmap = flyBitmapTD[2];else if (bitmap1 == bitmapTH1) bitmap = flyBitmapTH[2];else if (bitmap1 == bitmapTSH1) bitmap = flyBitmapTSH[2];else if (bitmap1 == bitmapTS1) bitmap = flyBitmapTS[2];else if (bitmap1 == bitmapT1) bitmap = flyBitmapT[2];else if (bitmap1 == bitmapUsual1) bitmap = flyBitmapUsual[2];
                                break;
                            case 2:
                                if (bitmap1 == bitmapDTSH1) bitmap = flyBitmapTDSH[1];else if (bitmap1 == bitmapDH1) bitmap = flyBitmapDH[1];else if (bitmap1 == bitmapDS1) bitmap = flyBitmapDS[1];else if (bitmap1 == bitmapD1) bitmap = flyBitmapD[1];else if (bitmap1 == bitmapH1) bitmap = flyBitmapH[1];else if (bitmap1 == bitmapSmile1) bitmap = flyBitmapSmile[1];else if (bitmap1 == bitmapSH1) bitmap = flyBitmapSH[1];else if (bitmap1 == bitmapDSH1) bitmap = flyBitmapSDH[1];else if (bitmap1 == bitmapS1) bitmap = flyBitmapS[1];else if (bitmap1 == bitmapDTH1) bitmap = flyBitmapTDH[1];else if (bitmap1 == bitmapDTS1) bitmap = flyBitmapTDS[1];else if (bitmap1 == bitmapDT1) bitmap = flyBitmapTD[1];else if (bitmap1 == bitmapTH1) bitmap = flyBitmapTH[1];else if (bitmap1 == bitmapTSH1) bitmap = flyBitmapTSH[1];else if (bitmap1 == bitmapTS1) bitmap = flyBitmapTS[1];else if (bitmap1 == bitmapT1) bitmap = flyBitmapT[1];else if (bitmap1 == bitmapUsual1) bitmap = flyBitmapUsual[1];
                                birdX = (float) 715 / 1050;
                                birdY = (float) 195 / 540;
                                break;
                            case 3:
                                if (bitmap1 == bitmapDTSH1) bitmap = flyBitmapTDSH[2];else if (bitmap1 == bitmapDH1) bitmap = flyBitmapDH[2];else if (bitmap1 == bitmapDS1) bitmap = flyBitmapDS[2];else if (bitmap1 == bitmapD1) bitmap = flyBitmapD[2];else if (bitmap1 == bitmapH1) bitmap = flyBitmapH[2];else if (bitmap1 == bitmapSmile1) bitmap = flyBitmapSmile[2];else if (bitmap1 == bitmapSH1) bitmap = flyBitmapSH[2];else if (bitmap1 == bitmapDSH1) bitmap = flyBitmapSDH[2];else if (bitmap1 == bitmapS1) bitmap = flyBitmapS[2];else if (bitmap1 == bitmapDTH1) bitmap = flyBitmapTDH[2];else if (bitmap1 == bitmapDTS1) bitmap = flyBitmapTDS[2];else if (bitmap1 == bitmapDT1) bitmap = flyBitmapTD[2];else if (bitmap1 == bitmapTH1) bitmap = flyBitmapTH[2];else if (bitmap1 == bitmapTSH1) bitmap = flyBitmapTSH[2];else if (bitmap1 == bitmapTS1) bitmap = flyBitmapTS[2];else if (bitmap1 == bitmapT1) bitmap = flyBitmapT[2];else if (bitmap1 == bitmapUsual1) bitmap = flyBitmapUsual[2];
                                birdX = (float) 625 / 1050;
                                birdY = (float) 203 / 540;
                                break;
                            case 4:
                                if (bitmap1 == bitmapDTSH1) bitmap = flyBitmapTDSH[1];else if (bitmap1 == bitmapDH1) bitmap = flyBitmapDH[1];else if (bitmap1 == bitmapDS1) bitmap = flyBitmapDS[1];else if (bitmap1 == bitmapD1) bitmap = flyBitmapD[1];else if (bitmap1 == bitmapH1) bitmap = flyBitmapH[1];else if (bitmap1 == bitmapSmile1) bitmap = flyBitmapSmile[1];else if (bitmap1 == bitmapSH1) bitmap = flyBitmapSH[1];else if (bitmap1 == bitmapDSH1) bitmap = flyBitmapSDH[1];else if (bitmap1 == bitmapS1) bitmap = flyBitmapS[1];else if (bitmap1 == bitmapDTH1) bitmap = flyBitmapTDH[1];else if (bitmap1 == bitmapDTS1) bitmap = flyBitmapTDS[1];else if (bitmap1 == bitmapDT1) bitmap = flyBitmapTD[1];else if (bitmap1 == bitmapTH1) bitmap = flyBitmapTH[1];else if (bitmap1 == bitmapTSH1) bitmap = flyBitmapTSH[1];else if (bitmap1 == bitmapTS1) bitmap = flyBitmapTS[1];else if (bitmap1 == bitmapT1) bitmap = flyBitmapT[1];else if (bitmap1 == bitmapUsual1) bitmap = flyBitmapUsual[1];
                                birdX = (float) 548 / 1050;
                                birdY = (float) 176 / 540;
                                break;
                            case 5:
                                if (bitmap1 == bitmapDTSH1) bitmap = flyBitmapTDSH[2];else if (bitmap1 == bitmapDH1) bitmap = flyBitmapDH[2];else if (bitmap1 == bitmapDS1) bitmap = flyBitmapDS[2];else if (bitmap1 == bitmapD1) bitmap = flyBitmapD[2];else if (bitmap1 == bitmapH1) bitmap = flyBitmapH[2];else if (bitmap1 == bitmapSmile1) bitmap = flyBitmapSmile[2];else if (bitmap1 == bitmapSH1) bitmap = flyBitmapSH[2];else if (bitmap1 == bitmapDSH1) bitmap = flyBitmapSDH[2];else if (bitmap1 == bitmapS1) bitmap = flyBitmapS[2];else if (bitmap1 == bitmapDTH1) bitmap = flyBitmapTDH[2];else if (bitmap1 == bitmapDTS1) bitmap = flyBitmapTDS[2];else if (bitmap1 == bitmapDT1) bitmap = flyBitmapTD[2];else if (bitmap1 == bitmapTH1) bitmap = flyBitmapTH[2];else if (bitmap1 == bitmapTSH1) bitmap = flyBitmapTSH[2];else if (bitmap1 == bitmapTS1) bitmap = flyBitmapTS[2];else if (bitmap1 == bitmapT1) bitmap = flyBitmapT[2];else if (bitmap1 == bitmapUsual1) bitmap = flyBitmapUsual[2];
                                birdX = (float) 419 / 1050;
                                birdY = (float) 232 / 540;
                                break;
                            case 6:
                                bitmap = bitmap1;
                                flyBackPoop = false;
                                isTouched = false;
                                pop = false;
                                po = false;
                                pooping = false;
                                eatScore = 0;
                                poop3 = 0;
                                poop2 = 1;
                                poop1 = 1;
                                lastTouchX = 0;
                                lastTouchY = 0;
                                m5 = 0;
                                disgust = 1;
                                poopingTimeIsPassed1 = false;
                                poopingTimeIsPassed2 = false;
                                poopingTimeIsPassed3 = false;
                                poopingNeedToDrawNow1 = false;
                                poopingNeedToDrawNow2 = false;
                                poopingNeedToDrawNow3 = false;
                                disgustingTimeIsPassed = false;
                                disgustingNeedToDrawNow = false;
                                eatButtonBitmap = eatButtonBitmap2;
                                sleepButtonBitmap = sleepButtonBitmap2;
                                playButtonBitmap = playButtonBitmap2;
                                washButtonBitmap = washButtonBitmap3;
                                break;
                        }
                    }
                    // utel
                    if(lastTouchX >= eatButtonLeft && lastTouchX <= eatButtonLeft + ButtonWidth && lastTouchY >= eatButtonTop && lastTouchY <= eatButtonTop + ButtonHeight && eatChecker && !playing && !sleeping && !laying && !flying && !flyingBack && !hitting && !washing && !pooping && !flyPoop && !disgusting && !flyBackPoop) {
                        ea = true;
                    }
                    if(!eatingTimeIsPassed && ea) {
                        new EatingThread().start();
                        eating = true;
                        eatingTimeIsPassed = true;
                    }
                    if(eatingNeedToDrawNow && eating){
                        if(eat >= 1) {
                            if (bitmap1 == bitmapDTS1 || bitmap1 == bitmapDTSH1) bitmap = eatBitmapDTS[eat];
                            else if (bitmap1 == bitmapDT1 || bitmap1 == bitmapDTH1) bitmap = eatBitmapDT[eat];
                            else if (bitmap1 == bitmapDS1 || bitmap1 == bitmapDSH1) bitmap = eatBitmapDS[eat];
                            else if (bitmap1 == bitmapTS1 || bitmap1 == bitmapTSH1) bitmap = eatBitmapTS[eat];
                            else if (bitmap1 == bitmapD1 || bitmap1 == bitmapDH1) bitmap = eatBitmapD[eat];
                            else if (bitmap1 == bitmapS1 || bitmap1 == bitmapSH1) bitmap = eatBitmapS[eat];
                            else if (bitmap1 == bitmapT1 || bitmap1 == bitmapTH1) bitmap = eatBitmapT[eat];
                            else if (bitmap1 == bitmapUsual1 || bitmap1 == bitmapH1) bitmap = eatBitmap[eat];
                            else if (bitmap1 == bitmapSmile1) bitmap = eatBitmapSmile[eat];
                        }
                        if(eat == 9){
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
                        }
                        if(eat == 10) {
                            eating = false;
                            eat = 0;
                            lastTouchY = 0;
                            lastTouchX = 0;
                            eatChecker = false;
                            checkEatButton = true;
                            e = 0;
                            ea = false;
                            eatButtonBitmap = eatDarkButtonBitmap[10];
                            eatTimer = 10;
                            eatScore++;
                        }
                    }
                    //xndal
                    if(lastTouchX >= playButtonLeft && lastTouchX <= playButtonLeft + ButtonWidth && lastTouchY >= playButtonTop && lastTouchY <= playButtonTop + ButtonHeight && playChecker && !eating && !sleeping && !laying && !flying && !flyingBack && !hitting && !washing && !pooping && !flyPoop && !disgusting && !flyBackPoop) {
                        pl = true;
                    }
                    if(!playingTimeIsPassed && pl) {
                        new PlayingThread().start();
                        playing = true;
                        playingTimeIsPassed = true;
                    }
                    if(playingNeedToDrawNow && playing){
                        smile *= (happyRight2 - happyLeft);
                        if (happyRight + smile > happyRight2) {
                            happyRight = happyRight2;
                        } else {
                            happyRight += smile;
                        }
                        smile /= (happyRight2 - happyLeft);
                        if(bitmap1 == bitmapDT1 || bitmap1 == bitmapDTH1 || bitmap1 == bitmapDTS1 || bitmap1 == bitmapDTSH1) bitmap = playBitmapDT[play];
                        else if(bitmap1 == bitmapD1 || bitmap1 == bitmapDH1 || bitmap1 == bitmapDS1 || bitmap1 == bitmapDSH1) bitmap = playBitmapD[play];
                        else if(bitmap1 == bitmapT1 || bitmap1 == bitmapTH1 || bitmap1 == bitmapTS1 || bitmap1 == bitmapTSH1) bitmap = playBitmapT[play];
                        else if(bitmap1 == bitmapUsual1 || bitmap1 == bitmapH1 || bitmap1 == bitmapS1 || bitmap1 == bitmapSmile1) bitmap = playBitmap[play];
                        if(play == 20) {
                            playing = false;
                            playChecker = false;
                            checkPlayButton = true;
                            play = 0;
                            lastTouchY = 0;
                            lastTouchX = 0;
                            p = 0;
                            pl = false;
                            playButtonBitmap = playDarkButtonBitmap[15];
                            playTimer = 15;
                        }
                    }
                    //qnel
                    if(lastTouchX >= sleepButtonLeft && lastTouchX <= sleepButtonLeft + ButtonWidth && lastTouchY >= sleepButtonTop && lastTouchY <= sleepButtonTop + ButtonHeight && !sleepFinished && sleepChecker && !playing && !eating && !hitting && !washing && !pooping && !flyPoop && !disgusting && !flyBackPoop) {
                        fl = true;
                    }
                    if(!flyingTimeIsPassed && fl && !sleepFinished) {
                        new FlyingThread().start();
                        flying = true;
                        flyingTimeIsPassed = true;
                    }
                    if(flyingNeedToDrawNow && flying && !sleepFinished && !sleeping) {
                        switch (sleep) {
                            case 1:
                                if (bitmap1 == bitmapDTSH1) bitmap = flyBitmapTDSH[2];else if (bitmap1 == bitmapDH1) bitmap = flyBitmapDH[2];else if (bitmap1 == bitmapDS1) bitmap = flyBitmapDS[2];else if (bitmap1 == bitmapD1) bitmap = flyBitmapD[2];else if (bitmap1 == bitmapH1) bitmap = flyBitmapH[2];else if (bitmap1 == bitmapSmile1) bitmap = flyBitmapSmile[2];else if (bitmap1 == bitmapSH1) bitmap = flyBitmapSH[2];else if (bitmap1 == bitmapDSH1) bitmap = flyBitmapSDH[2];else if (bitmap1 == bitmapS1) bitmap = flyBitmapS[2];else if (bitmap1 == bitmapDTH1) bitmap = flyBitmapTDH[2];else if (bitmap1 == bitmapDTS1) bitmap = flyBitmapTDS[2];else if (bitmap1 == bitmapDT1) bitmap = flyBitmapTD[2];else if (bitmap1 == bitmapTH1) bitmap = flyBitmapTH[2];else if (bitmap1 == bitmapTSH1) bitmap = flyBitmapTSH[2];else if (bitmap1 == bitmapTS1) bitmap = flyBitmapTS[2];else if (bitmap1 == bitmapT1) bitmap = flyBitmapT[2];else if (bitmap1 == bitmapUsual1) bitmap = flyBitmapUsual[2];
                                break;
                            case 2:
                                if (bitmap1 == bitmapDTSH1) bitmap = flyBitmapTDSH[1];else if (bitmap1 == bitmapDH1) bitmap = flyBitmapDH[1];else if (bitmap1 == bitmapDS1) bitmap = flyBitmapDS[1];else if (bitmap1 == bitmapD1) bitmap = flyBitmapD[1];else if (bitmap1 == bitmapH1) bitmap = flyBitmapH[1];else if (bitmap1 == bitmapSmile1) bitmap = flyBitmapSmile[1];else if (bitmap1 == bitmapSH1) bitmap = flyBitmapSH[1];else if (bitmap1 == bitmapDSH1) bitmap = flyBitmapSDH[1];else if (bitmap1 == bitmapS1) bitmap = flyBitmapS[1];else if (bitmap1 == bitmapDTH1) bitmap = flyBitmapTDH[1];else if (bitmap1 == bitmapDTS1) bitmap = flyBitmapTDS[1];else if (bitmap1 == bitmapDT1) bitmap = flyBitmapTD[1];else if (bitmap1 == bitmapTH1) bitmap = flyBitmapTH[1];else if (bitmap1 == bitmapTSH1) bitmap = flyBitmapTSH[1];else if (bitmap1 == bitmapTS1) bitmap = flyBitmapTS[1];else if (bitmap1 == bitmapT1) bitmap = flyBitmapT[1];else if (bitmap1 == bitmapUsual1) bitmap = flyBitmapUsual[1];
                                birdX = (float) 353 / 1050;
                                birdY = (float) 238 / 540;
                                break;
                            case 3:
                                if (bitmap1 == bitmapDTSH1) bitmap = flyBitmapTDSH[2];else if (bitmap1 == bitmapDH1) bitmap = flyBitmapDH[2];else if (bitmap1 == bitmapDS1) bitmap = flyBitmapDS[2];else if (bitmap1 == bitmapD1) bitmap = flyBitmapD[2];else if (bitmap1 == bitmapH1) bitmap = flyBitmapH[2];else if (bitmap1 == bitmapSmile1) bitmap = flyBitmapSmile[2];else if (bitmap1 == bitmapSH1) bitmap = flyBitmapSH[2];else if (bitmap1 == bitmapDSH1) bitmap = flyBitmapSDH[2];else if (bitmap1 == bitmapS1) bitmap = flyBitmapS[2];else if (bitmap1 == bitmapDTH1) bitmap = flyBitmapTDH[2];else if (bitmap1 == bitmapDTS1) bitmap = flyBitmapTDS[2];else if (bitmap1 == bitmapDT1) bitmap = flyBitmapTD[2];else if (bitmap1 == bitmapTH1) bitmap = flyBitmapTH[2];else if (bitmap1 == bitmapTSH1) bitmap = flyBitmapTSH[2];else if (bitmap1 == bitmapTS1) bitmap = flyBitmapTS[2];else if (bitmap1 == bitmapT1) bitmap = flyBitmapT[2];else if (bitmap1 == bitmapUsual1) bitmap = flyBitmapUsual[2];
                                birdX = (float) 287 / 1050;
                                birdY = (float) 226 / 540;
                                break;
                            case 4:
                                if (bitmap1 == bitmapDTSH1) bitmap = flyBitmapTDSH[1];else if (bitmap1 == bitmapDH1) bitmap = flyBitmapDH[1];else if (bitmap1 == bitmapDS1) bitmap = flyBitmapDS[1];else if (bitmap1 == bitmapD1) bitmap = flyBitmapD[1];else if (bitmap1 == bitmapH1) bitmap = flyBitmapH[1];else if (bitmap1 == bitmapSmile1) bitmap = flyBitmapSmile[1];else if (bitmap1 == bitmapSH1) bitmap = flyBitmapSH[1];else if (bitmap1 == bitmapDSH1) bitmap = flyBitmapSDH[1];else if (bitmap1 == bitmapS1) bitmap = flyBitmapS[1];else if (bitmap1 == bitmapDTH1) bitmap = flyBitmapTDH[1];else if (bitmap1 == bitmapDTS1) bitmap = flyBitmapTDS[1];else if (bitmap1 == bitmapDT1) bitmap = flyBitmapTD[1];else if (bitmap1 == bitmapTH1) bitmap = flyBitmapTH[1];else if (bitmap1 == bitmapTSH1) bitmap = flyBitmapTSH[1];else if (bitmap1 == bitmapTS1) bitmap = flyBitmapTS[1];else if (bitmap1 == bitmapT1) bitmap = flyBitmapT[1];else if (bitmap1 == bitmapUsual1) bitmap = flyBitmapUsual[1];
                                birdX = (float) 230 / 1050;
                                birdY = (float) 232 / 540;
                                break;
                            case 5:
                                if (bitmap1 == bitmapDTSH1) bitmap = flyBitmapTDSH[2];else if (bitmap1 == bitmapDH1) bitmap = flyBitmapDH[2];else if (bitmap1 == bitmapDS1) bitmap = flyBitmapDS[2];else if (bitmap1 == bitmapD1) bitmap = flyBitmapD[2];else if (bitmap1 == bitmapH1) bitmap = flyBitmapH[2];else if (bitmap1 == bitmapSmile1) bitmap = flyBitmapSmile[2];else if (bitmap1 == bitmapSH1) bitmap = flyBitmapSH[2];else if (bitmap1 == bitmapDSH1) bitmap = flyBitmapSDH[2];else if (bitmap1 == bitmapS1) bitmap = flyBitmapS[2];else if (bitmap1 == bitmapDTH1) bitmap = flyBitmapTDH[2];else if (bitmap1 == bitmapDTS1) bitmap = flyBitmapTDS[2];else if (bitmap1 == bitmapDT1) bitmap = flyBitmapTD[2];else if (bitmap1 == bitmapTH1) bitmap = flyBitmapTH[2];else if (bitmap1 == bitmapTSH1) bitmap = flyBitmapTSH[2];else if (bitmap1 == bitmapTS1) bitmap = flyBitmapTS[2];else if (bitmap1 == bitmapT1) bitmap = flyBitmapT[2];else if (bitmap1 == bitmapUsual1) bitmap = flyBitmapUsual[2];
                                birdX = (float) 159 / 1050;
                                birdY = (float) 193 / 540;
                                break;
                            case 6:
                                bitmap = bitmap1;
                                birdX = (float)48/1050;
                                birdY = (float)218/540;
                                break;
                            case 7:
                                birdX = (float)60/1050;
                                birdY = (float)207/540;
                                laying = true;
                                flying = false;
                                if(bitmap1 == bitmapDTSH1 || bitmap1 == bitmapDSH1) bitmap = sleepDSH1;else if(bitmap1 == bitmapDTS1 || bitmap1 == bitmapDS1) bitmap = sleepDS1;else if(bitmap1 == bitmapDTH1 || bitmap1 == bitmapDH1) bitmap = sleepDH1;else if(bitmap1 == bitmapDT1 || bitmap1 == bitmapD1) bitmap = sleepD1;else if(bitmap1 == bitmapTSH1 || bitmap1 == bitmapSH1) bitmap = sleepSH1;else if(bitmap1 == bitmapTS1 || bitmap1 == bitmapS1) bitmap = sleepS1;else if(bitmap1 == bitmapTH1 || bitmap1 == bitmapH1) bitmap = sleepH1;else if(bitmap1 == bitmapT1 || bitmap1 == bitmapUsual1) bitmap = sleepUsual1;else if(bitmap1 == bitmapSmile1) bitmap = sleepSmile1;
                                sleepButtonBitmap = sleepDarkButtonBitmap[60];
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
                            if(bitmap1 == bitmapDTSH1 || bitmap1 == bitmapDSH1) bitmap = sleepDSH1;else if(bitmap1 == bitmapDTS1 || bitmap1 == bitmapDS1) bitmap = sleepDS1;else if(bitmap1 == bitmapDTH1 || bitmap1 == bitmapDH1) bitmap = sleepDH1;else if(bitmap1 == bitmapDT1 || bitmap1 == bitmapD1) bitmap = sleepD1;else if(bitmap1 == bitmapTSH1 || bitmap1 == bitmapSH1) bitmap = sleepSH1;else if(bitmap1 == bitmapTS1 || bitmap1 == bitmapS1) bitmap = sleepS1;else if(bitmap1 == bitmapTH1 || bitmap1 == bitmapH1) bitmap = sleepH1;else if(bitmap1 == bitmapT1 || bitmap1 == bitmapUsual1) bitmap = sleepUsual1;else if(bitmap1 == bitmapSmile1) bitmap = sleepSmile1;
                        }
                        if (!timeIsPassedSleep2 && checkSleep) {
                            new ThreadSleepBird2().start();
                            timeIsPassedSleep2 = true;
                        }
                        if (needToDrawNowSleep2 && checkSleep) {
                            if(bitmap1 == bitmapDTSH1 || bitmap1 == bitmapDSH1) bitmap = sleepDSH2;else if(bitmap1 == bitmapDTS1 || bitmap1 == bitmapDS1) bitmap = sleepDS2;else if(bitmap1 == bitmapDTH1 || bitmap1 == bitmapDH1) bitmap = sleepDH2;else if(bitmap1 == bitmapDT1 || bitmap1 == bitmapD1) bitmap = sleepD2;else if(bitmap1 == bitmapTSH1 || bitmap1 == bitmapSH1) bitmap = sleepSH2;else if(bitmap1 == bitmapTS1 || bitmap1 == bitmapS1) bitmap = sleepS2;else if(bitmap1 == bitmapTH1 || bitmap1 == bitmapH1) bitmap = sleepH2;else if(bitmap1 == bitmapT1 || bitmap1 == bitmapUsual1) bitmap = sleepUsual2;else if(bitmap1 == bitmapSmile1) bitmap = sleepSmile2;
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
                                flying = false;
                            } else {
                                sleepRight += qun;
                            }
                            qun /= (sleepRight2 - sleepLeft);
                            r1 = 0;
                        }
                    }
                    if(sleepFinished) {
                        sleeping = false;
                        laying = false;
                        flying = false;
                        if(!flyingBackTimeIsPassed){
                            new FlyingBackThread().start();
                            flyingBackTimeIsPassed = true;
                            flyingBack = true;
                        }
                        if(flyingBackNeedToDrawNow && flyingBack) {
                            switch (flyBack) {
                                case 1:
                                    bitmap = bitmap1;
                                    birdX = (float) 48 / 1050;
                                    birdY = (float) 218 / 540;
                                    break;
                                case 2:
                                    if (bitmap1 == bitmapDTSH1) bitmap = flyBitmapTDSH[4];
                                    else if (bitmap1 == bitmapDH1) bitmap = flyBitmapDH[4];
                                    else if (bitmap1 == bitmapDS1) bitmap = flyBitmapDS[4];
                                    else if (bitmap1 == bitmapD1) bitmap = flyBitmapD[4];
                                    else if (bitmap1 == bitmapH1) bitmap = flyBitmapH[4];
                                    else if (bitmap1 == bitmapSmile1) bitmap = flyBitmapSmile[4];
                                    else if (bitmap1 == bitmapSH1) bitmap = flyBitmapSH[4];
                                    else if (bitmap1 == bitmapDSH1) bitmap = flyBitmapSDH[4];
                                    else if (bitmap1 == bitmapS1) bitmap = flyBitmapS[4];
                                    else if (bitmap1 == bitmapDTH1) bitmap = flyBitmapTDH[4];
                                    else if (bitmap1 == bitmapDTS1) bitmap = flyBitmapTDS[4];
                                    else if (bitmap1 == bitmapDT1) bitmap = flyBitmapTD[4];
                                    else if (bitmap1 == bitmapTH1) bitmap = flyBitmapTH[4];
                                    else if (bitmap1 == bitmapTSH1) bitmap = flyBitmapTSH[4];
                                    else if (bitmap1 == bitmapTS1) bitmap = flyBitmapTS[4];
                                    else if (bitmap1 == bitmapT1) bitmap = flyBitmapT[4];
                                    else if (bitmap1 == bitmapUsual1) bitmap = flyBitmapUsual[4];
                                    birdX = (float) 159 / 1050;
                                    birdY = (float) 193 / 540;
                                    break;
                                case 3:
                                    if (bitmap1 == bitmapDTSH1) bitmap = flyBitmapTDSH[3];else if (bitmap1 == bitmapDH1) bitmap = flyBitmapDH[3];else if (bitmap1 == bitmapDS1) bitmap = flyBitmapDS[3];else if (bitmap1 == bitmapD1) bitmap = flyBitmapD[3];else if (bitmap1 == bitmapH1) bitmap = flyBitmapH[3];else if (bitmap1 == bitmapSmile1) bitmap = flyBitmapSmile[3];else if (bitmap1 == bitmapSH1) bitmap = flyBitmapSH[3];else if (bitmap1 == bitmapDSH1) bitmap = flyBitmapSDH[3];else if (bitmap1 == bitmapS1) bitmap = flyBitmapS[3];else if (bitmap1 == bitmapDTH1) bitmap = flyBitmapTDH[3];else if (bitmap1 == bitmapDTS1) bitmap = flyBitmapTDS[3];else if (bitmap1 == bitmapDT1) bitmap = flyBitmapTD[3];else if (bitmap1 == bitmapTH1) bitmap = flyBitmapTH[3];else if (bitmap1 == bitmapTSH1) bitmap = flyBitmapTSH[3];else if (bitmap1 == bitmapTS1) bitmap = flyBitmapTS[3];else if (bitmap1 == bitmapT1) bitmap = flyBitmapT[3];else if (bitmap1 == bitmapUsual1) bitmap = flyBitmapUsual[3];
                                    birdX = (float) 230 / 1050;
                                    birdY = (float) 232 / 540;
                                    break;
                                case 4:
                                    if (bitmap1 == bitmapDTSH1) bitmap = flyBitmapTDSH[4];else if (bitmap1 == bitmapDH1) bitmap = flyBitmapDH[4];else if (bitmap1 == bitmapDS1) bitmap = flyBitmapDS[4];else if (bitmap1 == bitmapD1) bitmap = flyBitmapD[4];else if (bitmap1 == bitmapH1) bitmap = flyBitmapH[4];else if (bitmap1 == bitmapSmile1) bitmap = flyBitmapSmile[4];else if (bitmap1 == bitmapSH1) bitmap = flyBitmapSH[4];else if (bitmap1 == bitmapDSH1) bitmap = flyBitmapSDH[4];else if (bitmap1 == bitmapS1) bitmap = flyBitmapS[4];else if (bitmap1 == bitmapDTH1) bitmap = flyBitmapTDH[4];else if (bitmap1 == bitmapDTS1) bitmap = flyBitmapTDS[4];else if (bitmap1 == bitmapDT1) bitmap = flyBitmapTD[4];else if (bitmap1 == bitmapTH1) bitmap = flyBitmapTH[4];else if (bitmap1 == bitmapTSH1) bitmap = flyBitmapTSH[4];else if (bitmap1 == bitmapTS1) bitmap = flyBitmapTS[4];else if (bitmap1 == bitmapT1) bitmap = flyBitmapT[4];else if (bitmap1 == bitmapUsual1) bitmap = flyBitmapUsual[4];
                                    birdX = (float) 287 / 1050;
                                    birdY = (float) 226 / 540;
                                    break;
                                case 5:
                                    if (bitmap1 == bitmapDTSH1) bitmap = flyBitmapTDSH[3];else if (bitmap1 == bitmapDH1) bitmap = flyBitmapDH[3];else if (bitmap1 == bitmapDS1) bitmap = flyBitmapDS[3];else if (bitmap1 == bitmapD1) bitmap = flyBitmapD[3];else if (bitmap1 == bitmapH1) bitmap = flyBitmapH[3];else if (bitmap1 == bitmapSmile1) bitmap = flyBitmapSmile[3];else if (bitmap1 == bitmapSH1) bitmap = flyBitmapSH[3];else if (bitmap1 == bitmapDSH1) bitmap = flyBitmapSDH[3];else if (bitmap1 == bitmapS1) bitmap = flyBitmapS[3];else if (bitmap1 == bitmapDTH1) bitmap = flyBitmapTDH[3];else if (bitmap1 == bitmapDTS1) bitmap = flyBitmapTDS[3];else if (bitmap1 == bitmapDT1) bitmap = flyBitmapTD[3];else if (bitmap1 == bitmapTH1) bitmap = flyBitmapTH[3];else if (bitmap1 == bitmapTSH1) bitmap = flyBitmapTSH[3];else if (bitmap1 == bitmapTS1) bitmap = flyBitmapTS[3];else if (bitmap1 == bitmapT1) bitmap = flyBitmapT[3];else if (bitmap1 == bitmapUsual1) bitmap = flyBitmapUsual[3];
                                    birdX = (float) 353 / 1050;
                                    birdY = (float) 238 / 540;
                                    break;
                                case 6:
                                    if (bitmap1 == bitmapDTSH1) bitmap = flyBitmapTDSH[4];else if (bitmap1 == bitmapDH1) bitmap = flyBitmapDH[4];else if (bitmap1 == bitmapDS1) bitmap = flyBitmapDS[4];else if (bitmap1 == bitmapD1) bitmap = flyBitmapD[4];else if (bitmap1 == bitmapH1) bitmap = flyBitmapH[4];else if (bitmap1 == bitmapSmile1) bitmap = flyBitmapSmile[4];else if (bitmap1 == bitmapSH1) bitmap = flyBitmapSH[4];else if (bitmap1 == bitmapDSH1) bitmap = flyBitmapSDH[4];else if (bitmap1 == bitmapS1) bitmap = flyBitmapS[4];else if (bitmap1 == bitmapDTH1) bitmap = flyBitmapTDH[4];else if (bitmap1 == bitmapDTS1) bitmap = flyBitmapTDS[4];else if (bitmap1 == bitmapDT1) bitmap = flyBitmapTD[4];else if (bitmap1 == bitmapTH1) bitmap = flyBitmapTH[4];else if (bitmap1 == bitmapTSH1) bitmap = flyBitmapTSH[4];else if (bitmap1 == bitmapTS1) bitmap = flyBitmapTS[4];else if (bitmap1 == bitmapT1) bitmap = flyBitmapT[4];else if (bitmap1 == bitmapUsual1) bitmap = flyBitmapUsual[4];
                                    birdX = (float) 419 / 1050;
                                    birdY = (float) 232 / 540;
                                    break;
                                case 7:
                                    bitmap = bitmap1;
                                    birdX = (float) 419 / 1050;
                                    birdY = (float) 232 / 540;
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
                    // loxanal
                    if(lastTouchX >= dirtButtonLeft && lastTouchX <= dirtButtonLeft + ButtonWidth && lastTouchY >= dirtButtonTop && lastTouchY <= dirtButtonTop + ButtonHeight && (dirtRight - dirtLeft <= dirtWeight / 2.) && !playing && !eating && !sleeping && !laying && !flying && !flyingBack && !hitting && !pooping && !flyPoop && !disgusting && !flyBackPoop) {
                        wa = true;
                    }
                    if(!washingTimeIsPassed && wa) {
                        new WashingThread().start();
                        washing = true;
                        washingTimeIsPassed = true;
                    }
                    if(washingNeedToDrawNow && washing && wash <= 25) {
                        birdX = (float) 414 / 1050;
                        birdY = (float) 31 / 540;
                        bitmap = washBitmap[wash];
                        if(wash == 10) dirtRight = dirtRight2;
                        if(wash == 25) {
                            washing = false;
                            wash = 1;
                            washingTimeIsPassed = false;
                            lastTouchY = 0;
                            lastTouchX = 0;
                            wa = false;
                            bitmap = bitmap1;
                            birdX = (float) 419/1050;
                            birdY = (float) 232/540;
                        }
                    }

                    // tprtal
                    for (int i = 1; i < 15; i++) {
                        hitBitmap[i] = Bitmap.createScaledBitmap(hitBitmap[i],(int)(canvas.getWidth() * birdWidth),(int)(canvas.getHeight()*birdHeight),true);
                    }
                    for (int i = 1; i < 15; i++) {
                        hitBitmapD[i] = Bitmap.createScaledBitmap(hitBitmapD[i],(int)(canvas.getWidth() * birdWidth),(int)(canvas.getHeight()*birdHeight),true);
                    }
                    for (int i = 1; i < 15; i++) {
                        hitBitmapH[i] = Bitmap.createScaledBitmap(hitBitmapH[i],(int)(canvas.getWidth() * birdWidth),(int)(canvas.getHeight()*birdHeight),true);
                    }
                    for (int i = 1; i < 15; i++) {
                        hitBitmapDH[i] = Bitmap.createScaledBitmap(hitBitmapDH[i],(int)(canvas.getWidth() * birdWidth),(int)(canvas.getHeight()*birdHeight),true);
                    }
                    if(lastTouchX >= (birdX * canvas.getWidth()) && lastTouchX <= (birdX + birdWidth)*(canvas.getWidth()) && lastTouchY >= (birdY*canvas.getHeight()) && lastTouchY <= (birdY + birdHeight)*(canvas.getHeight()) && !eating && !playing && !flying && !sleeping && !laying && !flyingBack && !washing && !pooping && !flyPoop && !disgusting && !flyBackPoop) {
                        hi = true;
                    }
                    if(!hitTimeIsPassed && hi) {
                        new HitThread().start();
                        hitting = true;
                        hitNeedToDrawNow = true;
                    }
                    if(hitNeedToDrawNow && hitting) {
                        if(bitmap1 == bitmapDH1 || bitmap1 == bitmapDTH1 || bitmap1 == bitmapDTSH1 || bitmap1 == bitmapDSH1) bitmap = hitBitmapDH[hit];
                        if(bitmap1 == bitmapD1 || bitmap1 == bitmapDT1 || bitmap1 == bitmapDTS1 || bitmap1 == bitmapDS1) bitmap = hitBitmapD[hit];
                        if(bitmap1 == bitmapH1 || bitmap1 == bitmapTH1 || bitmap1 == bitmapTSH1 || bitmap1 == bitmapSH1) bitmap = hitBitmapH[hit];
                        if(bitmap1 == bitmapUsual1 || bitmap1 == bitmapS1 || bitmap1 == bitmapT1 || bitmap1 == bitmapTS1 || bitmap1 == bitmapSmile1) bitmap = hitBitmap[hit];
                        if(hit >= 14) {
                            hitting = false;
                            hit = 1;
                            hi = false;
                            lastTouchY = 0;
                            lastTouchX = 0;
                        }
                    }
                    // screenshot
                    if(lastTouchX >= (screenshotX * canvas.getWidth()) && lastTouchX <= (screenshotX + screenshotWidth)*(canvas.getWidth()) && lastTouchY >= (screenshotY*canvas.getHeight()) && lastTouchY <= (screenshotY + screenshotHeight)*(canvas.getHeight())) {
                        takeScreenshot();
                        lastTouchY = 0;
                        lastTouchX = 0;
                    }
                    screenshotBitmap = Bitmap.createScaledBitmap(screenshotBitmap,canvas.getWidth() * 73/1050,canvas.getHeight()*73/540,true);
                    canvas.drawBitmap(screenshotBitmap, (float) canvas.getWidth() *screenshotX,(float) canvas.getHeight()*screenshotY,paint);
                    // cit
                    canvas.drawBitmap(bitmap,(float) canvas.getWidth() *birdX,(float) canvas.getHeight()*birdY,paint);
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
                sleep(1300);
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
                sleep(900);
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
                    sleep(100);
                    eat++;
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
                    sleep(100);
                    play++;
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
                    sleep(300);
                    sleep++;
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
                    sleep(300);
                    flyBack++;
                    flyingBackTimeIsPassed = false;
                    flyingBackNeedToDrawNow = true;
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    class WashingThread extends Thread{
        @Override
        public void run() {
            try {
                if(wash<25) {
                    sleep(100);
                    wash++;
                    washingTimeIsPassed = false;
                    washingNeedToDrawNow = true;
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
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
    class HitThread extends Thread{
        @Override
        public void run() {
            try {
                if(hit>=1 && hit <=5) {
                    hit+=2;
                }
                if(hit >=6 && hit <=14) {
                    sleep(10);
                    hit++;
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    class Minute extends Thread{
        @Override
        public void run() {
            try {
                sleep(120);
                pop = true;
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    class PoopThread extends Thread{
        @Override
        public void run() {
            try {
                if(poop1 <= 4) {
                    sleep(100);
                    poop1++;
                    poopingTimeIsPassed1 = false;
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    class PoopFlyThread extends Thread{
        @Override
        public void run() {
            try {
                if(poop2 < 6) {
                    sleep(300);
                    poopingTimeIsPassed2 = false;
                    poopingNeedToDrawNow2 = true;
                    poop2++;
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    class PoopFlyBackThread extends Thread{
        @Override
        public void run() {
            try {
                if(poop3 < 6) {
                    sleep(350);
                    poopingTimeIsPassed3 = false;
                    poopingNeedToDrawNow3 = true;
                    poop3++;
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    class DisgustThread extends Thread{
        @Override
        public void run() {
            try {
                if(disgust <= 10) {
                    sleep(300);
                    disgust++;
                    disgustingTimeIsPassed = false;
                    disgustingNeedToDrawNow = true;
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

