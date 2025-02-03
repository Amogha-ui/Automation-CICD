package Selenium;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import TestComponents.BaseTest;

public class ErrorValidation extends BaseTest{

	    @Test(groups= {"Errorvalidation"},retryAnalyzer=Retry.class)
	    public void errorvalidate() throws IOException, InterruptedException {
	    
      
		landingpage.landingactions("arhaa@gmail.com", "Tinku@11911");
		
		Assert.assertEquals("Incorrect email password.", landingpage.getErrorMessage());
		
		
		
		
		
		
	}

}
