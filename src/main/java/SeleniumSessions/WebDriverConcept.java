package SeleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebDriverConcept {

	WebDriver driver;

	public WebDriverConcept(WebDriver driver) {

		this.driver = driver;
	}

	public void launchURL(String URL) {
		driver.get(URL);
	}

	public String getTitle() {
		String title = driver.getTitle();
		System.out.println(title);
		return title;
	}

	public String getCurrentURL() {

		String urrURL = driver.getCurrentUrl();
		System.out.println(urrURL);
		return urrURL;
	}

	public WebElement getElement(By locator) {
		WebElement element = driver.findElement(locator);
		// System.out.println(element);
		return element;
	}
	
	public boolean elementIsEnabled(By locator)
	{
		return getElement(locator).isEnabled();
	}

	public void doClick(By locator) {

		getElement(locator).click();

	}

	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	public void doClear(By locator) {
		getElement(locator).clear();
	}

	public void doSendKeys1(By locator, String value) {
		doClear(locator);
		getElement(locator).sendKeys(value);
	}

	public String getText(By locator) {
		return getElement(locator).getText();
	}

	public String getAttribute(By locator, String value) {
		return getElement(locator).getAttribute(value);
	}
	public Boolean elementIsDisplay(By locator)
	{
		Boolean flag=getElement(locator).isDisplayed();
		return flag;
	}
	public boolean elementIsSelected(By locator)
	{
		return getElement(locator).isSelected();
	}
	public void implicitwait(int value)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(value));
	}
	

}
