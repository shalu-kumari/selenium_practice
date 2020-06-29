package com.selenium.demo.selenium.demo.practice;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class buyProduct {
	
	WebDriver driver;
	
	Properties prop;

	FileInputStream fis;
	
static {
		
		System.setProperty("webdriver.chrome.driver", ".//driver/chromedriver.exe");
	}
	
	@BeforeTest
	public void openBrowser() throws FileNotFoundException {
	
	prop=new Properties();
	
	fis = new FileInputStream("D:\\developer\\SeleniumPractice\\resources\\property.file");
	
	driver= new ChromeDriver();
	
	driver.get(prop.getProperty("YourLogo_url"));
	
	driver.manage().window().maximize();
	
	}
	
	@Test(enabled = false)
	public void endToEndTestCase() throws InterruptedException, AWTException {
		
		driver.findElement(By.xpath(prop.getProperty("SignInBotton_xpath"))).click();
		
        WebDriverWait wait = new WebDriverWait(driver, 30);
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("EmailAdd_create_xpath"))));
        
        driver.findElement(By.xpath(prop.getProperty("EmailForLogin_xpath"))).sendKeys("kumarishalu312@gmail.com");
        
        driver.findElement(By.xpath(prop.getProperty("PassworForLogin_xpath"))).sendKeys("Shalu@533");
        
        driver.findElement(By.xpath(prop.getProperty("LoginButtton"))).click();
        
        Thread.sleep(5000);
        
        System.out.println(driver.findElement(By.xpath(prop.getProperty("WomenHover"))).isDisplayed());
        
        Actions action = new Actions(driver);
        
        action.moveToElement(driver.findElement(By.xpath(prop.getProperty("WomenHover")))).perform();
       
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("TshirtLink_xpath"))));
        
        driver.findElement(By.xpath(prop.getProperty("TshirtLink_xpath"))).click();
       
        Thread.sleep(2000);
        
        WebElement firstProduct= driver.findElement(By.xpath(prop.getProperty("FirstProduct")));
        
        System.out.println(firstProduct.isDisplayed());
        
        action.moveToElement(firstProduct).perform();
        
        Thread.sleep(2000);
        
        driver.findElement(By.xpath(prop.getProperty("MoreButton"))).click();
        
        Thread.sleep(3000);
        
        driver.findElement(By.xpath(prop.getProperty("Quantity"))).click();
        
        Robot r = new Robot();
        
        r.keyPress(KeyEvent.VK_BACK_SPACE);
        
        driver.findElement(By.xpath(prop.getProperty("Quantity"))).sendKeys("4");
        
        System.out.println(driver.findElement(By.xpath(prop.getProperty("Size_id"))).isDisplayed());
        
        WebElement sizeId = driver.findElement(By.xpath(prop.getProperty("Size_id")));
        
        Select select = new Select(sizeId);
        
        select.selectByValue("2");
        
        driver.findElement(By.id(prop.getProperty("ColorSelection_id"))).click();
        
        driver.findElement(By.xpath(prop.getProperty("AddCartButton_xpath"))).click();
        
        Thread.sleep(3000);
        
        driver.findElement(By.xpath(prop.getProperty("ProceedToPay_xpath"))).click();
        
         }
	
		@Test(enabled = false)
		public void verifyAddToWishList() throws InterruptedException {
			
			System.out.println(driver.findElement(By.xpath(prop.getProperty("WomenHover"))).isDisplayed());
	        
	        Actions action = new Actions(driver);
	        
	        action.moveToElement(driver.findElement(By.xpath(prop.getProperty("WomenHover")))).perform();
	       
	        WebDriverWait wait = new WebDriverWait(driver, 3);
	        
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("TshirtLink_xpath"))));
	        
	        driver.findElement(By.xpath(prop.getProperty("TshirtLink_xpath"))).click();
	       
	        Thread.sleep(2000);
	      
	        
	        WebElement firstProduct= driver.findElement(By.xpath(prop.getProperty("FirstProduct")));
	        
	        System.out.println(firstProduct.isDisplayed());
	        
	        action.moveToElement(firstProduct).perform();
	        
	        Thread.sleep(2000);
	        
	        driver.findElement(By.xpath(prop.getProperty("AddToWishList_xpath"))).click();
	        
	        Thread.sleep(2000);
	        
	        String msg = driver.findElement(By.xpath(prop.getProperty("ErrorMessageForAddToWishList_xpath"))).getText();
			
			//System.out.println("Error message is: " + msg);
			
			assertEquals(msg, "You must be logged in to manage your wishlist.");
			
		}
		
		@Test(enabled = false)
		public void shoppingCartSummaryPage() throws InterruptedException, AWTException {
			
			driver.findElement(By.xpath(prop.getProperty("SignInBotton_xpath"))).click();
			
	        WebDriverWait wait = new WebDriverWait(driver, 30);
	        
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("EmailAdd_create_xpath"))));
	        
	        driver.findElement(By.xpath(prop.getProperty("EmailForLogin_xpath"))).sendKeys("kumarishalu312@gmail.com");
	        
	        driver.findElement(By.xpath(prop.getProperty("PassworForLogin_xpath"))).sendKeys("Shalu@533");
	        
	        driver.findElement(By.xpath(prop.getProperty("LoginButtton"))).click();
	        
	        Thread.sleep(5000);
	        
	        System.out.println(driver.findElement(By.xpath(prop.getProperty("WomenHover"))).isDisplayed());
	        
	        Actions action = new Actions(driver);
	        
	        action.moveToElement(driver.findElement(By.xpath(prop.getProperty("WomenHover")))).perform();
	       
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("TshirtLink_xpath"))));
	        
	        driver.findElement(By.xpath(prop.getProperty("TshirtLink_xpath"))).click();
	       
	        Thread.sleep(2000);
	        
	        WebElement firstProduct= driver.findElement(By.xpath(prop.getProperty("FirstProduct")));
	        
	        System.out.println(firstProduct.isDisplayed());
	        
	        action.moveToElement(firstProduct).perform();
	        
	        Thread.sleep(2000);
	        
	        driver.findElement(By.xpath(prop.getProperty("MoreButton"))).click();
	        
	        Thread.sleep(3000);
	        
	        driver.findElement(By.xpath(prop.getProperty("Quantity"))).click();
	        
	        Robot r = new Robot();
	        
	        r.keyPress(KeyEvent.VK_BACK_SPACE);
	        
	        driver.findElement(By.xpath(prop.getProperty("Quantity"))).sendKeys("4");
	        
	        System.out.println(driver.findElement(By.xpath(prop.getProperty("Size_id"))).isDisplayed());
	        
	        WebElement sizeId = driver.findElement(By.xpath(prop.getProperty("Size_id")));
	        
	        Select select = new Select(sizeId);
	        
	        select.selectByValue("2");
	        
	        driver.findElement(By.id(prop.getProperty("ColorSelection_id"))).click();
	        
	        driver.findElement(By.xpath(prop.getProperty("AddCartButton_xpath"))).click();
	        
	        Thread.sleep(3000);
	        
	        driver.findElement(By.xpath(prop.getProperty("ProceedToPay_xpath"))).click();
	        
	        Thread.sleep(3000);
	       
	        driver.findElement(By.xpath(prop.getProperty("PlusButton_xpath"))).click();
	        
	        String total = driver.findElement(By.xpath(prop.getProperty("total"))).getText();
	        
	        assertEquals(total, "$68.04");
		}
		
		@Test
		public void SearchProductFunctionality() throws InterruptedException {
			
			System.out.println(driver.findElement(By.xpath(prop.getProperty("WomenHover"))).isDisplayed());
	        
	        Actions action = new Actions(driver);
	        
	        action.moveToElement(driver.findElement(By.xpath(prop.getProperty("WomenHover")))).perform();
	       
	        WebDriverWait wait = new WebDriverWait(driver, 3);
	        
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("TshirtLink_xpath"))));
	        
	        driver.findElement(By.xpath(prop.getProperty("TshirtLink_xpath"))).click();
	       
	        Thread.sleep(2000);
	      
	        
	        WebElement firstProduct= driver.findElement(By.xpath(prop.getProperty("FirstProduct")));
	        
	        System.out.println(firstProduct.isDisplayed());
	        
	        action.moveToElement(firstProduct).perform();
	        
	        String productText = firstProduct.getText();
	        
	        driver.findElement(By.xpath(prop.getProperty("SearchTest"))).sendKeys(productText);
	        
	        driver.findElement(By.xpath(prop.getProperty("SearchButton"))).click();
	        
	        Thread.sleep(2000);
	        
		}
}



