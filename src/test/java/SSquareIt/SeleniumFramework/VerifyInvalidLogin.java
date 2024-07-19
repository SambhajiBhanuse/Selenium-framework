package SSquareIt.SeleniumFramework;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import testComponents.TestClass;

public class VerifyInvalidLogin extends TestClass {
	
	@Test
	public void verifywithInvaliLogin() throws IOException {
		
		WebDriver driver= initBrowser();
		LandingPage lp=new LandingPage(driver);
		LoginPage login=lp.navigateToLoginPage();
		HomePage hp=login.loginAction("bhanusepatil33@gmail.com", "Sambhaji@33");
		
		SoftAssert sa=new SoftAssert();
		
		String actual=driver.getCurrentUrl();
		String expected="https://tutorialsninja.com/demo/index.php?route=account/account";
		sa.assertEquals(actual, expected);
		tearDown();
		sa.assertAll();
		
	}

}
