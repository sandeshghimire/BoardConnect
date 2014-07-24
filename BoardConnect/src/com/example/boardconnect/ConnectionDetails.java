package com.example.boardconnect;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

public class ConnectionDetails extends Activity {
	TextView connSSID;
	TextView connMAC;
	TextView connStrength;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// remove the title bar
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		// The layout file
		setContentView(R.layout.connection_details);
		connSSID = (TextView)findViewById(R.id.text_ssid);
		connMAC = (TextView)findViewById(R.id.text_mac);
		connStrength = (TextView)findViewById(R.id.text_strength);
		
		Bundle getConnData = getIntent().getExtras();
		ArrayList<String> connData = getConnData.getStringArrayList("connData");
		connSSID.setText((String)connData.get(0));
		connMAC.setText("MAC Address: " + (String)connData.get(1));
		connStrength.setText("Signal Strength: " + (String)connData.get(2) + "Mbps");
	}
}
