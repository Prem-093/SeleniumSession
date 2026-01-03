package Seleniumcheataheet;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitConceptSelenium {
	
	static WebDriver driver;
	
	
	//FluentWait
	public static void fluentwait(By locator)
	{
		Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2))
				.withMessage("Exception handel");
				
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
				
				}
	
	//exa of method overloading
	public void waitForwindowhandle()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.numberOfWindowsToBe(1));
	}
	
	public static void waitfroFrame(WebElement element,int value)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(value));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	}
	//exa of method overloading
	public static void waitfroFrame(By locator, int value)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(value));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}
	
	public static Alert waitforAlert(int value)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(value));
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public static Boolean vrifyExactTitle(String exactTitle, int value )
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(value));
		return wait.until(ExpectedConditions.titleIs(exactTitle));
	}
	
	public static Boolean verifyTitle(String titleFraction, int value)
	{
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(value));
		return wait.until(ExpectedConditions.titleContains(titleFraction));
	}
   public static Boolean checkExacturl(String exactURL, int value)
   {
	   WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(value));
	   return wait.until(ExpectedConditions.urlToBe(exactURL));
	   
   }
   public static void checkElementClickable(By locator, int value)
   {
	   WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(value));
	   wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
   }
	
	
	public static String exlicitWaitvisibilityofElement(By locator, int value)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(value));
		
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
	}
	
	public static Boolean waitURL(int value,String urlFractions)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(value));
		return wait.until(ExpectedConditions.urlContains(urlFractions));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		driver=new ChromeDriver();
		//driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		//driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.get("https://selectorshub.com/iframe-and-nested-iframe/");
		
		//By frameloc=By.id("pact2");
		//waitfroFrame(frameloc,5);
		By frloc=By.xpath("(//iframe[@loading='lazy'])[1]");
		By frloc2=By.xpath("//iframe[@id='pact3']");
		WebElement frElement=driver.findElement(frloc);
		waitfroFrame(frElement,5);
		By idloc=By.id("jex");
		String placeholderValue=driver.findElement(idloc).getAttribute("placeholder");
		System.out.println(placeholderValue);
		waitfroFrame(frloc2,5);
		By frLocator2=By.id("glaf");
		String placeholdersecond=driver.findElement(frLocator2).getAttribute("placeholder");
		System.out.println(placeholdersecond);
		driver.switchTo().parentFrame();
		String placeholderValue2=driver.findElement(idloc).getAttribute("placeholder");
		System.out.println(placeholderValue2);
		driver.switchTo().defaultContent();
		By witframe= By.id("inp_val");
		String firstplaceholder=driver.findElement(witframe).getAttribute("placeholder");
		System.out.println(firstplaceholder);
		
		
		
	
		/*
		 * By rightclick=By.xpath("//span[text()='right click me']"); WebElement
		 * element=driver.findElement(rightclick); Actions act=new Actions(driver);
		 * act.contextClick(element).build().perform(); By
		 * Elements=By.xpath("//ul[contains(@class,'context-menu-list')]/li/span");
		 * List<WebElement> list=driver.findElements(Elements); for(WebElement e:list) {
		 * String text=e.getText();
		 * 
		 * if(text.equalsIgnoreCase("edit")) { e.click(); break; }
		 * 
		 * 
		 * } waitforAlert(5).accept();
		 */
		
		
		
		
		
		//By link=By.linkText("Continue");
		//By head=By.xpath("//div[@class='well']/h2");
		/*
		 * Boolean flag= waitURL(10,"route=account/login"); System.out.println(flag);
		 */
		/*
		 * Boolean flag=checkExacturl(
		 * "https://naveenautomationlabs.com/opencart/index.php?route=account/login",
		 * 10); System.out.println(flag);
		 */
	/*
	Boolean flag=vrifyExactTitle("Account Login", 5);
	if(flag)
	{
		String title=driver.getTitle();
		System.out.println(title);
	}*/
	

}
}
