package com.example.boardconnect;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;

/*
 * First Activity.
 */
public class SplashScreenActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// remove the title bar
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		// The layout file
		setContentView(R.layout.activity_splash_screen);
		// Set the Main Activity after 4 seconds
		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				// The Main Activity
				Intent nextActivity = new Intent(SplashScreenActivity.this,
						MainActivity.class);
				startActivity(nextActivity);

				// Close the Splash Screen Activity
				SplashScreenActivity.this.finish();
			}
		};

		// Schedule a task for single execution after a specified delay.
		// Show splash screen for 4 seconds
		new Timer().schedule(task, 4000);

	}

}
