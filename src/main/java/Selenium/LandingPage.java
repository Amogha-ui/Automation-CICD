package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.Abstractcomponent;

public class LandingPage extends Abstractcomponent {
	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
 //WebElement userid= driver.findElement(By.id("userEmail"));
 @FindBy(id="userEmail")
 WebElement userid;
 @FindBy(id="userPassword")
 WebElement passwrd;
 @FindBy(id="login")
 WebElement submit;
 @FindBy(css="[class*='flyInOut")
 WebElement errormsg;
 
 public ProductCatalogue landingactions(String name,String password)
 {
	 userid.sendKeys(name);
	 passwrd.sendKeys(password);
	 submit.click();
	 ProductCatalogue productsq=new ProductCatalogue(driver);
	 return productsq;
	 
 }

public void navigateurl()
{
	driver.get("https://rahulshettyacademy.com/client/");
}

public String getErrorMessage() {
	waitforwebelementtoappear(errormsg);
	return errormsg.getText();
	
	
}
}
