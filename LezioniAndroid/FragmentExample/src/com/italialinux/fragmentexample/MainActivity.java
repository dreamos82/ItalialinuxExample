package com.italialinux.fragmentexample;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        if(findViewById(R.id.fragment_container)!=null){
        	ChoiceFragment fragment = new ChoiceFragment();
        	Bundle bundle = new Bundle();
        	Log.i("TAG", "Is smartphone");
        	bundle.putBoolean("isTablet", false);
        	fragment.setArguments(bundle);
        	getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
        Log.i("TAG", "Not smartphone");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
