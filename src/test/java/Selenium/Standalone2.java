package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Standalone2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String prod1="ADIDAS ORIGINAL";
        String prod2="ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client/");
		LandingPage lp=new LandingPage(driver);
		driver.findElement(By.id("userEmail")).sendKeys("arhaa@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Tinku@1911");
		driver.findElement(By.id("login")).click();
		
		List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
		WebElement prod=products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(prod1)).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		List<WebElement> cartprod= driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean value=cartprod.stream().anyMatch(cartp->cartp.getText().equalsIgnoreCase(prod1));
		Assert.assertTrue(value);
		driver.findElement(By.xpath("(//*[@class='totalRow'])[3]/button")).click();
		Actions a=new Actions(driver);
		a.sendKeys(driver.findElement(By.xpath("//*[@placeholder='Select Country']")), "india").build().perform();
		driver.findElement(By.xpath("(//*[@type='button'])[2]")).click();
		driver.findElement(By.xpath("//*[@class='actions']/a")).click();
		String msg=driver.findElement(By.xpath("//*[@class='hero-primary']")).getText();
		Assert.assertTrue(msg.equalsIgnoreCase("Thankyou for the order."));
		driver.quit();
		
		
		
	}

}
