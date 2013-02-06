package com.example.transition.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.transition.R;
import com.example.transition.fragments.alerts.AcknowledgeAlertDialog;

/**
 * The activity used to display the splash screen.
 * @since 06/02/2013
 * @author Chris Logan
 */
public class SplashActivity extends AbstractLoggableFragmentActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		
		Button button = (Button) findViewById(R.id.button);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				popAlert();
			}
		});
	}	
	
	private void popAlert()
	{
		AcknowledgeAlertDialog aad = new AcknowledgeAlertDialog();
		aad.setTitle("Alert!");
		aad.setMessage("You have pressed that which should not be pressed!");
		aad.show(getSupportFragmentManager(), "alert");

	}
}