package com.orangehrm.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features", 
		glue = "com/orangehrm/steps", 
		//dryRun = true, 
		monochrome = true, 
		tags = {"@regression"},
		plugin = {"pretty", "html:target/cucumber-default-reports", "json:target/cucumber.json"}
		)
public class RegressionRunner {

}
