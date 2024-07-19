package SSquareIt.stepDefinition;

import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Then;
import testComponents.TestClass;

public class InvalidStep extends TestClass {
	
	@Then("verify the url of current page")
	public void  verify_the_url_of_current_page() {
		
      SoftAssert sa=new SoftAssert();
	String actual=driver.getCurrentUrl();
	String expected="https://tutorialsninja.com/demo/index.php?route=account/account";
	sa.assertEquals(actual, expected);
	 tearDown();
	sa.assertAll();
	}

}
