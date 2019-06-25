package com.orangehrm.steps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.orangehrm.utils.BaseClass;
import com.orangehrm.utils.CommonMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleSearchSteps extends BaseClass {

	@Given("I navigated to the Google")
	public void i_navigated_to_the_Google() {
		// setting up system property and driver by extending the BaseClass
		setUp();
		driver.navigate().to("http://www.google.com");
		// navigating to web site
		System.out.println(driver.getTitle());// printing out site title
	}

	@When("I type search item")
	public void i_type_search_item() {
		// sending Car into search box
		WebElement searchBox = driver.findElement(By.xpath("//input[@name='q']"));
		CommonMethods.sendText(searchBox, "car");
	}

	@When("I click on google search button")
	public void i_click_on_google_search_button() {
		// clicking on search button after sending Iphone text into search box
		WebElement searchBtn = driver.findElement(By.xpath("//div[@class='VlcLAe']//input[@name='btnK']"));
		System.out.println("clicked search button : " +  searchBtn.getAttribute("name"));
		CommonMethods.click(searchBtn);
		}

	@Then("I see search results are displayed")
	public void i_see_search_results_are_displayed() {
		// verifying if result was displayed and taking screenshot and printing out title
		boolean searchResultStats = driver.findElement(By.xpath("//div[@id='resultStats']")).isDisplayed();
		
		if (searchResultStats=true) {
			
			TakesScreenshot camera = (TakesScreenshot) driver;
			
			File screenshot = camera.getScreenshotAs(OutputType.FILE);
			
			try {
				FileUtils.copyFile(screenshot, new File("Screenshots/Google/Iphonepage.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Results are displayed : " + searchResultStats);
		
		} else {
			System.out.println("Wrong Page");
		
		}
		//closing the browser
		tearDown();
	}
}
