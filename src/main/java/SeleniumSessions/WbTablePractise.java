package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WbTablePractise {
	
	static WebDriver driver;
	
	public static  void getWebTableSelecturHubPrecedingSibling(String name)
	{
		driver.findElement(By.xpath("//a[text()='"+name+"']/parent::td/preceding-sibling::td/input[@type='checkbox']")).click();
	}
	
	public static ArrayList<String> getWebTablefolllowingSibling(String userName)
	{
		List<WebElement> webtableList =driver.findElements(By.xpath("//a[text()='"+userName+"']/parent::td/following-sibling::td"));
	    ArrayList<String> webtableListDetails =new  ArrayList<String>();
		for(WebElement e:webtableList)
		{
			String webtableListtext= e.getText();
			System.out.println(webtableListtext);
			webtableListDetails.add(webtableListtext);
		}
	
	    return webtableListDetails;
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		Actions action=new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(5000);
		getWebTableSelecturHubPrecedingSibling("Kevin.Mathews");
		ArrayList<String> webTablerowDetails=getWebTablefolllowingSibling("Kevin.Mathews");
		System.out.println(webTablerowDetails);
	}

}
