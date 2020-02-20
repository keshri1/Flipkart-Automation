package com.flipkart.flows;

import org.openqa.selenium.WebDriver;

import com.flipkart.pages.SearchPage;

public class SearchProductScenarioOneFlow {
	private WebDriver driver;

	public SearchProductScenarioOneFlow(WebDriver driver){
		this.driver = driver;
	}

	public void searchFlow() throws InterruptedException {
		
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
		searchPage.printPrice();
		searchPage.addToCart();
		searchPage.increseQuantity();
		searchPage.printAfterPrice();
		
		
	}

	public void searchFlowScenarioTwo() throws InterruptedException {
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
		searchPage.printPrice();
		searchPage.addToCart();
		
		driver.get("https://www.amazon.in/");
		searchPage.enterProductInAmaxon();
		searchPage.clickProductInAmazon();
		searchPage.printPriceInAmazaon();
		searchPage.addToCartInAmazon();
		searchPage.goToCart();
		searchPage.printAfterPriceAmazon();
		searchPage.printCheaperPrice();
	}
	
}
