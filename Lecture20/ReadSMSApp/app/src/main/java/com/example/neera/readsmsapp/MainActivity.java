package com.example.neera.readsmsapp;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] projection = new String[]{
                Telephony.Sms.Inbox.BODY,
                Telephony.Sms.Inbox.ADDRESS,
                Telephony.Sms.Inbox._ID

        };

        Cursor smsInboxCursor = getContentResolver().query(
                Telephony.Mms.Inbox.CONTENT_URI,
                projection,
                null,
                null,
                Telephony.Sms.Inbox.DEFAULT_SORT_ORDER
        );
        Log.d("XXXXX", "" + smsInboxCursor.isBeforeFirst());

        int colIndexBody = smsInboxCursor.getColumnIndex(Telephony.Sms.Inbox.BODY);
        int colIndexDate = smsInboxCursor.getColumnIndex(Telephony.Sms.Inbox.DATE_SENT);
        int colIndexAddress = smsInboxCursor.getColumnIndex(Telephony.Sms.Inbox.ADDRESS);

        for (int i = 0; i < 5; i++) {
            smsInboxCursor.moveToNext();

            String body = smsInboxCursor.getString(colIndexBody);
            String address = smsInboxCursor.getString(colIndexAddress);
            long sentMillis = smsInboxCursor.getLong(colIndexDate);

            Toast.makeText(this, sentMillis + "\n" + address + ":" + body, Toast.LENGTH_SHORT).show();
        }

    }
}
