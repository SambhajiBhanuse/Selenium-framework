package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageClass  {
	
	static WebDriver driver;
	
	@FindBy(xpath="//span[@id='cart-total']/..")
	private WebElement cartButton; 
	
	public BasePageClass(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public static  void visibilityOfElementLocated(By FindBy) {
		
	WebDriverWait wa=new WebDriverWait(driver,Duration.ofSeconds(10));
	wa.until(ExpectedConditions.visibilityOfElementLocated(FindBy));

}
	public void clickOnCart() {
		
		cartButton.click();
		
	}
}