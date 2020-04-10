package me.rishabhkhanna.broadcasts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    public static final String TAG = "Receiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)){
            Intent i = new Intent(context,MainActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
            Toast.makeText(context, "Power Connected", Toast.LENGTH_SHORT).show();
        }
        if(intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)){
            Toast.makeText(context, "Power Disconnected", Toast.LENGTH_SHORT).show();
        }

        if(intent.getAction().equals("some.Intent.Action")){
            Log.d(TAG, "onReceive: Custom Broadcast Received !! ");
        }
    }
}
