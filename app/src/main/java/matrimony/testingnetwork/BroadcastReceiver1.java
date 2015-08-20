package matrimony.testingnetwork;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BroadcastReceiver1 extends BroadcastReceiver {

    public static String RECEIVER_KEY1="RECEIVER_KEY1";
    receiver1Listener mreceiver1Listener;

    public BroadcastReceiver1() {

    }
    public BroadcastReceiver1(Activity ac1) {
        try {
            mreceiver1Listener=(receiver1Listener)ac1;
        }

        catch (Exception e1)
        {
            e1.printStackTrace();
        }
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.v("In rec1", "received");
        String output=intent.getStringExtra("key");
        Log.v("In rec1", output);
        mreceiver1Listener.method1(output);

        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
       // throw new UnsupportedOperationException("Not yet implemented");
    }

    public interface receiver1Listener {
        public void method1(String str);

    }
}
