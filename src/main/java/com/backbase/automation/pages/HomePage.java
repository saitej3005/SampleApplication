package com.backbase.automation.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
	
	WebDriver driver;
	
	@FindBy(xpath = "html/body/header/h1/a")
	public WebElement applicationHeader;
	
	@FindBy(id ="add")
	public WebElement addComputerButton;
	
	@FindBy(xpath ="//*[@id='main']/table/tbody/tr[1]/td[1]")
	public WebElement computerName;
	
	@FindBy(xpath ="//*[@id='main']/table/tbody/tr[1]/td[1]")
	public WebElement introducedDate;
	
	@FindBy(xpath ="//*[@id='main']/table/tbody/tr[1]/td[1]")
	public WebElement discontinuedDate;
	
	@FindBy(id ="searchbox")
	public WebElement searchBox;
	
	@FindBy(id ="searchsubmit")
	public WebElement filterByNameButton;
	
	@FindBy(xpath = "//*[@id='pagination']/ul/li[3]/a")
	public WebElement nextPageButton;
	
	@FindBy(xpath = "//*[@id='pagination']/ul/li[2]/a")
	public WebElement displayPageNumber;
	
	@FindBy(xpath = "//*[@id='pagination']/ul/li[1]/a")
	public WebElement previousPageButton;
	
	@FindBy(xpath = "//*[@id='main']/div[1]")
	public WebElement messageAfterCreation;
	
	@FindBy(xpath = "//*[@id='main']/div[1]")
	public WebElement messageAfterUpdation;
	
	@FindBy(xpath ="//*[@id='main']/table/tbody/tr[1]/td[1]/a")
	public WebElement computerNameInHomePageTable;
	
	@FindBy(xpath = "//*[@id='main']/div[1]")
	public WebElement messageAfterDeletion;
	
	@FindBy(xpath = "//*[@id='main']/div[2]/em")
	public WebElement searchResultsForInavlidData;
	
	@FindBy(xpath = "//*[@id='main']/h1")
	public WebElement computerCountMessage;
	
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void launchapplication(String url) {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		}
	
	public String getText(WebElement element) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return element.getText();
	}
	
	public ComputerPage clickAddNewComputerButton() {
		
		addComputerButton.click();
		return PageFactory.initElements(driver, ComputerPage.class);
		
	}
	
	public String getMessageDisplayed() {
		
		String actual_message = messageAfterCreation.getText();
		return actual_message; 
		
	}
	
	public void searchComputer(String computerName) {
		
		searchBox.sendKeys(computerName);
		filterByNameButton.click();
		
	}
	
	public void clickComputerSearchResults() {
		
		computerNameInHomePageTable.click();
		
		}
		
	public String getMessageDisplayedAfterEdit() {
		
		
		String actual_message = messageAfterUpdation.getText();
		return actual_message; 
		
		
	}
	
	public String getMessageDisplayedAfterDelete() {
		
		
		String actual_message = messageAfterDeletion.getText();
		return actual_message; 
		
		
	}
	
	public void searchResultsValidation() {
		
		if  (computerNameInHomePageTable.isDisplayed()) {
			
			System.out.println("Search results available");
			
		}
		else {
			System.out.println("No Search results found");
			
		}
		
	}
	
	
	public String searchResultsForInvalidData() {
		
					
			return searchResultsForInavlidData.getText();
		}
		
	public String homePageTableNavigationTest() {
		
		nextPageButton.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return displayPageNumber.getText();
		
	}
	
	
	public String getComputerCount() {
		
		
		String computer_Count = computerCountMessage.getText();
//		return computer_Count.substring(0, 3);
		return computer_Count.replace(" computers found", "");
		
	}
	
	public String previousPageNavigationclick() {
		
		nextPageButton.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		previousPageButton.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return displayPageNumber.getText();
		
	}
}
	
	
	


