package AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Selenium.ProductCart;
import Selenium.orderHistoryPage;

public class Abstractcomponent {
	WebDriver driver;

	public Abstractcomponent(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	@FindBy(css="[routerlink*='cart']")
	 WebElement cart;
	
	@FindBy(css="[routerlink*='myorders']")
	 WebElement orderHistory;
	public ProductCart gotoCart()
	{
		cart.click();
		ProductCart cart=new ProductCart(driver);
		return cart;
	}
	public orderHistoryPage orderHistory()
	{
		orderHistory.click();
		orderHistoryPage order=new orderHistoryPage(driver);
		return order;
	}
	public void waitforelementtoappear(By FindBy)
	{
		WebDriverWait wait2=new WebDriverWait(driver, Duration.ofSeconds(15));
		wait2.until(ExpectedConditions.visibilityOfElementLocated(FindBy));	
	}
	public void waitforwebelementtoappear(WebElement FindBy)
	{
		WebDriverWait wait2=new WebDriverWait(driver, Duration.ofSeconds(15));
		wait2.until(ExpectedConditions.visibilityOf(FindBy));	
	}
	
	public void waitforelementtodisappear(WebElement ele) throws InterruptedException
	{
		Thread.sleep(1000);
		//WebDriverWait wait2=new WebDriverWait(driver, Duration.ofSeconds(15));
		//wait2.until(ExpectedConditions.invisibilityOf(ele));
	}
	

}
