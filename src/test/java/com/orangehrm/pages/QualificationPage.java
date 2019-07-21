package com.orangehrm.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utils.BaseClass;

public class QualificationPage extends BaseClass{
    
    
    @FindBy(xpath="//span[text()='Qualifications']")
    public WebElement qualificationLink;
    
    @FindBy(linkText="Languages")
    public WebElement languagesLink;
    
    @FindBy(xpath="//*[@id='languagesDiv']/div/a/i")
    public WebElement addButtonQulifiPage;

    @FindBy(xpath="//*[@id='name' and  @sf-changed='form']")
    public WebElement addLanguageName;
    
    @FindBy(xpath="//a[text()='Save']")
    public WebElement saveBtnQuliPage;
    
    @FindBy(xpath="//table[@class='highlight bordered']//tbody//tr")
    public List<WebElement> tableRow;
    
    public QualificationPage() {
        PageFactory.initElements(driver, this);
    }
}