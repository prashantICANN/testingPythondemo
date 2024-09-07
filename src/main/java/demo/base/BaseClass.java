package demo.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import java.util.NoSuchElementException;
import java.util.Properties;



import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;

public class BaseClass {
	
	
	
     protected static WebDriver driver ;
     public static Properties prop;
     protected Wait<WebDriver> fluentWait;
      private static final  Logger log = LogManager.getLogger(BaseClass.class);
     
      
      @BeforeMethod
     public  void  intializeDriver() throws IOException
     {
    	 try {
    	 prop = new Properties();
    	 FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "\\Configuration\\config.properties");
    	 prop.load(fis);
    	 }
    	 catch(FileNotFoundException e)
    	 {
    		 e.printStackTrace();
    	 }
    	 String browser =  prop.getProperty("browser");
    	 if(browser.equalsIgnoreCase("chrome"))
    	 {
    		 WebDriverManager.chromedriver().setup();
    		 driver = new ChromeDriver();
    	 }
    	 else if (browser.equalsIgnoreCase("mozila")){
    		 WebDriverManager.firefoxdriver().setup();
    		 driver = new FirefoxDriver();
    	 }
    	 else {
    		 WebDriverManager.edgedriver().setup();
    		 driver = new EdgeDriver();
    	 }
    	 
    	 //Define Fluent Wait
    	 fluentWait = new FluentWait<WebDriver>(driver)
    			 			.withTimeout(Duration.ofSeconds(20))
    			 			.pollingEvery(Duration.ofSeconds(3))
    			 			.ignoring(NoSuchElementException.class);
    	 
    	 
    	 
    	 driver.manage().window().maximize();
    	 driver.get(prop.getProperty("url"));
    }
     
     
     public static void takeScreenShot(WebDriver driver) throws IOException
     {
    	 TakesScreenshot scrShot =(TakesScreenshot)driver;
    	 File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
    	 String imageName =  "image" + (Math.random()*10);
    	FileUtils.copyFile(srcFile,new File(System.getProperty("user.dir") + "\\screenshotFolder\\" + imageName +".png" ));
    	 
    	 
    	 	
    	 
     }
     
     public  WebElement waitForElement(By locator)
     {
    	 return fluentWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
     }
     
     
     
     @AfterMethod
     public void tearDown()
     {
    	 if(driver!=null)
    	 {
    		 driver.quit();
    	 }
     }
     
     
     
     

}
