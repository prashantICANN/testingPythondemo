package demo.test;


import org.testng.annotations.*;


import demo.base.BaseClass;
import demo.pages.LoginPage;

public class LoginTest extends BaseClass{
	
	BaseClass base;
	LoginPage loginP;
	
	
	
	@BeforeMethod
	public void setup()
	{
		
		 launchUrl();
		 loginP = new LoginPage();
		
		
		
	}
	
	@Test
	
	public void loginTest()
	{
		loginP.login("testuser", "password123");
		loginP.verifyTitle();
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		System.out.println(driver.getTitle());
		driver.close();
		
		
	}

}
