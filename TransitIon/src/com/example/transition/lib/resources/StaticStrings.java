package com.example.transition.lib.resources;

/**
 * This class stores all of the statically referenced strings which are resource independent such as: file paths, file headers, date/time layout format strings.
 * @author Chris Logan
 *
 */
public class StaticStrings {

	//file paths
	/**
	 * The root location of where all files will be written/read.
	 */
	public static final String ROOT = "\\mnt\\sdcard\\TransitIon";
	/**
	 * The location of where all the log files will be written/read.
	 */
	public static final String LOG_FILE_PATH = ROOT + "\\logs";
	/**
	 * The location of where all the layout files will be written/read.
	 */
	public static final String LAYOUT_FILE_PATH = ROOT + "\\layouts";
	
	//format strings
	/**
	 * The layout for each log filename.
	 */
	public static final String FILE_NAME_LAYOUT = "yyyy_MM_dd_hh:mm:ss";
	/**
	 * The layout for the timestamp for each log entry.
	 */
	public static final String TIME_LAYOUT = "hh:mm:ss.SSS";	
}
