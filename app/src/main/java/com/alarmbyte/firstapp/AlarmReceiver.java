package com.alarmbyte.firstapp;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.content.WakefulBroadcastReceiver;


/**
 * Created by dmiller on 19-Oct-2015.
 */
public class AlarmReceiver extends WakefulBroadcastReceiver {
    public Ringtone ringtone ;
    public RingtoneManager ringToneManager;
    public String sample;

    public AlarmReceiver() {
        sample = "test";
    }
    public void stopRingTone(){
        ringtone.stop();
    }
    @Override
    public void onReceive(final Context context, Intent intent) {
        //this will update the UI with message
        MainActivity inst = MainActivity.instance();
        inst.setAlarmText("Damon Alarm! Going Off!");
        //ringToneManager = new  RingtoneManager(MainActivity.instance().getCallingActivity(),context);
        //this will sound the alarm tone
        //this will sound the alarm once, if you wish to
        //raise alarm in loop continuously then use MediaPlayer and setLooping(true)
        Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        if (alarmUri == null) {
            alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        }
        ringtone = RingtoneManager.getRingtone(context, alarmUri);
        ringtone.play();
        //this will send a notification message
        ComponentName comp = new ComponentName(context.getPackageName(),
                AlarmService.class.getName());
        startWakefulService(context, (intent.setComponent(comp)));
        inst.setAlarmText("Alarm! Wake up! Wake up!");
        setResultCode(Activity.RESULT_OK);
    }


}
