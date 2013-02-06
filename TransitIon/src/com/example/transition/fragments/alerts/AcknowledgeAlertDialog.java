package com.example.transition.fragments.alerts;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import com.example.transition.fragments.AbstractDialogFragment;
import com.example.transition.lib.resources.bundles.button.ButtonBundle;

/**
 * Alert dialog with a specific intended use of acknowledging the alert.
 * 
 * @since 06/02/2013
 * @author Chris Logan
 */
public class AcknowledgeAlertDialog extends AbstractDialogFragment{
	
	private String title;
	private String message;
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		//Use the {@link Builder} for convenient dialog construction
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		
		builder.setTitle(title)
				.setMessage(message)
				.setNeutralButton(ButtonBundle.ok(), new DialogInterface.OnClickListener()
					{
						@Override
						public void onClick(DialogInterface dialog, int which) {
							//LogInfo("UI", "User acknowledged message: " + message);
							acknowledge();
						}
						
					});
		
		return builder.create();
	}
	
	/**
	 * 
	 */
	private void acknowledge()
	{
		//TODO: perform acknowledge
	}
	
	public void setTitle(String t)
	{
		title = t;
	}
	
	public void setMessage(String m)
	{
		message = m;
	}

}
