package com.orangehrm.steps;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.orangehrm.pages.AddEmployeePage;
import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.CommonMethods;
import com.orangehrm.utils.ConfigsReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class AddEmployeeSteps extends CommonMethods {
	LoginPage login = new LoginPage();;
	HomePage home = new HomePage();;
	AddEmployeePage addEmp = new AddEmployeePage();

	@Given("I logged in into OrangeHrm")
	public void i_logged_in_into_OrangeHrm() {
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));

	}

	@When("I click on PIM link")
	public void i_click_on_PIM_link() {
		home.PIM.click();
	}

	@When("I click on Add employee link")
	public void i_click_on_Add_employee_link() {
		click(home.addEmployee);
	}

	@When("I provide Employee details {string} and {string} and {string} and {string}")
	public void i_provide_Employee_details(String fName, String mName, String lName, String location) {
		sendText(addEmp.firstName, fName);
		sendText(addEmp.middleName, mName);
		sendText(addEmp.lastName, lName);
		click(addEmp.location);
		selectList(addEmp.locationList, location);

	}
	@When("I click on create login details")
	public void i_click_on_create_login_details() {
	  click(addEmp.createLoginDetailsBtn);
	}

	@When("I provide all mandatory fields {string} and {string} and {string} and {string}")
	public void i_provide_all_mandatory_fields_and_and_and(String userName, String passWord, String confirmPassword, String adminRole) {
	    sendText(addEmp.loginUsername, userName);
	    sendText(addEmp.loginPassword, passWord);
	    sendText(addEmp.confirmPassword, confirmPassword);
	    selectList(addEmp.adminRole, adminRole);
}

	@When("I click on save button")
	public void i_click_on_save_button() {
		click(addEmp.saveBtn);
	}

	@Then("I see employee {string}, {string} is displayed")
	public void i_see_employee_and_is_displayed(String fName, String lName) {
		waitForElementBeClickable(addEmp.empCheck, 20);
		String empDetails = addEmp.empCheck.getText();
		Assert.assertEquals(empDetails, fName + " " + lName);
		takeScreenshot(empDetails);
	}

	@Then("I see following labels")
	public void i_see_following_labels(DataTable addEmpLabels) {
		List<String> expectedLabels = addEmpLabels.asList();
		System.out.println("------Printing labels from cucumber dataTables------");
		for (String label : expectedLabels) {
			System.out.println(label);
		}

		List<String> actualLabels = new ArrayList<String>();
		System.out.println("------Printing labels from application dataTables------");
		List<WebElement> labelList = addEmp.addEmpLabels;
		for (WebElement label : labelList) {
			String labeltxt = label.getText();
			if (!labeltxt.isEmpty()) {
				System.out.println(labeltxt.replace("*", ""));
			}
		}
		boolean condition = actualLabels.equals(expectedLabels);
		Assert.assertTrue(condition);
	}

}
