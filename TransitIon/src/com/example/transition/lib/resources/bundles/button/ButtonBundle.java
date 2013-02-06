package com.example.transition.lib.resources.bundles.button;

import java.util.ResourceBundle;

import com.example.transition.settings.AppConfig;

/**
 * Resource bundle to handle all the text for buttons.
 * @since 06/02/2013
 * @author Chris Logan
 *
 */
public class ButtonBundle {
	
	/**
	 * Static reference to the bundle to allow for retrieving of the text corresponding to the language specified by the current locale.
	 */
	private static ResourceBundle bundle = ResourceBundle.getBundle("com.example.transition.lib.resources.bundles.button.button", AppConfig.getCurrentLocale());
	
	/**
	 * Gets the text for the current language associated with "ok". <br>
	 * <ul>
	 * <li>English (default) - OK </li>
	 * </ul>
	 * @return A string with the inherent meaning of "OK" in the language of the current locale, or US by default.
	 */
	public static String ok(){ return bundle.getString("ok");}
}
