package SeleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitConcept {

	WebDriver driver;

	public WaitConcept(WebDriver driver) {

		this.driver = driver;

	}

	public void elementVisible(By locator, int value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(value));

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (TimeoutException e) {
			System.out.println("Webelement is not present within given time period");
		}
	}

	public void elementClickable(By locator, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		try {
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
		}
		catch(TimeoutException e)
		{
			System.out.println("Webelement is not present within given time period :"+sec);
		}
	}
	public Boolean waitongetTitle(String fractions , int sec)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		return wait.until(ExpectedConditions.titleContains(fractions));
	}
	

}
