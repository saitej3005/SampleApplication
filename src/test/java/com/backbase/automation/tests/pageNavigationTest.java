package com.backbase.automation.tests;


import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.backbase.automation.pages.HomePage;


public class pageNavigationTest {

	@Test ()
	public void nextPageNavigationTest() {
		WebDriver driver = null;
		
		try {
			System.setProperty("webdriver.chrome.driver", "D:\\selenium_drivers\\chrome\\chromedriver.exe");
			driver = new ChromeDriver();
			
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			homePage.launchapplication("http://computer-database.herokuapp.com/computers");
			Thread.sleep(2000);
			String actual_message = homePage.homePageTableNavigationTest();
			String computers_Count = homePage.getComputerCount();
			String expected_message = "Displaying 11 to 20 of "+computers_Count;
			Assert.assertEquals(actual_message, expected_message);

		} catch (Exception e) {
			System.out.print("Exception" + e.getMessage());
		} finally {
			driver.quit();
		}
	}
	
	@Test ()
	public void previousPageNavigationTest() {
		WebDriver driver = null;
		
		try {
			System.setProperty("webdriver.chrome.driver", "D:\\selenium_drivers\\chrome\\chromedriver.exe");
			driver = new ChromeDriver();
			
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			homePage.launchapplication("http://computer-database.herokuapp.com/computers");
			Thread.sleep(2000);
			String actual_message = homePage.previousPageNavigationclick();
			String computers_Count = homePage.getComputerCount();
			String expected_message = "Displaying 1 to 10 of "+computers_Count;
			Assert.assertEquals(actual_message, expected_message);

		} catch (Exception e) {
			System.out.print("Exception" + e.getMessage());
		} finally {
			driver.quit();
		}
	}
	
}
