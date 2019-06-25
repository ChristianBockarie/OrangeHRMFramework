package com.orangehrm.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utils.BaseClass;

public class AddEmployeePage extends BaseClass {

	@FindBy(id = "firstName")
	public WebElement firstName;

	@FindBy(id = "middleName")
	public WebElement middleName;

	@FindBy(id = "lastName")
	public WebElement lastName;

	@FindBy(id = "employeeId")
	public WebElement employeeId;

	@FindBy(xpath = "//div[@id='location_inputfileddiv']//input")
	public WebElement location;

	@FindBy(xpath = "//div[@id='location_inputfileddiv']//ul")
	public WebElement locationList;

	@FindBy(xpath = "//input[@id='chkLogin']")
	public WebElement createLoginDetails;// invalid xpath not found on webpage

	@FindBy(xpath = "//label[contains(text(),'Create Login Details')]")
	public WebElement createLoginDetailsBtn;

	//creating login deatails locators	
	@FindBy(xpath = "//input[@id='username']")
	public WebElement loginUsername;

	@FindBy(xpath = "//input[@id='password']")
	public WebElement loginPassword;

	@FindBy(xpath = "//input[@id='confirmPassword']")
	public WebElement confirmPassword;

	@FindBy(xpath = "//*[@id='adminRoleId_inputfileddiv']/div/input")
	public WebElement adminRole;

	@FindBy(xpath = "//div[@id='adminRoleId_inputfileddiv']//div[@class='select-wrapper initialized']//ul")
	public WebElement adminList;

	@FindBy(id = "systemUserSaveBtn")
	public WebElement saveBtn;

	@FindBy(xpath = "//span[@id='pim.navbar.employeeName']")
	public WebElement empCheck;

	@FindBy(xpath = "//form[@id='pimAddEmployeeForm']//label")
	public List<WebElement> addEmpLabels;

	public AddEmployeePage() {
		PageFactory.initElements(driver, this);
	}

}