package TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Selenium.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	public LandingPage landingpage;
	public WebDriver initializeDriver() throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\akkis\\eclipse-workspace\\Selenium\\src\\main\\java\\Resources\\GlobalProperties.properties");
		prop.load(fis);    
		String browserName=System.getProperty("browser")!=null?System.getProperty("browser"):prop.getProperty("browser");
		//String browserName=prop.getProperty("browser");
		
		if(browserName.contains("chrome"))
		{
		ChromeOptions options=new ChromeOptions();
	   WebDriverManager.chromedriver().setup();
	   if(browserName.contains("headless"))
	   {
	   options.addArguments("headless");
	   }
	   driver=new ChromeDriver(options);
	   driver.manage().window().setSize(new Dimension(1440,900));
	   
		}
		else if(browserName.equalsIgnoreCase("Edge"))
		{
			//edge
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	
	public List<HashMap<String, String>> getjsondata(String filepath) throws IOException
	{
	//read json and convert to string
	String jsonContent=FileUtils.readFileToString(new File(filepath),StandardCharsets.UTF_8);	
	
	//convert string to hashmap- jackson databind
	ObjectMapper mapper=new ObjectMapper();
	
	List<HashMap<String,String>> data=mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){});
	return data;	
	
	}
		@BeforeMethod(alwaysRun=true)
		public LandingPage launchapplication() throws IOException
		{
			driver=initializeDriver();
		    landingpage=new LandingPage(driver);
			landingpage.navigateurl();
			return landingpage;
			
		}
        @AfterMethod(alwaysRun=true)
        public void finish()
        {
        	driver.close();        }
	    public String getScreenshot(String testCasename,WebDriver driver) throws IOException
	    {
	    	TakesScreenshot ts=(TakesScreenshot)driver;
	    	File source=ts.getScreenshotAs(OutputType.FILE);
	    	File file=new File(System.getProperty("user.dir")+"//reportd//"+testCasename+".png");
	    	FileUtils.copyFile(source, file);
	    	return System.getProperty("user.dir")+"//reportd//"+testCasename+".png";
	    }
	   /* public File getScreenshot(String testCasename,WebDriver driver) throws IOException
	    {
	    	TakesScreenshot ts=(TakesScreenshot)driver;
	    	File source=ts.getScreenshotAs(OutputType.FILE);
	    	File file=new File(System.getProperty("user.dir")+"//reportd//"+testCasename+".png");
	    	FileUtils.copyFile(source, file);
	    	return file;
	    }*/

}
