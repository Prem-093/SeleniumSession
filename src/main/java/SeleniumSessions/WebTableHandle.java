package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WebTableHandle {

	static WebDriver driver;

	public static void webTable(String userName) {
		driver.findElement(
				By.xpath("//a[text()='" + userName + "']/parent::td/preceding-sibling::td/input[@type='checkbox']"))
				.click();
	}

	public static List<String> webTableText(String userName) {
		List<WebElement> webTableText = driver
				.findElements(By.xpath("//a[text()='" + userName + "']/parent::td/following-sibling::td"));
		List<String> webTablelist = new ArrayList<String>();
		for (WebElement e : webTableText) {
			String webTabletext = e.getText();
			System.out.println(webTabletext);
			webTablelist.add(webTabletext);
		}
		return webTablelist;

	}
	public static List<String> getWebTabledetails()
	{
		List<WebElement>  listDetails=driver.findElements(By.xpath("//span[text()='Shashank Singh']/ancestor::td/following-sibling::td"));
	    List<String> webTableList=new ArrayList<String>();
		for(WebElement e:listDetails)
	    {
	    	String tableText=e.getText();
	    	System.out.println(tableText);
	    	webTableList.add(tableText);
	    }
		return webTableList;
	
	}
	
	public static int traverseWebTablerowcount()
	{
		return driver.findElements(By.xpath("//table[contains(@id,'customers')]//tr")).size();
	}
	//customers
	public static void traverseWebTable(String userName)
	{
		String BeforeXpath="//*[@id='"+userName+"']/tbody/tr[";
		String AfterXpath="]/td[1]";
		
		for(int i=2; i <=traverseWebTablerowcount(); i++)
		{
			String totalXpath=BeforeXpath+i+AfterXpath;
			
			List<WebElement> webTableXpath=driver.findElements(By.xpath(totalXpath));
		   // System.out.println(webTableXpath);
		    for(WebElement e:webTableXpath)
		    {
		    	String webTableText=e.getText();
		    	System.out.println(webTableText);
		    }
		}
		
		
	}

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		//driver.get("https://selectorshub.com/xpath-practice-page/");
		//driver.get("https://www.espncricinfo.com/series/ipl-2025-1449924/delhi-capitals-vs-punjab-kings-66th-match-1485779/full-scorecard");
    	driver.get("https://www.w3schools.com/html/html_tables.asp");
		//Thread.sleep(5000);
		
		 // Actions action = new Actions(driver);
		 // action.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();
		 // webTable("Jasmine.Morgan"); 
		 // webTable("Joe.Root"); 
		 // List<String> weTableList = webTableText("Jasmine.Morgan");
		 

		//System.out.println(weTableList.get(0));
		
		//getWebTabledetails();
		//int columnSize=traverseWebTablecolumncount();
		//System.out.println(columnSize);
		traverseWebTable("customer");
	}

}
