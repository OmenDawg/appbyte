package com.alarmbyte.firstapp;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

/**
 * Created by dmiller on 19-Oct-2015.
 */
public class AlarmService extends IntentService {
    private NotificationManager notificationManager;
    public AlarmService(){
        super("AlarmService");
    }
    @Override
    public void onHandleIntent(Intent intent){
sendNotification("Wake up Damon");
    }
    public void sendNotification(String msg){
        Log.d("AlarmService","Preparing to send notifcation");
        notificationManager = (NotificationManager)this.getSystemService(Context.NOTIFICATION_SERVICE);
        PendingIntent contentIntent = PendingIntent.getActivity(this,0,new Intent(this,MainActivity.class),0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(
                this).setContentTitle("Alarm").setSmallIcon(R.mipmap.ic_launcher)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(msg))
                .setContentText(msg);
        builder.setContentIntent(contentIntent);
        notificationManager.notify(1, builder.build());
        Log.d("AlarmService", "Notification sent.");


    }
}
