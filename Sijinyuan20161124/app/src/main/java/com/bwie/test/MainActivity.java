package com.bwie.test;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;
/**
 * autour: 佀晋元
 * date: 2016/11/25 13:35 
 * update: 2016/11/25
 * version: 
 */


public class MainActivity extends AppCompatActivity {
    private int time=3;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            tv.setText(time+"秒");
        }
    };
    private Timer timer=new Timer();
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=(TextView)findViewById(R.id.dao);
        //定时器
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (time == 0) {
                    timer.cancel();
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    startActivity(intent);
                    finish();
                } else {


                    time--;

                    handler.sendEmptyMessage(0);

                }
            }
        }, 0, 1000);

    }}
