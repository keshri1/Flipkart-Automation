package com.flipkart.flows;

import org.openqa.selenium.WebDriver;

import com.flipkart.pages.SearchPage;

public class SearchProductScenarioOneFlow {
	private WebDriver driver;

	public SearchProductScenarioOneFlow(WebDriver driver){
		this.driver = driver;
	}

	public void searchFlow() {
		
		driver.get("https://flipkart.com/");
		driver.manage().window().maximize() ;
		SearchPage searchPage= null;
		
		try {
			searchPage = new SearchPage(driver);
		}
		
		catch (Exception e) {
			System.out.println("Fail to load Page");
		}
		
		searchPage.clickClosePopUp();
		searchPage.enterProduct();
		searchPage.clickProduct();
		String parentWindow = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle);
		}
		searchPage.printPrice();
		searchPage.addToCart();
	}
	
}
