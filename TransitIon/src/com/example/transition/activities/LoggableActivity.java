package com.example.transition.activities;

import android.app.Activity;
import android.util.Log;

import com.example.transition.lib.enums.LogLevel;
import com.example.transition.lib.fileio.XmlLogging;
import com.example.transition.lib.interfaces.ILoggable;

/**
 * The abstract class that allows for all activity classes to have an inherited call to the logger to be executed the same way every time. <br>
 * THESE METHODS ARE NOT TO INTENDED TO BE OVERWRITTEN!
 * @author Chris Logan
 *
 */
public abstract class LoggableActivity extends Activity implements ILoggable {

	public void LogError(String tag, String msg)
	{
		Log.e(tag, msg);
		XmlLogging.log(LogLevel.ERROR, tag, msg);
	}

	public void LogWarn(String tag, String msg)
	{
		Log.w(tag, msg);
		XmlLogging.log(LogLevel.WARN, tag, msg);
	}

	public void LogInfo(String tag, String msg)
	{
		Log.i(tag, msg);
		XmlLogging.log(LogLevel.INFO, tag, msg);
	}

	public void LogDebug(String tag, String msg)
	{
		Log.d(tag, msg);
		XmlLogging.log(LogLevel.DEBUG, tag, msg);
	}

}