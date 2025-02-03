package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.Abstractcomponent;

public class CheckoutPage extends Abstractcomponent{
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//*[@placeholder='Select Country']")
	WebElement country;
	@FindBy(xpath="(//*[@type='button'])[2]")
	WebElement selectcountry;
	@FindBy(xpath="//*[@class='actions']/a")
	private WebElement submit;
	By results=By.cssSelector(".ta-results");
	public void selectCountry(String countryName)
	{
		Actions a=new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		waitforelementtoappear(By.cssSelector(".ta-results"));
		selectcountry.click();
	}
	public ConfirmationPage submit()
	{
		submit.click();
		return new ConfirmationPage(driver);
	}
	
	//Actions a=new Actions(driver);
	//a.sendKeys(driver.findElement(By.xpath("//*[@placeholder='Select Country']")), "india").build().perform();
	//driver.findElement(By.xpath("(//*[@type='button'])[2]")).click();
	//driver.findElement(By.xpath("//*[@class='actions']/a")).click();

	
	

}
