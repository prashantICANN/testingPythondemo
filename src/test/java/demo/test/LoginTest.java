package demo.test;


import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;


import demo.base.BaseClass;
import demo.pages.LoginPage;


public class LoginTest extends BaseClass{
	
	BaseClass base;
	LoginPage loginP;
	 private static final Logger logger = LogManager.getLogger(LoginTest.class);
	
	
	@BeforeMethod
	public void setup() throws IOException
	{
		base = new BaseClass();
		// base.intializeDriver();
		 loginP = new LoginPage();
		
		
		
	}
	
	@Test
	
	public void loginTest() throws IOException
	{
		logger.info("Login Test Started");
		loginP.login("testuser", "password123");
		takeScreenShot(driver);
		loginP.verifyTitle();
		logger.info("Login Test COmpleted Successfully ");
		System.out.println("Test case passed successfully");
	}
	
	

}
