package SeleniumSessions;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RetryLogic2026Practise {

	static WebDriver driver;

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void retryLogicPractise(By locator, int timeout) {
		int attempts = 0;
		WebElement elements = null;

		while (attempts < timeout) {

			try {
				elements = getElement(locator);
				System.out.println("Element is found:" + attempts);
				break;
			} catch (NoSuchElementException e) {

				System.out.println("Element is not found :" + attempts);
                   
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			attempts++;
		}
		
		
		

	}

	public static void main(String[] args) {

	}

}
