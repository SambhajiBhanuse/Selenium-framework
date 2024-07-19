package SSquareIt.stepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import SSquareIt.SeleniumFramework.CartPage;
import SSquareIt.SeleniumFramework.CheckOutPage;
import SSquareIt.SeleniumFramework.HomePage;
import SSquareIt.SeleniumFramework.LandingPage;
import SSquareIt.SeleniumFramework.LoginPage;
import SSquareIt.SeleniumFramework.ProductDetails;
import SSquareIt.SeleniumFramework.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testComponents.TestClass;

public class E2EStepClass extends TestClass{
	LoginPage login;
	HomePage hp;
	ProductPage pp;
	CheckOutPage checkout;
	
	@Given("Navigate to baseUrl")
	public void Navigate_to_baseUrl() throws IOException {
		
	WebDriver driver= initBrowser();
	LandingPage lp=new LandingPage(driver);
	 login=lp.navigateToLoginPage();
		
	}
    @Given("^login with username (.+) and password (.+)$")
    public void login_with_username_name_and_password_password(String name,String password) {
    	
    	 hp=login.loginAction(name, password);
    }
    @When("^product (.+) added to cart and checkout$")
    public void product_added_to_cart_and_checkout(String product) {
    	 pp=hp.clickOnCameraTab();
    	ProductDetails details= pp.addProductToCart(product);
    	Assert.assertEquals(details.getPrice(), "$98.00");
    	 CartPage cp=details.setQuantity("2");
    	Assert.assertEquals(cp.getPrice(), "$196.00");
    	 checkout=cp.goToCheckoutPage();
    	 checkout.goToCheckout();
    }
    @Then("verify the details {string}")
    public void verify_the_details(String string) {
    	
    	 checkout.getErrorMessage();
    	 boolean isSuccess=checkout.getSuccessMessage().equalsIgnoreCase("***");
    	 Assert.assertTrue(isSuccess);	
    	 tearDown();
    	
    }
	
	}


