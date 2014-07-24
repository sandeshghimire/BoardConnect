package com.example.boardconnect;

import java.util.ArrayList;
import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;



public class MainActivity extends ActionBarActivity {
	TextView connSSID;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		ArrayList<String> connDetails = new ArrayList<String>();
		
		super.onCreate(savedInstanceState);
		// remove title bar.
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
		connSSID = (TextView)findViewById(R.id.text_wifi);
		connDetails=getCurrentWiFi();
		connSSID.setText((String)connDetails.get(0));
		connSSID.setOnClickListener(new MyOnClickListener(connDetails));
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
	
	public ArrayList<String> getCurrentWiFi(){
		WifiManager wiFi;
		WifiInfo connInfo;
		ArrayList<String> connDetails = new ArrayList<String>();
		
		wiFi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
		connInfo = wiFi.getConnectionInfo();
		connDetails.add(connInfo.getSSID());
		connDetails.add(connInfo.getMacAddress());
		connDetails.add(Integer.toString(connInfo.getLinkSpeed()));
		
		return connDetails;
	}
	
	public class MyOnClickListener implements OnClickListener{
		ArrayList<String> connDetails;
		public MyOnClickListener(ArrayList<String> connDetails){
			this.connDetails=connDetails;
		}
		
		@Override
		public void onClick(View v) {
			Intent nextActivity = new Intent(MainActivity.this,
					ConnectionDetails.class);
			Bundle connData = new Bundle();
			connData.putStringArrayList("connData", connDetails);
			nextActivity.putExtras(connData);
			startActivity(nextActivity);
			MainActivity.this.finish();
		}
	}
	
}
