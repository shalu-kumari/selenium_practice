package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsGeneratorNA { 
	
	static ExtentReports extent;
	
	public static ExtentReports extentReportGenerator() {
		
		String path = System.getProperty("user.dir")+"\\reports\\output.html";
		
		ExtentSparkReporter report = new ExtentSparkReporter(path);
		
		report.config().setReportName("TestCase Report");
		
		extent = new ExtentReports();
		
		extent.attachReporter(report);
		
		extent.setSystemInfo("Tester", "shalu");
		
		return extent;
		
	}
	

}
