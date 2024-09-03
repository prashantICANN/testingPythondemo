package demo.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	
	
	
	
     public static WebDriver driver ;
     
     
     public  void  launchUrl()
     
     
     {
    	 driver = new ChromeDriver();
    	 driver.get("http://127.0.0.1:5000/");
    	 driver.manage().window().maximize();
     }
     

}
