package SSquareIt.SeleniumFramework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BasePageClass;

public class ProductPage extends BasePageClass {
	
	static WebDriver driver;
	
	@FindBy(css="div.product-grid")
	private List<WebElement> products;
	
	By productLocation = By.cssSelector("div h4");
	By cartToProduct=By.cssSelector("a");
	
	public ProductPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> getproducts(){
		
		visibilityOfElementLocated(productLocation);
		return products;
		
		
	}
	
	public WebElement getProductByName(String proName) {
		
		WebElement ProdCamera=null;
		for(WebElement product:products) {
			
		WebElement targetproduct=	product.findElement(productLocation);
		String productname=targetproduct.getText();
		System.out.println(productname);
		if(productname.equalsIgnoreCase(proName)) {
			ProdCamera=targetproduct.findElement(cartToProduct);
	
		
	return ProdCamera;
	}
}
		return ProdCamera;
}
	public ProductDetails addProductToCart(String proName) {
		
		WebElement prod=getProductByName( proName);
		prod.click();
		ProductDetails details=new ProductDetails(driver);
		 return details;
	}
	}
