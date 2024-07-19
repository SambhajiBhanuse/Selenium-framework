package SSquareIt.SeleniumFramework;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testComponents.TestClass;

public class E2ETest extends TestClass{
	
	@Test(dataProvider="getData")
	public void endTOENDTest(String username,String password) throws IOException {
	
		WebDriver driver= initBrowser();
	LandingPage lp=new LandingPage(driver);
	LoginPage login=lp.navigateToLoginPage();
	HomePage hp=login.loginAction(username, password);
	ProductPage pp=hp.clickOnCameraTab();
	ProductDetails details= pp.addProductToCart("Nikon D300");
	Assert.assertEquals(details.getPrice(), "$98.00");
	 CartPage cp=details.setQuantity("2");
	Assert.assertEquals(cp.getPrice(), "$196.00");
	CheckOutPage checkout=cp.goToCheckoutPage();
	 checkout.goToCheckout();
	 checkout.getErrorMessage();
	 boolean isSuccess=checkout.getSuccessMessage().equalsIgnoreCase("***");
	 Assert.assertTrue(isSuccess);	
	 
	 tearDown();
	
	}
	@DataProvider(name="getData")
	public Object[][] getData() {
		return new Object[][] {
			{"sambhajibhanuse333@gmail.com","Sambhaji@0207"},
			{"bhanusepatil333@gmail.com","Sambhaji@333"}};
	}	
		
	}
