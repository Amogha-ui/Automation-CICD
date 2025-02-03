package Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import AbstractComponents.Abstractcomponent;

public class orderHistoryPage extends Abstractcomponent {
	WebDriver driver;
	public orderHistoryPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	}
	
	
	//driver.findElement(By.xpath("(//*[@class='totalRow'])[3]/button")).click();
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> orderHistory;
	
	
	
	
	public Boolean ordervalidate(String prod1) {
	
	Boolean value=orderHistory.stream().anyMatch(cartp->cartp.getText().equalsIgnoreCase(prod1));
	return value;

	}
	
}
