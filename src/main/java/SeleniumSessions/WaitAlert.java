package SeleniumSessions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitAlert {
	
	WebDriver driver;
	public Alert waitForjavaScriptAlert()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.alertIsPresent());
		
	}
	public void acceptAlert()
	{
		waitForjavaScriptAlert().accept();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
