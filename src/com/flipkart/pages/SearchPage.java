package com.flipkart.pages;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {

	private WebDriver driver;
	private static final By CLOSE = By.xpath("//button[@class='_2AkmmA _29YdH8']");
	private static final By SEARCH_BAR = By.xpath("//input[@title='Search for products, brands and more']");
	private static final By PRICE = By.xpath("//*[@id='container']/div/div[3]/div[2]/div[1]/div[2]/div[2]/div/div[3]/div[1]/div/div[1]");
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickClosePopUp() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(CLOSE)).click();	
	}

	public void enterProduct() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCH_BAR)).sendKeys("redmi note 8 (space black, 4gb ram, 64gb storage)");	
		driver.findElement(By.xpath("//button[@class='vh79eN']")).click();
	}

	public void clickProduct() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[contains(text(),'Redmi Note 8')]")).click();	
		
	}

	public void printPrice() {
		
		//WebElement price = driver.findElement((PRICE));
		WebElement element = driver.findElement(By.xpath("//div[@class='_1vC4OE _3qQ9m1']"));	
		String price = element.getText();
		System.out.println("Price of the Phone is:- "+ price);
		
	}

	public void addToCart() {
		driver.findElement(By.xpath("//button[@class='vh79eN']")).click();
		
	}
	

}
