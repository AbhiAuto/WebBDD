package com.webbdd.objecthandlers;

import java.io.File;
import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.junit.Assert;

public class ObjectRepositoryManager {
	// Public and private variable declarations.
	public static final String propertyFilePath = null;
	private static final Logger log = Logger.getLogger(PropertyFileReader.class);
	public static final String strRootDir = System.getProperty("user.dir");
	public static String strReturnVal = null;

	/**
	 * @author : Abhilash G
	 * @description : This function is used to fetch the Web object property
	 *              value from the WebObjectRepository.properties file in the
	 *              project
	 * @param : strVarName
	 * @dateCreated on : Nov 30 2017
	 * @updated On :
	 */
	public static String funcfetchWebObjProperties(String strVarName) {
		try {
			File file = null;
			String strName = null;
			strVarName = strVarName.replace(" ", "_");
			file = new File(strRootDir + "/Resources/ObjectRepository/WebRepo/WebObjectRepository.properties");
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);
			fileInput.close();

			Enumeration<?> enuKeys = properties.keys();
			while (enuKeys.hasMoreElements()) {
				Enumeration<?> enuVarNames = properties.propertyNames();
				Object eleName = enuVarNames.nextElement();
				strName = eleName.toString();
				if (strName.contains(strVarName)) {
					strReturnVal = properties.getProperty(strName);
					if (strReturnVal != null) {
						break;
					}
				}
			}

			strReturnVal =  strName + ":" + strReturnVal;

		} catch (Exception e) {
			log.info(e);
			Assert.fail("Property is not defined for : " + strVarName);
		}
		return strReturnVal;
	}

	/**
	 * @author : Abhilash G
	 * @description : This function is used to fetch the Mobile object property
	 *              value from the MobileObjectRepository.properties file in the
	 *              project
	 * @param : strVarName
	 * @dateCreated on : Nov 30 2017
	 * @updated On :
	 */
	public static String funcfetchMobileObjProperties(String strVarName) {
		try {
			File file = null;
			String strName = null;
			strVarName = strVarName.replace(" ", "_");
			file = new File(strRootDir + "/Resources/ObjectRepository/WebRepo/MobileObjectRepository.properties");
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);
			fileInput.close();

			Enumeration<?> enuKeys = properties.keys();
			while (enuKeys.hasMoreElements()) {
				Enumeration<?> enuVarNames = properties.propertyNames();
				Object eleName = enuVarNames.nextElement();
				strName = eleName.toString();
				if (strName.contains(strVarName)) {
					strReturnVal = properties.getProperty(strName);
					if (strReturnVal != null) {
						break;
					}
				}
			}

			strReturnVal =  strName + ":" + strReturnVal;

		} catch (Exception e) {
			log.info(e);
			Assert.fail("Property is not defined for : " + strVarName);
		}
		return strReturnVal;
	}
}
