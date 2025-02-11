package testComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class TestClass {
	
    protected static WebDriver driver;
    
    public WebDriver initBrowser() throws IOException {
    	
    FileInputStream fs=new FileInputStream("D:\\lab program\\CoreJavaBasic\\src\\SeleniumFramework\\src\\main\\java\\resources\\Properties.properties");
    Properties prop=new Properties();
    prop.load(fs);
    String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");
    if(browserName.equals("chrome")) {
    	driver=new ChromeDriver();
    	
    }else if(browserName.equals("firefox")) {
    	
    	driver=new FirefoxDriver();
    }
    else if(browserName.equals("edge")) {
    	driver=new EdgeDriver();
    }
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	String baseUrl=prop.getProperty("baseUrl");
	driver.get(baseUrl);
	return driver;
    }
    
    public void tearDown() {
    	
    	driver.close();
    }
    
    public static String getScreenshot(String TestcaseName,WebDriver driver) throws IOException {
    	
    	TakesScreenshot ts=(TakesScreenshot)driver;
    	String path=System.getProperty("C:\\Users\\sambhaji\\new screenshot")+"//reports"+ TestcaseName+".png";
    	File source=ts.getScreenshotAs(OutputType.FILE);
    	File destination=new File(path);
    	FileHandler.copy(source, destination);
    	
    	return path;
    	
    }
}
