package matrimony.testingnetwork;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BroadcastReceiver2 extends BroadcastReceiver {
    public static String RECEIVER_KEY2="RECEIVER_KEY2";
    public BroadcastReceiver2(Activity ac2) {
        try {
            mreceiver2Listener=(receiver2Listener)ac2;
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.v("In rec2", "recieved");
        String output=intent.getStringExtra( "key"/*"Ki"*/);
        if(output==null)
        {
            output = "Returned null";
        }
        Log.v("In rec2", output);
        mreceiver2Listener.method2(output);
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
       // throw new UnsupportedOperationException("Not yet implemented");
    }

    public interface receiver2Listener {

        public void method2(String output);

    }
    receiver2Listener mreceiver2Listener;
}
