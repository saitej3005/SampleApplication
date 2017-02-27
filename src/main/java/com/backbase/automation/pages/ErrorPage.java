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

public class ErrorPage {

	
	WebDriver driver;
	
	@FindBy(xpath = "html/body/div[2]/p")
	public WebElement errorMessage;
	
	
	
	public ErrorPage(WebDriver driver) {
		this.driver = driver;
	
	}
	
	public String getMessageText() {
		
		return errorMessage.getText();
	}
	

	public static String getRandomString(int length) 
	{
	   String randomStr = UUID.randomUUID().toString();
	   while(randomStr.length() < length) {
	       randomStr += UUID.randomUUID().toString();
	   }
	   return randomStr.substring(0, length);
	}
}
