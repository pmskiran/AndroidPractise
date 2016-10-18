package com.practice.upistuff;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TelephonyManager manager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        if(android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Log.i(getClass().getSimpleName(), "Single or Dula Sim "+manager.getPhoneCount());

            SubscriptionManager subscriptionManager = SubscriptionManager.from(this);
            List<SubscriptionInfo> subscriptionInfoList = subscriptionManager.getActiveSubscriptionInfoList();

            Log.i(getClass().getSimpleName(), "subscriptionInfoList cnt :: "+subscriptionInfoList.size());

            for(int i=0; i< subscriptionInfoList.size(); i++) {
                Log.i(getClass().getSimpleName(), "carrierName :: "+subscriptionInfoList.get(i).getCarrierName().toString());
            }
        }

        /*Log.i("OmSai ", "Defualt device ID "+manager.getDeviceId());
        Log.i("OmSai ", "Single 1 "+manager.getDeviceId(0));
        Log.i("OmSai ", "Single 2 "+manager.getDeviceId(1));*/

        ((Button) findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendSMSByIntent();
                //sendSMSByManager();
            }
        });

    }

    public void sendSMSByIntent() {
        Intent sendIntent = new Intent(Intent.ACTION_VIEW);
        sendIntent.setType("vnd.android-dir/mms-sms");
        sendIntent.putExtra("sms_body", "HI");
        sendIntent.putExtra("address", "83115409");
        startActivity(sendIntent);
    }

    public void sendSMSByManager() {
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage("83115409", null, "Hi, just testing..", null, null);
    }

}
