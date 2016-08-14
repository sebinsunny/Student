package com.production.jpsc.student;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import com.parse.ParsePushBroadcastReceiver;

/**
 * Created by Sebin on 2016-08-05.
 */
public class PushBroadcastReceiver extends ParsePushBroadcastReceiver {

    @Override
    protected Notification getNotification(Context context, Intent intent) {
        Notification notification = super.getNotification(context, intent);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            notification.color = context.getResources().getColor(R.color.colorPrimary);


        }
        return notification;
    }
}