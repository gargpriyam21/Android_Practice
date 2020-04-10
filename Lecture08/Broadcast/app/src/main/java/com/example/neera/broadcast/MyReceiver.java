package com.example.neera.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    public static final String TAG = "On recieve";

    @Override
    public void onReceive(Context context, Intent intent) {
        /*// TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        throw new UnsupportedOperationException("Not yet implemented");*/

        if (intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)) {

            Intent i = new Intent(context, BActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
            Toast.makeText(context, "Power Connected", Toast.LENGTH_SHORT).show();
        }

        if (intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)) {
            Toast.makeText(context, "Power Disconnected", Toast.LENGTH_SHORT).show();
        }

        if (intent.getAction().equals("Some.Intenet.Action")) {
            Log.d(TAG, "onReceive: Custom Broadcast Received !! ");
        }


    }
}
