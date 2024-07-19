package SSquareIt.SeleniumFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	static WebDriver driver;
	
  @FindBy(xpath="//strong[text()='Total']/../following-sibling::td")
	private WebElement totalprice;
	
	@FindBy(xpath="//strong[text()='Checkout']")
	private WebElement checkoutButton;
	
	
	public CartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}
	
	public String getPrice() {
		
		String netPrice=totalprice.getText();
		return netPrice;
	}
	public CheckOutPage goToCheckoutPage() {
		
		checkoutButton.click();
	CheckOutPage checkout=new CheckOutPage(driver);
	return checkout;
	}

}
