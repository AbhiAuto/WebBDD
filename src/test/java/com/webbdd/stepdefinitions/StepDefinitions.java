package com.webbdd.stepdefinitions;

import java.io.File;

import org.apache.log4j.PropertyConfigurator;

import com.webbdd.utilities.NavigationToUtilities;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;

public class StepDefinitions {
	public static String strBrowser = null;
	@Before
	public void getScenario(Scenario scenario) {
		//Intilizing the log4j for getting the Log details to ExecutionLog.log file
		File currentDirFile = new File("Resources/log4j.properties");
		String path = currentDirFile.getAbsolutePath();
		PropertyConfigurator.configure(path);
	}
	
	// This step def is using to navigate to a URL which is mentioned
	@Given("^the user navigates to \"([^\"]*)\" application$")
	public void the_user_navigates_to(String strURL) throws Throwable {
		NavigationToUtilities.NavLaunchUrl(strURL);
	}

}
