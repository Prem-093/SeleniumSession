package SeleniumSessions;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class LaunchCrossBrowser {
	WebDriver driver;

	 public WebDriver launchBrowser(String Browser)
	{
		
		 if(Browser==null)
		 {
			 System.out.println("Please pass correct Browser" +Browser);
			 throw new MySeleniumException("URLNULLEDEXCEPTION");
		 }
		 if(Browser.equalsIgnoreCase("Chrome")) {
		
		driver=new ChromeDriver();
		 
		}
		
		else if(Browser.equalsIgnoreCase("Safari"))
		{
			
		driver=new SafariDriver();
		}

		else if(Browser.equalsIgnoreCase("FireFox"))
		{
			
		driver=new FirefoxDriver();
		}
        
		else
		{
			System.out.println("Please pass correct browser Name:"+ Browser );
		}
		
		return driver;
	}
	 
	 public void launchURL(String url)
	
	 {
		 if(url==null)
		 {
			 System.out.println("Please pass correct URL" +url);
			 throw new MySeleniumException("URLNULLEDEXCEPTION");
		 }
		 
		 driver.get(url);
	 }
	 
	 public String getTitle() 
	 {
		 return driver.getTitle();
	 }

}
