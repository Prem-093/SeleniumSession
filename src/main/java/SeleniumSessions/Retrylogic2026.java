package SeleniumSessions;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Retrylogic2026 {
	
	static WebDriver driver;
	
	public static WebElement getElement(By locator) {
		 
		return driver.findElement(locator);
	}
	
	
	
	public static void retryLogic(By locator , int Timeout)
	{
		
		 int attempt=0;
		 WebElement element=null;
		while(attempt<Timeout)
		{
			
			try {
			 element=getElement(locator);
			 
			 System.out.println("Element is  found ::" +locator+ "...." +attempt);
			 
			 break;
			}
			catch(NoSuchElementException e)
			{
				System.out.println("Element is not found ::"+locator+ "...."+attempt);
			
			
			   try {
				
				Thread.sleep(500);
			}  catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			
			
			attempt++ ;
		}
		
		if(element==null)
		{
			System.out.println("Element is not found within timeout:"+Timeout);
		}
	
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		By user_name=By.name("username");
		retryLogic(user_name,20);
		
	}


}
