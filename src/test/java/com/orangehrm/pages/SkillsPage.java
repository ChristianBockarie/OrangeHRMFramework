package com.orangehrm.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utils.BaseClass;


public class SkillsPage extends BaseClass{

	@FindBy(id = "name")
	public WebElement skillName;
	
	@FindBy(id = "description")
	public WebElement description;
	
	@FindBy(xpath = "//i[text()='add']")
	public WebElement addBtn;
	
	@FindBy(xpath = "//a[text()='Save']")
	public WebElement saveBtn;
	
	@FindBy(xpath = "//table[@class='highlight bordered']")
	public WebElement skillsTable;
	
	@FindBy(xpath = "//table[@class='highlight bordered']/tbody/tr")
	public List<WebElement> skillsTableRows;

	public SkillsPage() {
		PageFactory.initElements(driver, this);
	}
}