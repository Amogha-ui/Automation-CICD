package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestComponents.BaseTest;

public class Standalone extends BaseTest{
	 String prod2="ZARA COAT 3";

	    @Test(dataProvider="getData2",groups= {"Errorvalidation"})
	    public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException {
	    
	      	       
			ProductCatalogue productsq=landingpage.landingactions(input.get("email"), input.get("password"));
			List<WebElement> prod_new=productsq.getProducst();
			productsq.addProductToCart(input.get("productName"));
			ProductCart cart=productsq.gotoCart();
			Boolean value=cart.cartvalidate(input.get("productName"));
			
			Assert.assertTrue(value);
			CheckoutPage page=cart.gotocheckout();
			page.selectCountry("india");
			ConfirmationPage page2=page.submit();		
			String msg=page2.getText();
			Assert.assertTrue(msg.equalsIgnoreCase("Thankyou for the order."));		
		
	}
	    
	    @Test(dependsOnMethods= {"submitOrder"})
	    public void orderVerification() throws IOException, InterruptedException {
	    
	       
			ProductCatalogue productsq=landingpage.landingactions("arhaa@gmail.com", "Tinku@1911");
			orderHistoryPage order=productsq.orderHistory();
			order.ordervalidate(prod2);					
		
	}
	    

	    @DataProvider
	    public Object[][] getData2() throws IOException
	    {
//	    	HashMap<String,String> map=new HashMap<String,String>();
//	    	map.put("email", "arhaa2@gmail.com");
//	    	map.put("password", "Tinku@1911");
//	    	map.put("productName", "ADIDAS ORIGINAL");
//	    	
//	    	HashMap<String,String> map1=new HashMap<String,String>();
//	    	map1.put("email", "arhaa2@gmail.com");
//	    	map1.put("password", "Tinku@1911");
//	    	map1.put("productName", "ADIDAS ORIGINAL");
	    	
	    	List<HashMap<String,String>> data=getjsondata(System.getProperty("user.dir")+"\\src\\test\\java\\Data\\Dataprovider.json");
	    	return new Object[][] {{data.get(0)},{data.get(1)}};
	    	
	    }
	    
	    @DataProvider
	    public Object[][] getData()
	    {
	    	return new Object[][] {{"arhaa2@gmail.com","Tinku@1911","ADIDAS ORIGINAL"},{"arhaa@gmail.com","Tinku@1911","ZARA COAT 3"}};
	    }
}
