package Stepdefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Selenium.CheckoutPage;
import Selenium.ConfirmationPage;
import Selenium.LandingPage;
import Selenium.ProductCart;
import Selenium.ProductCatalogue;
import TestComponents.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepdefinitionImpl extends BaseTest{
	
	public LandingPage landingpage;
	public ProductCatalogue productsq;
	public ConfirmationPage page2;
	
	
	@Given("I am on ecommerce page")
	public void I_am_on_ecommerce_page() throws IOException
	{
		landingpage=launchapplication();
	}
	@Given("^logged in with username (.+) and password (.+)$")	
	public void logged_in_with_username_and_password(String username,String pass)
	{
		 productsq=landingpage.landingactions(username,pass);
	}
	  
    @When("^I add (.+) to cart$")
    public void i_add_to_cart(String productName) throws InterruptedException
    {
    	List<WebElement> prod_new=productsq.getProducst();
		productsq.addProductToCart(productName);
    }
    //And checkout <productName> and submit the order 
	/*@And("checkout <productName> and submit the order")
	public void checkout_and_submit(String pname)
	{
		ProductCart cart=productsq.gotoCart();
		Boolean value=cart.cartvalidate(pname);		
		Assert.assertTrue(value);
		CheckoutPage page=cart.gotocheckout();
		page.selectCountry("india");
	    page2=page.submit();		
	}*/
	@When("checkout <productName> and submit the order")
	public void checkout_qwerty_and_submit_the_order(String productName) {
		ProductCart cart=productsq.gotoCart();
		Boolean value=cart.cartvalidate(productName);		
		Assert.assertTrue(value);
		CheckoutPage page=cart.gotocheckout();
		page.selectCountry("india");
	    page2=page.submit();
	}
	 @Then("{string} message is displayed on confirmation page")
	 public void message_displayed(String string)
	 {
		String msg=page2.getText();
		Assert.assertTrue(msg.equalsIgnoreCase("Thankyou for the order."));	
		driver.close();
	 }
	 @Then ("{string} is displayed")
	 public void message_is_displayed(String string)
	 {
		 Assert.assertEquals(string, landingpage.getErrorMessage());
		 driver.close();
		 }
	 
	 
	
	
	
	
	
	
	

	
	
	
}
