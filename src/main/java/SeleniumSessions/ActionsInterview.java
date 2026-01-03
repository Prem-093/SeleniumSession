package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



public class ActionsInterview {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		
		
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		Actions action=new Actions(driver);
		WebElement rightClick=driver.findElement(By.xpath("//span[text()='right click me']"));
		//action.send
		//action.contextClick(rightClick).build().perform();
		
		  WebElement actnme=driver.findElement(By.name("email"));
		  //action.dragAndDrop(null, nu"l).build().perform();
		  org.openqa.selenium.interactions.Action act= action.clickAndHold(null).moveToElement(null).release().build();
		  act.perform();
		  
		  action.sendKeys(actnme, "Hi").build().perform();//Action.send first click and then send the valued
		//  action.sendKeys(actnme, "hellp")
		  
		  action.sendKeys(Keys.TAB).sendKeys("abc").sendKeys(Keys.TAB);//This concept we can use for accessibility testing
		 
		  action.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();
		  //action.sendKeys(Keys.END).build().perform();
		  
		  //action.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();
		  //Thread.sleep(1000);
		  
		  //action.sendKeys(Keys.HOME).build().perform();
		  
		  //driver.findElement(By.linkText("About Us")).click();
		 		action.contextClick(rightClick).build().perform();
		
				/*
				 * action.sendKeys(actnme, "ho") action.sendKeys(Keys.HOME)
				 * action.sendKeys(Keys.END) action.sendKeys(Keys.PAGE_DOWN);
				 * action.sendKeys(Keys.PAGE_UP);
				 * 
				 * action.contextClick(tfufyi)
				 * action.clickAndHold(actnme).moveToElement(actnme).release().build().perform()
				 */

	}

}
