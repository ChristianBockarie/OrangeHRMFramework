package com.orangehrm.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/Login.feature", 
				glue = "com/orangehrm/steps",
				dryRun = false
				)
public class LoginTestRunner {

}
