package com.selenium.demo.selenium.demo.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

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

public class UserRegistration {
	
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
		public void User_Registration_Process() throws InterruptedException {
		
		driver.findElement(By.xpath(prop.getProperty("SignInBotton_xpath"))).click();
		
        WebDriverWait wait = new WebDriverWait(driver, 30);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("EmailAdd_create_xpath"))));

		Thread.sleep(2000);
	
		driver.findElement(By.xpath(prop.getProperty("EmailAdd_create_xpath"))).sendKeys("kumarishalu312@gmail.com");
		
		driver.findElement(By.xpath(prop.getProperty("CreateAcc_xpath"))).click();
		
//		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("CustomerFN_xpath"))));
		
		driver.findElement(By.id(prop.getProperty("TitleButton_id"))).click();
		
		driver.findElement(By.xpath(prop.getProperty("CustomerFN_xpath"))).sendKeys(prop.getProperty("FirstName"));
		
		driver.findElement(By.xpath(prop.getProperty("CustomerLN_xpath"))).sendKeys(prop.getProperty("LastName"));
		
		driver.findElement(By.xpath(prop.getProperty("YourLogoPassword_xpath"))).sendKeys("Shalu@533");
		
		WebElement day = driver.findElement(By.xpath(prop.getProperty("DOB_Days_xpath")));
		
		day.click();
		
		Actions action = new Actions(driver);
		
		action.moveToElement(day).perform();
		
		WebElement month = driver.findElement(By.xpath(prop.getProperty("DOB_Month_xpath")));
		
		month.click();
		
		action.moveToElement(month).perform();
		
		WebElement year = driver.findElement(By.xpath(prop.getProperty("DOB_Year_xpath")));
		
		year.click();
		
		action.moveToElement(year).perform();
		
		driver.findElement(By.xpath(prop.getProperty("OptionForSignIn_xpath"))).click();
		
		driver.findElement(By.xpath(prop.getProperty("Address_FN"))).sendKeys(prop.getProperty("FirstName"));
		
		driver.findElement(By.xpath(prop.getProperty("Address_Ln"))).sendKeys(prop.getProperty("LastName"));
		
		driver.findElement(By.xpath(prop.getProperty("Address_xpath"))).sendKeys("btm 2nd satge");
		
		driver.findElement(By.xpath(prop.getProperty("City_xpath"))).sendKeys("banglore");
		
		
		
		 WebElement state = driver.findElement(By.xpath(prop.getProperty("State_xpath")));
		 
		 state.click();
		 
		 Select select = new Select(state);
		 
		 select.selectByIndex(14);
		 
		// action.moveToElement(state).perform();
		 
		 driver.findElement(By.xpath(prop.getProperty("Zipcode_xpath"))).sendKeys("46077");
		 
		  WebElement country = driver.findElement(By.xpath(prop.getProperty("Country_xpath")));
		  
		  country.click();
		  
		  select.selectByIndex(21);;
		  
		  //action.moveToElement(country).perform();
		  
		  driver.findElement(By.xpath(prop.getProperty("MobilePhoneNo_xpath"))).sendKeys("9876543234");
		  
		  driver.findElement(By.xpath(prop.getProperty("AliasAddress_xpath"))).sendKeys("my add");
		  
		  driver.findElement(By.xpath(prop.getProperty("RegisterButton_xpath"))).click();
		  
		  Thread.sleep(5000);
		  
		  
		  
	}
	
	@Test(enabled = false)
	public void validateUser() throws InterruptedException {
		
        driver.findElement(By.xpath(prop.getProperty("SignInBotton_xpath"))).click();
		
        WebDriverWait wait = new WebDriverWait(driver, 30);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("EmailAdd_create_xpath"))));

		Thread.sleep(2000);
	
		driver.findElement(By.xpath(prop.getProperty("EmailAdd_create_xpath"))).sendKeys("kumarishalu312@gmail.com");
		
		driver.findElement(By.xpath(prop.getProperty("CreateAcc_xpath"))).click();
		
		Thread.sleep(3000);
		
		String errorMsg = driver.findElement(By.xpath(prop.getProperty("SameAccountErrorMsg_xpath"))).getText();

		System.out.println("Error Message :" + errorMsg);
		}
	
	@Test(enabled = false)
	public void invalidUser() throws InterruptedException {
		
		 driver.findElement(By.xpath(prop.getProperty("SignInBotton_xpath"))).click();
			
	        WebDriverWait wait = new WebDriverWait(driver, 30);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("EmailAdd_create_xpath"))));

			Thread.sleep(2000);
		
			driver.findElement(By.xpath(prop.getProperty("EmailAdd_create_xpath"))).sendKeys(prop.getProperty("EmailID"));
			
			driver.findElement(By.xpath(prop.getProperty("CreateAcc_xpath"))).click();
			
			Thread.sleep(3000);
			
			driver.findElement(By.xpath(prop.getProperty("RegisterButton_xpath"))).click();
			  
			Thread.sleep(5000);
			
			String errormsg = driver.findElement(By.xpath(prop.getProperty("ErrorMsgForMandator_fields"))).getText();
			
			System.out.println("Error Message : " + errormsg);
			
	     }
	@Test
	public void enterInvalidData() throws InterruptedException {
		
		 	driver.findElement(By.xpath(prop.getProperty("SignInBotton_xpath"))).click();
			
	        WebDriverWait wait = new WebDriverWait(driver, 30);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("EmailAdd_create_xpath"))));

			Thread.sleep(2000);
		
			driver.findElement(By.xpath(prop.getProperty("EmailAdd_create_xpath"))).sendKeys(prop.getProperty("EmailID"));
			
			driver.findElement(By.xpath(prop.getProperty("CreateAcc_xpath"))).click();
			
			Thread.sleep(3000);
			
			driver.findElement(By.id(prop.getProperty("TitleButton_id"))).click();
			
			driver.findElement(By.xpath(prop.getProperty("CustomerFN_xpath"))).sendKeys("8765");
			
			driver.findElement(By.xpath(prop.getProperty("CustomerLN_xpath"))).sendKeys("8765");
			
			driver.findElement(By.xpath(prop.getProperty("YourLogoPassword_xpath"))).sendKeys("Shalu@533");
			
			WebElement day = driver.findElement(By.xpath(prop.getProperty("DOB_Days_xpath")));
			
			day.click();
			
			Actions action = new Actions(driver);
			
			action.moveToElement(day).perform();
			
			WebElement month = driver.findElement(By.xpath(prop.getProperty("DOB_Month_xpath")));
			
			month.click();
			
			action.moveToElement(month).perform();
			
			WebElement year = driver.findElement(By.xpath(prop.getProperty("DOB_Year_xpath")));
			
			year.click();
			
			action.moveToElement(year).perform();
			
			driver.findElement(By.xpath(prop.getProperty("OptionForSignIn_xpath"))).click();
			
			driver.findElement(By.xpath(prop.getProperty("Address_FN"))).sendKeys("4365768");
			
			driver.findElement(By.xpath(prop.getProperty("Address_Ln"))).sendKeys("8765");
			
			driver.findElement(By.xpath(prop.getProperty("Address_xpath"))).sendKeys("btm 2nd satge");
			
			driver.findElement(By.xpath(prop.getProperty("City_xpath"))).sendKeys("098765");
			
			 WebElement state = driver.findElement(By.xpath(prop.getProperty("State_xpath")));
			 
			 state.click();
			 
			 Select select = new Select(state);
			 
			 select.selectByIndex(14);
			 
			 driver.findElement(By.xpath(prop.getProperty("Zipcode_xpath"))).sendKeys("46077");
			 
			  WebElement country = driver.findElement(By.xpath(prop.getProperty("Country_xpath")));
			  
			  country.click();
			  
			  select.selectByIndex(21);;
			  
			  driver.findElement(By.xpath(prop.getProperty("MobilePhoneNo_xpath"))).sendKeys("uytrgh");
			  
			  driver.findElement(By.xpath(prop.getProperty("AliasAddress_xpath"))).sendKeys("my add");
			  
			  driver.findElement(By.xpath(prop.getProperty("RegisterButton_xpath"))).click();
			  
			  Thread.sleep(5000);
			  
			  String errormsg = driver.findElement(By.xpath(prop.getProperty("ErrorMsgForMandator_fields"))).getText();
				
			  System.out.println("Error Message : " + errormsg);
				
			  }
}
