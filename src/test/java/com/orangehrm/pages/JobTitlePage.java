package com.orangehrm.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utils.BaseClass;

public class JobTitlePage extends BaseClass {

	@FindBy(xpath="//span[@class='left-menu-title'][contains(text(),'Admin')]")
	public WebElement admin; 
	
	@FindBy(xpath="//li[@id='menu_admin_Job']//a[@class='collapsible-header waves-effect waves-orange']")
	public WebElement jobLink;
	
	@FindBy(xpath="//span[contains(text(),'Job Titles')]")
	public WebElement jobTitle;
	
	@FindBy(xpath="//th[@class='row-name sortable']")
	public List<WebElement> jtTableRow;
	
	@FindBy(css="li#menu_admin_Job")
    public WebElement job;
	
	@FindBy(xpath="//i[text()='add']")
    public WebElement addJobTitle;
	
	@FindBy(css="input#jobTitleName")
    public WebElement jobTitleField;
	
	@FindBy(css="*#jobDescription")
    public WebElement jobDescription;
    
    @FindBy(xpath="//a[text()='Save']")
    public WebElement save;
    
    @FindBy(css="input#jobSpecification")
    public WebElement jobSpecification;
  
  @FindBy(xpath = "//table[@class='highlight bordered']/tbody/tr")
   public List<WebElement> jobTitleTableRows;
	
	public JobTitlePage() {
		PageFactory.initElements(driver, this);
	}
}
