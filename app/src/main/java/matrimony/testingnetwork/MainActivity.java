package matrimony.testingnetwork;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements BroadcastFragment.OnFragmentInteractionListener,BroadcastReceiver1.receiver1Listener,BroadcastReceiver2.receiver2Listener{

    BroadcastReceiver1 mbroadcastr1;
    BroadcastReceiver2 mbroadcastr2;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mbroadcastr1= new BroadcastReceiver1(this);
        mbroadcastr2=new BroadcastReceiver2(this);
/*
        String url = "http://www.vogella.com";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);*/

        BroadcastFragment fragment = BroadcastFragment.newInstance("Sample String 1","Sample String 2");
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.parent, fragment, "Tag1");
        transaction.addToBackStack(null);
        transaction.commit();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
    }

    @Override
    protected void onResume(){
        super.onResume();

        IntentFilter filterReceiver1 = new IntentFilter(Intent.ACTION_DEFAULT  /*BroadcastReceiver1.RECEIVER_KEY1*/);
        IntentFilter filterReceiver2 = new IntentFilter(Intent.ACTION_DEFAULT /*BroadcastReceiver2.RECEIVER_KEY2*/);
        filterReceiver1.addCategory(Intent.CATEGORY_DEFAULT);
        filterReceiver2.addCategory(Intent.CATEGORY_DEFAULT);
        registerReceiver(mbroadcastr1,filterReceiver1);
        registerReceiver(mbroadcastr2, filterReceiver2);
    }

    public  void onPause()
    {
        super.onPause();
        unregisterReceiver(mbroadcastr1);
        unregisterReceiver(mbroadcastr2);
    }

    @Override
    public void method1(String str) {

        Toast.makeText(getApplicationContext(),"in method1 "+ str, Toast.LENGTH_SHORT).show();
        FragmentManager manager= getSupportFragmentManager();
        BroadcastFragment fragment= (BroadcastFragment)manager.findFragmentByTag("Tag1");
        fragment.changedText1(str);
    }

    @Override
    public void method2(String output) {

        Toast.makeText(getApplicationContext(),"in method2 "+ output, Toast.LENGTH_SHORT).show();
        FragmentManager manager= getSupportFragmentManager();
        BroadcastFragment fragment= (BroadcastFragment)manager.findFragmentByTag("Tag1");
        fragment.changedText2(output);

    }
}
