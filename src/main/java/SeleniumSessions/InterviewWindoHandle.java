package SeleniumSessions;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class InterviewWindoHandle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.orangehrm.com/30-day-free-trial");
		Actions action=new Actions(driver);
		action.sendKeys(Keys.END).build().perform();
		String Parentwindowid=driver.getWindowHandle();
		System.out.println(Parentwindowid);
		//driver.switchTo().newWindow(WindowType.WINDOW); //open a new window

		//driver.switchTo().window(Parentwindowid);
		
		  driver.findElement(By.xpath("//img[@alt='facebook logo']")).click();
		  Set<String> Window=driver.getWindowHandles();
		  Iterator<String> it=Window.iterator(); 
		  String ParentindowID=it.next();
		  driver.switchTo().window(ParentindowID);
		  String title=driver.getTitle();
		  System.out.println(title); 
		  String childwindow=it.next();
		  driver.switchTo().window(childwindow);
		  String childTitle=driver.getTitle();
		  System.out.println(childTitle);
		 
	
	
		
		/*
		 * List<WebElement>
		 * orangelinks=driver.findElements(By.xpath("//div[@class='social-link']//li"));
		 * for(WebElement e:orangelinks) { e.click(); }
		 * 
		 * Set<String> Window= driver.getWindowHandles();
		 * 
		 * Iterator<String> it= Window.iterator();
		 * 
		 * while(it.hasNext())
		 * 
		 * { String windowIds= it.next(); System.out.println(windowIds);
		 * driver.switchTo().window(windowIds); String urlText=driver.getCurrentUrl();
		 * System.out.println(urlText); if(!windowIds.equalsIgnoreCase(Parentwindowid))
		 * { driver.close(); } }
		 */
		
		

	}

}
