package com.example.waterbottlecompanion;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            //Prepare a null fragment
            Fragment currentFragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_logs:
                    currentFragment = new LogsFragment();
                    break;
                case R.id.navigation_connect:
                    currentFragment = new ConnectFragment();
                    break;
                case R.id.navigation_sync:
                    //mTextMessage.setText(R.string.title_notifications);
                    break;
            }
            //transmits proper fragment
            FragmentManager fm = getSupportFragmentManager();
            if (currentFragment != null) {
                fm.beginTransaction()
                        .replace(R.id.fragment_container, currentFragment)
                        .commit();
                Log.d(TAG, "onNavigationItemSelected: loaded" + currentFragment.toString());
                return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
