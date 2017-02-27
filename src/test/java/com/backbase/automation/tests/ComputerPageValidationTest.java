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


public class ComputerPageValidationTest {
	
	@Test ()
	public void saveComputerWithoutData() {
		WebDriver driver = null;
		
		try {
			System.setProperty("webdriver.chrome.driver", "D:\\selenium_drivers\\chrome\\chromedriver.exe");
			driver = new ChromeDriver();
			
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			homePage.launchapplication("http://computer-database.herokuapp.com/computers");
			Thread.sleep(2000);
			ComputerPage computerPage = homePage.clickAddNewComputerButton();
			computerPage.clickSaveButtonWithoutData();
			Thread.sleep(2000);
			String actual_Message = computerPage.getValidationMessage();
			String expected_Message = "Required";
			Assert.assertEquals(actual_Message, expected_Message);

		} catch (Exception e) {
			System.out.print("Exception" + e.getMessage());
		} finally {
			driver.quit();
		}
	}
	
	@Test ()
	public void saveComputerWithInvalidIntroducedDate() {
		WebDriver driver = null;
		
		HashMap<String,String> testDataMap = new HashMap<String,String>();
        testDataMap.put("computername", "testcomputer");
        testDataMap.put("introduceddate", "01-02-2017");
        
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
			String actual_Message = computerPage.getValidationMessageForIntroducedDate();
			String expected_Message = "Date ('yyyy-MM-dd')";
			Assert.assertEquals(actual_Message, expected_Message);

		} catch (Exception e) {
			System.out.print("Exception" + e.getMessage());
		} finally {
			driver.quit();
		}
	}
	
	
	@Test ()
	public void saveComputerWithInvalidDiscontinuedDate() {
		WebDriver driver = null;
		
		HashMap<String,String> testDataMap = new HashMap<String,String>();
        testDataMap.put("computername", "testcomputer");
        testDataMap.put("introduceddate", "2017-03-31");
        testDataMap.put("discontinueddate", "01-02-2017");
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
			String actual_Message = computerPage.getValidationMessageForIntroducedDate();
			String expected_Message = "Date ('yyyy-MM-dd')";
			Assert.assertEquals(actual_Message, expected_Message);

		} catch (Exception e) {
			System.out.print("Exception" + e.getMessage());
		} finally {
			driver.quit();
		}
	}
	

}
