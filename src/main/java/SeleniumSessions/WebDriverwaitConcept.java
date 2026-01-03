package SeleniumSessions;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverwaitConcept {

	public WebDriverwaitConcept(WebDriver driver) {

		this.driver = driver;
	}

	WebDriver driver;

	public WebElement waitforElementVisisble(By locator, int timeout) {

		// An expectation for checking that an element is present on the DOM of a page
		// and visible.
		// Visibility means that the element is not only displayed but also has a height
		// and width that is greater than 0.

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element;

	}

	public void sendValuesAfterWait(By locator, int timeout, String Values) {

		waitforElementVisisble(locator, timeout).sendKeys(Values);

	}

	public void elementToBeClickable(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}

	public List<WebElement> waitForElementsVisible(By locators, int TimeOut) {

		// An expectation for checking that all elements present on the web page that
		// match the locatorare visible.
		// Visibility means that the elements are not only displayed but also have a
		// heightand width that is greater than 0.

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TimeOut));
		List<WebElement> link_list = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locators));
		return link_list;
	}

	public Alert waitforAlertJSPopUp(int TimeOut) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TimeOut));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		return alert;
	}

	public String alrttGetText(int TimeOut) {
		String alertText = waitforAlertJSPopUp(TimeOut).getText();
		return alertText;
	}

	public void alertAcept(int TimeOut) {

		waitforAlertJSPopUp(TimeOut).accept();

	}

	public void alertDismiss(int TimeOut) {

		waitforAlertJSPopUp(TimeOut).dismiss();

	}

	public void sendValuesAlert(int TimeOut, String values) {

		waitforAlertJSPopUp(TimeOut).sendKeys(values);

	}

	public String waitGetTitle(String titleFraction, int timout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timout));

		if (wait.until(ExpectedConditions.titleContains(titleFraction))) {
			String textTitle = driver.getTitle();

			return textTitle;

		} else {
			System.out.println("Title is not present within TomeOutLimit " + timout);
			return null;
		}
	}

	public String waitExacttGetTitle(String titleFraction, int timout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timout));

		if (wait.until(ExpectedConditions.titleIs(titleFraction))) {
			String textTitle = driver.getTitle();

			return textTitle;

		} else {
			System.out.println("Title is not present within TomeOutLimit " + timout);
			return null;
		}

	}

	public String waitForGetURL(String URLFraction, int timout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timout));

		if (wait.until(ExpectedConditions.urlContains(URLFraction))) {
			String URL = driver.getCurrentUrl();

			return URL;

		} else {
			System.out.println("URL is not present within TomeOutLimit " + timout);
			return null;
		}

	}

	public String waitForExacttGetURL(String URLFraction, int timout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timout));

		if (wait.until(ExpectedConditions.urlToBe(URLFraction))) {
			String URL = driver.getCurrentUrl();

			return URL;

		} else {
			System.out.println("URL is not present within TomeOutLimit " + timout);
			return null;
		}

	}

	public Boolean waitForWindowGetSize(int TotalWindow, int Timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Timeout));

		return wait.until(ExpectedConditions.numberOfWindowsToBe(TotalWindow));
	}

	public void waitForFramebyLocator(By locator, int Timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Timeout));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}

	public void waitForFramebyIndex(int Index, int Timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Timeout));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(Index));
	}

	public void waitForFramebyName(String name, int Timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Timeout));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(name));
	}

	public void waitForPageLoadTimeOut(int TimeOut) {
		long TotalTime = System.currentTimeMillis() + TimeOut;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String pageStage = js.executeScript("return document.readyState").toString();
		while (System.currentTimeMillis() < TotalTime) {
			if (pageStage.equals("complete")) {
				System.out.println("PAGE DOM is fully loaded now....");

				break;
			} else {
				System.out.println("Page is not loded with given Timeout =" + pageStage);
			}
		}
	}

	public boolean pageLoadTimeout(int Timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Timeout));
		String flag = wait.until(ExpectedConditions.jsReturnsValue("return document.readyState==\'complete\'"))
				.toString();
		return Boolean.parseBoolean(flag);
	}

	public WebElement retryingElement(By locator, int TimeOut) {
		ElementUtil util = new ElementUtil(driver);
		WebElement element = null;
		int attempt = 0;
		while (attempt < TimeOut) {
			try {
				util.getElement(locator);

				System.out.println("Element is located " + locator + "in attemps" + attempt);
				break;
			}

			catch (NoSuchElementException e) {
				System.out.println("Element is not located " + locator + "in attemps" + attempt);

				try {

					Thread.sleep(500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}

			attempt++;
		}

		if (element == null) {
			System.out.println(
					"element is not found...tried for " + TimeOut + " secs " + " with the interval of 500 millisecons");
		}
		return element;

	}

	public static void main(String[] args) {

		LaunchCrossBrowser brows = new LaunchCrossBrowser();
		WebDriver driver = brows.launchBrowser("Chrome");

		// driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		// driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		// https://www.orangehrm.com/30-day-free-trial/
		// driver.get("https://www.orangehrm.com/30-day-free-trial/");
		driver.get("https://selectorshub.com/xpath-practice-page/");
		// driver.get("http://selectorshub.com/iframe-and-nested-iframe/");

		// Actions action=new Actions(driver);
		// action.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();

		// WebElement loc_tuter=
		// driver.findElement(By.xpath("(//div[@class='social-link']//li)[3]"));
		By loc_tuter = By.xpath("(//div[@class='social-link']//li)[3]");
		By loc_Frame = By.xpath("//iframe[@id='pact2']");

		By email_loc = By.id("input-email");

		By Pass_Loc = By.id("input-password");

		By but_loc = By.xpath("//input[@type='submit']");

		By LinksList = By.xpath("//div[@class='list-group']/a");

		By alert_LOc = By.xpath("//button[text()='Click for JS Alert']");

		By AddressLoc = By.xpath("(//a[text()='Forgotten Password'])[2]");

		WebDriverwaitConcept waitCon = new WebDriverwaitConcept(driver);

		Boolean FlagSttus = waitCon.pageLoadTimeout(10);
		System.out.println(FlagSttus);

		/*
		 * WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		 * 
		 * 
		 * 
		 * int timeout=20;
		 * 
		 * long endTime=System.currentTimeMillis() + timeout;
		 * 
		 * while(System.currentTimeMillis() < endTime) { JavascriptExecutor js=
		 * (JavascriptExecutor)driver; String
		 * pagestate=js.executeScript("return document.readyState").toString();
		 * if(pagestate.equals("complete")) {
		 * System.out.println("PAGE DOM is fully loaded now...."); break; }
		 * 
		 * 
		 * else { System.out.println("PAGE IS not loaded...." + pagestate); }
		 * 
		 * }
		 */
		// WebDriverwaitConcept waitCon = new WebDriverwaitConcept(driver);
		// waitCon.waitForPageLoadTimeOut(20);

		/*
		 * WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10)); String
		 * flag = wait.until(ExpectedConditions.
		 * jsReturnsValue("return document.readyState == \'complete\'")) .toString();
		 * System.out.println(flag);
		 */

		// WebDriverwaitConcept waitCon = new WebDriverwaitConcept(driver);
//
//		waitCon.elementToBeClickable(loc_tuter, 20);
//		
//		if(waitCon.waitForWindowGetSize(2, 10))
//		{
//			Set<String>  handel=driver.getWindowHandles();
//			
//			java.util.Iterator<String> it=handel.iterator();
//			it.next();
//		
//		}

		/*
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 * wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(2));
		 * 
		 * driver.findElement(By.xpath("//input[@id='jex']")).sendKeys("Hi");
		 */

		// iframe[@id='pact2']

		/*
		 * WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		 * 
		 * wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		 */

		// driver.getWindowHandles();

		// String forgrtText=waitCon.waitGetTitle("Forgot", 5);
		// System.out.println(forgrtText);

		// waitCon.waitExacttGetTitle("Forgot Your Password?", 10);

		/*
		 * WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		 * wait.until(ExpectedConditions.urlMatches("forgotten")); String
		 * currentURL=driver.getCurrentUrl(); System.out.println(currentURL);
		 */
		/*
		 * String currentURL = waitCon .waitForExacttGetURL(
		 * "https://naveenautomationlabs.com/opencart/index.php?route=account/forgotten",
		 * 5); System.out.println(currentURL);
		 */

		// driver.findElement(alert_LOc).click();

		/*
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); Alert
		 * alert = wait.until(ExpectedConditions.alertIsPresent());
		 * 
		 * String alertText = alert.getText(); System.out.println(alertText);
		 * alert.accept();
		 */

		/*
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 * List<WebElement> listLink =
		 * wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(LinksList));
		 */

		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));

		// WebElement email =
		// wait.until(ExpectedConditions.presenceOfElementLocated(email_loc));

		// email.sendKeys("Prem");

		// An expectation for checking that an element is present on the DOM of a page.
		// This does not necessarily mean that the element is visible.

		// WebElement Pass =
		// wait.until(ExpectedConditions.presenceOfElementLocated(Pass_Loc));

		// Pass.sendKeys("Tripathi");

		// WebElement Button =
		// wait.until(ExpectedConditions.presenceOfElementLocated(but_loc));
		// Button.click();

		/*
		 * WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		 * 
		 * WebElement email =
		 * wait1.until(ExpectedConditions.visibilityOfElementLocated(email_loc));
		 */
		// email.sendKeys("Prem");

		/*
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
		 * wait.until(ExpectedConditions.elementToBeClickable(but_loc));
		 */

		/*
		 * waitConcept.sendValuesAfterWait(email_loc, 10, "Prem");
		 * waitConcept.sendValuesAfterWait(Pass_Loc, 10, "Tripathi");
		 * waitConcept.elementToBeClickable(but_loc, 10);
		 */
	}
}
