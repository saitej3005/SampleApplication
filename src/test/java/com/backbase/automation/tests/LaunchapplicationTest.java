package com.backbase.automation.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.backbase.automation.pages.HomePage;



public class LaunchapplicationTest {
	
	@Test ( priority = 1 )
	public void LaunchapplicationTest() {
		WebDriver driver = null;
		try {
			System.setProperty("webdriver.chrome.driver", "D:\\selenium_drivers\\chrome\\chromedriver.exe");
			driver = new ChromeDriver();
			
			HomePage homepage = PageFactory.initElements(driver, HomePage.class);
			homepage.launchapplication("http://computer-database.herokuapp.com/computers");
			Thread.sleep(6000);
			String expected_header = "Play sample application � Computer database";
			String actual_header = homepage.getText(homepage.applicationHeader);
			Assert.assertEquals(actual_header, expected_header);		

		} catch (Exception e) {
			System.out.print("Exception" + e.getMessage());
		} finally {
			driver.quit();
		}
	}
	
}
