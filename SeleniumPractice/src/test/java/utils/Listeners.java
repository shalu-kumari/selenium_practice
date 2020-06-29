package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners  implements ITestListener{
	
	ExtentReports extent = ExtentReportsGeneratorNA.extentReportGenerator();
	
	ExtentTest test;
	
	WebDriver driver;
	
	 private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		
		test = extent.createTest(result.getMethod().getMethodName());
	
		extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		
		extentTest.get().log(Status.PASS, "test case executed successfully");
		
	}

	public void onTestFailure(ITestResult result) {
		
		
		extentTest.get().fail(result.getThrowable());
		//test.log(Status.FAIL, "Test Case failed");
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		 driver.close();
		 
		 extent.flush();
	}

}
