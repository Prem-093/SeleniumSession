package Seleniumcheataheet;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WindowHandle {

	static WebDriver driver;
	
	
	public static String twoWindowHandle(By locator,String parID)
	{
		driver.findElement(locator).click();
		Set<String> handles=driver.getWindowHandles();
		Iterator<String> it=handles.iterator();
		String Parenwindow=it.next();
		String childwindow=it.next();
		System.out.println(childwindow);
		driver.switchTo().window(childwindow);
		String url=driver.getCurrentUrl();
		driver.close();
		return url;
	}

	public static void multipleWindowHandle(String parID) {
		Set<String> handles = driver.getWindowHandles();
       Iterator<String> it= handles.iterator();
       while(it.hasNext())
       {
    	   String windowid=it.next();
    	   System.out.println(windowid);
    	   driver.switchTo().window(windowid);
    	  String ttile= driver.getTitle();
    	 System.out.println(ttile);
    	 
    	 if(!windowid.equalsIgnoreCase(parID))
    	 {
    		 driver.close();
    	 }
       }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();

		driver.get("https://www.orangehrm.com/30-day-free-trial/");
		String parentWindow = driver.getWindowHandle();

		Actions action = new Actions(driver);

		action.sendKeys(Keys.END).build().perform();
		
		By locFacebook=By.xpath("//img[@alt='facebook']");
		String titleTxt=twoWindowHandle(locFacebook,parentWindow);
		System.out.println(titleTxt);
		
	
		
		
		
		
		/*
		 * List<WebElement> list =
		 * driver.findElements(By.xpath("//div[@class='social-link']//li"));
		 * 
		 * 
		 * 
		 * //System.out.println(parentWindow); for (WebElement e : list) { e.click(); }
		 * 
		 * 
		 * multipleWindowHandle(parentWindow);
		 */
	}

}
