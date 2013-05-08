package org.italialinux.stringresourcesexample;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	
	private final static String TAG = "MainActivity";
	
	private int counter; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TextView myTv = (TextView) findViewById(R.id.textview1);
		myTv.setText(R.string.example);
		Button myButton = (Button) findViewById(R.id.button1);
		myButton.setOnClickListener(this);
		counter = 0;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {		
		String myString = getResources().getString(R.string.resourceexample);
		Log.i(TAG, "String is: " + R.string.resourceexample);		
		TextView myTv2 = (TextView) findViewById(R.id.textview2);
		myTv2.setText(myString + " " + counter);
		counter++;
	}

}
