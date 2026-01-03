package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenBrowser {
	
	
	 WebDriver driver ;
	
	public  WebDriver launchBrowser(String Browser)
	{   
		if(Browser.equalsIgnoreCase("Chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("FireFox"))
		{
			driver=new FirefoxDriver();
		}
		
		else if(Browser.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		
		else
		{
			System.out.println("Please pass correct Browser :"+Browser);
		}
		return driver;
	}
	
	

	
}
