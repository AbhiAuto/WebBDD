package com.webbdd.runtest;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class) 
@CucumberOptions(
		plugin = {"json:target/cucumber.json", "pretty",
		        },
				features = {"Features"},
				tags = {"@test"},
				glue = {"com.autobotsbdd.stepdefinitions"},
				monochrome = true
		) 
public class RunTest { 
	}

