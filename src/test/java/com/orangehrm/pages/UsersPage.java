package com.orangehrm.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utils.BaseClass;

public class UsersPage extends BaseClass{

	@FindBy(xpath="//i[text()='add']")
	public WebElement btnAdd;
	
	@FindBy(xpath = "//div[@class='modal-content']//label")
	public List<WebElement> addUserLabels;
	
	public UsersPage() {
		PageFactory.initElements(driver, this);
	}
}