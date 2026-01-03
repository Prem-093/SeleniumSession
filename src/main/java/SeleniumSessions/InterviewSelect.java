package SeleniumSessions;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class InterviewSelect {

	public static void main(String[] args) {

      WebDriver driver= new ChromeDriver();
      
      driver.get("https://www.lambdatest.com/selenium-playground/select-dropdown-demo");
      
    WebElement selectdropdown= driver.findElement(By.xpath("//select[@id='select-demo']"));
      Select select=new Select(selectdropdown);
      select.selectByVisibleText("Sunday");
   
    WebElement multiSelect=  driver.findElement(By.xpath("//select[@id='multi-select']"));
      
      Select select1=new Select(multiSelect);
      select1.selectByVisibleText("New York");
      select1.selectByVisibleText("Texas");
      select1.selectByVisibleText("Washington");
      
      List<WebElement> selectedoption= select1.getAllSelectedOptions();
      for(WebElement e:selectedoption)
      {
    	String selectedDropDown=  e.getText();
    	System.out.println(selectedDropDown);
      }
      
      
      System.out.println("...................................................");
    String firstSelected=  select1.getFirstSelectedOption().getText();
    System.out.println(firstSelected);
    
    List<WebElement> dropdownoption=select1.getOptions();
    select1.isMultiple();
    
    select1.deselectByVisibleText("Washington");
    select1.deselectAll();
      
     String parentWindow= driver.getWindowHandle();
    Set<String> handle= driver.getWindowHandles();
    Iterator<String> it=handle.iterator();
    while (it.hasNext())
    {
    	it.next();
    }
	}
  
	//Select select=new Select();
	
}
