package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementTest {

	WebDriver driver;

	public WebElementTest(WebDriver driver) {

		this.driver = driver;
	}

	public void doClick(By locator) {
		doGetElement(locator).click();
	}

	public String dogetAttribute(By locator, String Value) {
		return doGetElement(locator).getAttribute(Value);
	}

	public WebElement doGetElement(By locator) {

		WebElement element = null;

		try {
			element = driver.findElement(locator);
		}

		catch (NoSuchElementException e) {
			System.out.println("Element not present with :" + locator + "Please pass correct locator");
		}
		try {
			Thread.sleep(1000);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		element = driver.findElement(locator);

		return element;
	}

	public void doSendKeys(By locator, String values) {
		doGetElement(locator).sendKeys(values);
	}

	public String doGetText(By locator) {
		return doGetElement(locator).getText();
	}

	public void doClear(By locator) {
		doGetElement(locator).clear();
	}

	public boolean eleDisplay(By locator) {
		return doGetElement(locator).isDisplayed();
	}

	public static void main(String[] args) {

		LaunchCrossBrowser initBrowser = new LaunchCrossBrowser();

		WebDriver driver = initBrowser.launchBrowser("Chrome");
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		/*
		 * WebDriver driver=new ChromeDriver(); driver.get(
		 * "https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		 * driver.findElement(By.id("input-email")).sendKeys("Prem");
		 * driver.findElement(By.id("input-password")).sendKeys("Tripathi");
		 */

		By idemail = By.id("input-email");
		By idPass = By.id("input-password");
		By clickBut = By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input");
		By doText = By.xpath("//*[@id=\"account-login\"]/div[1]");
		By eleDisp = By.xpath("//*[@id=\"search\"]/input");

		WebElementTest ele = new WebElementTest(driver);
		ele.doGetElement(idemail);
		ele.doSendKeys(idemail, " Prem");
		ele.doClear(idemail);
		ele.doGetElement(idPass);
		ele.doSendKeys(idPass, " Tripathi");
		ele.doClear(idPass);
		ele.doClick(clickBut);
		String text = ele.doGetText(doText);
		System.out.println("error message= " + text);
		Boolean flagstatus = VerifyText.verifyText(text, "Warning: No match for E-Mail Address and/or Password.");

		System.out.println(flagstatus);
		ele.doClear(idemail);
		ele.doClear(idPass);

		Boolean Flag = ele.eleDisplay(eleDisp);
		System.out.println(Flag);
		// ele.doGetElement(eleDisp).sendKeys("ABC");// NoSuchElementException

		//String xyz = ele.dogetAttribute(idemail, "placeholder");
		//System.out.println(xyz);
		String attValue = ele.dogetAttribute(idPass, "type");
		System.out.println(attValue);
	}
}
