package com.example.transition.settings;

import com.example.transition.lib.enums.LogLevel;

/**
 * This class holds all of the configurations and settings of the app during runtime.
 * @author Chris Logan
 *
 */
public class AppConfig {

	/**
	 * Stores the log level. Defaults to {@link LogLevel#DEBUG} for maximum verbosity on start up and gets set when settings load.
	 */
	private static LogLevel logLevel = LogLevel.DEBUG;
	
	/**
	 * Determines if the {@link LogLevel} provided is allowed to be logged.
	 * @param level The level attempting to be logged.
	 * @return True if the level is at or above the current log level. False if this level of logging is not allowed.
	 */
	public static boolean allowLogging(LogLevel level) {
		return logLevel.getLevel() >= level.getLevel();
	}


}
