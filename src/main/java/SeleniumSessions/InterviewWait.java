package SeleniumSessions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InterviewWait {
	static WebDriver driver;
	
	public static List<WebElement> checkElementVisible(By locator, int timeOut,int intervalTime)
	{
		WebDriverWait waits =new WebDriverWait(driver,Duration.ofSeconds(timeOut),Duration.ofSeconds(timeOut));
		return waits.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(null));
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//its and global wait
		//it will apply on all element by default
		//it will not applicable on non web elements alerts,title,URL
		//it will not apply on specific element
		
		driver.findElement(null).sendKeys(args);//10  sec
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(null).sendKeys(args);//20
		
		
		
		
		//*******WebDriverWait
		
		WebDriverWait waits =new WebDriverWait(driver,Duration.ofSeconds(10));
		waits.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(null));//driver.findElements
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(null));//driver.findElement
		
		WebDriverWait waitalert=new WebDriverWait(driver,Duration.ofSeconds(30));
		
		 Alert alert= waitalert.until(ExpectedConditions.alertIsPresent());//alrt
		
		WebDriverWait wait3=new WebDriverWait(driver,Duration.ofSeconds(20));
		if(wait3.until(ExpectedConditions.titleContains(null)))//title
		{
			String title=driver.getTitle();
			System.out.println(title);
		}
		
		
		WebDriverWait wait4=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait4.until(ExpectedConditions.titleIs(null));//
		By but=By.xpath("//input[@Value='Login']");
		WebDriverWait wait5=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait5.until(ExpectedConditions.elementToBeClickable(but)).click();
				
		
		Wait<WebDriver> wait1=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2))
				.withMessage("element not available");
		
		wait1.until(ExpectedConditions.elementToBeClickable(but)).click();
		

	}

}
