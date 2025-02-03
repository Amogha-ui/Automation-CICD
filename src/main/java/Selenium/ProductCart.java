package Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import AbstractComponents.Abstractcomponent;

public class ProductCart extends Abstractcomponent {
	WebDriver driver;
	public ProductCart(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	}
	
	
	//driver.findElement(By.xpath("(//*[@class='totalRow'])[3]/button")).click();
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartval;
	
	@FindBy(xpath="(//*[@class='totalRow'])[3]/button")
	WebElement cartcheckout;
	
	
	
	
	public Boolean cartvalidate(String prod1) {
	
	Boolean value=cartval.stream().anyMatch(cartp->cartp.getText().equalsIgnoreCase(prod1));
	return value;

	}
	public CheckoutPage gotocheckout()
	{
		cartcheckout.click();
		return new CheckoutPage(driver);
	}
}
