package demo.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import demo.base.BaseClass;


public class LoginPage extends BaseClass{
	
	
	@FindBy(id = "username")
	WebElement user;
	
	
	@FindBy(id = "password")
	WebElement pass;
	
	@FindBy(id = "login")
	WebElement login;

	
	@FindBy(xpath = "//div/h2")
	WebElement homeText;
	
	
	public LoginPage()
	{
		
		PageFactory.initElements(driver, this);
	}
	
	public void login(String user1,String password1)
	{
		user.sendKeys(user1);
		pass.sendKeys(password1);
		
		login.click();		
	}
	
	public void verifyTitle()
	{
		String pageText = homeText.getText();
	
		Assert.assertEquals(pageText, "Welcome to the Home Page");
		System.out.println("***************************************************************Test Case Passed Successfully *********************************************************************");
	}
}
