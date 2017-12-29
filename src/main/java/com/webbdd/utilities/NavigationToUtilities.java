package com.webbdd.utilities;

import com.webbdd.objecthandlers.PropertyFileReader;

public class NavigationToUtilities {
	
	public static void NavLaunchUrl(String strURL) {
		strURL = PropertyFileReader.funcFetchConfigValue(strURL);
		ActionUtilities.funcLaunchURL(strURL);
	}
}
