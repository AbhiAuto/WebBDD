
package com.webbdd.base;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.webbdd.objecthandlers.PropertyFileReader;

/**
 * @Author Abhilash G
 * @Date 24-11-2017
 * @Description
 */
public class BrowserManager {

	public static String BrowserDriver = null;
	public static WebDriver driver = null;
	public static String strBrowserName = null;
	private static final Logger log = Logger.getLogger(BrowserManager.class);
	
	/**
	 * @author : Abhilash G
	 * @Date : 30/11/2017
	 * @Description : This function is to lauch various broswers like Chrome, firefox, Mozilla, IE etc
	 * @param : browserName
	 */
	public static WebDriver funcGetWebdriver() {
		try {
			strBrowserName = PropertyFileReader.funcFetchConfigValue("browserName");
			if (strBrowserName==null  || strBrowserName.equals(" ")) {
				log.info("Browser name is null, please check the value browserName of in config.properties");
				System.exit(0);
			} else {
				log.info("Browser : " + strBrowserName);
				strBrowserName = strBrowserName.toLowerCase();

				switch(strBrowserName) {

				case "chrome":
						
					System.setProperty("webdriver.chrome.driver", "./Resources/Drivers/chromedriver.exe");
						
					Map<String, Object> prefs = new HashMap<String, Object>();

					// To Turns off multiple download warning
					prefs.put("profile.default_content_settings.popups", 0);
					prefs.put("profile.content_settings.pattern_pairs.*.multiple-automatic-downloads", 1);

					// Turns off download prompt
					prefs.put("download.prompt_for_download", false);
					prefs.put("credentials_enable_service", false);

					// To stop Save password propmts
					prefs.put("password_manager_enabled", false);

					ChromeOptions options = new ChromeOptions();
					options.addArguments("chrome.switches", "--disable-extensions");

					// To Disable any browser notifications
					options.addArguments("--disable-notifications");

					// To disable yellow strip info bar which prompts info
					// messages
					options.addArguments("disable-infobars");
					options.setExperimentalOption("prefs", prefs);
					options.addArguments("--test-type");

					driver = new ChromeDriver(options);
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		return driver;
	}
}