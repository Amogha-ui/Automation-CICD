package Selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import AbstractComponents.Abstractcomponent;

public class ProductCatalogue extends Abstractcomponent {
	WebDriver driver;
	public ProductCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
 //WebElement userid= driver.findElement(By.id("userEmail"));
	//List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
 @FindBy(css=".mb-3")
 List<WebElement> products;
 @FindBy(css=".ng-animating")
 WebElement spinner;
 By productlocator=By.cssSelector(".mb-3");
 By Productclick = By.cssSelector(".card-body button:last-of-type");
 By toast=By.cssSelector("#toast-container");
 
public List<WebElement> getProducst()
{
	waitforelementtoappear(productlocator);
	return products;
}
public WebElement getProductByname(String prod1)
{
	WebElement prod=getProducst().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(prod1)).findFirst().orElse(null);
	return prod;
}
public void addProductToCart(String prod1) throws InterruptedException
{
	WebElement prod=getProductByname(prod1);
	prod.findElement(Productclick).click();
	waitforelementtoappear(toast);
	//wait.until(ExpectedConditions.visibilityOfElementLocated(toast));
	//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	waitforelementtodisappear(spinner);
	
}
}
