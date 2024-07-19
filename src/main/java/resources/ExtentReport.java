package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	
	public  static ExtentReports extentReports() {
		
		String path=System.getProperty("C:\\Users\\sambhaji") + "//reports//index.html";
		ExtentSparkReporter reports=new ExtentSparkReporter(path);
		reports.config().setDocumentTitle("Test Reports");
		reports.config().setReportName("Automation Test Reports");
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reports);
		extent.setSystemInfo("Tester", "Sambhaji");
		
		return extent;
	}

}
