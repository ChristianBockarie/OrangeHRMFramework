package com.orangehrm.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.SkillsPage;
import com.orangehrm.utils.CommonMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SkillsSteps extends CommonMethods {

	HomePage home;
	SkillsPage skills;

	public SkillsSteps() {
		home = new HomePage();
		skills = new SkillsPage();
	}

	@Given("I click on Admin link")
	public void i_click_on_Admin_link() {
		click(home.admin);
	}

	@Given("I click on Qualifications link")
	public void i_click_on_Qualifications_link() {
		click(home.qualifications);
	}

	@Given("I click on Skills links")
	public void i_click_on_Skills_links() {
		click(home.skills);
	}

	@When("I click on Add")
	public void i_click_on_Add() {
		//waitForElementBeVisible(By.id("preloader"), 5);
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("preloader")));
		click(skills.addBtn);
	}

	@When("I provide {string} and {string} for that skill")
	public void i_provide_and_for_that_skill(String skillName, String description) {
		sendText(skills.skillName, skillName);
		sendText(skills.description, description);
	}

	@When("I click Save button")
	public void i_click_Save_button() throws InterruptedException {
		click(skills.saveBtn);
		Thread.sleep(5000);
	}

	@Then("I see skill {string} and {string} is added")
	public void i_see_skill_is_added(String skillName, String description) {
		waitForElementBeClickable(skills.skillsTable, 20);
		for (WebElement row : skills.skillsTableRows) {
			if (row.getText().contains(skillName)) {
				Assert.assertTrue(row.getText().contains(skillName + " " + description));
			}
		}
	}
}