package SeleniumSessions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WindowHandle {

	WebDriver driver;

	public WindowHandle(WebDriver driver) {

		this.driver = driver;
	}

	public void windowHandels(Actions action, By locator, ElementUtil util) {

		action.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();
		util.doClick(locator);
		Set<String> Window = driver.getWindowHandles();
		Iterator<String> it = Window.iterator();
		String parentWindow = it.next();
		System.out.println(parentWindow);
		String childWindow = it.next();
		System.out.println(childWindow);
		driver.switchTo().window(childWindow);
		String childURl = driver.getCurrentUrl();
		System.out.println(childURl);
		driver.close();
		driver.switchTo().window(parentWindow);
		String chilURL = driver.getCurrentUrl();
		System.out.println(chilURL);
		driver.quit();
	}

	public void windowMultipleHandle(Actions action, By locator, ElementUtil util) {

		action.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();
		util.doeveryLinkClick(locator);
		String parenWind = driver.getWindowHandle();

		Set<String> windowID = driver.getWindowHandles();

		Iterator<String> it = windowID.iterator();
		
	//ArrayList<String> list=new	ArrayList<String>();
		
		while (it.hasNext()) {
			String windowText = it.next();
			System.out.println(windowText);
			driver.switchTo().window(windowText);
			String url = driver.getCurrentUrl();
			System.out.println(url);

			if (!windowText.equalsIgnoreCase(parenWind)) {

				driver.close();
			}
		}
		driver.switchTo().window(parenWind);

		String parURL = driver.getCurrentUrl();

		System.out.println(parURL);

		driver.quit();

	}

	public static void main(String[] args) throws InterruptedException {

		LaunchCrossBrowser CrBr = new LaunchCrossBrowser();

		WebDriver driver = CrBr.launchBrowser("Chrome");

		Actions action = new Actions(driver);
		ElementUtil util = new ElementUtil(driver);

		driver.get("https://www.orangehrm.com/30-day-free-trial/");

		// Thread.sleep(3000);

		// driver.get("https://opensource-demo.orangehrmlive.com/");//parent page
		// Thread.sleep(3000);
		//action.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();

	By locLink=By.xpath("//div[@class='social-link']//li");
		
		/*driver.findElement(By.xpath("(//div[@class='social-link']//li)[1]")).click();

		driver.findElement(By.xpath("(//div[@class='social-link']//li)[2]")).click();

		driver.findElement(By.xpath("(//div[@class='social-link']//li)[3]")).click();*/

		/*String parenWind = driver.getWindowHandle();

		Set<String> windowID = driver.getWindowHandles();

		Iterator<String> it = windowID.iterator();*/

	/*	while (it.hasNext()) {
			String windowText = it.next();
			System.out.println(windowText);
			driver.switchTo().window(windowText);
			String url = driver.getCurrentUrl();
			System.out.println(url);
			
			if(!windowText.equalsIgnoreCase(parenWind))
			{
				
				driver.close();
			}
		}*/
		
		/*driver.switchTo().window(parenWind);
		
		String parURL=driver.getCurrentUrl();
		
		System.out.println(parURL);
		
		driver.quit();*/
		WindowHandle wndHandle = new WindowHandle(driver);
		
		wndHandle.windowMultipleHandle(action, locLink,util);
		//driver.getCurrentUrl();

		// driver.switchTo().window(parenWind);
		// driver.quit();
		// System.out.println(parenWind);

		// (//div[@class='social-link']//li)[2]
		// By widLOC = By.xpath("(//div[@class='social-link']//li)[1]");

		/*
		 * Set<String> Window = driver.getWindowHandles();
		 * 
		 * Iterator<String> it = Window.iterator(); String ParentWindow = it.next();
		 * System.out.println(ParentWindow);
		 * 
		 * String ChildWindow = it.next();
		 * 
		 * System.out.println(ChildWindow);
		 * 
		 * driver.switchTo().window(ChildWindow);
		 * System.out.println(driver.getCurrentUrl()); // driver.getCurrentUrl();
		 * driver.close(); driver.switchTo().window(ParentWindow);
		 * System.out.println(driver.getCurrentUrl()); driver.quit();
		 */

	
		// wndHandle.windowHandels(action, locLink, util);

	}

}
