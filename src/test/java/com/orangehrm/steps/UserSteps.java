package com.orangehrm.steps;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.UsersPage;
import com.orangehrm.utils.CommonMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserSteps extends CommonMethods {

	HomePage home;
	UsersPage user;

	public UserSteps() {
		home = new HomePage();
		user = new UsersPage();
	}

	@Given("I click on User Management link")
	public void i_click_on_User_Management_link() {
		click(home.userMngm);
	}

	@Given("I click on Users link")
	public void i_click_on_Users_link() {
		click(home.users);
	}
	
	@When("I click on Add Users")
	public void i_click_on_Add_Users() {
		click(user.btnAdd);
	}

	@Then("I see Add Users Labels displayed")
	public void i_see_Add_Users_Labels_displayed(io.cucumber.datatable.DataTable userLabels) {
		List<String> expectedLabels = userLabels.asList();

		List<WebElement> labelList = user.addUserLabels;
		List<String> actualLabels = new ArrayList<>();
		for (WebElement label : labelList) {
			waitForElementBeClickable(label, 5);
			String labeltxt = label.getText();
			if (!labeltxt.isEmpty()) {
				actualLabels.add(labeltxt.replace("*", ""));
			}
		}
		System.out.println(expectedLabels);
		System.out.println(actualLabels);
		Assert.assertTrue(expectedLabels.equals(actualLabels));
	}
}