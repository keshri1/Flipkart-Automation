package com.flipkart.pages;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {

	private WebDriver driver;
	private static final By CLOSE = By.xpath("//button[@class='_2AkmmA _29YdH8']");
	private static final By SEARCH_BAR = By.xpath("//input[@title='Search for products, brands and more']");
	private static final By PRICE = By.xpath("//*[@id='container']/div/div[3]/div[2]/div[1]/div[2]/div[2]/div/div[3]/div[1]/div/div[1]");
	private String priceFlipkart = null;
	String priceFlipkartAdd = null;
	String priceAmazon = null;
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickClosePopUp() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(CLOSE)).click();	
	}

	public void enterProduct() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCH_BAR)).sendKeys("DW00100148 Classic Black Cornwall Analog Watch - For Men");	
		driver.findElement(By.xpath("//button[@class='vh79eN']")).click();
	}

	public void clickProduct() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(text(),'DW00100149 Classic Black Cornwall Analog Watch')]")).click();	
		
	}

	public void printPrice() {
		
		//WebElement price = driver.findElement((PRICE));
		
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle);
		}
		//driver.switchTo().window(parentWindow);
		WebElement element = driver.findElement(By.xpath("//div[@class='_1vC4OE _3qQ9m1']"));	
		priceFlipkart = element.getText();
		System.out.println("Price of the Watch is "+priceFlipkart);

	}

	public void addToCart() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='_2AkmmA _2Npkh4 _2MWPVK']")).click();
	}

	public void increseQuantity() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[2]")).click();
		Thread.sleep(6000);
		
	}

	public void printAfterPrice() {
		
		WebElement element = driver.findElement(By.xpath("//span[@class='pMSy0p XU9vZa']"));	
		priceFlipkartAdd = element.getText();
		System.out.println("Price of the Watch after adition is "+priceFlipkartAdd);
		
	}

	public void enterProductInAmaxon() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='twotabsearchtextbox']"))).sendKeys("DW00100148 Classic Black Cornwall Analog Watch - For Men");	
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
	}

	public void clickProductInAmazon() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[contains(text(),'Daniel Wellington Classic Analog Black Dial')]")).click();
	}

	public void printPriceInAmazaon() {
		
		String parentWindow = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle);
		}
		//driver.switchTo().window(parentWindow);
		WebElement element = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-price priceBlockBuyingPriceString']"));	
		priceAmazon = element.getText();
		System.out.println("Price of the Watch is "+priceAmazon);
	}

	public void addToCartInAmazon() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		
	}

	public void goToCart() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='hlb-view-cart-announce']")).click();
		
	}

	public void printAfterPriceAmazon() {
		
		WebElement element = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-price sc-price sc-white-space-nowrap sc-price-sign']"));	
		priceAmazon = element.getText();
		System.out.println("Price of the Watch is "+priceAmazon);
	}

	public void printCheaperPrice() {
		System.out.println(priceFlipkart);
		System.out.println(priceAmazon);
		double j = Double.parseDouble(priceAmazon.replaceAll(",", ""));
	    double i = Double.parseDouble(priceFlipkart.substring(1).replaceAll(",", ""));
		if(i>j)
			System.out.println("Amazon is giving cheaper price at "+j);
		else if(j>i)
			System.out.println("Flipkart is giving cheaper price at "+i);
		
		else System.out.println("Both are available at same price at "+j);
	}
	
	

}
