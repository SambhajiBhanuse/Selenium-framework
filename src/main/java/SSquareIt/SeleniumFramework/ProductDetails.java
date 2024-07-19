package SSquareIt.SeleniumFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BasePageClass;

public class ProductDetails extends BasePageClass{
	
	static WebDriver driver;

	@FindBy(xpath="(//h1[text()='Nikon D300'])/..//ul[@class='list-unstyled']//h2")
	
	private WebElement price;
	
	@FindBy(xpath="//input[@name='quantity']")
	private WebElement qty;
	
	@FindBy(id="button-cart")
	private WebElement quantityButton;
	
	
	public ProductDetails(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}
	
	public String getPrice() {
		
		String proPrice=price.getText();
		return proPrice;
	}
	public CartPage setQuantity(String quantity) {
		
		qty.clear();
		qty.sendKeys(quantity);
		quantityButton.click();
		clickOnCart();
	  CartPage cp=new CartPage(driver);
		  return cp;
		
	}
}
