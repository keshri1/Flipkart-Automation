package com.flipkart.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.flipkart.flows.SearchProductScenarioOneFlow;

public class SearchProductScenarioOneTest {
	
	    public static void main(String[] args) throws InterruptedException {
	   
			System.setProperty("webdriver.chrome.driver","C://Users//sunny//Downloads//chromedriver.exe");
			
			WebDriver driver = new ChromeDriver();
			
			SearchProductScenarioOneFlow searchProductScenarioOneFlow = null;
			
			try {
				searchProductScenarioOneFlow = new SearchProductScenarioOneFlow(driver);
			}
			
			catch (Exception e) {
				System.out.println("Fail to load Page");
			}
			
			searchProductScenarioOneFlow.searchFlow();

	        driver.close();
	       
	    }

	}

