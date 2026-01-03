package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Alert {

	public static void main(String[] args) {
		
		
		WebDriver driver=new ChromeDriver();
		
		ElementUtil util=new ElementUtil(driver);

		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		By righsugg_loc=By.xpath("//span[text()='right click me']");
	
	  Actions action=new Actions(driver);
	  action.contextClick(driver.findElement(righsugg_loc)).build().perform();
	  
	By link=  By.xpath("//ul[@class='context-menu-list context-menu-root']/li/span");
	  
	  util.doLinkClick(link, "Paste");
	  
	  
	  
	}

}
