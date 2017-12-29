package com.webbdd.utilities;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.webbdd.base.BrowserManager;

public class ActionUtilities {
	public static WebDriver driver = BrowserManager.funcGetWebdriver();
	private static final Logger log = Logger.getLogger(ActionUtilities.class);

	/**
	 * @author : Abhilash G
	 * @Date : 30/11/2017
	 * @Description : This function is to lauch the URL which we are passing in the config property file
	 * @param : strURL
	 */
	public static void funcLaunchURL(String strURL) {
		driver.get(strURL);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		log.info("Application launched successfully");
	}
}
