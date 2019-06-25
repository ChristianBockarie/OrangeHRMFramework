package com.orangehrm.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.CommonMethods;
import com.orangehrm.utils.ConfigsReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class LoginSteps extends CommonMethods {

	LoginPage login;

	@Given("I see OrangeHrm logo")
	public void i_see_OrangeHrm_logo() {
		login = new LoginPage();
		boolean isDisplayed = login.logo.isDisplayed();
		Assert.assertTrue(isDisplayed);
	}

	@When("I enter valid username and password")
	public void i_enter_valid_username_and_password() {
		sendText(login.userName, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
	}

	@When("I click login button")
	public void i_click_login_button() {
		click(login.loginBtn);
	}

	@Then("I succesfully logged in")
	public void i_succesfully_logged_in() {
		HomePage home = new HomePage();
		Assert.assertTrue(home.dashboardText.isDisplayed());
	}

	@When("I enter invalid username and password")
	public void i_enter_invalid_username_and_password() {
		sendText(login.userName, "Test123");
		sendText(login.password, "Test");
	}

	@Then("I see error message is displayed")
	public void i_see_error_message_is_displayed() {
		Assert.assertTrue(login.message.isDisplayed());
		String errorText = login.message.getText().trim();
		System.out.println(errorText);
		Assert.assertEquals("Invalid Credentials", errorText);
	}
	@When("I enter invalid username and password I see errorMessage")
	public void i_enter_invalid_username_and_password_I_see_errorMessage(DataTable wrongCredentials) {
	   List<Map<String, String>> maps = wrongCredentials.asMaps();
	   
	   for (Map<String, String> map: maps) {
		   //printing value for eaach key
		   System.out.println(map.get("UserName"));
		   System.out.println(map.get("Password"));
		   System.out.println(map.get("ErrorMessage"));
		   System.out.println("--------------------");
		   //passing username and pwassword values from datatable/map
		   sendText(login.userName, map.get("UserName"));
		   sendText(login.password, map.get("Password"));
		   click(login.loginBtn);
		   //verifying text error message
		   String actualError = login.message.getText().trim();
		   String expectedError = map.get("ErrorMessage");
		   Assert.assertEquals(expectedError, actualError);
		   System.out.println(expectedError);
	   }
	}


}
