package com.orangehrm.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utils.BaseClass;

public class LocationPage extends BaseClass{

	@FindBy(xpath="//i[text()='add']")
	public WebElement btnAdd;
	
	@FindBy(id="name")
	public WebElement name;
	
	@FindBy(xpath="//div[@id='countryCode_inputfileddiv']//ul")
	public WebElement countryDD;
	
	@FindBy(xpath="//div[@id='time_zone_inputfileddiv']//ul")
	public WebElement timezoneDD;
	
	@FindBy(xpath="//div[@id='time_zone_inputfileddiv']//input")
	public WebElement timezoneInp;
	
	@FindBy(xpath="//div[@id='countryCode_inputfileddiv']//input")
	public WebElement countryInp;
	
	@FindBy(xpath="//a[text()='Save']")
	public WebElement saveBtn;
	
	@FindBy(id="city")
	public WebElement city;
	
	@FindBy(id="zipCode")
	public WebElement zip;
	
	@FindBy(id="province")
	public WebElement state;
	
	@FindBy(xpath = "//table[@class='highlight bordered']")
	public WebElement locationsTable;
	
	@FindBy(xpath = "//table[@class='highlight bordered']//tr")
	public List<WebElement> locationsTableRows;
	
	@FindBy(xpath = "//div[@class='modal-content']//label")
	public List<WebElement> locationLabels;
	
	public LocationPage() {
		PageFactory.initElements(driver, this);
	}
}