package com.example.transition.activities;

import android.os.Bundle;

import com.example.transition.R;

/**
 * The activity used to display the splash screen.
 * @author Chris Logan
 *
 */
public class SplashActivity extends LoggableActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//XmlLogging.createLog();

		setContentView(R.layout.splash);

	}
}