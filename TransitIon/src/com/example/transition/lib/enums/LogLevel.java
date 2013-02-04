package com.example.transition.lib.enums;

import android.util.Log;

/**
 * Enumeration to hold the log level (as int) and the log type (as string). <br> 
 * This style of logging is following <a href="http://logging.apache.org/log4j/1.2/manual.html">Apache</a> with the notable differences
 * being that the Trace level has been rolled into Debug and that the Fatal level has been rolled into Error in order to better align with Android native style logging using {@link Log}. <br>
 * <br>
 * The levels logging used based on verbosity from most verbose to least verbose are: <br>
 * <ol> 
 * <li>{@link LogLevel#DEBUG} = DBG</li>
 * <li>{@link LogLevel#INFO} = NFO</li>
 * <li>{@link LogLevel#WARN} = WRN</li>
 * <li>{@link LogLevel#ERROR} = ERR</li>
 * </ol> 
 * 
 * @author Chris Logan
 *
 */
public enum LogLevel {

	/**
	 * Most verbose level of logging. Used to log the flow within methods and values. <br>
	 * Intended use for debugging and testing.
	 */
	DEBUG(1),

	/**
	 * Second most verbose level of logging. Used to log the entrance into or exit out of sections of code in order to give a basic flow outline of the code at runtime. <br>
	 * Intended use for tracing and reporting UI actions. 
	 */
	INFO(2),

	/**
	 * Second least verbose level of logging. Used to log potential trouble spots and recoverable errors. <br>
	 * Intended use for unstable but handleable or anticipated errors or exceptions. 
	 */
	WARN(3),

	/**
	 * Least verbose level of logging. Used to log fatal and unrecoverable errors. <br>
	 * Intended use for errors or exceptions that may cause a crash or require a restart. 
	 */
	ERROR(4);

	/**
	 * Each level has a numeric value to allow for ease of comparisons. <br>
	 * <ol> 
	 * <li>{@link LogLevel#DEBUG} = DBG</li>
	 * <li>{@link LogLevel#INFO} = NFO</li>
	 * <li>{@link LogLevel#WARN} = WRN</li>
	 * <li>{@link LogLevel#ERROR} = ERR</li>
	 * </ol> 
	 */
	private int level;

	/**
	 * Human readable 3 character value, intended for logging purposes. <br>
	 * <ol> 
	 * <li>{@link LogLevel#DEBUG} = DBG</li>
	 * <li>{@link LogLevel#INFO} = NFO</li>
	 * <li>{@link LogLevel#WARN} = WRN</li>
	 * <li>{@link LogLevel#ERROR} = ERR</li>
	 * </ol>
	 */
	private String type;

	/**
	 * Private constructor for the elements in the enum.
	 * @param lvl The {@link LogLevel#level} value for the constructed enum.
	 */
	private LogLevel(int lvl)
	{
		level = lvl;
		switch(level)
		{
		case 1: type = "DBG"; break;
		case 2: type = "NFO"; break;
		case 3: type = "WRN"; break;
		case 4: type = "ERR"; break;
		}
	}

	/**
	 * Getter for the numerical value associated with the enum.
	 * @return The {@link LogLevel#level} value stored during construction. 
	 */
	public int getLevel()
	{
		return level;
	}

	/**
	 * Getter for the string value associated with the enum.
	 * @return The {@link LogLevel#type} value stored during construction.  
	 */
	public String getType()
	{
		return type;
	}
}
