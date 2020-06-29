package com.selenium.demo.selenium.demo.practice;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class PopUp {
	
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
		
		driver.get(prop.getProperty("URL"));
		
		driver.manage().window().maximize();
		
		}
		
	
		@Test(enabled = false)
		public void toolTips() throws InterruptedException {
			
		WebElement tutorial = driver.findElement(By.xpath(prop.getProperty("ToolTip")));
		
		Actions action = new Actions(driver);
		
		action.moveToElement(tutorial).perform();
		
		Thread.sleep(1000);
		
		WebElement java= driver.findElement(By.xpath(prop.getProperty("ToolTip2")));
		
		action.moveToElement(java).perform();
		
		Thread.sleep(1000);
		
		WebElement tooltip= driver.findElement(By.xpath(prop.getProperty("ToolTip3")));
		
		String tooltipText = tooltip.getText();
		
		System.out.println("TooltipText: " +tooltipText);
		
		Assert.assertEquals("Selenium & Cucumber Basic Tutorial", tooltipText);
		
		Thread.sleep(3000);
		
		tooltip.click();
		
		String pageTitle= driver.getTitle();
		
		System.out.println("page title: " +pageTitle);
		
		String exp_pageTitle="Selenium Framework | cucumber-jvm and Selenium";
		
		if(pageTitle.equals(exp_pageTitle) ) 
			
			System.out.println("Page Title matched ");
			
		else
			
			System.out.println("page Title not matched");
		
		}
		
		@Test(enabled = false)
		public void browserWindow() throws InterruptedException {
			
			driver.findElement(By.xpath(prop.getProperty("WindowBrowser"))).click();
			
			driver.findElement(By.xpath(prop.getProperty("MessageWindow"))).click();
			
			String parentWindow = driver.getWindowHandle();
			
		        Set<String> winhandle = driver.getWindowHandles();
		        
		        Iterator<String> itr = winhandle.iterator();
		        
		        while(itr.hasNext()) {
		        	
		        	String childWindow = itr.next();
		       	
		        	if(!parentWindow.equals(childWindow)) {
		        		
		        		 driver.switchTo().window(childWindow);
		        		 
		        		driver.close();		
		        	}
		        	
		        	 }
		        driver.switchTo().window(parentWindow);
			
			}
		
		@Test(enabled = false)
		public void newTab() throws AWTException {
			
			driver.findElement(By.xpath(prop.getProperty("NewTab"))).click();
			
			Robot r =new Robot();
			
			r.keyPress(KeyEvent.VK_CONTROL);
			
			r.keyPress(KeyEvent.VK_TAB);
			
		//	String url = driver.getCurrentUrl();
			
		//	System.out.println("current url " + url);
			
			driver.quit();
	}
		
		@Test(enabled = false)
		public void handleNewBrowser() {
			 
			String oldTab = driver.getWindowHandle();
			
			driver.findElement(By.xpath(prop.getProperty("NewTab"))).click();
			
			WebDriverWait wait = new WebDriverWait(driver, 60);
			
			wait.until(ExpectedConditions.numberOfWindowsToBe(2));
			
			ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles()) ;
			
			newTab.remove(oldTab);
			
			driver.switchTo().window(newTab.get(0));
			
			assertEquals(driver.getTitle(), "Selenium Framework | Selenium, Cucumber, Ruby, Java et al.");
			
			driver.close();
			
			driver.switchTo().window(oldTab);
			
			assertEquals(driver.getTitle(), "Selenium Framework | Practiceform");
						
		}
		
		@Test(enabled = false)
		public void JavascriptAlert() throws InterruptedException {
			
			driver.findElement(By.xpath(prop.getProperty("AlertBox"))).click();
			
			Alert alert = driver.switchTo().alert();
			
			String msg = alert.getText();
			
			System.out.println("message present " + " "+ msg);
			
			alert.accept();
			
			driver.findElement(By.xpath(prop.getProperty("TimeAlert"))).click();
			
			Thread.sleep(5000);
			
			Alert alert1 = driver.switchTo().alert();
			
			String msg2 =alert1.getText();
			
			System.out.println("message present in time alert"+ " "+msg2);
			
			alert1.accept();
			
			}
		
		@Test(enabled = false)
		public void textColor() throws InterruptedException {
			
		//	WebElement element = driver.findElement(By.xpath("//span[@id='clock']"));
			
			WebDriverWait wait = new WebDriverWait(driver, 3);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='clock']")));
			
			WebElement un = driver.findElement(By.xpath(prop.getProperty("TextColor")));
			
			String color = un.getCssValue("color");
			
			System.out.println("color"+ color);
			
			String v = Color.fromString(color).asHex();
			
			System.out.println("color code" + " "+ v);
			
			assertEquals(v, "#ff0000");
			
		}
		
		@Test(enabled = false)
		public void dragDrop() throws InterruptedException {
			
		WebElement source =	driver.findElement(By.xpath(prop.getProperty("DragSource")));
			
		WebElement target =	driver.findElement(By.xpath(prop.getProperty("DragTraget")));
		
		int x = target.getLocation().getY();
		
		System.out.println("x = " + x);
			
			Actions action = new Actions(driver);
			
			action.clickAndHold(source).moveToElement(target).release().perform();
			
			//action.dragAndDrop(source, target).perform();
			
			Thread.sleep(5000);
			
			int y = target.getLocation().getY();
			
			System.out.println("y = " + y);
			
			if(x == y) {
				
			System.out.println("Drag and Drop operation failed");
			}
			else {
				System.out.println("Drag and Drop happened successfully");
				
				}
		}
		
		@Test
		
		public void handlingFrame() {
			
			//driver.switchTo().frame(0);
			
			//driver.switchTo().frame(0);
			
			System.out.println(driver.findElement(By.xpath(prop.getProperty("EmailFrame_xpath"))).isDisplayed());
			
			
			driver.findElement(By.xpath(prop.getProperty("EmailFrame_xpath"))).sendKeys("kumarishalu312@gmail.com");
			
			driver.findElement(By.xpath(prop.getProperty("Name_xpath"))).sendKeys("pagal");
			
			driver.findElement(By.xpath(prop.getProperty("SubscribeButton_xpath"))).click();
			
			 String parentwin = driver.getWindowHandle();
			 
			 Set<String> set = driver.getWindowHandles();
			 
			 Iterator<String>itr = set.iterator();
			 
			 while(itr.hasNext()) {
				 
				 String childwin = itr.next();
						 
						 if(!parentwin.equals(childwin)) {
							 
							 driver.switchTo().window(childwin);
							 
							 driver.close();
						 }
				  }
			
			 driver.switchTo().window(parentwin);
			 
	 		
			
	 		
			
		}
	}


