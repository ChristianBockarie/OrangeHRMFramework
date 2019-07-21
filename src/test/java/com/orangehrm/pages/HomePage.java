package com.orangehrm.pages;

import org.openqa.selenium.WebElement;	
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utils.BaseClass;

public class HomePage extends BaseClass{
	
	@FindBy(xpath="//li[text()='Dashboard']")
	public WebElement dashboardText;
	
	@FindBy(partialLinkText="PIM")
    public WebElement PIM;
	
	@FindBy(linkText = "Admin")
	public WebElement admin;

	@FindBy(linkText = "Training")
	public WebElement training;

	@FindBy(linkText = "Users")
	public WebElement users;

	@FindBy(linkText = "User Management")
	public WebElement userMngm;

	@FindBy(linkText = "Organization")
	public WebElement organization;

	@FindBy(linkText = "Locations")
	public WebElement locations;

	@FindBy(linkText = "Skills")
	public WebElement skills;

	@FindBy(linkText = "Courses")
	public WebElement courses;

	@FindBy(linkText = "Qualifications")
	public WebElement qualifications;

	@FindBy(partialLinkText = "Add Employee")
	public WebElement addEmployee;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
}