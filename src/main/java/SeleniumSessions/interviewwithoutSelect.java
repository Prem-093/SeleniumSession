package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class interviewwithoutSelect {

	public static void main(String[] args) {
		
	     WebDriver driver= new ChromeDriver();
	     driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
			/*
			 * WebElement ddloc= driver.findElement(By.xpath("//select[@name='Country']"));
			 * Select select=new Select(ddloc); List<WebElement> ddlist=
			 * select.getOptions();
			 * 
			 * for(WebElement e:ddlist) { String textdropdown=e.getText();
			 * System.out.println(textdropdown);
			 * if(textdropdown.equalsIgnoreCase("Pakistan")) { e.click(); break; } }
			 */
		List<WebElement> ddList=driver.findElements(By.xpath("//select[@name='Country']/option"));
		int ddcount=ddList.size();
		System.out.println(ddcount);
		for(WebElement e:ddList)
		{
		
			String ddtext=e.getText();
			System.out.println(ddtext);
			if(ddtext.equalsIgnoreCase("Australia"))
			{
				e.click();
				break;
			}
			
		}
		

	}
	


}
