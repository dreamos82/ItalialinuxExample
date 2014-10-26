package com.italialinux.sqliteexample;

import java.util.List;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.italialinux.sqliteexample.data.DatabaseHelper;
import com.italialinux.sqliteexample.data.model.Contact;



public class MainActivity extends ActionBarActivity {
	private static final String TAG = "MainActivity";

	DatabaseHelper helper;
	
	SharedPreferences prefs = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefs = getSharedPreferences("com.italialinux.sqliteexample", MODE_PRIVATE);
        helper = new DatabaseHelper(this);
        if(prefs.getBoolean("firstrun", true)){
        	prefs.edit().putBoolean("firstrun", false).commit();
        	populate_contacts();
        }
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment(helper))
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment implements OnClickListener{
    	DatabaseHelper helper;

        public PlaceholderFragment(DatabaseHelper helper) {
        	this.helper = helper;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            Button btn = (Button)rootView.findViewById(R.id.button1);
            btn.setOnClickListener(this);
            return rootView;
        }

		@Override
		public void onClick(View v) {
			Log.i("InnerFragment", "Clicked button");
			TextView tv = (TextView)getView().findViewById(R.id.textView1);
			List<Contact> contactset = helper.getAllContacts();
			String output = "";
			for(Contact contact: contactset){
				output += contact.getId() + "Name: " + contact.getContact_name() + " Number: " + contact.getNumber() + "\n";
			}
			tv.setText(output);
		}
    }
    
    public void populate_contacts(){
    	Log.i(TAG, "Populating content values");
    	if(helper!=null){
    		Contact contact1 = new Contact("italialinux site", "+391234567");
    		Contact contact2 = new Contact("osdev site", "+391234567");
    		Contact contact3 = new Contact("Rossi mario", "+441234567");
    		Contact contact4 = new Contact("Lucky Leprechanus", "+3531234567");
    		helper.insertContact(contact1);
    		helper.insertContact(contact2);
    		helper.insertContact(contact3);
    		helper.insertContact(contact4);
    	}
    	
    }
}
