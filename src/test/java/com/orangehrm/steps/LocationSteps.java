package com.orangehrm.steps;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.LocationPage;
import com.orangehrm.utils.CommonMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LocationSteps extends CommonMethods {

	HomePage home;
	LocationPage location;

	public LocationSteps() {
		home = new HomePage();
		location = new LocationPage();
	}

	@Given("I click on Organization link")
	public void i_click_on_Organization_link() {
		click(home.organization);
	}

	@Given("I click on Locations links")
	public void i_click_on_Locations_links() {
		click(home.locations);
	}

	@When("I click on Add Locations")
	public void i_click_on_Add_Locations() {
		click(location.btnAdd);
	}

	@When("I add {string}, {string}, {string} and {string}")
	public void i_add_and(String locationName, String country, String city, String zip) {
		sendText(location.name, locationName);
		click(location.countryInp);
		selectList(location.countryDD, country);
		sendText(location.city, city);
		sendText(location.zip, zip);
	}

	@Then("I see location {string}, {string}, {string} and {string} is added")
	public void i_see_location_and_is_added(String locationName, String country, String city, String zip) {
		waitForElementBeClickable(location.locationsTable, 20);
		for (WebElement row : location.locationsTableRows) {
			if (row.getText().contains(locationName)) {
				Assert.assertTrue(row.getText().contains(locationName + " " + country + " " + city + " " + zip));
			}
		}
	}

	@Then("I see Location Labels displayed")
	public void i_see_Location_Labels_displayed(io.cucumber.datatable.DataTable locationsLabels) {
		List<String> expectedLabels = locationsLabels.asList();

		List<WebElement> labelList = location.locationLabels;
		List<String> actualLabels = new ArrayList<>();
		for (WebElement label : labelList) {
			waitForElementBeClickable(label, 5);
			String labeltxt = label.getText();
			System.out.println(labeltxt);
			if (!labeltxt.isEmpty()) {
				actualLabels.add(labeltxt.replace("*", ""));
			}
		}
		Assert.assertTrue(expectedLabels.equals(actualLabels));
	}
}
