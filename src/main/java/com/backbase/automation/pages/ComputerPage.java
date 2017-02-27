package com.backbase.automation.pages;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ComputerPage {
	
	WebDriver driver;
	
	@FindBy(id ="name")
	public WebElement computerTextBox;
	
	@FindBy(id ="introduced")
	public WebElement introducedDateTextBox;
	
	@FindBy(id ="discontinued")
	public WebElement discontinuedDateTextBox;
	
	@FindBy(id = "company")
	public WebElement companyList;
	
	
	@FindBy(xpath = "//*[@id='main']/form/div/input")
	public WebElement createThisComputerButton;
	
	@FindBy(xpath = "//*[@id='main']/form/div/a")
	public WebElement cancelButton;
	
	@FindBy(xpath = "//*[@id='main']/form[2]/input")
	public WebElement deleteButton;
	
	@FindBy(xpath ="//*[@id='main']/table/tbody/tr[1]/td[1]/a")
	public WebElement computerNameInHomePageTable;
	
	@FindBy(xpath = "//*[@id='main']/form/fieldset/div[1]/div/span")
	public WebElement validationMessage;

	
	@FindBy(xpath = "//*[@id='main']/form/fieldset/div[2]/div/span")
	public WebElement validationMessageForIntroducedDate;

	@FindBy(xpath = "//*[@id='main']/form/fieldset/div[3]/div/span")
	public WebElement validationMessageForDiscontinuedDate;
	
	
	
	public ComputerPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void saveUserData(HashMap<String,String> testMap) {
		
		computerTextBox.sendKeys(testMap.get("computername"));
		introducedDateTextBox.sendKeys(testMap.get("introduceddate"));
		discontinuedDateTextBox.sendKeys(testMap.get("discontinueddate"));
		Select select = new Select(companyList);
		select.selectByVisibleText(testMap.get("company"));
		createThisComputerButton.click();
	}
	
	public void editComputerData(HashMap<String,String> testMap) {
		
		computerTextBox.clear();
		computerTextBox.sendKeys(testMap.get("computername"));
		introducedDateTextBox.clear();
		introducedDateTextBox.sendKeys(testMap.get("introduceddate"));
		discontinuedDateTextBox.clear();
		discontinuedDateTextBox.sendKeys(testMap.get("discontinueddate"));
		Select select = new Select(companyList);
		select.selectByVisibleText(testMap.get("company"));
		createThisComputerButton.click();
	}
	
	public void deleteComputerData() {
		
		deleteButton.click();
	}
	
	public void clickSaveButtonWithoutData() {
		
		createThisComputerButton.click();
	}
	
	public String getValidationMessage() {
		
		if (validationMessage.isDisplayed()) {
			
			return validationMessage.getText();
			
		}
		return validationMessage.getText();
	}
	
	public void cancelComputerData(HashMap<String,String> testMap) {
		
		computerTextBox.sendKeys(testMap.get("computername"));
		introducedDateTextBox.sendKeys(testMap.get("introduceddate"));
		discontinuedDateTextBox.sendKeys(testMap.get("discontinueddate"));
		Select select = new Select(companyList);
		select.selectByVisibleText(testMap.get("company"));
		cancelButton.click();
	}
	
	public ErrorPage computerNameMaxLengthValidation(HashMap<String,String> testMap) {
		
		computerTextBox.sendKeys(testMap.get("computername"));
		introducedDateTextBox.sendKeys(testMap.get("introduceddate"));
		discontinuedDateTextBox.sendKeys(testMap.get("discontinueddate"));
		Select select = new Select(companyList);
		select.selectByVisibleText(testMap.get("company"));
		createThisComputerButton.click();
		return PageFactory.initElements(driver, ErrorPage.class);
	}
	
	
	public static String getRandomString(int length) 
	{
	   String randomStr = UUID.randomUUID().toString();
	   while(randomStr.length() < length) {
	       randomStr += UUID.randomUUID().toString();
	   }
	   return randomStr.substring(0, length);
	}

	public String getValidationMessageForIntroducedDate() {
		
		return validationMessageForIntroducedDate.getText();
	}

	public String getValidationMessageForDiscontinuedDate() {
	
	return validationMessageForDiscontinuedDate.getText();
	}
	

	public void fillComputerData(HashMap<String,String> testMap) {
	
	computerTextBox.sendKeys(testMap.get("computername"));
	introducedDateTextBox.sendKeys(testMap.get("introduceddate"));
	discontinuedDateTextBox.sendKeys(testMap.get("discontinueddate"));
	Select select = new Select(companyList);
	select.selectByVisibleText(testMap.get("company"));
	}


	public void verifyDataAfterPageRefresh() {
	
	if (computerTextBox.getText().isEmpty()) { 
		
		System.out.println("Data removed after page refresh");
	}
  }
}
