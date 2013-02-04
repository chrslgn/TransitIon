package com.example.transition.lib.fileio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.xmlpull.v1.XmlSerializer;

import android.os.Environment;
import android.util.Xml;

import com.example.transition.lib.enums.LogLevel;
import com.example.transition.lib.resources.StaticStrings;
import com.example.transition.settings.AppConfig;

/**
 * This class is used for logging. It creates a log, then writes to it in an XML format, dependent on the debug level allowed by {@link AppConfig#allowLogging(LogLevel)}. 
 * @author Chris Logan
 *
 */
public class XmlLogging {

	/**
	 * Formatter to be used for the current time at which the log is being written to.
	 */
	private static final SimpleDateFormat TIME_STAMP_FORMATTER = new SimpleDateFormat(StaticStrings.TIME_LAYOUT, Locale.US); 

	/**
	 * {@link Calendar} instance which allows for the current date and time to be obtained for the purposes of naming the log file and providing the times that the logs are written.
	 */
	private static Calendar calendar = Calendar.getInstance();
	
	/**
	 * Private member variable to hold the name of the log file during runtime. 
	 */
	private static String fileName;
	
	/**
	 * Simple boolean checker to ensure that the log file has been created.
	 */
	private static boolean fileExists = false;
	
	/**
	 * Serializer used to write the log in an XML format.
	 */
	private static XmlSerializer serializer = Xml.newSerializer();
	
	/**
	 * A writer to the log file which is required by {@link XmlSerializer#setOutput(java.io.Writer)}. 
	 */
	private static FileWriter fileWriter;


	/**
	 * Creates the log file and initializes {@link XmlLogging#serializer} to prepare for writing to file.
	 */
	public static void createLog()
	{
		//check that there is an sdcard to store the log files
		if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) == false)
		{
			//TODO: display error message to user that the sd card is unaccessible and that logging will not work
			return;
		}		

		//format the filename 
		fileName = new SimpleDateFormat(StaticStrings.FILE_NAME_LAYOUT, Locale.US).format(new Date()) + ".xml"; 

		//if the file path for the logs does not exist then create it
		if ((new File(StaticStrings.LOG_FILE_PATH)).exists() == false)
			(new File(StaticStrings.LOG_FILE_PATH)).mkdir();

		try {
			fileWriter = new FileWriter(new File(StaticStrings.LOG_FILE_PATH, fileName), true);
			serializer.setOutput(fileWriter);
			serializer.startDocument("UTF-8", true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Writes to the log file.
	 * @param level The {@link LogLevel} of the content that is being logged.
	 * @param tag A notifying tag of as to what reason the content is being logged. 
	 * @param msg The message content that is being logged.
	 */
	public static void log(LogLevel level, String tag, String msg)
	{
		if(AppConfig.allowLogging(level) == false)
			return;
		
		//if the file doesn't exist at this point in the code, then create it
		if(fileExists == false)
			createLog();
		
		
		try {
			//create event node
			serializer.startTag("", "LogEvent");

			//create timestamp node
			serializer.startTag("", "Timestamp");
			serializer.attribute("", "Epoch", "" + getNowEpoch()); //add epoch milliseconds for machine use if needed 
			serializer.text(getNowFormatted());
			serializer.endTag("", "Timestamp");

			//create error level node
			serializer.startTag("", "Level");
			serializer.text(level.getType());
			serializer.endTag("", "Level");

			//create tag node
			serializer.startTag("", "Tag");
			serializer.text(tag);
			serializer.endTag("", "Tag");

			//create msg node
			serializer.startTag("", "Message");
			serializer.text(msg);
			serializer.endTag("", "Message");

			//end event node
			serializer.endTag("", "LogEvent");

		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Gets the current time as formatted by {@link XmlLogging#TIME_STAMP_FORMATTER}.
	 * @return The current time in a formatted layout.
	 */
	private static String getNowFormatted()
	{
		return TIME_STAMP_FORMATTER.format(calendar.getTime());
	}

	/**
	 * Gets the current time following {@link Calendar#getTimeInMillis()} as a string.
	 * @return The string of the current time in milliseconds since the epoch.
	 */
	private static String getNowEpoch()
	{
		return Long.toString(calendar.getTimeInMillis());
	}

	/**
	 * Ends and closes the log file.
	 */
	public static void closeLog()
	{
		try {
			serializer.endDocument();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
