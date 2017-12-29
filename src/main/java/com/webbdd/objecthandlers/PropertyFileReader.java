package com.webbdd.objecthandlers;

import java.io.File;
import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.junit.Assert;

public class PropertyFileReader {
	private static final Logger log = Logger.getLogger(PropertyFileReader.class);
	public static final String strRootDir = System.getProperty("user.dir");
	public static String strReturnVal = null;

	/**
	 * @author : Abhilash G
	 * @description : This function is used to fetch the project config value
	 *              from the config.properties file in the project
	 * @param : strVarName
	 * @dateCreated on : Nov 30 2017
	 * @updated On :
	 */
	public static String funcFetchConfigValue(String strVarName) {
		try {
			File file = null;
			strVarName = strVarName.replace(" ", "_");
			file = new File(strRootDir + "/Resources/config.properties");
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);
			fileInput.close();

			Enumeration<?> enuKeys = properties.keys();
			while (enuKeys.hasMoreElements()) {
				strReturnVal = properties.getProperty(strVarName);
				if (strReturnVal != null) {
					break;
				}
			}
		} catch (Exception e) {
			log.info(e);
			Assert.fail("Property is not defined for : " + strVarName);
		}
		return strReturnVal;
	}
}
