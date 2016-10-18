package com.practice.gcm;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.gcm.GcmListenerService;

/**
 * Created by spartans on 29/9/16.
 */

public class MyGcmListenerService extends GcmListenerService {

    @Override
    public void onMessageReceived(String s, Bundle data) {
        super.onMessageReceived(s, data);
        String message = data.getString("message");
        Log.d(getClass().getSimpleName(), "Message: " + message);
    }
}
