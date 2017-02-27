package com.backbase.automation.tests;


import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.backbase.automation.pages.ComputerPage;
import com.backbase.automation.pages.HomePage;

public class EditcomputerTest {
	
	@Test ( priority = 1 )
	public void EditcomputerTest() {
		WebDriver driver = null;
		
		HashMap<String,String> testDataMap = new HashMap<String,String>();
        testDataMap.put("computername", "testcomputer");
        testDataMap.put("introduceddate", "2017-02-02");
        testDataMap.put("discontinueddate", "2017-03-31");
        testDataMap.put("company", "RCA");
		
  		try {
			System.setProperty("webdriver.chrome.driver", "D:\\selenium_drivers\\chrome\\chromedriver.exe");
			driver = new ChromeDriver();
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			homePage.launchapplication("http://computer-database.herokuapp.com/computers");
			Thread.sleep(2000);
			ComputerPage computerPage = homePage.clickAddNewComputerButton();
			computerPage.saveUserData(testDataMap);
			Thread.sleep(2000);
			homePage.searchComputer(testDataMap.get("computername"));
			Thread.sleep(2000);
			homePage.clickComputerSearchResults();
			Thread.sleep(2000);
			testDataMap.put("computername", "editcomputer");
		    testDataMap.put("introduceddate", "2017-02-24");
		    testDataMap.put("discontinueddate", "2017-04-30");
		    testDataMap.put("company", "IBM");
			computerPage.editComputerData(testDataMap);
		    String expected_message = "Done! Computer "+ testDataMap.get("computername") + " has been updated";
			String actual_message = homePage.getMessageDisplayedAfterEdit();
			Assert.assertEquals(actual_message, expected_message);
		    
		} catch (Exception e) {
			System.out.print("Exception" + e.getMessage());
		} finally {
			driver.quit();
		}
	}
}
