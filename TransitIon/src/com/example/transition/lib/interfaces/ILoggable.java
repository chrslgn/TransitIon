package com.example.transition.lib.interfaces;

import com.example.transition.lib.enums.LogLevel;

/**
 * Interface used to conform all classes to have the same methods for logging.
 * @since 06/02/2013
 * @author Chris Logan
 *
 */
public interface ILoggable {

	/**
	 * Used to log {@link LogLevel#ERROR} issues.
	 * @param tag The associated reason for calling the logger.
	 * @param msg The content/message to be logged.
	 */
	public void LogError(String tag, String msg);

	/**
	 * Used to log {@link LogLevel#WARN} issues.
	 * @param tag The associated reason for calling the logger.
	 * @param msg The content/message to be logged.
	 */
	public void LogWarn(String tag, String msg);

	/**
	 * Used to log {@link LogLevel#INFO} issues.
	 * @param tag The associated reason for calling the logger.
	 * @param msg The content/message to be logged.
	 */
	public void LogInfo(String tag, String msg);

	/**
	 * Used to log {@link LogLevel#DEBUG} issues.
	 * @param tag The associated reason for calling the logger.
	 * @param msg The content/message to be logged.
	 */
	public void LogDebug(String tag, String msg);

}
