package SSquareIt.SeleniumFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	static WebDriver driver;
//	driver.findElement(By.id("input-email")).sendKeys("bhanusepatil333@gmail.com");
//	driver.findElement(By.id("input-password")).sendKeys("Sambhaji@333");
//	driver.findElement(By.xpath("//input[@type='submit']")).click();
//	
	@FindBy(id="input-email")
	private WebElement username;
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submitButton;
	
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public HomePage loginAction(String userEmail, String  UserPassword ) {
		
		username.sendKeys(userEmail);
		password.sendKeys(UserPassword);
		submitButton.click();
		HomePage hp=new HomePage(driver);
		return hp;
	}
	
}
