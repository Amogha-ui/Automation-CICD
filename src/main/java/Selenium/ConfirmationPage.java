package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.Abstractcomponent;

public class ConfirmationPage extends Abstractcomponent {
	WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//driver.findElement(By.xpath("//*[@class='hero-primary']")).getText();
	@FindBy(xpath="//*[@class='hero-primary']")
	WebElement message;
	public String getText()
	{
		
		String msg=message.getText();
		return msg;
		
	}

}
