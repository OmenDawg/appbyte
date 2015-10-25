package com.alarmbyte.firstapp;

import javazoom.jl.decoder.JavaLayerError;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import
import android.content.res.AssetManager;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TimePicker;
import android.widget.ToggleButton;
import android.widget.TextView;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;


import java.io.IOException;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    AlarmManager alarmManager;
    AlarmReceiver alarmReceiver;
    PendingIntent pendingIntent;
    Intent myIntent;
    private TimePicker timePicker;
    private TextView textView;
    private static MainActivity inst;


    public static MainActivity instance() {
        return inst;
    }

    @Override
    public void onStart() {
        super.onStart();
        inst = this;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timePicker = (TimePicker) findViewById(R.id.timePickerAlarm);
        textView = (TextView) findViewById(R.id.textViewAlarm);

    }

    public void onStop(View view) {
        alarmManager.cancel(pendingIntent);
    }

    public void onToggleClicked(View view) {
        if (((ToggleButton) view).isChecked()) {

            String mp3File = "Angel Sword (Salvation).mp3";
            AssetManager assetMan = getAssets();
            try {
                FileInputStream mp3Stream = assetMan.openFd(mp3File).createInputStream();
                BufferedInputStream bis = new BufferedInputStream(mp3Stream);
                try {
                    Player player = new Player(bis);
                    player.play();
                } catch (JavaLayerException jle) {
                    Log.d("JL: ", jle.toString());
                }

            } catch (IOException ie) {
                Log.d("IO: ", ie.toString());
            }
            //BufferedInputStream bis = new BufferedInputStream(mp3Stream);

//Player player = new Player(bis);
            //player.play();

//            Calendar calendar = Calendar.getInstance();
//            calendar.set(Calendar.HOUR_OF_DAY, timePicker.getCurrentHour());
//            calendar.set(Calendar.MINUTE, timePicker.getCurrentMinute());
//            myIntent = new Intent(getApplicationContext(), AlarmReceiver.class);
//            pendingIntent = PendingIntent.getBroadcast(getBaseContext(), 0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
//            alarmManager = (AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE);
//            alarmManager.set(AlarmManager.RTC_WAKEUP, 0, pendingIntent);
//            setAlarmText("Alarm On");
//            Log.d("MyActivity", "Alarm On");
        } else {
//            Calendar cal = Calendar.getInstance();
//            cal.set(Calendar.HOUR_OF_DAY, timePicker.getCurrentHour());
//            cal.set(Calendar.MINUTE, timePicker.getCurrentMinute());
//            myIntent = new Intent(getApplicationContext(), AlarmReceiver.class);
//            pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
//            alarmManager = (AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE);
//            alarmManager.set(AlarmManager.RTC_WAKEUP, 0, pendingIntent);
//            alarmManager.cancel(pendingIntent);
//            //alarmReceiver.stopRingTone();
//            setAlarmText("Alarm Off");
//            Log.d("MyActivity", "Alarm Off");
        }
    }

    public void setAlarmText(String alarmText) {
        textView.setText((alarmText));
    }
}
